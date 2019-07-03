package com.loyofo.spring.config;

import com.loyofo.spring.bean.ManPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {
    @Bean
    public ManPerson manPerson() {
        return new ManPerson();
    }
}
