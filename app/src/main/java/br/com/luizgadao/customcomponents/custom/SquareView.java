package br.com.luizgadao.customcomponents.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Luiz on 23/12/15.
 */
public class SquareView extends View {
    public SquareView(Context context) {
        super(context);
    }

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(min, min);
    }
}
