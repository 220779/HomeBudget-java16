package ee.secretagency.example.homebudgetjava16;

import ee.secretagency.endofthegame.homework.exercise1.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeBudgetJava16Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeBudgetJava16Application.class, args);
    }

    //TODO: Explain
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }
}


