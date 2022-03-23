package Streams;

import java.util.Optional;

public class OptionalClass {
    public static void main(String args[]) {
        Integer value1 = null;
        Integer value2 = 10;

        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        OptionalSum os = new OptionalSum();
        System.out.println(os.sum(a,b));
    }
}
