package com.example.smarthome.Page_Samrt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smarthome.MQTT.ClientMQTT;
import com.example.smarthome.R;

import org.eclipse.paho.client.mqttv3.MqttException;

public class AdustTheCurtain extends AppCompatActivity {
    Toolbar curtain_tb;
    private ClientMQTT clientMQTT;
    private Spinner spinner_choose_home;
    private Spinner spinner_choose_model;
    private Button bt_openAll;
    private Button bt_openMid;
    private Button bt_closeCurtain;
    private int home_choose;
    //下拉框进入默认是全屋，进入界面时应该根服务器同步数据，设置当前设备状态是怎么样的，那个seekbar也一样，要根据实际情况来变
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adust_the_curtain);
        curtain_tb=findViewById(R.id.curtain_tb);
        bt_openAll=findViewById(R.id.open_all);
        bt_openMid=findViewById(R.id.open_mid);
        bt_closeCurtain=findViewById(R.id.close_curtain);
        clientMQTT=new ClientMQTT("light");
        try {
            clientMQTT.Mqtt_innit();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        clientMQTT.startReconnect(AdustTheCurtain.this);
        bt_openMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }













}