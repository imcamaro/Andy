package com.andy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@Tag(name="Hello Controller")
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "Hello World", description = "return hello world to client")
    public ResponseEntity<String> hello(){
        log.info("####### Access into hello API #######");
        return ResponseEntity.ok("Hello World!");
    }

}
