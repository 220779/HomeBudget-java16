package ee.secretagency.homebudgetjava16.exception;

import org.springframework.dao.EmptyResultDataAccessException;

public class IncomeNotFound extends RuntimeException {


    public IncomeNotFound(String formatted, EmptyResultDataAccessException exc) {
    }
}
