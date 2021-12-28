package ru.shepin.pizza_head_first_book.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import ru.shepin.pizza_head_first_book.R;


public class StoresFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.stores)
        );

        setListAdapter(stringArrayAdapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stores, container, false);
    }
}