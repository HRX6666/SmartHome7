package com.example.smarthome.Database;

import org.litepal.crud.LitePalSupport;

public class Device extends LitePalSupport {
    private int source_command;//种类，根据种类查询
    private String source_long_address;
    private String source_short_address;
    private int network_flag;
//    private int source_data;//这玩意是开关键决定的，不需要保存
    private int flag;//是否同意允许该家器接入
    private int light_brightness;
    private int light_temp;

    private int air_HotOrCold;
    private int air_temp;

    private int curtain_extent;
    //表关联
    private Model model;//离家模式等等等。。。。。。
    private Room room;

//    public int getSource_data() {
//        return source_data;
//    }
//
//    public void setSource_data(int source_data) {
//        this.source_data = source_data;
//    }

    public int getSource_command() {
        return source_command;
    }

    public void setSource_command(int source_command) {
        this.source_command = source_command;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getSource_long_address() {
        return source_long_address;
    }

    public void setSource_long_address(String source_long_address) {
        this.source_long_address = source_long_address;
    }

    public String getSource_short_address() {
        return source_short_address;
    }

    public void setSource_short_address(String source_short_address) {
        this.source_short_address = source_short_address;
    }

    public int getNetwork_flag() {
        return network_flag;
    }

    public void setNetwork_flag(int network_flag) {
        this.network_flag = network_flag;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Device(int source_command, String source_long_address, String source_short_address, int network_flag) {
        this.source_command = source_command;
        this.source_long_address = source_long_address;
        this.source_short_address = source_short_address;
        this.network_flag = network_flag;
    }

    public Device() {
    }
}
