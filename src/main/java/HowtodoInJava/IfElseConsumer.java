package HowtodoInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class IfElseConsumer {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Consumer<Integer> action = i -> {
            if( i % 2 == 0){
                System.out.println("Even number :: " + i);
            } else {
                System.out.println("Odd number :: " + i);
            }
        };

        numberList.stream().forEach(action);

        Arrays.asList(-1, 1, -2, 3, 4, -5, 6, 0).stream()
                .forEach(
                        i -> {
                            if (i == 0) {
                                System.out.println("Number is 0");
                            } else if (i > 0) {
                                System.out.println("Positive Number");
                            } else {
                                System.out.println("Negative Number");
                            }
                        }
                );

        ArrayList<Integer> numberList2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));


        Predicate<Integer> isEven = i -> i % 2 == 0;

        numberList2.stream()
                .filter(isEven)
                .forEach(System.out::println);
    }
}
