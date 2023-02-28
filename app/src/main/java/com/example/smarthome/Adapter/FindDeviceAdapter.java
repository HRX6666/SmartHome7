package com.example.smarthome.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthome.R;

import java.util.List;
import java.util.Map;

public class FindDeviceAdapter extends RecyclerView.Adapter<FindDeviceAdapter.ViewHolder>{
  //那三个类弃用了，只用device类
    private List<Map<String,String>> mDeviceList;
    private Context context;

    public FindDeviceAdapter(List<Map<String,String>> deviceList){
        mDeviceList=deviceList;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView showCategory;
        Button bt_approve;
        Button bt_reject;
        ImageView imageView;
        View deviceView;
        public ViewHolder(View view){//通过转化为view的布局获得控件实例
            super(view);
            deviceView=view;
            showCategory=view.findViewById(R.id.device_category_display);
            bt_reject=view.findViewById(R.id.reject);
            bt_approve=view.findViewById(R.id.approve);
            imageView=view.findViewById(R.id.device_image1);

        }
    }


    @NonNull
    @Override
    public FindDeviceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.device_list,parent,false);
        final ViewHolder holder=new ViewHolder(view);
//        holder.bt_approve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        holder.bt_reject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FindDeviceAdapter.ViewHolder holder, int position) {
        String category=mDeviceList.get(position).get("source_command");//这个怕是发现一次，保存是否组网，没组网就显示。传入的list、应该在外面先判断一下再传入未租网的list，
        int source_command=Integer.valueOf(category);
        switch (source_command){
            case 1:holder.imageView.setImageResource(R.drawable.lights_smart);break;
            case 2:holder.imageView.setImageResource(R.drawable.air_condition_smart);break;
            case 3:holder.imageView.setImageResource(R.drawable.curtain_smart);break;
            case 4:holder.imageView.setImageResource(R.drawable.lock_smart);break;
            case 5:holder.imageView.setImageResource(R.drawable.set_voice);

        }
        holder.showCategory.setText(category);


        holder.bt_approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.bt_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
