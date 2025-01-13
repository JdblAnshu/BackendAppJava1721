//package com.java.backend.app.spring_java_backend.mongoAerospike;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SampleFinalWorkingCode {
//
//	private final IdempotencyHandlerFactory handlerFactory;
//
//	// Get the database type from configuration
//	@Value("${idempotency.db.type}")
//	private String dbType;
//
//	public MessageProcessorService(IdempotencyHandlerFactory handlerFactory) {
//		this.handlerFactory = handlerFactory;
//	}
//
//	public void processMessage(String recordId) {
//		// Get the appropriate handler based on the dbType
//		IdempotencyHandler handler = handlerFactory.getHandler(dbType);
//
//		// Check if the message has already been processed
//		if (handler.isProcessed(recordId)) {
//			System.out.println("Duplicate message: " + recordId);
//			return;
//		}
//
//		// Process the message
//		System.out.println("Processing message: " + recordId);
//
//		// Mark the message as processed
//		handler.markProcessed(recordId);
//	}
//}
