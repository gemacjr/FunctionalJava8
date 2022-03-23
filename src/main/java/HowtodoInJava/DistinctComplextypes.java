package HowtodoInJava;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctComplextypes {
    public static void main(String[] args)
    {
        Person lokeshOne = new Person(1, "Lokesh", "Gupta");
        Person lokeshTwo = new Person(2, "Lokesh", "Gupta");
        Person lokeshThree = new Person(3, "Lokesh", "Gupta");
        Person brianOne = new Person(4, "Brian", "Clooney");
        Person brianTwo = new Person(5, "Brian", "Clooney");
        Person alex = new Person(6, "Alex", "Kolen");

        //Add some random persons
        Collection<Person> list = Arrays.asList(alex,
                brianOne,
                brianTwo,
                lokeshOne,
                lokeshTwo,
                lokeshThree);

        //1 - Using default equals() methods

        // Get distinct people by id
        List<Person> distinctElements = list.stream()
                .distinct()
                .collect( Collectors.toList() );

        // Let's verify distinct people
        System.out.println( distinctElements );

        //2 - Using custom equality

        // Get distinct objects by key
        distinctElements = list.stream()
                .filter( distinctByKey(p -> p.getFname() + " " + p.getLname()) )
                .collect( Collectors.toList() );

        // Again verify distinct people
        //System.out.println( distinctElements );

        Collection<Person> list1 = Arrays.asList(alex, brianOne,
                brianTwo, lokeshOne,
                lokeshTwo, lokeshThree);

        List<Person> distinctPersons = list1.stream()
                .filter(distinctByKeys(Person::getFname, Person::getLname))
                .collect(Collectors.toList());

        System.out.println(distinctPersons);
    }

    //Utility function
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private static <T> Predicate<T> distinctByKeys(final Function<? super T, ?>... keyExtractors)
    {
        final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

        return t ->
        {
            final List<?> keys = Arrays.stream(keyExtractors)
                    .map(ke -> ke.apply(t))
                    .collect(Collectors.toList());

            return seen.putIfAbsent(keys, Boolean.TRUE) == null;
        };
    }
}
