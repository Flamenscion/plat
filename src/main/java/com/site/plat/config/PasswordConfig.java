package com.site.plat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean(name = "customPasswordEncoder") // Переименовываем бин
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}