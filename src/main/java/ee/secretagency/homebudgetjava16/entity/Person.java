package ee.secretagency.homebudgetjava16.entity;

public record Person(
        String name,
        String surname,
        int age,
        Address address
) {
}
