package org.workout.streamapi;

import java.util.*;
import java.util.stream.Collectors;



public class StringsSortedAndGroupedByLength {
    public static void main(String [] args) {
        workout();
    }

    public static void workout() {
        List<String> list = Arrays.asList("apple", "banana", "orange", "pear", "grape", "kiwi");
        System.out.println("groupAndSortByLength=" + groupAndSortByLength(list));
    }

    public static Map<Integer, List<String>> groupAndSortByLength(List<String> stringList) {
        return stringList
                .stream()
                .collect(Collectors.groupingBy(String::length, LinkedHashMap::new,
                        Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)
                        )
                )
                .entrySet()
                .stream()
                //min to max
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                //max to min
                .sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}