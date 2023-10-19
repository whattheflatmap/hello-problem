package com.whattheflatmap.helloproblem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;
import org.zalando.problem.spring.webflux.advice.ProblemHandling;
import org.zalando.problem.spring.webflux.advice.security.SecurityAdviceTrait;
import org.zalando.problem.violations.ConstraintViolationProblem;
import org.zalando.problem.violations.Violation;
import reactor.core.publisher.Mono;

import java.util.List;

@ControllerAdvice
public class ExceptionHandling implements ProblemHandling, SecurityAdviceTrait {

    public ResponseEntity<Problem> process(ResponseEntity<Problem> entity) {
        Problem problem = entity.getBody();
        if(problem instanceof ConstraintViolationProblem) {
            List<Violation> violations = ((ConstraintViolationProblem)problem).getViolations();

            ProblemBuilder builder = Problem.builder()
                            .withTitle("Validation Error")
                            .withStatus(entity.getBody().getStatus())
                            .withDetail(violations.get(0).getMessage());
            return new ResponseEntity<>(builder.build(), entity.getStatusCode());
        }
        return entity;
    }

    @ExceptionHandler
    public Mono<ResponseEntity<Problem>> handleCustomException(final CustomException ex, final ServerWebExchange request) {
        Problem problem = Problem.builder()
                .withTitle("Exception")
                .withStatus(Status.BAD_REQUEST)
                .withDetail("Custom exception")
                .build();
        return create(ex, problem, request);
    }
}
