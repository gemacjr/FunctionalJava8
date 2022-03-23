package HowtodoInJava;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsJoining {
    public static void main(String[] args)
    {
        Stream<String> words = Arrays.asList("A", "B", "C", "D").stream();

        String joinedString = words.collect(Collectors.joining());    //ABCD

        System.out.println( joinedString );

        final String collectString = words.collect(Collectors.joining(","));//A,B,C,D

        System.out.println( collectString);

        final String collectStr2 = words.collect(Collectors.joining(",", "{", "}"));//{A,B,C,D}

        System.out.println( collectStr2 );
    }
}
