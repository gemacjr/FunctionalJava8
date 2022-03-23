package FuncProgrammingInJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComparePersons {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 40),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));

        List<Person> ascendingAge = people.stream()
                .sorted(Person::ageDifference)
                .collect(Collectors.toList());

        System.out.println(ascendingAge);
    }
}
