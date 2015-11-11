package com.example.yck1.cwgl.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yck1.cwgl.File.FileIO;
import com.example.yck1.cwgl.R;
import com.example.yck1.cwgl.User.User;
import com.example.yck1.cwgl.User.UserDeserializer;
import com.example.yck1.cwgl.User.UserSerialiser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginActivity extends AppCompatActivity {

    User user =new User();


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

                user.setEmail(et_anme.getText().toString());
                user.setPassword(et_password.getText().toString());
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.serializeNulls();
                gsonBuilder.registerTypeAdapter(User.class, new UserSerialiser());
                Gson gson = gsonBuilder.create();
                String json = gson.toJson(user);
                FileIO file1 = new FileIO();
                file1.write(json, "/user.json");
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        login_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FileIO file = new FileIO();
                String s = file.read("/user.json");
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.serializeNulls();
                gsonBuilder.registerTypeAdapter(User.class, new UserDeserializer());
                Gson gson = gsonBuilder.create();
                user = gson.fromJson(s, User.class);
                if (user.getEmail() == et_anme.getText().toString() && user.getPassword() == et_password.getText().toString()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "你的名字不存在或者密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
