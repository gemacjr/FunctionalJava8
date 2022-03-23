package FunctionalHighOrder;

public class EagerEval {

    public static void main(String[] args) {
        System.out.printf("%d%n", ifThenElse(true,square(4),cube(4)));
        System.out.printf("%d%n", ifThenElse(false,square(4),cube(4)));
    }

    static int cube(int x){
        System.out.println("in cube");
        return x * x * x;
    }

    static int ifThenElse(boolean predicate, int onTrue, int onFalse){
        return (predicate) ? onTrue : onFalse;
    }

    static int square(int x){
        System.out.println("in square");
        return x * x;
    }
}
