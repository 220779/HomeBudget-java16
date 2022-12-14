package ee.secretagency.homebudgetjava16.service;

import ee.secretagency.homebudgetjava16.entity.Income;
import ee.secretagency.homebudgetjava16.exception.IncomeNotFound;
import ee.secretagency.homebudgetjava16.repository.IncomesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
public class IncomeService {

    private final IncomesRepository repository;

    public IncomeService(IncomesRepository repository) {
        this.repository = repository;
    }

    public List<Income> readAllIncomes() {
        //  List<Income> result = repository.findAll();
        var incomesFromDb = repository.findAll();

        log.info("incomes from datasource: {}", incomesFromDb);
        return incomesFromDb;


    }

    public Income readIncomeById(Long id) {
        log.info("reading income with id: [{}]", id);
        Income incomeFromRepository = null;
        try {
            incomeFromRepository = repository.getOne(id);
            if (incomeFromRepository == null) {
                log.info("It's null");
            } else {
                log.info("It's not null");
            }
            log.info("" + incomeFromRepository);
            log.info("read income: [{}]", incomeFromRepository);

        } catch (EntityNotFoundException e) {
            log.warn("some unexpected exception has occurred", e);
            return null;
        }
        return incomeFromRepository;
    }

    public Income readIncomeByIdBetterWay(Long id) {
        log.info("reading income with id: [{}] - better way", id);
        var maybeIncome = repository.findAll();
        // return maybeIncome.orElse(null);
        //return maybeIncome.orElseThrow(()-> new IncomeNotFound("no Entity"));
        return null;
    }

    public void deleteIncomeWithId(Long id) {
        log.info("deleting income with id: [{}]", id);
        try {
            repository.deleteById(id);
            } catch (EmptyResultDataAccessException exc) {
            log.warn("Trying to delete non existing income", exc);
            throw new IncomeNotFound("No existing income");
       }
    }
    //second deleting solution
    @Transactional
    public void deleteIncomeWithIdBetter(Long id) {
        log.info ("delete income with id: [{}]", id);

                if(repository.existsById(id)){
                    repository.deleteById(id);
                } else {
                    throw new IncomeNotFound("No existing income with id: [%d]".formatted(id));

                }
    }

    public Income createNewIncome(Income income) {

        return null;
    }
}




