package day03;

//#### 题2
//        * 本地创建一个文件 ，内容格式为每行:id,name,age
//        - 如: 1, 张三, 23
//        * 解析此文件，解析后将内容存储进数据库。自行建数据库，表等
//        * 附加能力:
//        - 对数据做去重处理，即id,name,age三个数据完全一样认为是相同的
//        - 对数据排序,将数据排序后存储进数据库


import java.io.*;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkTwo {


    public static void main(String[] args) {
        String sql="select *from user.user_info where id=? and name=? and age=?";
        String sql2="";
        List<User> list=readFile("",new MapperUser());//读文件，获取所有user
        list = list.stream().sorted(Comparator.comparingInt(User::getId))
                .collect(Collectors.toList()); // 默认正序
        for (User user : list) {
            List params =new ArrayList();
            params.add(user.getId());
            params.add(user.getName());
            params.add(user.getAge());
           ResultSet resultSet= MysqlTools.querySelect(sql,params);
           if(resultSet !=null){
               MysqlTools.insert(sql2,params);
           }
        }



    }


     interface mapper<T> {
     public T set( int id,String name,int age);

    }

    static class MapperUser implements mapper<User>{
        @Override
        public User set(int id,String name,int age) {
            User user=new User();
            user.setAge(age);
            user.setId(id);
            user.setName(name);
            return user;
        }

    }

   //读文件， 返回list<User>
    public static<T> List<T> readFile(String path, mapper<T> mapperUser){
        File file =new File(path);
        List<T> results=new ArrayList<>();
        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(file))){
            while(bufferedReader.readLine() !=null) {
             String line=  bufferedReader.readLine();
             String[] result=line.split(",");
             int id=Integer.valueOf(result[0]);
             String name=result[1];
             int age=Integer.valueOf(result[2]);
             T obj= mapperUser.set(id,name,age);
             results.add(obj);
             }
            return results;
            } catch (Exception e) {
            throw new IllegalStateException(e);
            }


    }


}
