package com.hoonyeee.android.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.GridLayout;

public class Stage extends View {
    float displayWidth;
    float unit;
    final float WIDTH_SIZE = 19;
    Paint wall,background, outer;
    static float stage_width;
    int stage_map[][] ={
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,9,9,9,9,9,9,9,9,9,9,9}
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //스테이지 그리기
        //간격
        for(int y=0; y<stage_map.length; y++){
            for(int x=0;x<stage_map[0].length; x++){
                if(stage_map[y][x]==0){
                    canvas.drawRect(
                            x*unit,
                            y*unit,
                            x*unit+unit,
                            y*unit+unit,
                            background
                    );
                }else if(stage_map[y][x]==9){
                    canvas.drawRect(
                            x*unit,
                            y*unit,
                            x*unit+unit,
                            y*unit+unit,
                            wall
                    );
                    canvas.drawRect(
                            x*unit,
                            y*unit,
                            x*unit+unit,
                            y*unit+unit,
                            outer
                    );

                }

            }
        }
    }

    public Stage(Context context, float displayWidth){
        super(context);
        this.displayWidth = displayWidth;
        unit = displayWidth/WIDTH_SIZE;

        outer = new Paint();
        outer.setColor(Color.WHITE);
        outer.setStyle(Paint.Style.STROKE);
        outer.setStrokeWidth(1);

        wall = new Paint();
        wall.setColor(Color.BLUE);
        wall.setStyle(Paint.Style.FILL);

        background = new Paint();
        background.setColor(Color.GRAY);
        background.setStyle(Paint.Style.STROKE);
        background.setStrokeWidth(1);

        //preview에서 사용할 수 있게 준비
        stage_width = (stage_map[0].length+1)*unit;
    }
}
