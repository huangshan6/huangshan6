package com.example.demo.liuxinyu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/add")
    public ResponseEntity<String> addNumbers(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        try {
            int operand1 = Integer.parseInt(num1);
            int operand2 = Integer.parseInt(num2);
            int result = operand1 + operand2;
            return ResponseEntity.ok("The result of addition is: " + result);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input for addition: " + e.getMessage());
        }
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divideNumbers(@RequestParam("numerator") String numerator, @RequestParam("denominator") String denominator) {
        try {
            int num = Integer.parseInt(numerator);
            int denom = Integer.parseInt(denominator);
            if (denom == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Division by zero is not allowed");
            }
            double result = (double) num / denom;
            return ResponseEntity.ok("The result of division is: " + result);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input for division: " + e.getMessage());
        }
    }
}
