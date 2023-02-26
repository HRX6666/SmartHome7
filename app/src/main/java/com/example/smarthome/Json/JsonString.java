package com.example.smarthome.Json;
import java.util.HashMap;
import java.util.Map;

public class JsonString {
    private String timestamp;
    private String firmware_version;
    private String device_name;
    private String device_id;
    private String misc;
    private String target_short_address;
    private String target_command;
    private String target_data;


    public JsonString(String timestamp, String firmware_version, String device_name, String device_id, String misc, String target_short_address, String target_command, String target_data) {
        this.timestamp = timestamp;
        this.firmware_version = firmware_version;
        this.device_name = device_name;
        this.device_id = device_id;
        this.misc = misc;
        this.target_short_address = target_short_address;
        this.target_command = target_command;
        this.target_data = target_data;
    }


    @Override
    public String toString() {
        return "{\"timestamp\":\""+timestamp+"\"," +
                "\"firmware_version\":\""+firmware_version+"\"," +
                "\"device_name\":\" "+device_name+"\"," +
                "\"device_id\":\" "+device_id+"\"," +
                "\"other_data\": {" +
                "\"misc\":\""+misc+
                "\"}," +
                "\"sensors\": [" +
                "{" +
                "\"target_short_address\":\""+target_short_address+" \"," +
                "\"target_command\": \""+target_command+"\"," +
                "\"timestamp\": \""+timestamp+"\"," +
                "\"target_data\":\" "+target_data+"\"," +
                "\"misc\": \""+misc + "\"}" + "]" +
                "}";
    }
}
