package PAcktpubFunctionalProgrammingJava.Chapter2;

@FunctionalInterface
public interface IntegerConcatenation {
    public String concatenate(Integer n1, Integer n2) throws IllegalArgumentException;
}
