package com.mogmet.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by mogmet on 2017/01/02.
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Map<String, String>> mData;
    private Context mContext;

    public CustomRecyclerAdapter(Context context, ArrayList<Map<String, String>> data) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(mInflater.inflate(R.layout.custom_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Map<String, String> data = mData.get(position);
        holder.customButton.setText(data.get("buttontext"));
        holder.customThumbnail.setImageResource(R.drawable.btn_normal);
        holder.customTextView.setText(data.get("text"));
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

}
