package com.blit;

/* Learning about Streams and Collectors in Java. Useful for accumulating
 * and reducing Elements into collections, summurizing elements according
 * to various conditions.
 * 
 * A Stream is a sequence of elements that supports aggregate operations
 * sych as filtering, mapping, sorting, and more. Part of java.util.stream
 * pacakge.
 * 
 * Streams provide a declarative and functional approach to processing
 * collections of data. Express complex data processing pipelines.
 * 
 * Streams supports parallelism to improve performance.
 * Streams are immutable. They produce a new stream when a transformation
 * is applied.
 */    

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class HelloStreams {

    public HelloStreams () {
        List<Integer> numbers = Arrays.asList(2, 5, 6, 7, 33, 21, 84, 86);

        List<Integer> numPlus1 = numbers.stream()
            .map((x) -> {
                return x+1;
            })
            .sorted()
            .collect(Collectors.toList());

        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);

        List<String> names = Arrays.asList("Tom", "Tim", "Jerry", "Todd",
          "Megan", "Keith");
        
        names.stream()
            .sorted((s, t) -> { return s.compareTo(t)*-1; })
            .filter((s) -> { return (int)s.charAt(0) > (int)'L'; })
            .forEach((s) -> { System.err.println(s);} );
    }

}
