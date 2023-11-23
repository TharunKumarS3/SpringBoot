package com.example.Starter.errors;

import com.example.Starter.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//flow
//controller -> excpetion handler - > here - > ErrorMessage class for setting details
//- > here - > response

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionalHandler extends ResponseEntityExceptionHandler {

    //we need to write custom error handler responser
    @ExceptionHandler(DeptNotFoundException.class) //for deptNotFound error
    public ResponseEntity<ErrorMessage> deptNotFoundException(DeptNotFoundException deptNotFoundException,
                                                             WebRequest request)
    {
        //setting error message
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND,deptNotFoundException.getMessage());

        //sending response
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

    }
}
