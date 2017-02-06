package com.mogmet.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mogmet on 2017/01/02.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.custom_thumbnail)
    ImageView customThumbnail;
    @BindView(R.id.custom_text_view)
    TextView customTextView;
    @BindView(R.id.custom_button)
    Button customButton;
    private int mPosition;
    private CustomViewHolderListener mListener;

    public CustomViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.custom_button)
    void onClickCustomButton(View view) {
        mListener.onClickCustomButton(mPosition);
    }

    void bindView(int position, CustomViewHolderListener listener) {
        mPosition = position;
        mListener = listener;
    }

    public interface CustomViewHolderListener {
        void onClickCustomButton(int position);
    }
}
