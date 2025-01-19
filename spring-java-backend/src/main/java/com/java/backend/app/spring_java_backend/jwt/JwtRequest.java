package com.java.backend.app.spring_java_backend.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtRequest {

	String email;

	String password;
}
