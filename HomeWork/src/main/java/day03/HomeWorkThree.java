package day03;


//#### 题3
//        * 给定数据列表List<Stu>
//* Stu属性
//        - id,name,age,className
//        * 流化操作: 过滤stu.className==一班 -> 去重 -> 基于年纪排序 -> 返回最新列表


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkThree {


    public static void main(String[] args) {
        //不新建一个Stu类了，直接用User
        List<User> results=new ArrayList<>();
        results = results.stream().filter(user -> user.getName().equals("一班")).distinct().sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList()); // 默认正序
        System.out.println(results);
    }


}
