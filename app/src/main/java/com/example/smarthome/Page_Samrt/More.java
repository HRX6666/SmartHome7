package com.example.smarthome.Page_Samrt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.smarthome.Database.AddModel;
import com.example.smarthome.Helper.AddMedalHelper;
import com.example.smarthome.R;

import org.json.JSONObject;
import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

public class More extends AppCompatActivity {
    RelativeLayout select_condition,select_tesk;
    Button create;
    EditText model_name;
    String name_ml;
    private JSONObject registerInfo;  //注册返回信息
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        inite();


    }

    private void inite() {
        select_condition =findViewById(R.id.select_condition);
        select_tesk=findViewById(R.id.select_tesk);
        create=findViewById(R.id.create);
        model_name=findViewById(R.id.model_name);
        select_tesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(More.this,Condition.class);
                startActivity(intent);
            }
        });
        select_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(More.this, Tesk.class);
                startActivity(intent1);

            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
                name_ml=model_name.getText().toString();    //获取输入框值
                //判断输入框中是否有值
                if(TextUtils.isEmpty(name_ml)){
                    Toast.makeText(More.this,"请输入自定义场景名称",Toast.LENGTH_SHORT).show();
                    return;
                }
                AddModel addModel=new AddModel();
                addModel.setModel(name_ml);
                addModel.save();
                finish();


            }
        });
    }


}