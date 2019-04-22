package com.ssaurel.tictactoe;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Khan Desktop on 20-Apr-19.
 */

@RunWith(AndroidJUnit4.class)
public class GameEngineIntegrationTest {

    private GameEngine engine;


    @Before
    public void setUp(){
        Context ctx = InstrumentationRegistry.getTargetContext();
        engine = new GameEngine(ctx);
    }

    @Test
    public void isEnded() throws Exception {
        boolean expected = false;
        boolean output = engine.isEnded();
        assertEquals(expected,output);
    }

    @Test
    public void play_pos() throws Exception {

        //Positive Inputs//
        int input1 = 2;
        int input2 = 1;
        char expected= ' ' ;
        char output;
        output = engine.play(input1,input2);

        assertEquals(expected, output);
    }

    @Test
    public void play_neg() throws Exception {

        //Negative Inputs//
        int input1 = -1;
        int input2 = -2;
        char expected= ' ' ;
        char output;
        output = engine.play(input1,input2);

        assertEquals(expected, output);
    }


    @Test
    public void elt_pos() throws Exception {
        int input1 = 2;
        int input2 =2;
        char expected =' ';
        char output;

        output = engine.elt(input1, input2);

        assertEquals(expected, output);
    }

    @Test
    public void elt_negpoint()  //since graphic based interface, no chance for negative input, if negative input arises, system will ignore the negative sign and will consider as positive
    {
        int input1 =-2;
        int input2 =-1;
        char expected =' ';
        char output;

        output = engine.elt(input1, input2);

        assertEquals(expected, output); //test is passed until the input values are not increased enough to throw Out of Bounds Exception. Max limit is 8.
    }

    @Test
    public void newGame() throws Exception {
    }

    @Test
    public void checkEnd() throws Exception {
        char expected = ' ';
        char output;
        output = engine.checkEnd();

        assertEquals(expected,output);
    }

    @Test
    public void computer() throws Exception {
        char expected = ' ';
        char output;

        output = engine.computer();

        assertEquals(expected,output); //checks if expected free space is also there in the grid or not
        // initially there is free space on the grid so test passes
    }

}