package com.example.smarthome.Database;

import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Room extends LitePalSupport {
    private int category;


    private List<Device> deviceList;


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public Room() {
    }
}
