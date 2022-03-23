package FunctionalHighOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HigherOrderFunctions {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("One");
        list.add("Abc");
        list.add("BCD");

        Collections.sort(list, (String a, String b) -> {
            return a.compareTo(b);
        });

        System.out.println(list);

        Comparator<String> comparator = (String a, String b) -> {
            return a.compareTo(b);
        };

        Comparator<String> comparatorReveresed = comparator.reversed();
        Collections.sort(list, comparatorReveresed);

        System.out.println(list);
    }
}
