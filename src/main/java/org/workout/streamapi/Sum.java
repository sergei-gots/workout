package org.workout.streamapi;

import java.util.Arrays;

public class Sum {
    public static void workout () {
        int [] array  = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Arrays.stream(array).sum() of even numbers = " +
                Arrays
                        .stream(array)
                        .filter(i -> i%2 == 0)
                        .sum());
        System.out.println("Arrays.stream(array).sum() of even numbers^2 = " +
                Arrays
                        .stream(array)
                        .filter(i -> i%2 == 0)
                        .reduce(0,  (acc, i)-> acc + i*i));
    }
}
