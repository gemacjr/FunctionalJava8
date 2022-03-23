package FuncProgrammingInJava;

import java.util.List;
import java.util.stream.Collectors;

public class IterateAString {
    public static void main(String[] args) {
        String str = "Wooter";
        final List<Character> collectList = str.chars()
                .mapToObj(ch -> Character.valueOf((char) ch))
                .collect(Collectors.toList());

        System.out.println(collectList);
    }

    static void printChar(int aChar){
        System.out.println((char)(aChar));
    }
}
