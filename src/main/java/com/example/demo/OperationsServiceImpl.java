package com.example.demo;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationsServiceImpl implements  OperationsService{

    private final TracerImpl tracerImpl;

    public Optional<Float> add(List<Float> numbers) {
        if (numbers !=null && numbers.size() > 0) {
            Float result = numbers.stream()
                    .reduce(0f, Float::sum);
            tracerImpl.trace(result);
            return Optional.of(result);
        }
        tracerImpl.trace(0);
        return Optional.empty();
    }


    public Optional<Float> substract(List<Float> numbers) {
        if (numbers !=null && numbers.size() > 0) {
            Float result = numbers.get(0);

            for (int i = 1; i < numbers.size(); i++) {
                result = result - numbers.get(i);
            }
            tracerImpl.trace(result);

            return Optional.of(result);
        }

        tracerImpl.trace(0);
        return Optional.empty();

    }
}
