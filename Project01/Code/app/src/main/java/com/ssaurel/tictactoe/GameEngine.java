package com.ssaurel.tictactoe;

import android.content.Context;

import java.util.Random;




public class GameEngine  {

    private static final Random RANDOM = new Random();
    private char[] elts;
    private char currentPlayer;
    private boolean ended = false;      //Initially game is considered not to be ended



    public GameEngine (Context ctx){
        elts = new char[9];                 //The grid of 3X3=9 is formed as array of 9
        newGame(ctx);

    }


    public boolean isEnded()        //method checks if game ended or not
    {

        return ended=false;

    }

    public char play(int x, int y)// play method sets mark of the Current Player on the grid (x,y)
                                    // 1 - graph coverage
    {
        if (!ended && elt(Math.abs(x),Math.abs(y)) == ' ') //' ' represents an empty place at the
                                                           // grid where input can be placed
                                                          // 2 - graph coverage
        {
            elts[3 * (Math.abs(y)) + (Math.abs(x))] = currentPlayer;  //input from player placed
            changePlayer();   //player changes then
        }
        return checkEnd();          //method checks if game is over or not
                                    // 4 - graph coverage
    }


    public void changePlayer() // 1 - graph coverage
    {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X'); //player will continue as X
                                                            // 2,3,4 - graph coverage
    }

    public char elt(int x, int y)   //method used for returning the formula used to make logic in app
    {

        return elts[3 * (Math.abs(y)) + (Math.abs(x))];
    }

    public void newGame(Context ctx) // 1 - graph coverage

    {
        for (int i = 0; i < elts.length; i++)      // 4 - graph coverage
        {
            elts[i] = ' ';      // 2 - graph coverage
        }

        currentPlayer = 'X'; //User hardcoded to X while starting the game.
        ended = false;       // 3 - graph coverage

    }




    public char checkEnd()     // 1 - graph coverage
    {


            for (int i = 0; i < 3; i++)      // 2,5,6 - graph coverage
            {
                if (elt(i, 0) != ' ' && elt(i, 0) == elt(i, 1) && elt(i, 1) == elt(i, 2))

                {
                    ended = true;                   // 3 - graph coverage
                    return elt(i, 0);            // 3 - graph coverage
                }


                if (elt(0, i) != ' ' && elt(0, i) == elt(1, i) && elt(1, i) == elt(2, i))


                {
                    ended = true;                                           // 4 - graph coverage
                    return elt(0, i);                                   // 4 - graph coverage
                }
            }

            if (elt(0, 0) != ' ' && elt(0, 0) == elt(1, 1) && elt(1, 1) == elt(2, 2))

            {
                ended = true;                                      // 7 - graph coverage
                return elt(0, 0);                           // 7 - graph coverage
            }

            if (elt(2, 0) != ' ' && elt(2, 0) == elt(1, 1) && elt(1, 1) == elt(0, 2))

            {
                ended = true;                                         // 8 - graph coverage
                return elt(2, 0);                              // 8 - graph coverage
            }


            for (int i = 0; i < 9; i++)                 // 9,11 - graph coverage

            {

                if (elts[i] == ' ')
                    return ' ';                    // 10 - graph coverage

            }

            return 'T';                                 // 12 - graph coverage


        }


        public char computer()         // 1 - graph coverage
        {

        if (!ended){
            int position;         //initial position of computer is outside boundary to make sure
                                 // user places first
                                 // 2 - graph coverage
            do {
                position = RANDOM.nextInt(9);    // user places his turn
            }while (elts[position] != ' ');             // when it sees an empty on the grid
                                                        // 4 - graph coverage
            elts[position] = currentPlayer;
            changePlayer();                         //switches back to user if game not over
                                                    // 5 - graph coverage

        }
            return checkEnd();              //returns to check if the game is over or not

    }

}
