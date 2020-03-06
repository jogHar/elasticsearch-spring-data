package com.joghar.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.joghar.model.Student;
@Service
public class StudentService {
	@Autowired ElasticsearchTemplate elasticsearchTemplate;
	
	public List<Student> likeByName(String value) {
		String name = ".*"+value+".*";
		SearchQuery query = new NativeSearchQueryBuilder().withFilter(QueryBuilders.regexpQuery("name", name)).build();
		List<Student> students = elasticsearchTemplate.queryForList(query, Student.class);
		return students;
	}
}
