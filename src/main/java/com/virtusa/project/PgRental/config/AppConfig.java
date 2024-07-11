package com.virtusa.project.PgRental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        // ModelMapper modelMapper = new ModelMapper();
        // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return new ModelMapper();
    }
}
