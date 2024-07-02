package com.blackcode.helpdesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.blackcode.helpdesk.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public boolean instanciaDB(DBService dbService) {
        dbService.instanciaDB();
        return false;
    }

}
