package ee.secretagency.homework.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("one");
        var oldWayOfCreatingStringList = Arrays.asList("one", "two");
        //       oldWayOfCreatingStringList.add("three");
        var persons = List.of(
                new Person("Kuno", "Kitsing", 100, 101),
                new Person("Juku", "Kama", 100, 102),
                new Person("Sergei", "Varon", 100, 103),
                new Person("Anna", "Minna", 100, 103)
        );

        //make collections with names, loops approach

        List<String> justNames = new ArrayList<>();
        for (var person : persons) {
            justNames.add(person.name());
        }
        System.out.println("Just names:" + justNames);

        //make a collection with names of people who are older then 30

        List<String> justNamesOlderPersons = new ArrayList<>();
        for (var person : persons) {

            if (person.age() > 30) {
                justNamesOlderPersons.add(person.name());
            }

            System.out.println("Just names:" + justNamesOlderPersons);

            System.out.println("NOW STREAMS");

           var nameWithStream = persons.stream()
                    .map(person1 -> person.name())
       //             .toList()
                    .collect(Collectors.toList());

            System.out.println("streams - just names: " + nameWithStream);

            var olderPersonFilteredWithStrerams = persons.stream()
                    .filter(person1 -> person.age() > 30)
                    .map(person1 -> person.name())
                    .toList();

            System.out.println("stream - older persons. " + olderPersonFilteredWithStrerams);

            persons.stream()
                    .filter(person1 -> person.age() < 30)
                    .map(person1 -> person.height())
                    .forEach(height -> System.out.println("person height: " + height));

            persons.stream()
                    .filter(person1 -> {
                        System.out.println("checking person: " + person);
                        return person.age() < 30;
                    })
                    .map(person1 -> {
                        System.out.println("mapping to names : ".formatted(person, person.name()) );
                        return person.name();
                    })
                    .toList();
        }
    }
}
