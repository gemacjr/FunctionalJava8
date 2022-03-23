package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsStuff {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        //numbers.forEach(System.out::print);

        int total = numbers.stream().reduce(0, (a,b) -> a + b);

        //System.out.println(total);

        Predicate<Integer> even = a -> a % 2 == 0;
        Predicate<Integer> odd = a -> a % 2 != 0;

        System.out.println("Even");
        print(numbers,even);
        System.out.println("Odd");
        print(numbers,odd);

        final int sumEven = sum(numbers, even);
        System.out.println(sumEven);
        final int sumOdd = sum(numbers, odd);
        System.out.println(sumOdd);

//        BiFunction<List<Integer>, Predicate<Integer>, Void> biFunc = StreamsStuff::print;
//        biFunc.apply(numbers, even);
    }

    static void print(List<Integer> numbers, Predicate<Integer> predicate){
        numbers.stream()
                .filter(predicate::test)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static int sum (List<Integer> numbers, Predicate<Integer> predicate) {
       return numbers.stream()
                .filter(predicate::test)
                .reduce(0, (a, b) -> a + b);
    }
}
