package com.mogmet.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public CustomViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
