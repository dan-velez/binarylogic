package com.blit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloStreams {
 
    public HelloStreams () {
        List<Integer> numbers = Arrays.asList(2, 5, 8, 6, 33, 21, 84, 86, 78);
        List<Integer> numsPlus1 = 
            numbers.stream().map((x) -> {
                return x+1;
            }).sorted().collect(Collectors.toList());
        
        System.out.println(numbers);
        System.out.println(numsPlus1);

        List<String> names = Arrays.asList("Tim", "Tom", "Jerry", "Todd",
            "Megan", "Keith", "Jack", "Bob");
        
        System.out.println(names);

        names.stream()
            .sorted((s, t) -> { return s.compareTo(t) * -1; })
            .filter((s) -> { return (int)s.charAt(0) > (int)'L'; })
            .forEach((s) -> { System.out.println(s); });
    }

}
