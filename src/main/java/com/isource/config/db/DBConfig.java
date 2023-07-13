package com.isource.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Lazy
public class DBConfig {

	@Lazy(value = true)
	@Bean(name = "WEB")
	@ConfigurationProperties(prefix = "postgresql.datasource")
	public DataSource dataSourceWEB() {    // datasources is used to Attempts to establish a connection with the data source that, this {@code DataSource} object represents. 
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcTemplateWEB")
	public JdbcTemplate jdbcTemplateWEB(@Qualifier("WEB") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	
	@Bean(name = "CRM")
	@ConfigurationProperties(prefix = "mssql.datasource")
	public DataSource dataSourceCRM() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcTemplateCRM")
	public JdbcTemplate jdbcTemplateCRM(@Qualifier("CRM") DataSource ds) {
		return new JdbcTemplate(ds);
	}


}
