package com.example.smarthome.Adapter;
import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthome.Adapter.base.CommonAdapter;
import com.example.smarthome.Adapter.base.ViewHolder;
import com.example.smarthome.R;

import java.util.List;

/**
 * Created by Renny on 2018/1/3.
 */

public class ExtendHeadAdapter extends CommonAdapter<String> {

    public ExtendHeadAdapter(  List<String> datas) {
        super( R.layout.item_header, datas);
    }

    @Override
    protected void convert(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    protected void convert(ViewHolder holder, final int position) {
        String data=getData(position);
        TextView tv = holder.getView(R.id.title_iv);
        tv.setText(data);
        if (mItemClickListener != null) {
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClicked(position, v);
                }
            });
        }
    }


}