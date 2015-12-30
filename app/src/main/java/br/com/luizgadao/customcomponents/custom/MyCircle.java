package br.com.luizgadao.customcomponents.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Luiz on 30/12/15.
 */
public class MyCircle extends View {

    Paint paintRed;
    Paint paintYellow;

    public MyCircle(Context context) {
        super(context);
        init();
    }

    public MyCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paintRed = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRed.setColor(Color.RED);

        paintYellow = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintYellow.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int stroke = 25;
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        int w = getWidth() - stroke;
        int h = getHeight() - stroke;

        int radius = Math.min(w, h) / 2;

        //canvas.drawCircle(cx, cy, radius, paintRed);
        //canvas.drawArc(0, 0, getWidth(), getWidth(), 0, 30, true, paintRed);

        canvas.drawArc(new RectF(0, 0, getWidth(), getHeight()), -90, 270, true, paintRed);
        canvas.drawCircle(cx, cy, radius, paintYellow);
    }
}
