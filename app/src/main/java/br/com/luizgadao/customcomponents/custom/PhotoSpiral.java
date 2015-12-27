package br.com.luizgadao.customcomponents.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Luiz on 27/12/15.
 */
public class PhotoSpiral extends ViewGroup {
    public PhotoSpiral(Context context) {
        super(context);
    }

    public PhotoSpiral(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoSpiral(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        View child = getChildAt(0);
        int size = child.getMeasuredWidth() + child.getMeasuredHeight();
        int width = ViewGroup.resolveSize(size, widthMeasureSpec);
        int height = ViewGroup.resolveSize(size, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View first = getChildAt(0);
        int childW = first.getMeasuredWidth();
        int childH = first.getMeasuredHeight();

        int[] posX = {0, childW, childH, 0};
        int[] posY = {0, 0, childW, childH};
        for (int i = 0; i < getChildCount(); i++){
            View child = getChildAt(i);
            int x = posX[i];
            int y = posY[i];
            child.layout(x, y, x + child.getMeasuredWidth(), y + child.getMeasuredHeight());
        }
    }
}
