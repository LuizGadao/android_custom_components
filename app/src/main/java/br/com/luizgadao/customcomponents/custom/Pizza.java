package br.com.luizgadao.customcomponents.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import br.com.luizgadao.customcomponents.R;

/**
 * Created by Luiz on 28/12/15.
 */
public class Pizza extends View {

    private Paint paint;
    private int numWedges = 6;

    public Pizza(Context context) {
        super(context);
        init(context, null);
    }

    public Pizza(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Pizza(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet){
        int strokeWidth = 4;
        int color = Color.YELLOW;
        if (attributeSet != null){
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Pizza);
            strokeWidth = typedArray.getDimensionPixelSize(R.styleable.Pizza_stroke_width, strokeWidth);
            color = typedArray.getColor(R.styleable.Pizza_colorr, color);
            numWedges = typedArray.getInt(R.styleable.Pizza_num_edges, numWedges);
        }

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth() - (getPaddingRight() + getPaddingLeft());
        int height = getHeight() - (getPaddingTop() + getPaddingBottom());
        int cx = width / 2 + getPaddingLeft();
        int cy = height / 2 + getPaddingTop();
        float diamater = Math.min(width, height) - paint.getStrokeWidth();
        float radius = diamater / 2;

        canvas.drawCircle(cx, cy, radius, paint);
        drawPizzaCuts(canvas, cx, cy, radius);
    }

    private void drawPizzaCuts(Canvas canvas, int cx, int cy, float radius){
        float degrees = 360f / numWedges;
        canvas.save();
        for (int i = 0; i < numWedges; i++){
            canvas.drawLine(cx, cy, cx, cy - radius, paint);
            canvas.rotate(degrees, cx, cy);
        }
        canvas.restore();
    }
}
