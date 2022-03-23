package PAcktpubFunctionalProgrammingJava;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Chapter1 {
    public static void main(String[] args) {

        //fluentInterfacesEx();
        //composeExample();
        //System.out.println(factorialStream(7));
        //List<Integer> fibonacci = getFibonacci(10);
        //System.out.println(fibonacci);
        //System.out.println(getFibonacciBI(1_000_000));
        //lambdaExpressionExamples();
    }

    private static void defaultInterfaceExamples() {
        ComputeImpl computeImpl = new ComputeImpl();
        System.out.println(computeImpl.doubleNumber(2));

        ArrayList<String> list = new ArrayList();
        list.add("Apple");
        list.add("Peach");
        list.add("Banana");
        list.forEach(f -> System.out.println(f));
    }

    private static void lambdaExpressionExamples() {
        Random random = new Random();
        random.ints().limit(5).map(x -> 2 * x).forEach(System.out::println);
        random.ints().limit(5).map(x -> {
            int y = 2 * x;
            return y;
        }).forEach(System.out::println);
        random.ints().limit(5).map(x -> 2 * x).forEach(System.out::println);
    }

    public static List<Integer> getFibonacci(int series) {
        return Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(series)
                .map(n -> n[0])
                .collect(toList());
    }

    public static BigInteger getFibonacciBI(int series) {
        return Stream.iterate(new BigInteger[]{
                        BigInteger.ZERO, BigInteger.ONE}, t -> new BigInteger[]{t[1], t[0].add(t[1])})
                .limit(series)
                .map(n -> n[1]) // find, we need n[1]
                .reduce((a, b) -> b).orElse(BigInteger.ZERO);

    }

    private static int factorialStream(int num){
        return IntStream.rangeClosed(2, num).reduce(1, (x, y) -> x * y);
    }

    private static void composeExample() {
        Function<Integer, Integer> absThenNegate
                = ((Function<Integer, Integer>) Math::negateExact).compose(Math::abs);
        Function<Integer, Integer> negateThenAbs
                = ((Function<Integer, Integer>) Math::negateExact).andThen(Math::abs);

        System.out.println(absThenNegate.apply(-25));
        System.out.println(absThenNegate.apply(25));
        System.out.println(negateThenAbs.apply(-25));
        System.out.println(negateThenAbs.apply(25));

    }

    private static void fluentInterfacesEx(){

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusYears(2);
        futureDate = today.minusMonths(1);
        futureDate = today.plusDays(3);

        System.out.println(LocalDate.now());
        System.out.println(futureDate);

        futureDate = LocalDate.now()
                .plusYears(2)
                .minusMonths(1)
                .plusDays(3);

        System.out.println(LocalDate.now());
        System.out.println(futureDate);

        // Stream example
        Stream<String> names = Stream.of("George", "Mary", "Karen","Jim");
        Function<String, String> toLower = (String name) -> name.toLowerCase();
        names.map(toLower).sorted().forEach(x -> System.out.println(x));
    }

    // High-order and first-class functions
    private static void highOrderFunctionExamples() {

        Integer arr[] = {1, 2, 3, 4, 5};
        List<Integer> numbers = Arrays.asList(arr);
        numbers.forEach(x -> System.out.println(x));
    }
}
