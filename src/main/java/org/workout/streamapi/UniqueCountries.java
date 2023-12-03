package org.workout.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UniqueCountries {
    public static void workout() {
        List<String> cities = Arrays.asList(
                "Москва, Россия",
                "Париж, Франция",
                "Лондон, Великобритания",
                "Берлин, Германия",
                "Москва, Россия",
                "Токио, Япония",
                "Париж, Франция",
                "Леон, Франция",
                "Леон,Франция"

        );
        System.out.println(findUniqueCountries(cities));
    }

    /**
     * Format pattern for List item is "City name, Country Name", i.e. names are split with ", " sequnnce
     *
     */
    public static List<String> findUniqueCountries(List<String> cityCountryPairList) {
        return cityCountryPairList
                .stream()
                .map(s -> {
                    String mapped = null;
                    try {
                        mapped = s.split(", ")[1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Illegal format. Entry \"" + s + "\" will be ignored.");
                    }
                    return mapped;
                }  )
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }
}
