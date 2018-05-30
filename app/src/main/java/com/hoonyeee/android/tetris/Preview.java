package com.hoonyeee.android.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Preview extends View {
    float displayWidth, stage_width;
    float unit, startY;
    final float WIDTH_SIZE = 19;
    Paint wall,background, outer;

    int preview_map[][] ={
            {9,0,0,0,0,9},
            {9,0,0,0,0,9},
            {9,0,0,0,0,9},
            {9,0,0,0,0,9},
            {9,9,9,9,9,9}
    };

    public Preview(Context context, float displayWidth) {
        super(context);
        this.displayWidth = displayWidth;
        unit = displayWidth/WIDTH_SIZE;
        startY = unit*4;
        stage_width = Stage.stage_width;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //프리뷰 그리기
        System.out.println("width = "+stage_width);
        for(int y=0; y<preview_map.length; y++){
            for(int x=0;x<preview_map[0].length; x++){
                if(preview_map[y][x]==0){
                    canvas.drawRect(
                            x*unit + stage_width,
                            y*unit + startY,
                            x*unit+unit+stage_width,
                            y*unit+unit+startY,
                            background
                    );
                }else if(preview_map[y][x]==9){
                    canvas.drawRect(
                            x*unit+stage_width,
                            y*unit+startY,
                            x*unit+unit+stage_width,
                            y*unit+unit+startY,
                            wall
                    );

                    canvas.drawRect(
                            x*unit+stage_width,
                            y*unit+startY,
                            x*unit+unit+stage_width,
                            y*unit+unit+startY,
                            outer
                    );
                }
            }
        }
    }
}
