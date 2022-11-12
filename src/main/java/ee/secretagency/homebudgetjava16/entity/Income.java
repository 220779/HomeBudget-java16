package ee.secretagency.homebudgetjava16.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "INCOMES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)

    @NotNull
    IncomeCategory category;

    @NotNull
    @Size(min = 3)
    String currency;

    @NotNull
    @Positive
    BigDecimal amount;
    String person;
    ZonedDateTime timeStamp;
}

