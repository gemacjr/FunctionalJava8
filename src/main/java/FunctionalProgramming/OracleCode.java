package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;

public class OracleCode {

    public static void main(String[] args) {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors =
                Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades =
                Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

        final long countFriendsStartN = friends.stream()
                .filter(name -> name.startsWith("N"))
                .count();

        //System.out.println(countFriendsStartN);

        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final long countFriendsStartNPred =
                friends.stream()
                        .filter(startsWithN)
                        .count();

        //System.out.println(countFriendsStartNPred);


//        final long countFriendsStartWithN = friends.stream()
//                .filter(checkIfStartsWith("N"))
//                .count();
//
//        System.out.println(countFriendsStartWithN);

        pickName(friends, "N");

        System.out.println("Total number of characters in all names: " +
                        friends.stream()
                                .mapToInt(name -> name.length())
                                .sum());

        final Optional<String> aLongName =
                friends.stream()
                        .reduce((name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name ->
                System.out.println(
                        String.format("A longest name: %s", name)));

        final String steveOrLonger =
                friends.stream()
                        .reduce("Steve", (name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);

        System.out.println(steveOrLonger);

        final String join = String.join(", ", friends);
        System.out.println("Join friends " + String.join(", ", friends));

        System.out.println(
                friends.stream()
                        .map(String::toUpperCase)
                        .collect(joining(", ")));
    }
    public static void pickName(
            final List<String> names,
            final String startingLetter) {
        final Optional<String> foundName =
                names.stream()
                        .filter(name -> name.startsWith(startingLetter))
                        .findFirst();
        System.out.println(
                String.format("A name starting with %s: %s",
                        startingLetter, foundName.orElse("No name found")));
    }


//    static Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
//        Predicate<String> chaeckStarts = (String name) -> name.startsWith(letter);
//        return chaeckStarts;
//    }

        static Predicate<String> checkIfStartsWith ( final String letter){
            return name -> name.startsWith(letter);
        }

}
