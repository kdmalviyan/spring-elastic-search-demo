package com.kd.example.es.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "addresses")
public class Address {
	@Id
	private String id;
	private boolean isCurrent;
	private boolean isOffice;
	private String street;
	private String city;
	private String state;
	private String country;
	private String pincode;
}
