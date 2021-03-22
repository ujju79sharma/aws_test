package com.java.demo.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.java.demo.models.Users;

@Component
public class Query implements GraphQLQueryResolver{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Users findUserById(int userId) {
		return mongoTemplate.findOne(org.springframework.data.mongodb.core.query.Query.query(Criteria.where("userId").is(userId)), Users.class);
	}
}
