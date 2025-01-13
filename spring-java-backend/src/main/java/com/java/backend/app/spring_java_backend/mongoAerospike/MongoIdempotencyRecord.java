package com.java.backend.app.spring_java_backend.mongoAerospike;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "idempotency_records")
public class MongoIdempotencyRecord {

	@Id
	private String id;
	private long timestamp;

	public MongoIdempotencyRecord(String id) {
		this.id = id;
		this.timestamp = System.currentTimeMillis();
	}

	// Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}

