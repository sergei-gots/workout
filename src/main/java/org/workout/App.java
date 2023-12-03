package org.workout;

import org.workout.myimpl.MyRandom;
import org.workout.myimpl.TryToBreakHashMapUsingNotImplComparable;
import org.workout.streamapi.*;

public class App
{
    public static void main( String[] args ) {

        System.out.println("Hello World!");
        int caseIndex = 7;
        switch (caseIndex) {
            case 0:
                FirstUniqueValue.workout();
                break;
            case 1:
                UniqueCountries.workout();
                break;
            case 7:
                StringsStartWith.workout();
                break;
            case 2:
                Sum.workout();
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
            case 6:
                SquareAndSort.workout();
                break;
        }
    }
}
