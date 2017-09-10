package com.project.tangyifeng.bigchuangiotproject.mysql;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadPoolExecutor;

import static com.project.tangyifeng.bigchuangiotproject.mysql.MySqlConst.DB_URL;
import static com.project.tangyifeng.bigchuangiotproject.mysql.MySqlConst.PASSWORD;
import static com.project.tangyifeng.bigchuangiotproject.mysql.MySqlConst.USER;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/9/8.
 */

public class MySqlHandler {

    private Statement statement;
    private ThreadPoolExecutor poolExecutor;

    private static final String TAG = "MySqlHandler";

    public MySqlHandler() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = conn.createStatement();
            Log.d(TAG, "mysql connected.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
