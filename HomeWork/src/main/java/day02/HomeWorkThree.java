package day02;

import org.testng.annotations.Test;

import java.util.*;

//#### 集合作业题
//        * 1.判断两个集合是否有相同元素，若有则输出相同的元素
//        * 2.给定一个HashSet，排序其中元素，输出
public class HomeWorkThree<T> {


    @Test
    public void test(){
        List<String> a=new ArrayList<>();
        a.add("1");
        a.add("3");
        a.add("1");
        List<String> b=new ArrayList<>();
        b.add("1");
        b.add("2");
        Set<String> c=new HomeWorkThree<String>().SetEqual(a,  b);
        System.out.println(c.toString());


        HashSet<Integer> d=new HashSet<>();
        d.add(1);
        d.add(8);
        d.add(5);
        List<Integer> f=new HomeWorkThree<Integer>().SetSort(d);
        System.out.println(f.toString());
    }


    public   Set<String> SetEqual(Collection<T> a, Collection<T> b){

        Set<String> c=new HashSet<>();

        for (T s : a) {
            for (T k:b) {
                if (s.toString().equals(k.toString())){
                    c.add(s.toString());
                }
            }
        }
        return c;
    }

    public List<Integer> SetSort(HashSet<Integer> a){
        HashSet<Integer> b=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for (Integer s:a) {
            list.add(s);
        }
        Collections.sort(list);

        return list;


    }
}
