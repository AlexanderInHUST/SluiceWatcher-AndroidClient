package com.project.tangyifeng.bigchuangiotproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.tangyifeng.bigchuangiotproject.mysql.MySqlColumnValue;
import com.project.tangyifeng.bigchuangiotproject.mysql.MySqlHandler;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.button)
    void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MySqlHandler mySqlHandler = new MySqlHandler();
                ArrayList<HashMap<String, MySqlColumnValue>> list =  mySqlHandler.query("select * from cm_customer");
                System.out.println(list.get(0).keySet().size());
                mySqlHandler.close();
            }
        }).start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
