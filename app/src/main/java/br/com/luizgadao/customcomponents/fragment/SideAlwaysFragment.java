package br.com.luizgadao.customcomponents.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.luizgadao.customcomponents.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SideAlwaysFragment extends Fragment {


    public SideAlwaysFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_side_always, container, false);
    }
}
