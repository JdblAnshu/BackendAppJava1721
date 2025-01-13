package com.java.backend.app.spring_java_backend.mongoAerospike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdempotencyManager {

	private final MongoIdempotencyHandler mongoHandler;
	//private final AerospikeIdempotencyHandler aerospikeHandler;

	@Autowired
	public IdempotencyManager(MongoIdempotencyHandler mongoHandler/* AerospikeIdempotencyHandler aerospikeHandler*/) {
		this.mongoHandler = mongoHandler;
		//this.aerospikeHandler = aerospikeHandler;
	}

	public IdempotencyOperation getHandler(String dbType) {
		switch (dbType) {
			case "mongo":
				return mongoHandler;
			case "aerospike":
				return null;//aerospikeHandler;
			default:
				throw new IllegalArgumentException("Unsupported database type: " + dbType);
		}
	}
}
