package FunctionalHighOrder;

interface Function<T, R>{
    R apply(T t);
}

public class PartialAdd {

    Function<Integer, Integer> add(final int x){
        Function<Integer, Integer> partialAdd = new Function<Integer, Integer>(){
            @Override
            public Integer apply(Integer y){
                return y + x;
            }
        };
        return partialAdd;
    }

    public static void main(String[] args) {
        PartialAdd pa = new PartialAdd();
        Function<Integer, Integer> add10 = pa.add(10);
        Function<Integer, Integer> add20 = pa.add(20);

        System.out.println(add10.apply(5));
        System.out.println(add20.apply(5));
    }
}
