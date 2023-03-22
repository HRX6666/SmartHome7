package com.example.smarthome.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthome.Database.AddModel;
import com.example.smarthome.R;

import java.util.List;

public class AddModelAdapter2 extends RecyclerView.Adapter<AddModelAdapter2.ViewHolder> {
    private Context mContext; // 声明一个上下文对象
    private List<AddModel> list; // 声明一个音频信息列表
    OnItemClickListener onItemClickListener;//声明接口对象

    public void set0nItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;//传递接口
    }
    public interface OnItemClickListener{
        void OnItemClick(View view,int position);//设置接口
    }
    public void AddMedalAdapter2(Context context, List<AddModel> mp3audio_list) {
        mContext = context;
        list = mp3audio_list;
    }

    public AddModelAdapter2(FragmentActivity activity, List<AddModel> modelList) {
        list = modelList;
    }


    @NonNull
    @Override
    public AddModelAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.add_medal, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
//        int pos = viewHolder.getAbsoluteAdapterPosition();//获取绝对位置

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddModelAdapter2.ViewHolder holder, int position) {
        AddModel addModel=list.get(position);
        holder.m_model.setText(addModel.getModel());
        holder.itemView.setOnClickListener(v -> {
            onItemClickListener.OnItemClick(v,position);
        });

    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView m_model;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            m_model=(TextView) itemView.findViewById(R.id.model_name);

        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
