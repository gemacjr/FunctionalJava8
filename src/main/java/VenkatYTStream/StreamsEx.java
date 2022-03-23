package VenkatYTStream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamsEx {

    public static int doubleIt(int number){
        try { Thread.sleep(100);} catch(Exception ex){}
        return number * 2;
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector){
        return numbers.stream()
                .filter(selector)
                .reduce(0, Math::addExact);
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        System.out.println(numbers.parallelStream()
                .mapToInt(StreamsEx::doubleIt)
                .sum());

        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(totalValues(values, e -> e % 2 == 0));
        System.out.println(totalValues(values, e -> e % 2 != 0));
    }
}
