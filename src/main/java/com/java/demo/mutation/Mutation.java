package com.java.demo.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.java.demo.dao.CountersDAO;
import com.java.demo.models.Users;

@Component
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CountersDAO sequence;
	
	public Users createAUser(String name, int rollNo, int marks, String school) {
		
		Users user = new Users();
		
		user.setUserId(sequence.getNextSequenceOf("userId"));
		user.setName(name);
		user.setMarks(marks);
		user.setRollNo(rollNo);
		user.setSchool(school);
		
		mongoTemplate.save(user, "users");
		
		return user;
	}
}
