package com.mytaxi.screens;

import com.mytaxi.android_demo.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class LogIn {

    private static Matcher usernameTextbox = withId(R.id.edt_username);
    private static Matcher passwordTextbox = withId(R.id.edt_password);
    private static Matcher loginButton = withId(R.id.btn_login);

    /**
     * Logs into my Taxi application
     * @param username - {String} username
     * @param password - {String} password
     * @throws Exception
     */
    public static void logInToMyTaxi(String username, String password) throws Exception{
        //Enter Username & Password and click Login
        onView(usernameTextbox).perform(typeText(username));
        onView(passwordTextbox).perform(typeText(password));
        onView(loginButton).perform(click());
        //Wait to sync test
        Thread.sleep(5000);
        //Verify login is successful
        onView(loginButton).check(doesNotExist());
    }

}
