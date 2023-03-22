package com.example.smarthome.Database;
import androidx.annotation.NonNull;
import org.litepal.crud.LitePalSupport;
public class AddModel extends LitePalSupport implements Comparable<AddModel> {
    private String model;
    public void setModel(String model) {
        this.model =model;
    }
    public String getModel() {
        return model;
    }
    @Override
    public String toString() {
        return "User{" +
                ", name='" + model + '\'' +
                '}';
    }
    public int compareTo(@NonNull AddModel addModel) {
        return this.getModel().compareTo(addModel.getModel());
    }

}