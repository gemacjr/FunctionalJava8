package FuncProgrammingInJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TransformList {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");

        List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

//        friends.stream()
//                .map(String::toUpperCase)
//                .forEach(System.out::println);

        List<String> startsWithN =
                friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .collect(Collectors.toList());

        System.out.println(startsWithN);

        System.out.println(String.format("Found %d names", startsWithN.size()));

        Predicate<String> startWithN = name -> name.startsWith("N");

        long countFriendsStartN = friends.stream().filter(startWithN).count();
    }
}
