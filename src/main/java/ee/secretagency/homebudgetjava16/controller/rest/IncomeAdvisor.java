package ee.secretagency.homebudgetjava16.controller.rest;


import ee.secretagency.homebudgetjava16.exception.IncomeNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class IncomeAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IncomeNotFound.class)
    public String handleIncomeNotFoundException () {
     //   log.info("handling not found incomes");
        return "cannot find this income";
    }

}
