package com.whattheflatmap.helloproblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/")
public class HelloProblemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloProblemApplication.class, args);
    }

    @GetMapping("/hello")
    public Mono<String> hello() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
