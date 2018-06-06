package com.mytaxi.screens;

import android.content.Intent;

import com.mytaxi.android_demo.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class DriverProfile {

    private static Matcher driverProfileLabel = withText("Driver Profile");
    private static Matcher callButton = withId(R.id.fab);

    /**
     * Calls the driver currently displayed
     and verifies the the dialer is displayed
     * @throws Exception
     */
    public static void call() throws Exception{
        //Verify Driver Profile screen is displayed
        onView(driverProfileLabel).check(matches(isDisplayed()));
        onView(callButton).perform(click());
        //Wait to sync test
        Thread.sleep(3000);
        //Verify Dialer is displayed
        intended(allOf(hasAction(Intent.ACTION_DIAL)));
    }
}
