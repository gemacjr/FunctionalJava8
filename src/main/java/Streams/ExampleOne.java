package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleOne {


    public static void main(String[] args) {

        List<String> names = Arrays.asList("Johnny", "", "Peter", "Sean", "", "George");
        List<String> filtered = names.stream().filter(name -> !name.isEmpty()).collect(Collectors.toList());
        List<String> filtered2 = names.parallelStream().filter(name -> !name.isEmpty()).collect(Collectors.toList());

// names = [Johnny, , Peter, Sean, , George]
// filtered = [Johnny, Peter, Sean, George]
// filtered2 = [Johnny, Peter, Sean, George]


        List<Integer> nums = Arrays.asList(3, 7, 1, 8, 2, 4, 9, 5, 6);

        // forEach
        System.out.println("forEach");
        nums.stream().forEach(System.out::println);

        List<Integer> result;

        // map
        System.out.print("map:    ");
        result = nums.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(result);

        // filter
        System.out.print("filter: ");
        result = nums.stream().filter(i -> i > 4).collect(Collectors.toList());
        System.out.println(result);

        // limit
        System.out.print("limit:  ");
        result = nums.stream().limit(3).collect(Collectors.toList());
        System.out.println(result);

        // sorted
        System.out.print("sorted: ");
        result = nums.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        // pipelining
        List<Integer> nums1 = Arrays.asList(3, 7, 1, 8, 2, 9, 5, 6);
        System.out.print("pipelining: ");
        List<Integer> result1 = nums1.stream().sorted().filter(i -> i > 4).limit(3).map(i->i*i).collect(Collectors.toList());
        System.out.println(result1);

        // Collectors
        List<String> names2 = Arrays.asList("Johnny", "", "Peter", "Sean", "", "George");

        // convert stream to list
        List<String> filtered3 = names2.stream().filter(name -> !name.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered3);

        // convert list to string with common as delimiter
        String merged = names.stream().filter(name -> !name.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + merged);
    }

}
