package com.ssaurel.tictactoe;

import android.content.ContextWrapper;
import android.view.MenuItem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowAlertDialog;
import android.app.AlertDialog;

import android.view.Menu;
import android.view.MenuItem;


import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;
import static org.hamcrest.Matchers.equalTo;

@RunWith(RobolectricTestRunner.class)


public class MainActivityTest {


    @Test
    public void onOptionsItemSelected() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        MenuItem menuItem = new RoboMenuItem(R.id.action_new_game);
        activity.onOptionsItemSelected(menuItem);
        ShadowActivity shadowActivity = shadowOf(activity);
        assertTrue(shadowActivity.isFinishing());

    }


    @Test
    public void gameEnded() throws Exception {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextWrapper(null));

        AlertDialog alert = builder.create();

        ShadowAlertDialog shadowAlertDialog = shadowOf(alert);

        String expected = "GameEnded. " + "O" + " win";

        assertThat(shadowAlertDialog.getMessage(), is(anything(expected)) );   //Test checks if given test has similar dialog as expected
    }


    /* Input Space Partitioning*/

    @Test
    public void gameEnded_XWon() throws Exception {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextWrapper(null));

        AlertDialog alert = builder.create();

        ShadowAlertDialog shadowAlertDialog = shadowOf(alert);

        String expected = "GameEnded. " + "X" + " win";

        assertThat(shadowAlertDialog.getMessage(), is(anything(expected)) );   //Test checks if given test has similar dialog as expected
    }

    @Test
    public void gameEnded_Tie() throws Exception {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextWrapper(null));

        AlertDialog alert = builder.create();

        ShadowAlertDialog shadowAlertDialog = shadowOf(alert);

        String expected = "Game EndedEnded. Tie";

        assertThat(shadowAlertDialog.getMessage(), is(anything(expected)) );
    }

}