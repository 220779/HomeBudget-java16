package ee.secretagency.homebudgetjava16.controller.rest;


import ee.secretagency.homebudgetjava16.dto.ErrorInfo;
import ee.secretagency.homebudgetjava16.exception.IncomeNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.ZonedDateTime;

@RestControllerAdvice
@Slf4j
public class IncomeAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IncomeNotFound.class)
    public ErrorInfo handleIncomeNotFoundException (IncomeNotFound exc) {
       log.debug("handling not found incomes");
       log.warn("income not found", exc);
        return ErrorInfo.builder()
                .status(404)
                .error("income not found")
                .messages(exc.getMessage())
                .timeStamp(ZonedDateTime.now())
                .path(ServletUriComponentsBuilder.fromCurrentRequest().toUriString()) //TODO:
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorInfo handleVaslidationException(MethodArgumentNotValidException exc){
        return ErrorInfo.builder()
                .status(400)
                .error("validation failed")
                .timeStamp((ZonedDateTime.now()))
                .path(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString())
                .build();
    }

}
//log levels
// -error
// - warn
// - info  - default one
// - debug
// - trace