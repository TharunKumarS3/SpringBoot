package com.example.Starter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    //this pojo class
    //we need to send httpStatus and message to response handler
    private HttpStatus httpStatus;
    private String message;
}
