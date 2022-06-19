package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OperationsController {
    private final OperationsServiceImpl operationsServiceImpl;

    @PostMapping("/add")
    ResponseEntity<String> add(@RequestParam(value = "numbers", required = true) List<Float> numbers) {
        Optional<Float> optResult = operationsServiceImpl.add(numbers);

        if (optResult.isPresent())
                return ResponseEntity.ok()
                    .header(null)
                    .body(optResult.get().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(null)
                .body("Error. No numbers in the request");
    }

    @PostMapping("/substract")
    ResponseEntity<String> substract(@RequestParam(value = "numbers", required = true)  List<Float> numbers) {
        Optional<Float> optResult = operationsServiceImpl.substract(numbers);

        if (optResult.isPresent())
            return ResponseEntity.ok()
                    .header(null)
                    .body(optResult.get().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(null)
                .body("Error. No numbers in the request");
    }
}
