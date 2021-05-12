package com.octopusthu.javaengineering.tournament.web;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * RestControllerAdvice
 *
 * @author octopusthu@gmail.com
 */
@RestControllerAdvice
public class GlobalRestControllerAdvice {

    /**
     * 处理 DomainObjectException
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainObjectException.class)
    public String handleDomainObjectException(DomainObjectException exception) {
        return exception.getMessage();
    }
}
