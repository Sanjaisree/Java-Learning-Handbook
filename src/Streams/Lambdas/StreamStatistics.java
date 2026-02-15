package Streams.Lambdas;

import java.util.*;
import java.util.stream.*;

public class StreamStatistics{

    public static void main(String[] args) {

        // Generate 100 random integers between 1 and 1000
        List<Integer> numbers = new Random()
                .ints(100, 1, 1001)
                .boxed()
                .collect(Collectors.toList());

        // Single pass statistics
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        // Print results
        System.out.println("Count   : " + stats.getCount());
        System.out.println("Sum     : " + stats.getSum());
        System.out.println("Min     : " + stats.getMin());
        System.out.println("Max     : " + stats.getMax());
        System.out.println("Average : " + stats.getAverage());
    }
}
