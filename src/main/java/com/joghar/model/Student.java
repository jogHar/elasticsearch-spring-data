package com.joghar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

@Document(indexName="deltafixes", type="student")
@Getter
@Setter
public class Student {
	@Id
	private String id;
	private String name;
	private Integer age;
}
