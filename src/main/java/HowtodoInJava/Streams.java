package HowtodoInJava;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        // Stream.of()
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        //stream.forEach(p -> System.out.print(p));

        Stream<Integer> arrayStream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
        //arrayStream.forEach(p -> System.out.println(p));

        List<Integer> list = Arrays.asList(2,3,4,5,6,71,5);

        //list.stream().forEach(p -> System.out.println(p));

        // Stream.generate()
        Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
        final List<Integer> randomList = randomNumbers.limit(20).collect(Collectors.toList());

        //System.out.println(randomList);

        // Stream of String chars or tokens
        final IntStream streamChars = "12345_abcdefg".chars();
        //streamChars.forEach(p -> System.out.print( (char) p));


        // Stream Collectors
        final List<Integer> evenNumbers = list.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        //System.out.println(evenNumbers);

        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        Predicate<String> predicate1 = s -> s.startsWith("A");
        Predicate<String> predicate2 = t -> t.length() > 5;

        final List<String> aList = memberNames.stream()
                .filter(predicate1)
                .filter(predicate2)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        //System.out.println(aList);

        // Sorted toUppercase

        final List<String> sortedUpperCase = memberNames.stream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        //System.out.println(sortedUpperCase);

        // Stream.collect()

        List<String> memNamesInUppercase = memberNames.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.print(memNamesInUppercase);

        // Stream.match()

        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);     //true

        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);     //false

        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);     //false

        // Stream.count()

        long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();

        System.out.println(totalMatched);     //2

        // Stream.reduce()
        //The reduce() method performs a reduction on the elements of the stream with the given function.
        // The result is an Optional holding the reduced value.
        Optional<String> reduced = memberNames.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

        //Stream.anyMatch()
        boolean matched = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));

        System.out.println(matched);    //true

        // Stream.findFirst()

        String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst()
                .get();

        System.out.println(firstMatchedName);    //Lokesh

        // PARALLEL STREAMS

        List<Integer> numsList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        final Stream<Integer> integerStream = numsList.parallelStream();
        Integer[] evenNumsArr = integerStream.filter(i -> i % 2 == 0).toArray(Integer[]::new);

        System.out.println(Arrays.toString(evenNumsArr));
    }
}
