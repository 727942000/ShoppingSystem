package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllOperation implements Operation {
    public Map<Integer, List<String>> Select(EventName en,int ID){

        //返回值初始化
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        //连接
        Connectsql cs = new Connectsql();
        Connection conn = cs.getConnect(Operation.userName,Operation.userPassWd);
        try {
            Statement statement = conn.createStatement();
            // 执行查询操作，将结果存储在ResultSet对象中
            String query = "SELECT * FROM user ";
            String where = "WHERE u_id="+ID;
            query = query + where;
            ResultSet resultSet = statement.executeQuery(query);

            // 遍历结果集并处理数据
            while (resultSet.next()) {
                int id = resultSet.getInt("u_id");
                String u_id = resultSet.getString("u_id");
                String name = resultSet.getString("u_name");
                String password = resultSet.getString("u_password");
                String email = resultSet.getString("u_email");
                String sex = resultSet.getString("u_sex");
                String status = resultSet.getString("u_status");
                String role = resultSet.getString("u_role");
                list.add(u_id);
                list.add(name);
                list.add(password);
                list.add(email);
                list.add(sex);
                list.add(status);
                list.add(role);
                map.put(id,list);
                System.out.println(resultSet.getString("u_id")+" "+resultSet.getString("u_password"));
//                int id = resultSet.getInt("u_id");
//                String name = resultSet.getString("u_name");
//                //int age = resultSet.getInt("age");
//                System.out.println("ID: " + id + ", Name: " + name);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return map;
    }

    public static void main(String[] args) {
        AllOperation ap = new AllOperation();
        ap.Select(EventName.ID,6);
    }
}
