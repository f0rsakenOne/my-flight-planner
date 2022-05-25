package com.example.myflightplanner.configuration;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

  @Bean
  @ConditionalOnProperty(prefix = "flight-planner", name = "store-type", havingValue = "database")
  public DataSource getDatabaseDataSource() {
    return DataSourceBuilder.create()
        .driverClassName("org.h2.Driver")
        .url("jdbc:h2:mem:mydb;DB_CLOSE_DELAY=-1")
        .username("sa")
        .password("")
        .build();
  }
}
