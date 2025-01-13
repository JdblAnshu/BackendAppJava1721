package com.java.backend.app.spring_java_backend;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.java.backend.app.spring_java_backend")
public class SpringJavaBackendApplication implements ApplicationRunner {


	private final ApplicationContext applicationContext;

	public SpringJavaBackendApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaBackendApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		System.out.println("Beans provided by Spring Boot:");

		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

		System.out.println("Done provided by Spring Boot:");
	}
}
