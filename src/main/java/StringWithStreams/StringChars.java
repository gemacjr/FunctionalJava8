package StringWithStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringChars {

    public static void main(String[] args) {
        String testString = "Example";
        final IntStream chars = testString.chars();

        final List<Character> listOfChars = testString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

//
//        Stream<Character> characterStream = testString.chars()
//                .mapToObj(c -> (char) c);
//        final List<Character> listOfChars = characterStream.collect(Collectors.toList());


        System.out.println(listOfChars);

        IntStream intStream1 = testString.codePoints();

        Stream<Character> characterStream2
                = testString.codePoints().mapToObj(c -> (char) c);

        characterStream2.forEach(System.out::print);

        Stream<String> stringStream = testString.codePoints()
                .mapToObj(c -> String.valueOf((char) c));
    }
}
