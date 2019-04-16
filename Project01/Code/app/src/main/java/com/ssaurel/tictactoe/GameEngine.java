package com.ssaurel.tictactoe;
import java.util.Random;

public class GameEngine {

    private static final Random RANDOM = new Random();
    private char[] elts;
    private char currentPlayer;
    private boolean ended;

    public GameEngine() {
        elts = new char[9];
        newGame();
    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y) // play method sets mark of the Current Player on the grid (x,y)
                                    // 1 - graph coverage
    {
        if (!ended && elt(x,y) == ' ') //' ' represents an empty place at the grid where input can be placed
                                        // // 2 - graph coverage
        {
            elts[3 * y + x] = currentPlayer;  //input from player placed
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

    public char elt(int x, int y) {
        return elts[3 * y + x];
    }

    public void newGame() // 1 - graph coverage

    {
        for (int i = 0; i < elts.length; i++)      // 4 - graph coverage
        {
            elts[i] = ' ';      // 2 - graph coverage
        }

        currentPlayer = 'X'; //User hardcoded to X while starting the game.
        ended = false;       // 3 - graph coverage
    }

    public char checkEnd()          // 1 - graph coverage
    {

        for (int i = 0; i < 3; i++)      // 6 - graph coverage
        {
            if (elt(i, 0) != ' ' && elt(i, 0) == elt(i, 1) && elt(i, 1) == elt(i, 2))
                                                                            // 3 - graph coverage
            {
                ended = true;                   // 5 - graph coverage
                return elt(i, 0);            // 7 - graph coverage
            }


            if (elt(0, i) != ' ' && elt(0, i) == elt(1, i) && elt(1, i) == elt(2, i))
                                                                        // 9 - graph coverage

            {
                ended = true;                                           // 8 - graph coverage
                return elt(0, i);                                   // 10 - graph coverage
            }
        }

            if (elt(0, 0) != ' ' && elt(0, 0) == elt(1, 1) && elt(1, 1) == elt(2, 2))
                                                                // 11 - graph coverage
            {
                ended = true;                                      // 12 - graph coverage
                return elt(0, 0);                           // 13 - graph coverage
            }

            if (elt(2, 0) != ' ' && elt(2, 0) == elt(1, 1) && elt(1, 1) == elt(0, 2))
                                                                        // 14 - graph coverage
            {
                ended = true;                                         // 15 - graph coverage
                return elt(2, 0);                               // 16 - graph coverage
            }

            for (int i = 0; i < 9; i++)                 // 21 - graph coverage

            {

                if(elts[i]==' ')                    // 18 - graph coverage
                    return  ' ';                    // 20 - graph coverage

            }

        return 'T';                                 // 22 - graph coverage

        }

        public char computer()          // 1 - graph coverage
        {
        if (!ended){
            int position = -1;   //initial position of computer is outside boundary to make sure
                                 // user places first
                                 // 2 - graph coverage


            do {
                position = RANDOM.nextInt(9);    // computer places its turn
            }while (elts[position] != ' ');             // when it sees an empty on the grid
                                                        // 4 - graph coverage

            elts[position] = currentPlayer;             //switches back to user if game not over
            changePlayer();                             // 5 - graph coverage
        }

        return  checkEnd();                             //returns to check if game is over or not
                                                        // 6 - graph coverage
    }
}