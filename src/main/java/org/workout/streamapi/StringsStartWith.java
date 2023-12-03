package org.workout.streamapi;

import java.util.Arrays;

public class StringsStartWith {
    public static void workout() {
        String[] strings = { "My", "name", "is", "Sergei", "and", "I", "was", "born", "in", "June" };
        System.out.println("strings which start with 'i' = " +
                Arrays.toString(stringsStartWithCaseInsensitive(strings, "i"))
        );
    }

    private static String[] stringsStartWithCaseInsensitive(String[] strings, String start) {
        final String startLowerCase = start.toLowerCase();
        return Arrays
                .stream(strings)
                .filter(s -> s.toLowerCase().startsWith(startLowerCase))
                .toArray(String[]::new);
    }
}
