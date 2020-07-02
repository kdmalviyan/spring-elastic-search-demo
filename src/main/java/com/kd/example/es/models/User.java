package com.kd.example.es.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "users")
public class User {
	@Id
	private String id;
	private String name;
	private String company;
	private String designation;
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Address> addresses;
}
