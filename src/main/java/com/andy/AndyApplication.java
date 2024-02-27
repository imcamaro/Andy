package com.andy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com/andy")
@EnableSwagger2WebMvc
public class AndyApplication {
    public static void main(String[] args){

        SpringApplication.run(AndyApplication.class, args);

        log.info("###############################");
        log.info("##                           ##");
        log.info("##  Andy Start Successfully  ##");
        log.info("##                           ##");
        log.info("###############################");

    }
}
