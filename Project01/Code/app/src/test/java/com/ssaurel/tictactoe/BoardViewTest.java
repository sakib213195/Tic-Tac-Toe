package com.ssaurel.tictactoe;

import org.junit.Test;
import android.content.Context;

import static org.junit.Assert.*;

/**
 * Created by Khan Desktop on 18-Mar-19.
 */
public class BoardViewTest {
    @Test
    public void onMeasure() throws Exception {
        BoardView expected = new BoardView(null);
        expected.onMeasure(1,1);
        int input1=1;
        int input2 =1;
        BoardView actual = new BoardView(null);
        actual.onMeasure(input1,input2);
        assertEquals(expected,actual); // test failure occurs due to method unable to mock.
    }

    @Test
    public void onDraw() throws Exception {
    }

    @Test
    public void onTouchEvent() throws Exception {
    }

}