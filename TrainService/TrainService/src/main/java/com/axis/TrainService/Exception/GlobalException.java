package com.axis.TrainService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(IdNotValidException.class)
    public ResponseEntity<ErrorInfo> myException(IdNotValidException exception){

        ErrorInfo errorinfo = new ErrorInfo();
        errorinfo.setErrorMessage(exception.getMessage());
        errorinfo.setStatus(HttpStatus.NOT_FOUND.toString());
        errorinfo.setLocalDateTime(LocalDateTime.now());


        return new ResponseEntity<ErrorInfo>( errorinfo , HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(InvalidCharacterException.class)
    public ResponseEntity<ErrorInfo> myException(InvalidCharacterException exception1){

        ErrorInfo errorinfo = new ErrorInfo();
        errorinfo.setErrorMessage(exception1.getMessage());
        errorinfo.setStatus(HttpStatus.NOT_FOUND.toString());
        errorinfo.setLocalDateTime(LocalDateTime.now());


        return new ResponseEntity<ErrorInfo>( errorinfo , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ZeroException.class)
    public ResponseEntity<ErrorInfo>myException(ZeroException exception2){

        ErrorInfo errorinfo = new ErrorInfo();
        errorinfo.setErrorMessage(exception2.getMessage());
        errorinfo.setStatus(HttpStatus.NOT_FOUND.toString());
        errorinfo.setLocalDateTime(LocalDateTime.now());


        return new ResponseEntity<ErrorInfo>( errorinfo , HttpStatus.NOT_FOUND);
    }

   
}
