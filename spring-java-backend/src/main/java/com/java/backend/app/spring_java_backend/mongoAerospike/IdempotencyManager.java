package com.java.backend.app.spring_java_backend.mongoAerospike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IdempotencyManager {

	private final Optional<MongoIdempotencyHandler> mongoHandler;
	private final Optional<AerospikeIdempotencyHandler> aerospikeHandler;

	@Autowired
	public IdempotencyManager(Optional<MongoIdempotencyHandler> mongoHandler, Optional<AerospikeIdempotencyHandler> aerospikeHandler) {
		this.mongoHandler = mongoHandler;
		this.aerospikeHandler = aerospikeHandler;
	}

	public IdempotencyOperation getHandler(String dbType) {
		switch (dbType) {
			case "mongo":
				return mongoHandler.orElseThrow(() -> new IllegalArgumentException("Mongo handler not configured"));
			case "aerospike":
				return aerospikeHandler.orElseThrow(() -> new IllegalArgumentException("Aerospike handler not configured"));
			default:
				throw new IllegalArgumentException("Unsupported database type: " + dbType);
		}
	}
}
