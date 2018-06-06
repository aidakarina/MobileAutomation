package com.mytaxi.screens;

import android.support.test.espresso.matcher.RootMatchers;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class DriverSearch {

    private static Matcher mytaxiDemoLabel = withText("mytaxi demo");
    private static Matcher searchTextbox = withId(R.id.textSearch);

    /**
     * Partially searches in driver search with a specified hint
     * @param hintText - {String} - hint text to look for a driver
     * @throws Exception
     */
    public static void searchWithHint(String hintText) throws Exception {
        //Verifies screen to search for driver is displayed
        onView(mytaxiDemoLabel).check(matches(isDisplayed()));
        onView(searchTextbox).perform(typeText(hintText));
        //Wait to sync test
        Thread.sleep(5000);
    }

    /**
     * Verifies the specified driver is displayed and selects it
     * @param activity - {MainActivity} Main Activity
     * @param driverName - {String} Name of driver to be selected
     * @throws Exception
     */
    public static void selectDriver(MainActivity activity, String driverName) throws Exception{
        onView(withText(driverName)).inRoot(RootMatchers.withDecorView(not(is(activity.getWindow().getDecorView())))).
                perform(click());
        //Wait to sync test
        Thread.sleep(5000);
    }
}
