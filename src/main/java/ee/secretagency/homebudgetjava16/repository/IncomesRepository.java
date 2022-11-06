package ee.secretagency.homebudgetjava16.repository;

import ee.secretagency.homebudgetjava16.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IncomesRepository extends JpaRepository<Income, Long> {
}
