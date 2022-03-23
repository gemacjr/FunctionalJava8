package FuncProgrammingInJava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElement {

    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        System.out.println("//" + "START:NAME_OUTPUT");
        pickName(friends, "N");
        pickName(friends, "Z");
        System.out.println("//" + "END:NAME_OUTPUT");

        final Optional<String> foundName =
                friends.stream()
                        .filter(name ->name.startsWith("N"))
                        .findFirst();

        System.out.println("//" + "START:CLOSURE_OUTPUT");
        foundName.ifPresent(name -> System.out.println("Hello " + name));
        System.out.println("//" + "END:CLOSURE_OUTPUT");

        System.out.println("//" + "END:SUM_OUTPUT");

        System.out.println("//" + "END:AVERAGE_OUTPUT");
        System.out.println("//" + "START:REDUCE_OUTPUT");
        final Optional<String> aLongName =
                friends.stream()
                        .reduce((name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name ->
                System.out.println(String.format("A longest name: %s", name)));
        System.out.println("//" + "END:REDUCE_OUTPUT");

        final String steveOrLonger =
                friends.stream()
                        .reduce("Steve", (name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);

        System.out.println(steveOrLonger);
    }

    static void pickName(final List<String> names, final String startingLetter){
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();
        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("No name found")));
    }
}
