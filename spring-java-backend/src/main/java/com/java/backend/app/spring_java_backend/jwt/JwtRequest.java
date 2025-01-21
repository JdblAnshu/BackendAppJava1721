package com.java.backend.app.spring_java_backend.jwt;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtRequest {

	String email;

	String password;
}
