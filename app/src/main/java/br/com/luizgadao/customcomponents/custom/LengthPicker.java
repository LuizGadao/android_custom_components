package br.com.luizgadao.customcomponents.custom;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.luizgadao.customcomponents.R;

/**
 * Created by Luiz on 23/12/15.
 */
public class LengthPicker extends LinearLayout {

    private static final String MY_NUMBER = "my-number";
    private static final String SUPER_STATE = "super-state";

    OnChangeListerner mListener;
    Button mBtnPlus, mBtnMinus;
    TextView mText;
    int mNumber = 0;

    public LengthPicker(Context context) {
        super(context);
        init();
    }

    public LengthPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LengthPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.length_picker, this);
        setOrientation(LinearLayout.HORIZONTAL);

        mText = (TextView) findViewById(R.id.text);
        mBtnPlus = (Button) findViewById(R.id.btnPlus);
        mBtnMinus = (Button) findViewById(R.id.btnMinus);

        updateControls();

        OnClickListener handler = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnMinus:
                        if (mNumber > 0) {
                            mNumber--;
                            updateControls();
                            if (mListener != null)
                                mListener.onChange(mNumber);
                        }
                        break;
                    case R.id.btnPlus:
                        mNumber++;
                        updateControls();
                        if (mListener != null)
                            mListener.onChange(mNumber);
                        break;
                }
            }
        };
        mBtnMinus.setOnClickListener(handler);
        mBtnPlus.setOnClickListener(handler);
    }

    private void updateControls() {
        mBtnMinus.setEnabled(mNumber > 0);
        mText.setText("" + mNumber);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle args = new Bundle();
        args.putParcelable(SUPER_STATE, super.onSaveInstanceState());
        args.putInt(MY_NUMBER, mNumber);
        return args;
    }

    //not forget put id in layout
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle){
            Bundle args = (Bundle) state;
            mNumber = args.getInt(MY_NUMBER);
            super.onRestoreInstanceState(args.getParcelable(SUPER_STATE));
        }else{
            super.onRestoreInstanceState(state);
        }

        updateControls();
    }

    public void setOnChangeListener(OnChangeListerner changeListener){
        mListener = changeListener;
    }

    public int getmNumber() {
        return mNumber;
    }

    public interface OnChangeListerner{
        void onChange(int length);
    }
}
