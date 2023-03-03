package com.example.smarthome.Page_Home;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthome.Adapter.FindDeviceAdapter;
import com.example.smarthome.Database.Device;
import com.example.smarthome.MQTT.ClientMQTT;
import com.example.smarthome.Page_Samrt.AdjustTheLights;
import com.example.smarthome.R;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDevices extends AppCompatActivity {
    private List<Map<String,String>> deviceList=new ArrayList<Map<String,String>>();
    private Switch aSwitch;
    private ClientMQTT clientMQTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finddevices);
        aSwitch=findViewById(R.id.switch1);
        clientMQTT=new ClientMQTT("light");
        try {
            clientMQTT.Mqtt_innit();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        clientMQTT.startReconnect(FindDevices.this);
//        clientMQTT.Subscribe();
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //之后在数据库加一个是否是点击入网后能够获得的电器isGet,解析那里的litepal要记得让isGet为1，这里switch变成false后再全弄为0
                    deviceList.clear();
                    initContent();
                    RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recy_devices);
                    LinearLayoutManager linearLayout=new LinearLayoutManager(FindDevices.this);
                    recyclerView.setLayoutManager(linearLayout);
                    FindDeviceAdapter findDeviceAdapter=new FindDeviceAdapter(deviceList);
                    recyclerView.setAdapter(findDeviceAdapter);
                    findDeviceAdapter.notifyDataSetChanged();
                }else {
                    //还要弄一个什么都不显示的,建议传入空的List试试
                    //setIsUpdate全部都set成0
                    clientMQTT.unSubscribe();//取消订阅
                    Device device=new Device();
                    device.setIsUpdate(0);
                    device.updateAll("isUpdate = ?","1");

                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
//        deviceList.clear();
//        initContent();
//        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recy_devices);
//        LinearLayoutManager linearLayout=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayout);
//        FindDeviceAdapter findDeviceAdapter=new FindDeviceAdapter(deviceList);
//        recyclerView.setAdapter(findDeviceAdapter);
//        findDeviceAdapter.notifyDataSetChanged();

    }
    private void initContent()
    {
        List<Device> devicelist= LitePal.order("source_command desc").where("flag = ?","0").find(Device.class);
        for(Device devices:devicelist){
            String source_long_address=devices.getSource_long_address();
            int flag=devices.getFlag();
            String source_command=devices.getSource_command();
            Map<String,String> map=new HashMap<>();
            map.put("source_command",source_command);
            map.put("source_long_address",String.valueOf(source_long_address));
            map.put("flag",String.valueOf(flag));
            deviceList.add(map);

        }












    }







}
