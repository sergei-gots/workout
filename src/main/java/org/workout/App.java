package org.workout;

import org.workout.myimpl.MyRandom;
import org.workout.myimpl.TryToBreakHashMapUsingNotImplComparable;
import org.workout.streamapi.FindFirstUniqueValue;
import org.workout.streamapi.FindUniqueCountries;
import org.workout.streamapi.GetSum;
import org.workout.streamapi.StringsSortedAndGroupedByLength;

public class App
{
    public static void main( String[] args ) {

        System.out.println("Hello World!");
        int caseIndex = 5;
        switch (caseIndex) {
            case 0:
                FindFirstUniqueValue.workout();
                break;
            case 1:
                FindUniqueCountries.workout();
                break;
            case 2:
                GetSum.workout();
                break;
            case 3:
                StringsSortedAndGroupedByLength.workout();
                break;
            case 4:
                MyRandom.workout();
                break;
            case 5:
                TryToBreakHashMapUsingNotImplComparable.workout();
                break;
        }
    }
}
