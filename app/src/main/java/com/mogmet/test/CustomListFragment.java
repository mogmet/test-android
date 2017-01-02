package com.mogmet.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mogmet on 2017/01/02.
 */

public class CustomListFragment extends Fragment {
    @BindView(R.id.custom_recycler_view)
    RecyclerView customRecyclerView;
    ArrayList<Map<String, String>> mData;

    public static CustomListFragment newInstance() {
        return new CustomListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_list, container, false);
        ButterKnife.bind(this, view);
        customRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mData = new ArrayList<Map<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("text", "texttttttttttttt");
        map.put("buttonText", "button dao");
        mData.add(map);
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(getContext(), mData);
        customRecyclerView.setAdapter(adapter);
        return view;
    }
}
