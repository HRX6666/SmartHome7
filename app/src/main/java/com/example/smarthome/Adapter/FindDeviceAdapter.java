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

import com.example.smarthome.Database.Device;
import com.example.smarthome.MQTT.ClientMQTT;
import com.example.smarthome.Page_Samrt.AdjustTheLights;
import com.example.smarthome.R;

import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.List;
import java.util.Map;

public class FindDeviceAdapter extends RecyclerView.Adapter<FindDeviceAdapter.ViewHolder>{
  //那三个类弃用了，只用device类
    private List<Map<String,String>> mDeviceList;
    private Context context;
    private ClientMQTT clientMQTT;
    private static View deviceView;
    public FindDeviceAdapter(List<Map<String,String>> deviceList){
        mDeviceList=deviceList;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView showCategory;
        Button bt_approve;
        Button bt_reject;
        ImageView imageView;
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

//        clientMQTT=new ClientMQTT("light");
//        try {
//            clientMQTT.Mqtt_innit();
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//        clientMQTT.startReconnect(parent.getContext());
        return holder;/////////////////////////
    }

    @Override
    public void onBindViewHolder(@NonNull FindDeviceAdapter.ViewHolder holder, int position) {
        //直接
        String category=mDeviceList.get(position).get("source_command");//在解析完中控传过来的数据，数据早已存入数据库了，现在的工作只是Update就可以，保存是否组网，没组网就显示这个设备，传入的list、应该在外面先判断一下再传入未租网的list，
        String source_long_address=mDeviceList.get(position).get("source_long_address");
        switch (category){
            case "0x01":holder.imageView.setImageResource(R.drawable.lights_smart);break;
            case "0x02":holder.imageView.setImageResource(R.drawable.air_condition_smart);break;
            case "0x03":holder.imageView.setImageResource(R.drawable.curtain_smart);break;
            case "0x04":holder.imageView.setImageResource(R.drawable.lock_smart);break;
            case "0x05":holder.imageView.setImageResource(R.drawable.set_voice);

        }
        holder.showCategory.setText(category);


        holder.bt_approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Device device=new Device();
                device.setFlag(1);
                device.updateAll("source_long_address = ?",source_long_address);
                //向中控发送APP同意入网信息
//                clientMQTT.publishMessagePlus();

            }
        });
        holder.bt_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送拒绝指令
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDeviceList.size();/////////
    }
}
