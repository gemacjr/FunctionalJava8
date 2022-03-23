package VenkatYTStream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class PersonStreamEx {

    private static List<Person> createPeople(){
        return List.of(
                new Person("Sara", 20),
                new Person("Nancy", 22),
                new Person("Bob", 20),
                new Person("Paula", 32),
                new Person("Paul", 32),
                new Person("Jack", 3),
                new Person("Bill", 72),
                new Person("Jill", 11)
                );
    }

    public static void main(String[] args) {
        // OOP: Polymorphism

        // Functional Programming:
            //Functional Composition + lazy evaluation

        System.out.println(createPeople().stream()
        //.collect(toMap(keyFunction, valueFunction)));
                //.collect(toMap(person -> person.getName(), person -> person.getAge())));
        .collect(toMap(Person::getName, Person::getAge)));
        List<Integer> ages = createPeople().stream()
                .map(Person::getAge)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(ages);
        System.out.println(ages.getClass());

        System.out.println(createPeople().stream()
                .map(Person::getAge)
                //.reduce(0, (total, age) -> total + age));
                //.reduce(0, (total, age) -> Integer.sum(total, age);
                .reduce(0, Integer::sum));

        System.out.println(createPeople().stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(joining(", ")));

        List<Person> people = createPeople();


        Map<String, List<Integer>> ageByName = people.stream()
                .collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));

        System.out.println(ageByName);

        Map<String, List<Person>> byName = people.stream()
                .collect(groupingBy(Person::getName));

        System.out.println(byName);

        System.out.println(people.stream()
                .map(Person::getName)
                .flatMap(name -> Stream.of(name.split("")))
                .collect(Collectors.toList()));

//        System.out.println(people.stream()
//                .collect(partitioningBy(person -> person.getAge() % 2 == 0)));

        Map<String, Long> countByName = people.stream()
                .collect(groupingBy(Person::getName, counting()));

        System.out.println(people.stream()
                .collect(maxBy(comparing(Person::getAge))));

        String result = people.stream()
                .collect(collectingAndThen(
                        maxBy(comparing(Person::getAge)),
                        person -> person.map(Person::getName).orElse("")
                ));

        System.out.println(result);

        System.out.println(people.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getName,
                                filtering(name -> name.length() > 4, toList())))));

        List<Integer> numbers = List.of(1, 2, 3);

        // one-to-one function
        System.out.println(numbers.stream()
                .map(e -> e * 2)//one-t0-one function
                .collect(toList()));
        //Stream<T>.map(f11) ==> Stream<R>

        // one-to-many function
        System.out.println(numbers.stream()
                .map(e -> List.of(e - 1, e + 1)) //one-to-many function
                .collect(toList()));


    }
}
