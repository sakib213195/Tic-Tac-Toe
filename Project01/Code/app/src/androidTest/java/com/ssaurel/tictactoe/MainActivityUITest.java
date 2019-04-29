package com.ssaurel.tictactoe;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.repeatedlyUntil;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Khan Desktop on 22-Apr-19.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule <MainActivity> ActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private String name1 = "Sakib";
    private String name2 = "";
    private String name3 = "Arsenal";


    @Test
    public void TestUserInputwithinLimit() throws Exception {

        Espresso.onView(withId(R.id.Textchange)).perform(typeText(name1));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.btnChange)).perform(click());

        Espresso.onView(withId(R.id.User)).check(matches(withText(name1)));

    }

    @Test
    public void TestUserInputoutsideLimit() throws Exception {

        Espresso.onView(withId(R.id.Textchange)).perform(typeText(name2));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.btnChange)).perform(click());

        Espresso.onView(withId(R.id.User)).check(matches(withText(name2)));

    }

    @Test
    public void TestUserInputoutsideLimit2() throws Exception {

        Espresso.onView(withId(R.id.Textchange)).perform(typeText(name3));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.btnChange)).perform(click());

    }

    @Test

    public  void TestRun() throws  Exception{
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
        Espresso.onView(withId(R.id.board)).perform(click());
    }


}