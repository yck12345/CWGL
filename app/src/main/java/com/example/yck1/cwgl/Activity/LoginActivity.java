package com.example.yck1.cwgl.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yck1.cwgl.File.FileIO;
import com.example.yck1.cwgl.R;
import com.example.yck1.cwgl.User.Ht;
import com.example.yck1.cwgl.User.HtDeserializer;
import com.example.yck1.cwgl.User.Sr;
import com.example.yck1.cwgl.User.SrDeserializer;
import com.example.yck1.cwgl.User.User;
import com.example.yck1.cwgl.User.UserDeserializer;
import com.example.yck1.cwgl.User.UserSerialiser;
import com.example.yck1.cwgl.User.Zc;
import com.example.yck1.cwgl.User.ZcDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText et_anme = (EditText) findViewById(R.id.et_name);
        final EditText et_password = (EditText) findViewById(R.id.et_password);

        Button login_zc = (Button) findViewById(R.id.login_zc);
        Button login_ok = (Button) findViewById(R.id.login_ok);
        login_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user =new User();
                user.setEmail(et_anme.getText().toString());
                user.setPassword(et_password.getText().toString());
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.serializeNulls();
                gsonBuilder.registerTypeAdapter(User.class, new UserSerialiser());
                Gson gson = gsonBuilder.create();
                String json = gson.toJson(user);
                FileIO file1 = new FileIO();
                file1.write(json, "user.json");
                file1.write("[{\"count\":0,\"time\":\" null\",\"description\":\" null\",\"fs\":\"null \",\"fl\":\"null \"} ]","sr.json");
                file1.write("{"+"'zcs':"+"[]}","zc.json");
                file1.write("{"+"'hts':"+"[]}", "ht.json");
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        login_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user1 = new User();
                FileIO file = new FileIO();
                String s = file.read("user.json");
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(User.class, new UserDeserializer());
                gsonBuilder.registerTypeAdapter(Sr.class,new SrDeserializer());
                gsonBuilder.registerTypeAdapter(Zc.class, new ZcDeserializer());
                gsonBuilder.registerTypeAdapter(Ht.class,new HtDeserializer());
                Gson gson = gsonBuilder.create();
                user1 = gson.fromJson(s, User.class);
                if (user1.getEmail().equals(et_anme.getText().toString())  && user1.getPassword().equals(et_password.getText().toString()) ) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    et_password.setText("");
                    Toast.makeText(LoginActivity.this, "你的名字不存在或者密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
