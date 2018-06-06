package com.mytaxi.android_demo;

import android.Manifest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.screens.DriverProfile;
import com.mytaxi.screens.DriverSearch;
import com.mytaxi.screens.LogIn;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EspressoExerciseTest {

    private MainActivity activity = null;
    private String username = "whiteelephant261";
    private String password = "video1";
    private String textToSearch = "sa";
    private String driverName = "Sarah Friedrich";

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(Manifest.permission.ACCESS_FINE_LOCATION);

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        activity = activityTestRule.getActivity();
    }

    @Test
    public void espressoTest() throws Exception{
        LogIn.logInToMyTaxi(username,password);
        DriverSearch.searchWithHint(textToSearch);
        DriverSearch.selectDriver(activity,driverName);
        DriverProfile.call();
    }

    @After
    public void tearDown() throws Exception {
        activity.finish();
    }
}