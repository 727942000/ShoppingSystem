package com.company;

import java.sql.*;
import java.util.*;

public class AllOperation implements Operation {

    private Map<Integer, List<String>> map;
    private List<String> list;
    private Connectsql cs;
    public AllOperation(){
        //返回值初始化
        map = new HashMap<>();
        list = new ArrayList<>();
        //连接
        cs = new Connectsql();
    }

    public Map<Integer, List<String>> Select(EventName en,int ID){

        String tableName = "null";
        Connection conn = cs.getConnect(Operation.userName,Operation.userPassWd);
        StringBuilder query = new StringBuilder("SELECT * FROM");
        StringBuilder where = new StringBuilder(" WHERE");
        query.append(" ");
        try {
            Statement statement = conn.createStatement();
            // 执行查询操作，将结果存储在ResultSet对象中
            switch (en){
                case Buyer:
                    tableName = "user";
                    where.append(" u_id=");
                    where.append(String.valueOf(ID));
                    where.append(" And u_role=");
                    where.append("'U'");
                    break;
                case Seller:
                    tableName = "user";
                    where.append(" u_id=");
                    where.append(String.valueOf(ID));
                    where.append(" AND u_role=");
                    where.append("'S'");
                    break;
                case Administrator:
                    tableName = "user";
                    where.append(" u_id=");
                    where.append(String.valueOf(ID));
                    where.append(" AND u_role=");
                    where.append("'A'");
                    break;
                case Product:
                    tableName = "product";
                    where.append(" p_id=");
                    where.append(String.valueOf(ID));
                    break;
                case Orders:
                    tableName = "orders";
                    where.setLength(0);
//                    where.append(" o_id=");
//                    where.append(String.valueOf(ID));
                    break;
                case Address:
                    tableName = "address";
                    where.append(" a_id=");
                    where.append(String.valueOf(ID));
                    break;
                case cart:
                    tableName = "cart";
                    where.append(" c_id=");
                    where.append(String.valueOf(ID));
                    break;
                case Type:
                    tableName = "type";
                    where.append(" t_id=");
                    where.append(String.valueOf(ID));
                    break;
                case Item:
                    tableName = "item";
                    where.append(" i_id=");
                    where.append(String.valueOf(ID));
                default:
                    break;
            }

            if(tableName.compareTo("null")==0){
                statement.close();
                cs.closeConn(conn);
                return map;
            }

            query.append(tableName);
            query.append(where);
            ResultSet resultSet = statement.executeQuery(query.toString());

            // 遍历结果集并处理数据
            switch (en){
                case Buyer:
                case Seller:
                case Administrator:
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
                    break;
                case Product:
                    while (resultSet.next()){
                        int id = resultSet.getInt("p_id");
                        int t_id = resultSet.getInt("t_id");
                        String name = resultSet.getString("p_name");
                        String time = resultSet.getString("p_time");
                        String price = resultSet.getString("p_price");
                        String info = resultSet.getString("p_info");
                        String popularity = resultSet.getString("p_popularity");
                        list.add(String.valueOf(id));
                        list.add(String.valueOf(t_id));
                        list.add(name);
                        list.add(time);
                        list.add(price);
                        list.add(info);
                        list.add(popularity);
                        map.put(id,list);
                        System.out.println(id+" "+name);
                    }
                    break;
                case Orders:
                    while (resultSet.next()){
                        int id = resultSet.getInt("o_id");
                        int p_id = resultSet.getInt("p_id");
                        int u_id = resultSet.getInt("u_id");
                        int a_id = resultSet.getInt("a_id");
                        String name = resultSet.getString("o_name");
                        String time = resultSet.getString("o_time");
                        String price = resultSet.getString("o_price");
                        String state = resultSet.getString("o_state");
                        list.add(String.valueOf(id));
                        list.add(String.valueOf(p_id));
                        list.add(String.valueOf(u_id));
                        list.add(String.valueOf(a_id));
                        list.add(name);
                        list.add(time);
                        list.add(price);
                        list.add(state);
                        map.put(id,list);
                    }
                    break;
                case Address:
                    while (resultSet.next()){
                        int id = resultSet.getInt("a_id");
                        int u_id = resultSet.getInt("u_id");
                        String name = resultSet.getString("a_name");
                        String phone = resultSet.getString("a_phone");
                        String price = resultSet.getString("a_detail");
                        String state = resultSet.getString("a_state");
                        String sender = resultSet.getString("a_sender");
                        String a_s_address = resultSet.getString("a_s_address");
                        list.add(String.valueOf(id));
                        list.add(String.valueOf(u_id));
                        list.add(name);
                        list.add(phone);
                        list.add(price);
                        list.add(state);
                        list.add(sender);
                        list.add(a_s_address);
                        map.put(id,list);
                        System.out.println(id+" "+name);
                    }
                    break;
                case Type:
                    while (resultSet.next()){
                        int id = resultSet.getInt("t_id");
                        String name = resultSet.getString("t_name");
                        String info = resultSet.getString("t_info");
                        list.add(String.valueOf(id));
                        list.add(name);
                        list.add(info);
                        map.put(id,list);
                        System.out.println(id+" "+name);
                    }
                    break;
                case cart:
                    while (resultSet.next()){
                        int id = resultSet.getInt("c_id");
                        int u_id = resultSet.getInt("u_id");
                        int p_id = resultSet.getInt("p_id");
                        String count = resultSet.getString("c_count");
                        String num = resultSet.getString("c_num");
                        list.add(String.valueOf(id));
                        list.add(String.valueOf(u_id));
                        list.add(String.valueOf(p_id));
                        list.add(count);
                        list.add(num);
                        map.put(id,list);
                    }
                    break;
                case Item:
                    while (resultSet.next()){
                        int id = resultSet.getInt("i_id");
                        int o_id = resultSet.getInt("o_id");
                        int p_id = resultSet.getInt("p_id");
                        String count = resultSet.getString("i_count");
                        String num = resultSet.getString("i_num");
                        list.add(String.valueOf(id));
                        list.add(String.valueOf(o_id));
                        list.add(String.valueOf(p_id));
                        list.add(count);
                        list.add(num);
                        map.put(id,list);
                    }
                    break;
                default:
                    break;
            }

            //关掉
            resultSet.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        //关掉
        cs.closeConn(conn);
        return map;
    }

    public Map<Integer, List<String>> Select(EventName en,String _name){
        String tableName = "null";
        Connection conn = cs.getConnect(Operation.userName,Operation.userPassWd);
        StringBuilder query = new StringBuilder("SELECT * FROM");
        StringBuilder where = new StringBuilder(" WHERE");
        query.append(" ");
        try {
            Statement statement = conn.createStatement();
            // 执行查询操作，将结果存储在ResultSet对象中
            switch (en){
                case Buyer:
                    tableName = "user";
                    where.append(" u_name=");
                    where.append("'"+_name+"'");
                    where.append(" And u_role=");
                    where.append("'U'");
                    break;
                case Seller:
                    tableName = "user";
                    where.append(" u_name=");
                    where.append("'"+_name+"'");
                    where.append(" AND u_role=");
                    where.append("'S'");
                    break;
                case Administrator:
                    tableName = "user";
                    where.append(" u_name=");
                    where.append("'"+_name+"'");
                    where.append(" AND u_role=");
                    where.append("'A'");
                    break;
                case Product:
                    tableName = "product";
                    where.append(" p_name=");
                    where.append("'"+_name+"'");
                    where.append(" OR p_id="+"'"+_name+"'");
                    break;
                case Address:
                    tableName = "address";
                    where.append(" a_name=");
                    where.append("'"+_name+"'");
                    break;

                case Type:
                    tableName = "type";
                    where.append(" t_name=");
                    where.append("'"+_name+"'");
                    break;

                default:
                    break;
            }

            if(tableName.compareTo("null")==0){
                statement.close();
                cs.closeConn(conn);
                return map;
            }

            query.append(tableName);
            query.append(where);
            System.out.println(query.toString());
            ResultSet resultSet = statement.executeQuery(query.toString());

            // 遍历结果集并处理数据
            switch (en){
                case Buyer:
                case Seller:
                case Administrator:
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
                    break;
                case Product:
                    while (resultSet.next()){
                        int id = resultSet.getInt("p_id");
                        int t_id = resultSet.getInt("t_id");
                        String name = resultSet.getString("p_name");
                        String time = resultSet.getString("p_time");
                        String price = resultSet.getString("p_price");
                        String info = resultSet.getString("p_info");
                        String popularity = resultSet.getString("p_popularity");
                        list.add(String.valueOf(id));
                        list.add(String.valueOf(t_id));
                        list.add(name);
                        list.add(time);
                        list.add(price);
                        list.add(info);
                        list.add(popularity);
                        map.put(id,list);
                        System.out.println(id+" "+name);
                    }
                    break;

                case Address:
                    while (resultSet.next()){
                        int id = resultSet.getInt("a_id");
                        int u_id = resultSet.getInt("u_id");
                        String name = resultSet.getString("a_name");
                        String phone = resultSet.getString("a_phone");
                        String price = resultSet.getString("a_detail");
                        String state = resultSet.getString("a_state");
                        String sender = resultSet.getString("a_sender");
                        String a_s_address = resultSet.getString("a_s_address");
                        list.add(String.valueOf(id));
                        list.add(String.valueOf(u_id));
                        list.add(name);
                        list.add(phone);
                        list.add(price);
                        list.add(state);
                        list.add(sender);
                        list.add(a_s_address);
                        map.put(id,list);
                        System.out.println(id+" "+name);
                    }
                    break;
                case Type:
                    while (resultSet.next()){
                        int id = resultSet.getInt("t_id");
                        String name = resultSet.getString("t_name");
                        String info = resultSet.getString("t_info");
                        list.add(String.valueOf(id));
                        list.add(name);
                        list.add(info);
                        map.put(id,list);
                        System.out.println(id+" "+name);
                    }
                    break;

                default:
                    break;
            }

            //关掉
            resultSet.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        //关掉
        cs.closeConn(conn);
        return map;
    }

    //对购物车的操作
    public Boolean insertCart(int u_id,int p_id,float c_count,int c_num){
        StringBuilder sb = new StringBuilder("insert into "+EventName.cart +"(u_id,p_id,c_count,c_num) values(?,?,?,?)");

        System.out.println(sb);
        Connection conn = cs.getConnect(Operation.userName,Operation.userPassWd);
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sb.toString());
            preparedStatement.setInt(1,u_id);
            preparedStatement.setInt(2,p_id);
            preparedStatement.setFloat(3,c_count);
            preparedStatement.setInt(4,c_num);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        cs.closeConn(conn);
        System.out.println("Insert succeed");
        return true;

    }

    public Boolean deleteCart(int c_id){
        Connection conn = cs.getConnect(Operation.userName,Operation.userPassWd);
        StringBuilder sb = new StringBuilder("DELETE FROM ");

        //表的名字
        sb.append(EventName.cart);

        //WHERE
        sb.append(" WHERE c_id = ?");

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sb.toString());

            //占位值填充
            preparedStatement.setInt(1,c_id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        cs.closeConn(conn);
        System.out.println("Delete Succeed!");
        return true;
    }

    public Boolean updateCart(int c_id,int u_id,int p_id,float c_count,int c_num){
        //"UPDATE table_name SET column1 = ? WHERE column2 = ?"
        //StringBuilder sb = new StringBuilder("UPDATE "+EventName.cart +" SET u_id = ?,p_id = ?,c_count=?,c_num=? WHERE c_id=?");
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(EventName.cart);
        sb.append(" SET u_id = ?,p_id = ?,c_count=?,c_num=? WHERE c_id=?");
        System.out.println(sb);
        Connection conn = cs.getConnect(Operation.userName,Operation.userPassWd);
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sb.toString());
            preparedStatement.setInt(1,u_id);
            preparedStatement.setInt(2,p_id);
            preparedStatement.setFloat(3,c_count);
            preparedStatement.setInt(4,c_num);
            preparedStatement.setInt(5,c_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        cs.closeConn(conn);
        System.out.println("update succeed");
        return true;
    }

    public static void main(String[] args) {
        AllOperation ap = new AllOperation();
        //ap.Select(EventName.Seller,"黎云熙");
        //ap.insertCart(8,8,8,8);
        //ap.deleteCart(35802);
        ap.updateCart(35803,1,1,1,1);
    }


}
