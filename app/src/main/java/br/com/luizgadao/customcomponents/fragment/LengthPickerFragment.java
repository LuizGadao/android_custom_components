package br.com.luizgadao.customcomponents.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.luizgadao.customcomponents.R;
import br.com.luizgadao.customcomponents.custom.LengthPicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class LengthPickerFragment extends Fragment {


    private static final String TAG = LengthPickerFragment.class.getSimpleName();

    public LengthPickerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_length_picker, container, false);
        LengthPicker lengthPicker = (LengthPicker) v.findViewById(R.id.length_picker);
        lengthPicker.setOnChangeListener(new LengthPicker.OnChangeListerner() {
            @Override
            public void onChange(int length) {
                Log.i(TAG, "picker-change: " + length);
            }
        });
        return v;
    }


}
