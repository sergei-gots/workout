package org.workout;

import org.workout.strange.MyRandom;
import org.workout.streamapi.FindFirstUniqueValue;
import org.workout.streamapi.FindUniqueCountries;
import org.workout.streamapi.GetSum;
import org.workout.streamapi.StringsSortedAndGroupedByLength;

public class App
{
    public static void main( String[] args ) {

        System.out.println("Hello World!");
        FindFirstUniqueValue.workout();
        FindUniqueCountries.workout();
        GetSum.workout();
        StringsSortedAndGroupedByLength.workout();
        MyRandom.workout();
    }
}
