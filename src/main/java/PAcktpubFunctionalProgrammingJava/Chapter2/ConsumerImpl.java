package PAcktpubFunctionalProgrammingJava.Chapter2;

import java.util.function.Consumer;

public class ConsumerImpl<T> implements Consumer<T> {
    @Override
    public void accept(T t) {
        System.out.println("In consumerImpl : " + t);
    }
}
