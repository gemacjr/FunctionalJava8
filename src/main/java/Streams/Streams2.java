package Streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Streams2 {

    public static void main(String[] args) {
        statistics();
    }
    private static void statistics() {
        List<Integer> nums = Arrays.asList(3, 7, 1, 8, 2, 9, 5, 6);

        IntSummaryStatistics stats = nums.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Maximum number in List : " + stats.getMax());
        System.out.println("Minimum number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
