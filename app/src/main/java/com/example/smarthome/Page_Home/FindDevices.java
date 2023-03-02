package com.example.smarthome.Page_Home;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthome.Adapter.FindDeviceAdapter;
import com.example.smarthome.Database.Device;
import com.example.smarthome.R;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDevices extends AppCompatActivity {
    private List<Map<String,String>> deviceList=new ArrayList<Map<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finddevices);

    }
    @Override
    public void onStart() {
        super.onStart();
        deviceList.clear();
        initContent();
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recy_devices);
        LinearLayoutManager linearLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        FindDeviceAdapter findDeviceAdapter=new FindDeviceAdapter(deviceList);
        recyclerView.setAdapter(findDeviceAdapter);
        findDeviceAdapter.notifyDataSetChanged();

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
