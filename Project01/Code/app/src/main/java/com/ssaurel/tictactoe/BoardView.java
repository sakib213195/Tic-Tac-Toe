package com.ssaurel.tictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.MotionEvent;


public class BoardView extends View {

    private static final int LINE_THICK = 5;
    private static final int ELT_MARGIN = 20;
    private static final int ELT_STROKE_WIDTH = 15;
    private int width, height, eltW, eltH;
    private Paint gridPaint, oPaint, xPaint;
    private GameEngine gameEngine;
    private MainActivity activity;



    public BoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        gridPaint = new Paint();
        oPaint = new Paint(Paint.ANTI_ALIAS_FLAG);          //type of design of O is placed
        oPaint.setColor(Color.BLACK);                         //color of O is placed
        oPaint.setStyle(Paint.Style.STROKE);                //style of O is placed
        oPaint.setStrokeWidth(ELT_STROKE_WIDTH);            //Set the width for stroking
        xPaint = new Paint(oPaint);
        xPaint.setColor(Color.GRAY);

    }

    public void setMainActivity(MainActivity a) {
        this.activity = a;
    }

    public void setGameEngine(GameEngine g) {

        this.gameEngine = g;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) //
    {
        height = View.MeasureSpec.getSize(heightMeasureSpec);       //extraction of height from the supplied measure specification.
        width = View.MeasureSpec.getSize(widthMeasureSpec);       //extraction of width from the supplied measure specification
        setMeasuredDimension(width, height);


        eltW = (width - LINE_THICK) / 3;            //LINETHICK = 5
        eltH = (height - LINE_THICK) / 3;


    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        drawGrid(canvas);
        drawBoard(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) // converts a point touched on the screen to a
                                                   // case on the grid

    {


        if (!gameEngine.isEnded()  &&  event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) (event.getX() / eltW);
            int y = (int) (event.getY() / eltH);
            char win = gameEngine.play(x, y);


            invalidate();

            if (win != ' ') {
                activity.gameEnded(win);
            } else {
                // computer plays ...
                win = gameEngine.computer();
                invalidate();

            }
        }

        return super.onTouchEvent(event);
    }

    private void drawBoard(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                drawElt(canvas, gameEngine.elt(i, j), i, j);
            }
        }
    }

    private void drawGrid(Canvas canvas) {
        for (int i = 0; i < 2; i++) {
            // vertical lines
            float left = eltW * (i + 1);
            float right = left + LINE_THICK;
            float top = 0;                 //starts horizontally from extreme left of the rectangle
            float bottom = height;         //goes till the height

            canvas.drawRect(left, top, right, bottom, gridPaint);


            // horizontal lines
            float left2 = 0;           //starts horizontally from extreme left of the rectangle
            float right2 = width;       //goes till the width
            float top2 = eltH * (i + 1);
            float bottom2 = top2 + LINE_THICK;

            canvas.drawRect(left2, top2, right2, bottom2, gridPaint);
        }
    }

    private void drawElt(Canvas canvas, char c, int x, int y)       //O being shaped
    {
        if (c == 'O') {
            float cx = (eltW * x) + eltW / 2;
            float cy = (eltH * y) + eltH / 2;

            canvas.drawCircle(cx, cy, Math.min(eltW, eltH) / 2 - ELT_MARGIN * 2, oPaint);

        } else if (c == 'X') {                                  //X being shaped
            float startX = (eltW * x) + ELT_MARGIN;
            float startY = (eltH * y) + ELT_MARGIN;
            float endX = startX + eltW - ELT_MARGIN * 2;
            float endY = startY + eltH - ELT_MARGIN;

            canvas.drawLine(startX, startY, endX, endY, xPaint);

            float startX2 = (eltW * (x + 1)) - ELT_MARGIN;
            float startY2 = (eltH * y) + ELT_MARGIN;
            float endX2 = startX2 - eltW + ELT_MARGIN * 2;
            float endY2 = startY2 + eltH - ELT_MARGIN;

            canvas.drawLine(startX2, startY2, endX2, endY2, xPaint);
        }
    }


}