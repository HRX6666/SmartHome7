package com.example.smarthome.Page_Huiju;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smarthome.MQTT.ClientMQTT;
import com.example.smarthome.Page_Samrt.AdustTheCurtain;
import com.example.smarthome.R;

import org.eclipse.paho.client.mqttv3.MqttException;

public class HuijuFrament extends Fragment {
    private ClientMQTT clientMQTT;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        clientMQTT=new ClientMQTT("light");
        try {
            clientMQTT.Mqtt_innit();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        clientMQTT.startReconnect(getContext());
        return inflater.inflate(R.layout.huiju_fragment,container,false);


    }
}
