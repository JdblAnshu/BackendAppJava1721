package com.java.backend.app.spring_java_backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class DataSourceConfiguration {

	// MongoDB Configuration
	@Bean
	@ConditionalOnProperty(name = "data.source", havingValue = "mongo")
	public MongoDatabaseFactory mongoDatabaseFactory() {
		return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/test");
	}

	@Bean
	@ConditionalOnProperty(name = "data.source", havingValue = "mongo")
	public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory) {
		return new MongoTemplate(mongoDatabaseFactory);
	}

//	// Aerospike Configuration
//	@Bean
//	@ConditionalOnProperty(name = "data.source", havingValue = "aerospike")
//	public AerospikeTemplate aerospikeTemplate() {
//		com.aerospike.client.Host aerospikeHost = new com.aerospike.client.Host("localhost", 3000);
//		return new AerospikeTemplate(aerospikeHost);
//	}
}
