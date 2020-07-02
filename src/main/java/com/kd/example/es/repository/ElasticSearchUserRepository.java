package com.kd.example.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.kd.example.es.models.User;

public interface ElasticSearchUserRepository extends ElasticsearchRepository<User, String> {

}
