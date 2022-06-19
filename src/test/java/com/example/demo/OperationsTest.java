package com.example.demo;

import io.corp.calculator.TracerImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class OperationsTest {
    @InjectMocks
    private OperationsServiceImpl  operationsService;

    @Mock
    private TracerImpl tracerImpl;

    @Test
    void givenNoNumbers_whenAdd_thenReturnOptionalEmpty() throws Exception {

        Optional<Float> result = operationsService.add(null);
        Assert.assertEquals(result, Optional.empty());

    }


    @Test
    void givenNumbers_whenAdd_thenReturnOptionalWithResult() throws Exception {
        Optional<Float> result = operationsService.add(List.of(1f,2f));
        Assert.assertEquals(result, Optional.of(3f));
    }

    @Test
    void givenNumbers_whenSubstract_thenReturnOptionalWithResult() throws Exception {
        Optional<Float> result = operationsService.substract(List.of(3f,2f));
        Assert.assertEquals(result, Optional.of(1f));
    }


    @Test
    void givenNoNumbers_whenSubstract_ResponseOptionalEmpty() throws Exception {

        Optional<Float> result = operationsService.substract(null);
        Assert.assertEquals(result, Optional.empty());

    }
}
