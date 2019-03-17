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

    }



    @Test
    public void play() throws Exception {

        final Random RANDOM = new Random();
        char[] elts = new char[9];
        char currentPlayer= 'X';
        boolean ended = false;
        int input1 = 2;
        int input2 = 1;
        char expected= ' ' ;
        char output;


        GameEngine checkplay = new GameEngine();
        output = checkplay.play(input1,input2);

        assertEquals(expected, output); //passed test as the input values allow method to return successfully

    }

    @Test
    public void changePlayer() throws Exception {

    }

    @Test
    public void elt() throws Exception {
    }

    @Test
    public void newGame() throws Exception {
    }

    @Test
    public void checkEnd() throws Exception {
    }

    @Test
    public void computer() throws Exception {
    }

}