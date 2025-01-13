//package com.java.backend.app.spring_java_backend.mongoAerospike;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//
//@Component
//@ConditionalOnProperty(name = "data.source.aerospike", havingValue = "aerospike")
//public class AerospikeIdempotencyHandler implements IdempotencyOperation {
//
//
//	private final AerospikeIdempotencyRepository repository;
//
//	@Autowired
//	public AerospikeIdempotencyHandler(AerospikeIdempotencyRepository repository) {
//		this.repository = repository;
//	}
//
//	@Override
//	public boolean isProcessed(String recordId) {
//		return repository.existsById(recordId);
//	}
//
//	@Override
//	public void markProcessed(String recordId) {
//		repository.save(new AerospikeIdempotencyRecord(recordId));
//	}
//}
