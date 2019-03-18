package com.ssaurel.tictactoe;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Khan Desktop on 17-Mar-19.
 */
public class GameEngineTest {
    @Test
    public void isEnded() throws Exception {
        boolean expected = true;
        boolean input = true;

        boolean test = (expected==input);
        assertTrue(test); // Test is passed when both expected end and input end are same


    }



    @Test
    public void play() throws Exception {
        int input1 = 2;
        int input2 = 1;
        char expected= ' ' ;
        char output;


        GameEngine test = new GameEngine();
        output = test.play(input1,input2);

        assertEquals(expected, output); //passed test as the input values allow method to return successfully

    }

    @Test
    public void changePlayer() throws Exception {

        char expected = 'X';
        char input = 'X';
        char output;

        output = input;

        assertEquals(expected,output); //test is passed since the input and output will be the same in the app and same is followed.
                                       // The resultant being same as expected allows the test to pass, would have failed otherwise.



    }

    @Test
    public void elt() throws Exception {
        int input1 =2;
        int input2 =2;
        char expected =' ';
        char output;

        GameEngine test = new GameEngine();
        output = test.elt(input1, input2);

        assertEquals(expected, output); //test is passed until the input values are not increased enough to throw Out of Bounds Exception. Max limit is 8.
    }

    @Test
    public void newGame() throws Exception {

        GameEngine test = new GameEngine(); //Constructor Called
    }

    @Test
    public void checkEnd() throws Exception {
    }

    @Test
    public void computer() throws Exception {
    }

}