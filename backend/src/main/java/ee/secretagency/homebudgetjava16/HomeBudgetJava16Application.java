package ee.secretagency.homebudgetjava16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeBudgetJava16Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeBudgetJava16Application.class, args);
    }

    //use @Bean for direct creation of spring beans
//    @Bean
//    public Calculator calculator(){
//        return new Calculator();
//    }
}


