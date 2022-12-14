package ee.secretagency.homebudgetjava16.controller.rest;


import ee.secretagency.homebudgetjava16.entity.Income;
import ee.secretagency.homebudgetjava16.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@CrossOrigin("*")
public class IncomeController {

    private final IncomeService service;

    public IncomeController(IncomeService service) {
        this.service = service;
    }

    // TODO: handle paging and sorting
    @GetMapping("/incomes")
    public List<Income> getAllIncomes() {
        log.info("getting all incomes");

        return service.readAllIncomes();
    }

    @GetMapping("/incomes/{id}")
    public Income getIncomeById(@PathVariable("id") Long idOfIncome) {
        log.info("trying to get income with id: [{}]", idOfIncome);

        return service.readIncomeByIdBetterWay(idOfIncome);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/incomes/{id}")
    public void deleteIncomeById(@PathVariable("id") Long id) {
        log.info("trying to delete income with id: [{}]", id);

        service.deleteIncomeWithIdBetter(id);
    }

    // TODO: fix id from the income
    @PostMapping("/incomes")
    public ResponseEntity<Income> createNewIncome(@RequestBody Income income) {
        log.info("creating new income: [{}]", income);

        Income newIncome = service.createNewIncome(income);

        return ResponseEntity.created(URI.create("/incomes/" + newIncome.getId()))
                .body(newIncome);
    }
}



















