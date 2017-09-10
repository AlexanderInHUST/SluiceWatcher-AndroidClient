package com.project.tangyifeng.bigchuangiotproject.mysql;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

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
    private ResultSet queryResult;
    private Connection connection;


    private static final String TAG = "MySqlHandler";

    public MySqlHandler() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            Log.d(TAG, "mysql connected.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HashMap<String, MySqlColumnValue>> query(String queryCommand) {
        ArrayList<HashMap<String, MySqlColumnValue>> result = new ArrayList<>();
        ArrayList<String> columnLables = new ArrayList<>();
        ArrayList<Integer> columnType = new ArrayList<>();
        executeQuery(queryCommand);
        Log.d(TAG, "mysql query done.");
        try {
            ResultSetMetaData metaData = queryResult.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnLables.add(metaData.getColumnLabel(i));
                columnType.add(metaData.getColumnType(i));
            }
            while (queryResult.next()) {
                HashMap<String, MySqlColumnValue> singleRow = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    singleRow.put(columnLables.get(i - 1), new MySqlColumnValue(columnType.get(i - 1), queryResult.getObject(i)));
                }
                result.add(singleRow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "mysql query result has been handled done.");
        return result;
    }

    private void executeQuery(String queryCommand) {
        try {
            queryResult = statement.executeQuery(queryCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (queryResult != null) {
                queryResult.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
