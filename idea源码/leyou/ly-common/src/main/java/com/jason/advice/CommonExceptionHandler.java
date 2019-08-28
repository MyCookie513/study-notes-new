package com.jason.advice;

import com.jason.Enums.ExceptionEnum;
import com.jason.exception.lyException;
import com.jason.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(lyException.class)
    public ResponseEntity<ExceptionResult >  handleExeception(lyException e){
        ExceptionEnum exceptionEnum=e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode()).body(new ExceptionResult(exceptionEnum));

    }
}
