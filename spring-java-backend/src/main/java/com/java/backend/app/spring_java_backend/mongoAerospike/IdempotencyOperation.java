package com.java.backend.app.spring_java_backend.mongoAerospike;

//SAME AS IDEMPOTENCY OPERATION
public interface IdempotencyOperation {
	boolean isProcessed(String recordId);
	void markProcessed(String recordId);
//	void getKeyAndConsumer();
//	void insert();
}
