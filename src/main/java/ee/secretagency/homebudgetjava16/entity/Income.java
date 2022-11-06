package ee.secretagency.homebudgetjava16.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    Long id;
    @Enumerated(EnumType.STRING)
    IncomeCategory category;
    String currency;
    BigDecimal amount;
    String person;
    ZonedDateTime timeStamp;
}

