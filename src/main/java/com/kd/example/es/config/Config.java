package com.kd.example.es.config;

import java.util.List;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class Config {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Value("#{'${es.cluster.nodes}'.split(',')}")
	private List<String> elasticSearchClusterNodes;

	@Bean
	RestHighLevelClient client() {
		LOGGER.info("Creating Elastic Search clinet with " + elasticSearchClusterNodes);

		HttpHost[] hosts = elasticSearchClusterNodes.stream().map(s -> {
			return HttpHost.create(s);
		}).toArray(HttpHost[]::new);

		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(hosts));
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(client());
	}
}
