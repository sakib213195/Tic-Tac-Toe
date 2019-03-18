package com.ssaurel.tictactoe;

import android.arch.lifecycle.ReportFragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowActivity;

import static com.ssaurel.tictactoe.R.id.board;
import static org.junit.Assert.*;

import static com.ssaurel.tictactoe.R.id.board;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ReportFragment.class })



/**
 * Created by Khan Desktop on 17-Mar-19.
 */
public class MainActivityTest extends AppCompatActivity {

    @Test
    public void onCreate() throws Exception  {

        mockStatic(ReportFragment.class);
        MainActivity test = Mockito.spy(new MainActivity());

        // Call the method
        test.onCreate(null); // test failure due to parameters not met

        // Verify that it worked
        verify(test, times(1)).setContentView(R.layout.activity_main);

    }


    public void onCreateOptionsMenu() throws Exception {

        MenuItem expected = null; // expected menu
        MenuItem input = null; // inputted menu
        MainActivity output = Robolectric.setupActivity(MainActivity.class);
        output.onOptionsItemSelected(input);
        assertEquals(expected,output);//java.lang Exception  through framework unit test

    }

    @Test
    public void onOptionsItemSelected() throws Exception {

    }

    @Test
    public void gameEnded() throws Exception {
    }

}