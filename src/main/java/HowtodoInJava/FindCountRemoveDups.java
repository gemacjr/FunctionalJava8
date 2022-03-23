package HowtodoInJava;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindCountRemoveDups {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

// Get list without duplicates
        Set<String> distinctItems = list.stream()
            //    .distinct()
                .collect(Collectors.toSet());

// Let's verify distinct elements
        System.out.println(distinctItems);
    }
}
