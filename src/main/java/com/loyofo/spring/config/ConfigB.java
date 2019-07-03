package com.loyofo.spring.config;

import com.loyofo.spring.bean.WomanPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigB {
    @Bean
    public WomanPerson womanPerson() {
        return new WomanPerson();
    }
}
