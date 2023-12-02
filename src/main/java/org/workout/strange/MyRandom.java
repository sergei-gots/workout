package org.workout.strange;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class MyRandom {

    private static int currentBase = (int) System.nanoTime();

    public static void workout() {
        myRandomWorkout(5, 10000);
        myRandomWorkout(10, 10000);
        myRandomWorkout(11, 10000);
        myRandomWorkout(20, 10000);
    }

    public static void myRandomWorkout(int max, int n) {
        System.out.println("myRandomWorkout with max=" + max);
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = getRandomInt(max);
        }

        System.out.println("Arrays.toString((result)) = " + Arrays.toString((result)));
        String s = Arrays.stream(result)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, TreeMap::new, Collectors.summingInt(e -> 1)))
                .toString();

        System.out.println("numbers of different counts =" + s);
    }

    /**
     * @return random in between 1 and max inclusively
     **/
    public static int getRandomInt(int max) {

    if (max % 2 == 0) {
            int random;
            do {
                random = getRandomIntForOdd(max + 1);
            } while (random == max + 1);
            return random;
        }
        return getRandomIntForOdd(max);
    }

    public static int getRandomIntForOdd(int max) {
        currentBase = Integer.toString(currentBase).hashCode();

        return ((currentBase & Integer.MAX_VALUE) % max) + 1;
    }
}
