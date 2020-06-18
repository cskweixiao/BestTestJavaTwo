package day03;

import org.testng.collections.Lists;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlTools {

    static String url = "";
    static String username = "";
    static String passwd = "";


    public  static ResultSet querySelect(String sql,List params)  {

        try (Connection connection = DriverManager.getConnection(url, username, passwd);
             PreparedStatement statement = connection.prepareStatement(sql);
             ){
            for (int i = 1; i < params.size(); i++) {
                statement.setObject(i,params.get(i));
            }
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     public  static int insert(String sql ,List params){
        try(Connection connection = DriverManager.getConnection(url, username, passwd);
            PreparedStatement statement = connection.prepareStatement(sql)){
            for (int i = 1; i < params.size(); i++) {
                statement.setObject(i,params.get(i));
            }
                int rows = statement.executeUpdate();
                return rows;
         }catch (SQLException e){
            throw new RuntimeException(e);
        }

     }



}