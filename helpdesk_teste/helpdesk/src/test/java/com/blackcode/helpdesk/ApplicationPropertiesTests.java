package com.blackcode.helpdesk;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class ApplicationPropertiesTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private DataSource dataSource;

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        assertNotNull(context);
        assertTrue(context.containsBean("dataSource"));
        assertTrue(context.containsBean("jdbcTemplate"));

        // spring.datasource.url=jdbc:h2:file:~/test - verifique se a URL do H2 está
        // acessível e correta
        // assertEquals("jdbc:h2:file:~/test", dataSource.toString());
        // assertEquals("jdbc:h2:file:~/test", jdbcTemplate.getDataSource().toString());

        System.out.println("DataSource: " + dataSource.toString());

        // spring.h2.console.enabled=true - verifique se o console do H2 está habilitado
        assertNotNull(context.getBean(DataSource.class));
        assertNotNull(context.getBean(JdbcTemplate.class).getDataSource());
    }

}
