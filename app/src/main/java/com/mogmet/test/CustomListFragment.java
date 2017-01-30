package com.mogmet.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

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
    ArrayList<String> list;
    Gson gson = new Gson();

    public static CustomListFragment newInstance() {
        return new CustomListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_list, container, false);
        ButterKnife.bind(this, view);
        customRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String listJson = preferences.getString("hoge", "['blue']");
        list = gson.fromJson(listJson, ArrayList.class);
        ArrayList<Map<String, String>> mData;
        mData = new ArrayList<>();
        HashMap<String, String> map;
        int i = 0;
        for (String message : list) {
            map = new HashMap<>();
            map.put("text", message);
            map.put("buttontext", message + i++);
            mData.add(map);
        }
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(getContext(), mData);
        customRecyclerView.setAdapter(adapter);
        return view;
    }
}
