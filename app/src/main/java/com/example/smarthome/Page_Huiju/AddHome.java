package com.example.smarthome.Page_Huiju;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.smarthome.table.Homes;
import com.example.smarthome.R;

public class AddHome extends AppCompatActivity {
    View view;
    Toolbar toolbar;
    public   Integer dra=0;
    Homes homes=new Homes();
    TextView drawing,bedroom,masterroom,kitchen,mess,toilet,childroom,office,study,gallery,studio,bathroom,backyard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home);
        toolbar=findViewById(R.id.addhome_tb);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }
        });
        inithome();
    }

    private void inithome() {
        view=findViewById(R.id.room_manage);
        drawing=findViewById(R.id.drawing_tv);
        bedroom=findViewById(R.id.bedroom_tv);
        masterroom=findViewById(R.id.masterroom_tv);
        kitchen=findViewById(R.id.kitchen_tv);
        mess=findViewById(R.id.mess_tv);
        toilet=findViewById(R.id.toilet_tv);
        childroom=findViewById(R.id.childroom_tv);
        office=findViewById(R.id.office_tv);
        study=findViewById(R.id.study_tv);
        studio=findViewById(R.id.studio_tv);
        gallery=findViewById(R.id.gallery_tv);
        bathroom=findViewById(R.id.bedroom_tv);
        backyard=findViewById(R.id.backyard_tv);
       drawing.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


           }
       });
    }
}