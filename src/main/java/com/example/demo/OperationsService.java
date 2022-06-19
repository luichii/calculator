package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface OperationsService {
    public Optional<Float> add(List<Float> numbers);

    public Optional<Float> substract(List<Float> numbers);

}
