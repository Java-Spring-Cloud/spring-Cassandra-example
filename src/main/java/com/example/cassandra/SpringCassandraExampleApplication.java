package com.example.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cassandra.basic.BasicUserRepository;
import com.example.cassandra.basic.User;

@SpringBootApplication
@RestController
public class SpringCassandraExampleApplication {
	/*
	@Autowired BasicUserRepository basicUserRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraExampleApplication.class, args);
	}
	
/*	@RequestMapping(value="saveUser")
	public String storeCassd(){
		User user = new User(Long.parseLong("123"));
		basicUserRepository.save(user);
		return "worked well with CassD";
	}*/
}
