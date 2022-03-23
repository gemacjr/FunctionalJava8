package FunctionalHighOrder;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class Java8Tricks {

    public static void main(String[] args) {
        Apple apple1 = new Apple(30);
        Apple apple2 = new Apple(10);

        List<Apple> inventory = Arrays.asList(apple1,apple2);

        inventory.sort(comparing(Apple::getWeight));

        System.out.println(inventory);

        //inventory.stream().forEach(System.out::println);
    }
}
