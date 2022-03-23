package HowtodoInJava;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
        List<Integer> ints = IntStream.iterate(0, i -> i + 2)
                .mapToObj(Integer::valueOf)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(ints);

        List<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(randomNumbers);

        List<Employee> employees = Stream.generate(Employee::create)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(employees);
    }
}
