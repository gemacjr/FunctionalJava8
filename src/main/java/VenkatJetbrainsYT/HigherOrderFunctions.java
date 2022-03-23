package VenkatJetbrainsYT;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class HigherOrderFunctions {

    public static boolean isGreaterThan3(int number){
        return number > 3;
    }
    public static boolean isEven(int number){
        return number % 2 == 0;
    }
    public static int doubleNumber(int number){
        return number * 2;
    }
    public static void main(String[] args) {
        // find the double of the first even number greater than 3

        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);

        final Integer result = values.stream()
                .filter(HigherOrderFunctions::isGreaterThan3)
                .filter(HigherOrderFunctions::isEven)
                .map(HigherOrderFunctions::doubleNumber)
                .findFirst()
                .get();

        System.out.println(result);


    }


}
