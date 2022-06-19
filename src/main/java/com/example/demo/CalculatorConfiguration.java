package com.example.demo;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration {
    @Bean
    TracerImpl getTracerApi() {
        return new TracerImpl();
    }
}
