package com.whattheflatmap.helloproblem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.webflux.advice.ProblemHandling;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class ExceptionHandling implements ProblemHandling {

    @ExceptionHandler
    public Mono<ResponseEntity<Problem>> handleCustomException(final CustomException ex, final ServerWebExchange exchange) {
        Problem problem = Problem.builder()
                .withTitle("Exception")
                .withStatus(Status.BAD_REQUEST)
                .withDetail("Custom exception")
                .build();
        return create(ex, problem, exchange);
    }
}
