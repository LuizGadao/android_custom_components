package br.com.luizgadao.customcomponents.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.luizgadao.customcomponents.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends ListFragment implements AdapterView.OnItemClickListener {

    public MainActivityFragment() {}

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> listFragments = new ArrayList<>();
        listFragments.add(MyCircleFragment.class.getSimpleName());
        listFragments.add(LengthPickerFragment.class.getSimpleName());
        listFragments.add(SquareViewFragment.class.getSimpleName());
        listFragments.add(PhotoSpiralFragment.class.getSimpleName());
        listFragments.add(PizzaFragment.class.getSimpleName());
        listFragments.add(SideAlwaysFragment.class.getSimpleName());

        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listFragments);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0)
            open(new MyCircleFragment());
        else if (position == 1)
            open(new LengthPickerFragment());
        else if (position == 2)
            open(new SquareViewFragment());
        else if (position == 3)
            open(new PhotoSpiralFragment());
        else if (position == 4)
            open(new PizzaFragment());
        else if (position == 5)
            open(new SideAlwaysFragment());
    }

    private void open(Fragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment, "content")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();
    }
}
