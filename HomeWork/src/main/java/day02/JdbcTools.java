package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTools {

    String driverClass="";
    String jdbc_url="";
    String user="";
    String password="";

    //创建连接
    public Connection getConnetions(String driverClass,String jdbc_url,String user,String password) {
        Connection conn = null;

        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(jdbc_url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //无数据返回，关闭连接
    public static void release(PreparedStatement ps, Connection conn) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //insert
    public void insert(String sql){
        PreparedStatement ps = null;
       Connection connection= getConnetions(driverClass,jdbc_url,user,password);
       try {
           connection.prepareStatement(sql);
           //用于增删改操作
           int result = ps.executeUpdate();
           System.out.println(result);
       }catch (Exception e ){
           e.printStackTrace();
       }finally {
           release(ps,connection);
       }


    }



}
