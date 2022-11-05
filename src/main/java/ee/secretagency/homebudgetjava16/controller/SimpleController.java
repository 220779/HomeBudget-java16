package ee.secretagency.homebudgetjava16.controller;

import ee.secretagency.homebudgetjava16.entity.Address;
import ee.secretagency.homebudgetjava16.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    // /me?my-name=Kuno&my-surname= K.
    @GetMapping("/me")
    public Person showMyData(@RequestParam(value = "my-name", defaultValue = "Jackie") String myName,
                             @RequestParam(value = "my-surname", defaultValue = "Chan") String mySurname) {
        log.info("showing my personal data");
        log.info("received name: " + myName + ", and surname: " + mySurname); // don't use with logger :)
        log.info("received name: [{}], and surname: [{}]", myName, mySurname);

        return new Person(myName, mySurname, 18,
                new Address("Estonia", "Tartu"));
    }
}
