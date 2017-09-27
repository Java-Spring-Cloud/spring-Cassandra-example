package com.example.cassandra;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.cassandra")
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		// TODO Auto-generated method stub
		return "testmac";
	} 
}