package br.com.luizgadao.customcomponents.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Luiz on 28/12/15.
 */
public class SidewaysLayout extends LinearLayout {
    public SidewaysLayout(Context context) {
        super(context);
    }

    public SidewaysLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SidewaysLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        //canvas.drawColor(Color.LTGRAY);
        canvas.translate(0, getHeight());
        canvas.rotate(-90);
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
