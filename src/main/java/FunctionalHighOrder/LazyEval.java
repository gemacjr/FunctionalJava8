package FunctionalHighOrder;

import java.util.function.Function;

public class LazyEval {
    public static void main(String[] args) {
        Function<Integer, Integer> square = new Function<Integer, Integer>(){
            {
                System.out.println("SQUARE");
            }
            @Override
            public Integer apply(Integer t){
                System.out.println("in square");
                return t * t;
            }
        };
        Function<Integer, Integer> cube = new Function<Integer, Integer>()
        {
            {
                System.out.println("CUBE");
            }

            @Override
            public Integer apply(Integer t)
            {
                System.out.println("in cube");
                return t * t * t;
            }
        };

        System.out.printf("%d%n", ifThenElse(true, square, cube, 4));
        System.out.printf("%d%n", ifThenElse(false, square, cube, 4));
    }

    static <T, R> R ifThenElse(boolean predicate, Function<T, R> onTrue,
                               Function<T, R> onFalse, T t){
        return (predicate ? onTrue.apply(t) : onFalse.apply(t));
    }
}
