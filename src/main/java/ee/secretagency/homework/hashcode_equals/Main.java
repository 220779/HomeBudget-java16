package ee.secretagency.homework.hashcode_equals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Car toyota = new Car("Toyota", "Corolla");
        Car toyotaCopy = new Car("Toyota", "Corolla");
        Car toyota2 = new Car("Toyota", "Corolla");



        System.out.printf("toyota: [%s]%n", toyota);
        System.out.println("toyota == toyotaCopy:  " +
                (toyota == toyotaCopy));
        System.out.println("toyota == toyotaCopy:  " +
                (toyota == toyota2));

        System.out.println("now with equals");
        System.out.println("toyota.equals(toyotaCopy): " +
                toyota.equals((toyotaCopy)));
        System.out.println("toyota.equals(toyotaCopy): " +
                (toyota.equals((toyota2))));

        List<Car> carList = new ArrayList<>();

        Set<Car> cars = new HashSet<>();
        cars.add(toyota);
        cars.add(toyotaCopy);
        System.out.println("cars size : &d".formatted(cars.size()));
    }
    }

