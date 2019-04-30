package com.ssaurel.tictactoe;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Khan Desktop on 30-Apr-19.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityIntegrationTest {
    @Rule
    public ActivityTestRule<MainActivity> ActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void IntegrationTest() //Checks integration of app with framework
    {

        ViewInteraction appbtnChange = onView(allOf(withId(R.id.btnChange),isDisplayed()));
        ViewInteraction app = onView(allOf(withId(R.id.board),isDisplayed()));
        appbtnChange.perform(click());
        app.perform(click());
        app.perform(click());
        app.perform(click());
        app.perform(click());
        app.perform(click());
        app.perform(click());
        app.perform(click());
        app.perform(click());
        app.perform(click());

    }



}