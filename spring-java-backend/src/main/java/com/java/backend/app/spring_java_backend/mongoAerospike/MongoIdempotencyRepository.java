package com.java.backend.app.spring_java_backend.mongoAerospike;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoIdempotencyRepository extends MongoRepository<MongoIdempotencyRecord, String> {
}
