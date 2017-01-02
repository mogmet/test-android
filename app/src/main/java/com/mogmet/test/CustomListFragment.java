package com.mogmet.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by mogmet on 2017/01/02.
 */

public class CustomListFragment extends Fragment {
    public static CustomListFragment newInstance() {
        return new CustomListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
