 package com.example.smarthome.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.smarthome.Page_Home.HomeFragment;
import com.example.smarthome.Page_Huiju.HuijuFrament;
import com.example.smarthome.Page_Samrt.SmartFragment;
import com.example.smarthome.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

 public class BottomSmartHome extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_smart_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        bottomNavigationView=findViewById(R.id.smart_home);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.framentConntaint,new HuijuFrament()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch ( item.getItemId() ) {
                    case R.id.navigation_home:
                        fragment = new HuijuFrament();
                        break;
                    case R.id.navigation_dashboard:
                        fragment = new SmartFragment();
                        break;
                    case R.id.navigation_notifications:
                        fragment = new HomeFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framentConntaint,fragment).commit();
                    return true;

            }
        });



    }
}