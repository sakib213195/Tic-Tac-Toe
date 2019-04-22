package com.ssaurel.tictactoe;

import android.app.Instrumentation;
import android.content.Context;
import android.content.DialogInterface;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.ssaurel.tictactoe.R.id.board;

public class MainActivity extends AppCompatActivity {

    private BoardView boardView;
    private GameEngine gameEngine;
    public Context c;

    private Button btnChange;
    private EditText Textchange;
    private TextView User;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = (BoardView) findViewById(board);
        gameEngine = new GameEngine(c);
        boardView.setGameEngine(gameEngine);
        boardView.setMainActivity(this);

        btnChange = (Button) findViewById(R.id.btnChange);
        Textchange = (EditText) findViewById(R.id.Textchange);
        User = (TextView) findViewById(R.id.User);

        btnChange.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)  {
                if((User.length()>0) && (User.length()<=5)){
                User.setText(Textchange.getText());}

                if((User.length()>=6) || (User.length()<=0)) {
                    Toast.makeText(getApplicationContext(), "Outside Limit", Toast.LENGTH_SHORT).show();
                    User.setText(null);
                    btnChange.setOnClickListener(null);
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) // 1 - graph coverage

    {
        if (item.getItemId() == R.id.action_new_game)
        {
            newGame();                                      // 2 - graph coverage
        }

        return super.onOptionsItemSelected(item);           // 4 - graph coverage
    }

    public void gameEnded(char c) {
        String msg = (c == 'T') ? "Game EndedEnded. Tie" : "Game Ended. " + c + " win";

        new AlertDialog.Builder(this).setTitle("Tic Tac Toe").
                setMessage(msg).
                setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        newGame();
                    }
                }).show();
    }

    private void newGame() {
        gameEngine.newGame(null);
        boardView.invalidate();
    }


}