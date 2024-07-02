package com.blackcode.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.blackcode.helpdesk.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
    private DBService dbService;
	@Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlValor;

    @Bean
    public boolean instanciaDB() {
        if ( ddlValor.equals("create") || "create-drop".equals(ddlValor) ) {
            this.dbService.instanciaDB(); 
        }
        return true;
    }
}
