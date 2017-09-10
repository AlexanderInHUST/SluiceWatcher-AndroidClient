package com.project.tangyifeng.bigchuangiotproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.tangyifeng.bigchuangiotproject.mysql.MySqlHandler;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.button)
    void test() {
        MySqlHandler mySqlHandler = new MySqlHandler();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
