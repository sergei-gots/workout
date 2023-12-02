package org.workout.streamapi;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFirstUniqueValue {
    public static void main(String[] args) {
        workout();
    }

    public static void  workout() {
        int [] arr = { 4, 6, 9, 3, 2, 5, 2, 9, 7, 4, 9, 6, 3, 5, 2, 7 } ;

        System.out.println("First unique value: " +
            findFirstUniqueValue(arr));

    }

    private static Integer findFirstUniqueValue(int[] arr) {
        return Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.summingInt(e->1)))
                .entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 1)

                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }
}
