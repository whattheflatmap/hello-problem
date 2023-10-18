package com.whattheflatmap.helloproblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.nio.file.AccessDeniedException;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/")
public class HelloProblemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloProblemApplication.class, args);
    }

    @GetMapping("/bad-request")
    public Mono<String> badRequest() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/unsupported")
    public Mono<String> unsupported() {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @GetMapping("/access-denied")
    public Mono<String> accessDenied() throws AccessDeniedException {
        throw new AccessDeniedException("No access");
    }

    @GetMapping("/item-not-found")
    public Mono<String> itemNotFound() {
        throw new CustomProblem(1L);
    }

    @GetMapping("/custom")
    public Mono<String> custom() {
        throw new CustomException();
    }
}
