package day02;
//#### 从文件读取数据，解析出来之后，存入至数据库中
//        * 文件内容诸如: id, name, age是一种格式表示，用逗号分隔
//        ```java
//        id, name, age
//        1,   jim,  23
//        2,   jack, 24

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class HomeWorkOne {
    JdbcTools jc=new JdbcTools();

    public static void main(String[] args) {
        new HomeWorkOne().readFile("");
    }



    //读文件
    public   void  readFile(String filePath){
        File file =new File(filePath);
        InputStream inputStream = null;
        StringBuilder sb = new StringBuilder();

        try {
             inputStream = new FileInputStream(file);
            int len;
            byte[] buf = new byte[256];
            while ((len = inputStream.read(buf)) != -1) {
                String str = new String(buf, 0, len);
                String[] a=str.split(",");
                jc.insert(writeFile(a[1],a[2],a[3]));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    //sql生成
    public  static String writeFile(String id,String name,String sex){
        return "Insert into test.test(id,name,sex) value('"+id+"','"+name+"','"+sex+"');";
    }


}
