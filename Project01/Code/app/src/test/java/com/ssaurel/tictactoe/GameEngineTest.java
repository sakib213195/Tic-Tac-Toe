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
        boolean expected = false;
        GameEngine test = new GameEngine(null);
        boolean output = test.isEnded();
        assertEquals(expected,output);

    }



    @Test
    public void play() throws Exception {
        int input1 = 2;
        int input2 = 1;
        char expected= ' ' ;
        char output;


        GameEngine test = new GameEngine(null);
        output = test.play(input1,input2);

        assertEquals(expected, output); //passed test as the input values allow method to return successfully

    }

    /*@Test
    public void changePlayer() //input X is hardcoded in the system for the user.
     {

        char expected = 'X';

        GameEngine output = new GameEngine();

        output.changePlayer();

        assertEquals(expected,output);

    }*/

    @Test
    public void elt() throws Exception {
        int input1 = 2;
        int input2 =2;
        char expected =' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.elt(input1, input2);

        assertEquals(expected, output);
    }

    /*@Test
    public void newGame() throws Exception {
    // Testing not done since it is hardcoded that user will be X not O.
    // Also no chance of other inputs to disrupt.
    }*/

    @Test
    public void checkEnd() throws Exception //test passes only as returned value of this method
                                            // being applicable when grid has an empty space.
                            // hence passes to when expected is ' ' meaning value return is possible
    {
        char expected = ' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.checkEnd();

        assertEquals(expected,output);
    }

    @Test
    public void computer() throws Exception {
        char expected = ' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.computer();

        assertEquals(expected,output); //checks if expected free space is also there in the grid or not
                                       // initially there is free space on the grid so test passes


    }


    /* Input Space Partitioning*/

    @Test
    public void isEnded_notended() throws Exception //expected is considered as false only since when true, the game ends hence invalid
    {
        boolean expected = false;
        GameEngine test = new GameEngine(null);
        boolean output = test.isEnded();
        assertEquals(expected,output);

    }



    @Test

    public void play_posimaxgridpos ()// test checks if the input can be placed at the max positive point of the grid

    {
        int input1 = 2;
        int input2 = 1;
        char expected= ' ' ;
        char output;


        GameEngine test = new GameEngine(null);
        output = test.play(input1,input2);

        assertEquals(expected, output);

    }

    @Test

    public void play_startgridpos() // test checks if the input can be placed at very points on the grid

    {
        int input1 = 0;
        int input2 = 0;
        char expected= ' ' ;
        char output;


        GameEngine test = new GameEngine(null);
        output = test.play(input1,input2);

        assertEquals(expected, output);

    }

    @Test

    public void play_diffgridpos() // test checks if the input can be placed at not same x and y coordinate on the grid

    {
        int input1 = 2;
        int input2 = 0;
        char expected= ' ' ;
        char output;


        GameEngine test = new GameEngine(null);
        output = test.play(input1,input2);

        assertEquals(expected, output);

    }

    @Test

    public void play_neggridpos()  //since graphic based interface, no chance for negative input,
                                   // if negative input arises, system will ignore the negative sign
                                   //and will consider as positive
                                  // test checks if the application can deal  negative x and y inputs
                                 // coordinate on the grid

    {
        int input1 = -2;
        int input2 = -1;
        char expected = ' ';
        char output;


        GameEngine test = new GameEngine(null);
        output = test.play(input1,input2);

        assertEquals(expected, output);

    }

    @Test
    public void elt_maxpoint() //grid has 9 spaces ranging from 0 to 8 meaning (x,y) can be from (0,0) to (2,2)
    {
        int input1 =2;
        int input2 =2;
        char expected =' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.elt(input1, input2);

        assertEquals(expected, output); //test is passed until the input values are not increased enough to throw Out of Bounds Exception. Max limit is 8.
    }

    @Test
    public void elt_minpoint() //grid has 9 spaces ranging from 0 to 8 meaning (x,y) can be from (0,0) to (2,2)
    {
        int input1 =0;
        int input2 =0;
        char expected =' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.elt(input1, input2);

        assertEquals(expected, output); //test is passed until the input values are not increased enough to throw Out of Bounds Exception. Max limit is 8.
    }

    @Test
    public void elt_differentpoint() //grid has 9 spaces ranging from 0 to 8 meaning (x,y) can be from (0,0) to (2,2)
    {
        int input1 =1;
        int input2 =2;
        char expected =' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.elt(input1, input2);

        assertEquals(expected, output); //test is passed until the input values are not increased enough to throw Out of Bounds Exception. Max limit is 8.
    }

    @Test
    public void elt_negpoint()   //since graphic based interface, no chance for negative input,
                                 // if negative input arises, system will ignore the negative sign
                                 //and will consider as positive
                                //grid has 9 spaces ranging from 0 to 8 meaning (x,y) can be from (0,0) to (2,2)
    {
        int input1 =-2;
        int input2 =-1;
        char expected =' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.elt(input1, input2);

        assertEquals(expected, output); //test is passed until the input values are not increased enough to throw Out of Bounds Exception. Max limit is 8.
    }

    @Test
    public void checkEnd_empty() throws Exception //test passes only as returned value of this method
    // being applicable when grid has an empty space.
    // hence passes to when expected is ' ' meaning value return is possible
    {
        char expected = ' ';
        char output;

        GameEngine test = new GameEngine(null);
        output = test.checkEnd();

        assertEquals(expected,output);
    }


}

