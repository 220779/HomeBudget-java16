package ee.secretagency.homebudgetjava16.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name = "category_ID")
    IncomeCategory category;
    String currency;
    BigDecimal amount;
    String person;
    ZonedDateTime timeStamp;
}

