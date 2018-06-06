package com.mytaxi.android_demo;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.RootMatchers;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.screens.DriverProfile;
import com.mytaxi.screens.DriverSearch;
import com.mytaxi.screens.LogIn;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspressoExerciseTest {

    private MainActivity activity = null;
    private String username = "whiteelephant261";
    private String password = "video1";
    private String textToSearch = "sa";
    private String driverName = "Sarah Friedrich";

    @Rule
    public IntentsTestRule<MainActivity> activityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        activity = activityTestRule.getActivity();
    }

    @Test
    public void loginToApp() throws Exception{
        LogIn.logInToMyTaxi(username,password);
    }

    @Test
    public void searchDriverAndCall() throws Exception{
        DriverSearch.searchWithHint(textToSearch);
        onView(withText(driverName)).inRoot(RootMatchers.withDecorView(not(is(activity.getWindow().getDecorView())))).
                perform(scrollTo()).
                perform(click());
        //DriverSearch.selectDriver(activity,driverName);
        DriverProfile.call();
    }

    @After
    public void tearDown() throws Exception {
        activity.finish();
    }
}