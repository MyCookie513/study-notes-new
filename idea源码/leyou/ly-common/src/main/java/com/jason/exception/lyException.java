package com.jason.exception;

import com.jason.Enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class lyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;
}
