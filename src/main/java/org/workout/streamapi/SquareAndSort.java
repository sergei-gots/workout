package org.workout.streamapi;

import java.util.Arrays;

public class SquareAndSort {

    public static void workout() {
        int[] nums = { -4, -1, 0, 3, 10 };
        System.out.println("squareAndSort(nums)=" + Arrays.toString(squareAndSort(nums)));
    }

    public static int[] squareAndSort(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .map(i -> i*i)
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
