package com.whattheflatmap.helloproblem;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.webflux.advice.ProblemHandling;

@ControllerAdvice
public class ExceptionHandling implements ProblemHandling {

}
