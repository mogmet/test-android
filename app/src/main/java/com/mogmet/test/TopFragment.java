package com.mogmet.test;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by mogmet on 2017/01/02.
 */

public class TopFragment extends Fragment implements InputDialogFragment.Listener {
    @BindView(R.id.listview)
    ListView listView;
    ArrayAdapter<String> adapter;
    Gson gson = new Gson();
    ArrayList<String> list;

    public static TopFragment newInstance() {
        return new TopFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        ButterKnife.bind(this, view);
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String listJson = preferences.getString("hoge", "['red']");
        list = gson.fromJson(listJson, ArrayList.class);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);
        adapter.addAll(list);
//        // アイテムを追加します
//        adapter.add("red");
//        adapter.add("green");
//        adapter.add("blue");
//        // アダプターを設定します
        listView.setAdapter(adapter);
        return view;
    }

    @OnItemClick(R.id.listview)
    void listViewClicked(int position) {
        // クリックされたアイテムを取得します
        String item = (String) listView.getItemAtPosition(position);
        Toast.makeText(getContext(), item, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }

    @Override
    public void dialogClicked(String message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        list.add(message);
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("hoge", gson.toJson(list));
        editor.apply();
    }

    @OnClick(R.id.fab)
    void fabClicked() {
//        Snackbar.make(container, "なんかいれて", Snackbar.LENGTH_LONG).show();
        InputDialogFragment.newInstance().show(getActivity().getSupportFragmentManager(), "tekito");
    }

    @OnClick(R.id.custom_list_view_fab)
    void customListViewFabClicked() {
        replaceFragment(CustomListFragment.newInstance());
    }

    private void replaceFragment(Fragment fragment) {
        // TODO: あとでactivityを返す。
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
