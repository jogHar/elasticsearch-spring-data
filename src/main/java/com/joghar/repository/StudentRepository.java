package com.joghar.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.joghar.model.Student;
@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, String> {
	List<Student> findByName(String name);
}
