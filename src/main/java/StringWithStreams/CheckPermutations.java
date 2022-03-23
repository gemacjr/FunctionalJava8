package StringWithStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckPermutations {

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false; // Permutations must be same length

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters array has no negative values, and therefore no positive values either
    }

    static boolean perm(String[] strings){

        final List<String> collect = Arrays.stream(strings).collect(Collectors.toList());
        return collect.stream().distinct().count() <= 1;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
//        for (String[] pair : pairs) {
//            String word1 = pair[0];
//            String word2 = pair[1];
//            boolean anagram = permutation(word1, word2);
//            System.out.println(word1 + ", " + word2 + ": " + anagram);
//        }
        final List<String[]> collect = Arrays.stream(pairs).filter(CheckPermutations::perm).collect(Collectors.toList());

        System.out.println(collect.size());

    }
}
