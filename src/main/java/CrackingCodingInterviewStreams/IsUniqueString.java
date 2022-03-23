package CrackingCodingInterviewStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IsUniqueString {

    public static boolean isUniqueCharsStream(String str){
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).size() ==
                str.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        final List<String> collect = Arrays.stream(words).filter(IsUniqueString::isUniqueCharsStream).collect(Collectors.toList());
        System.out.println(collect);
    }
}
