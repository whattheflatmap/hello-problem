package com.whattheflatmap.helloproblem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.server.WebExceptionHandler;
import org.zalando.problem.jackson.ProblemModule;
import org.zalando.problem.spring.webflux.advice.ProblemExceptionHandler;
import org.zalando.problem.spring.webflux.advice.ProblemHandling;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import java.time.ZonedDateTime;

@Configuration
public class AppConfig {
    // The handler must have precedence over WebFluxResponseStatusExceptionHandler and Spring Boot's ErrorWebExceptionHandler
    @Bean
    @Order(-2)
    public WebExceptionHandler problemExceptionHandler(ObjectMapper mapper, ProblemHandling problemHandling) {
        return new ProblemExceptionHandler(mapper, problemHandling);
    }

    // Auto-registration for all beans of type com.fasterxml.jackson.databind.Module
    // 1. Define Module beans
//    @Bean
//    public ProblemModule problemModule() {
//        return new ProblemModule();
//    }
//
//    @Bean
//    public ConstraintViolationProblemModule constraintViolationProblemModule() {
//        return new ConstraintViolationProblemModule();
//    }

    // 2. Define Objectmapper bean
//    @Bean
//    public ObjectMapper objectMapper() {
//        return new ObjectMapper().registerModules(
//                new ProblemModule(),
//                new ConstraintViolationProblemModule());
//    }

//    @Bean
//    public ObjectMapper objectMapper(final Jackson2ObjectMapperBuilder builder) {
//        return builder
//                .findModulesViaServiceLoader(true)
//                .build();
//    }

    // 3. Define Jackson2ObjectMapperBuilder bean
//    @Bean
//    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
//        return new Jackson2ObjectMapperBuilder()
//                .findModulesViaServiceLoader(true);
//    }

    // 4. Define Jackson2ObjectMapperBuilderCustomizer bean
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder.findModulesViaServiceLoader(true);
    }
}
