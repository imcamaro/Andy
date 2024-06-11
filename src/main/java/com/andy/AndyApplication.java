package com.andy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AndyApplication {
    public static void main(String[] args){
        SpringApplication.run(AndyApplication.class, args);
        log.info("************************************");
        log.info("*                                  *");
        log.info("*  Application Start Successfully  *");
        log.info("*                                  *");
        log.info("************************************");
    }
}
