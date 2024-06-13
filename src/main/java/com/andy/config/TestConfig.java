package com.andy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestConfig {

    @Bean
    public void testWhenStart(){
        log.info("Starting In Progress");
    }

}
