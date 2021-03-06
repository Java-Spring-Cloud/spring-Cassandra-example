/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cassandra.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.Session;

/**
 * Basic {@link Configuration} to create the necessary schema for the
 * {@link User} table.
 * 
 * @author Oliver Gierke
 * @author Thomas Darimont
 * @author Mark Paluch
 */
@Configuration
@EnableAutoConfiguration
class BasicConfiguration {

	@Configuration
	@EnableCassandraRepositories
	static class CassandraConfig extends AbstractCassandraConfiguration {

		@Autowired
		private Environment env;
		
		@Bean
		public CassandraClusterFactoryBean cluster() {

			CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
			//cluster.setClusterName("sample");
			cluster.setContactPoints(env.getProperty("spring.data.cassandra.contact-points"));
			cluster.setPort(Integer.parseInt(env.getProperty("spring.data.cassandra.port")));
			return cluster;
		}		
		
		@Override
		public SchemaAction getSchemaAction() {
			return SchemaAction.CREATE;
		}
		
		@Override
		public String getKeyspaceName() {
			return "credit_autopay";
		}

		

		@Bean
		public CassandraTemplate cassandraTemplate(Session session) {
			return new CassandraTemplate(session);
		}

		@Override
		public String[] getEntityBasePackages() {
			return new String[] { User.class.getPackage().getName() };
		}


	}
}
