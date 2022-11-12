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
                new Person("Kuno", "Kitsing", 11, 181),
                new Person("Juku", "Kama", 24, 157),
                new Person("Sergei", "Varon", 45, 192),
                new Person("Anna", "Minna", 66, 183)
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
        }
        System.out.println("Just names older persons:" + justNamesOlderPersons);

        System.out.println("NOW STREAMS");

        var nameWithStream = persons.stream()
                .map(person -> person.name())
                //             .toList()
                .collect(Collectors.toList());

        System.out.println("streams - just names: " + nameWithStream);

            var olderPersonFilteredWithStreams = persons.stream()
                    .filter(person -> person.age() > 30)
                    .map(person -> person.name())
                    .toList();

            System.out.println("stream - older persons. " + olderPersonFilteredWithStreams);

            persons.stream()
                    .filter(person -> person.age() < 30)
                    .map(person -> person.height())
                    .forEach(height -> System.out.println("person height: " + height));

            persons.stream()
                    .filter(person -> {
                        System.out.println("checking person: " + person);
                        return person.age() < 30;
                    })
                    .map(person -> {
                        System.out.println("mapping to names : ".formatted(person, person.name()) );
                        return person.name();
                    })
                    .toList();

        //    persons.stream()
        //            .
    }




    }

