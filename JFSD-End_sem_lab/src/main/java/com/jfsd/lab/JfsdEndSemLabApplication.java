package com.jfsd.lab;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jfsd.lab.JfsdEndSemLabApplication;

@SpringBootApplication
@ComponentScan(basePackages="com.jfsd.controller")
@ComponentScan(basePackages = "com.jfsd.demo")
@EntityScan("com.jfsd.model")
@ComponentScan(basePackages = "com.jfsd.model") 
@EnableJpaRepositories(basePackages = "com.jfsd.repository")
public class JfsdEndSemLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(JfsdEndSemLabApplication.class, args);
		System.out.println("Running");
	}


}
