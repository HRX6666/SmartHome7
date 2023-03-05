package com.example.smarthome.Database;

import org.litepal.crud.LitePalSupport;

public class Device extends LitePalSupport {
    private String source_command;//种类，根据种类查询
    private String source_long_address;
    private String source_short_address;
    private String misc;//
    private String network_flag;//电器是否自动入网(电器重启后自动组网)
    private String source_data;//这玩意是开关键决定的，不需要保存
    private int flag;//是否同意允许该家器接入
    private int isUpdate;//判断app开启电器入网是否收到了这条电器信息

    private int light_brightness;//亮度
    private int light_temp;//色温

    private int air_HotOrCold;//制热还是制冷
    private String air_temp;//空调温度

//   private int air_temp;//空调温度

    private int curtain_extent;//窗帘程度
    //表关联
    private Model model;//离家模式等等等。。。。。。
    private Room room;//房间

//    public int getSource_data() {
//        return source_data;
//    }
//
//    public void setSource_data(int source_data) {
//        this.source_data = source_data;
//    }


    public int getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(int isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getSource_data() {
        return source_data;
    }

    public void setSource_data(String source_data) {
        this.source_data = source_data;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String getSource_command() {
        return source_command;
    }

    public void setSource_command(String source_command) {
        this.source_command = source_command;
    }

    public int getLight_brightness() {
        return light_brightness;
    }

    public void setLight_brightness(int light_brightness) {
        this.light_brightness = light_brightness;
    }

    public int getLight_temp() {
        return light_temp;
    }

    public void setLight_temp(int light_temp) {
        this.light_temp = light_temp;
    }

    public int getAir_HotOrCold() {
        return air_HotOrCold;
    }

    public void setAir_HotOrCold(int air_HotOrCold) {
        this.air_HotOrCold = air_HotOrCold;
    }

    public String getAir_temp() {
        return air_temp;
    }

    public void setAir_temp(String air_temp) {
        this.air_temp = air_temp;
    }
//    public int getAir_temp() {
//        return air_temp;
//    }
//
//    public void setAir_temp(int air_temp) {
//        this.air_temp = air_temp;
//    }

    public int getCurtain_extent() {
        return curtain_extent;
    }

    public void setCurtain_extent(int curtain_extent) {
        this.curtain_extent = curtain_extent;
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

    public String getNetwork_flag() {
        return network_flag;
    }

    public void setNetwork_flag(String network_flag) {
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



    public Device() {
    }
}
