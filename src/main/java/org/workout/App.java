package org.workout;

import org.workout.concurrent.FutureAndExecutorServiceSubmit;
import org.workout.myimpl.MyRandom;
import org.workout.myimpl.TryToBreakHashMapUsingNotImplComparable;
import org.workout.streamapi.*;
import org.workout.yandex.coderun.MiddleValue;

public class App
{
    @FunctionalInterface
    interface Workout {
        void workout();
    }
    public static void main( String[] args ) {

        System.out.println("Hello World!");

        Workout[] workouts = {
                FirstUniqueValue::workout,                          //[0]
                UniqueCountries::workout,
                SquareAndSort::workout,
                Sum::workout,
                StringsSortedAndGroupedByLength::workout,
                StringsStartWith::workout,                          //[5]

                MyRandom::workout,
                TryToBreakHashMapUsingNotImplComparable::workout,   //7

                FutureAndExecutorServiceSubmit::workout,            //8

                MiddleValue::workout                                //9
        };

        workouts[8].workout();
    }
}
