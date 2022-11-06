package ee.secretagency.homebudgetjava16.controller.rest;


import ee.secretagency.homebudgetjava16.entity.Income;
import ee.secretagency.homebudgetjava16.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class IncomeController {

    private final IncomeService service;

    public IncomeController(IncomeService service) {
        this.service = service;
    }

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
    public void  deleteIncomeById(@PathVariable("id") Long id) {
        log.info("trying to delete income with id: [{}]", id );

        service.deleteIncomeWithId(id);
    }

    }

//   @GetMapping("/incomes/{id}")
//   public Income readIncomeById(Long id) {
//       log.info("reading income with id: [{}]", id);
//       Income incomeFromRepository = null;
//  //     try {
////            incomeFromRepository = repository.getOne(id);
//       if (incomeFromRepository == null) {
//           log.info("It's null");
//       } else {
//           log.info("It's not null");
//       }
////            log.info("" + incomeFromRepository);
////            log.info("read income: [{}]", incomeFromRepository);
////
////        } catch (EntityNotFoundException e) {
////            log.warn("some unexpected exception has occurred", e);
////            return null;
////        }
//        return incomeFromRepository;



