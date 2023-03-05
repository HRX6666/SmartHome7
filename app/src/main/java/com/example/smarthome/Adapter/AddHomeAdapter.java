package com.example.smarthome.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthome.Helper.ExtendHeatHelper;
import com.example.smarthome.R;

import java.util.ArrayList;

public class AddHomeAdapter extends RecyclerView.Adapter<AddHomeAdapter.AddHomeHolder> {
    ArrayList<ExtendHeatHelper> addHomeHelpers;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public AddHomeAdapter(ArrayList<ExtendHeatHelper> addHomeHelpers) {
        this.addHomeHelpers = addHomeHelpers;
    }

    @NonNull
    @Override
    public AddHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_view, parent, false);
        AddHomeHolder addHomeHolder = new AddHomeHolder(view);
        return addHomeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddHomeHolder holder, int position) {
        ExtendHeatHelper extendHeatHelper = addHomeHelpers.get(position);
        holder.imageView.setImageResource(extendHeatHelper.getImage());
        holder.title.setText(extendHeatHelper.getTitle());
        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=holder.getLayoutPosition();//1
                    onItemClickListener.OnItemClickListener(holder.itemView,position);//2
                }
            });
        }
        if(onItemLongClickListener!=null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position=holder.getLayoutPosition();
                    onItemLongClickListener.onItemLongClick(holder.itemView,position);
                    return true;//返回true表示消耗了事件不会继续传递啦！
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return addHomeHelpers.size();
    }

    public static class AddHomeHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        public AddHomeHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_add);
            title = itemView.findViewById(R.id.tv_add);
        }

    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener=onItemLongClickListener;
    }
    public  interface OnItemLongClickListener{
        void onItemLongClick(View view,int position);
    }
    public interface OnItemClickListener{
        void OnItemClickListener(View view,int position);
    }

}
