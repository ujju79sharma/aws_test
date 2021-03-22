package com.java.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.java.demo.dao.CountersDAO;
import com.java.demo.models.Counters;

@Repository
public class CountersDAOImpl implements CountersDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public int getNextSequenceOf(String entityId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(entityId));
		Update update = new Update().inc("sequence", 1);
		return mongoTemplate.findAndModify(query, update, Counters.class).getSequence();
	}
}