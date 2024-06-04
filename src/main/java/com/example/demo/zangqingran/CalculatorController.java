package com.example.demo.zangqingran;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam String num1, @RequestParam String num2) {
        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double result = number1 + number2;
            return ResponseEntity.ok("Result: " + result);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: Please enter valid numbers.");
        }
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam String num1, @RequestParam String num2) {
        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            if (number2 == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Division by zero is not allowed.");
            }
            double result = number1 / number2;
            return ResponseEntity.ok("Result: " + result);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: Please enter valid numbers.");
        }
    }
}
