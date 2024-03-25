package com.blit;

import com.blit.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {

    public static void main ( String[] args ) {
        System.out.println("Hello Maven.");
        System.out.println("JSON Library install.");
        System.out.println("------------------------");

        JSONObject obj = new JSONObject("{\"A\":1}");
        obj.put("B", 2);
        obj.put("C", 3);
        System.out.println(obj.toString(4));

        JSONArray jarr = new JSONArray();
        jarr.put(obj);
        jarr.put(obj);
        jarr.put(obj);

        System.out.println(jarr.toString(4));

        Connection c = null;
        try {
            ConnectionUtil conn = new ConnectionUtil();
             c = conn.getConnection();
           
            System.out.println("Connection Success");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(c != null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
