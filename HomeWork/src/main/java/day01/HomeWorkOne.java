package day01;
//   实现一个可以解析字符串的计算器
//* 传入一个字符串，解析此字符串数字与运算符做计算
//* 比如: 字符串str="1+2", 可计算出结果=3

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
  str="1+2"
  str="'12+"
  str=+12
  str=12 +
  str='-1+2'
  str='0.01+2'
  str="'a+2'"
  str="12"
  str="+-12"
  1、
  2、判断是否有运算符
  3、
  4、
 */
public class HomeWorkOne {

    public void split(String a) {

        //判断运算符是否正确
        char[] charter = new char[]{'+', '-', '*', '/'};
        char[] b = a.trim().toCharArray();
        List list = new ArrayList();
        for (int i = 0; i < charter.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] == charter[i]) {
                    list.add(Character.toString(b[j]));
                }
            }
        }
        if (list.size() != 1) {
            System.out.println("运算符不正确，请确认后重新输入");
        } else {
            if (list.get(0).toString().equals("+")) {
                String[] x = a.trim().split("\\+");
                if (isDigit(x[0]) & isDigit(x[1])) {
                    System.out.println(new BigDecimal(x[0]).add(new BigDecimal(x[1])));
                } else {
                    System.out.println("数据输入有误");
                }
            }
            if(list.get(0).toString().equals("-")) {
                String[] x = a.trim().split("-");
                if (isDigit(x[0]) & isDigit(x[1])) {
                    System.out.println(new BigDecimal(x[0]).subtract(new BigDecimal(x[1])));
                }else {
                    System.out.println("数据输入有误");
                }
            }
            if(list.get(0).toString().equals("*")) {
                String[] x = a.trim().split("\\*");
                if (isDigit(x[0]) & isDigit(x[1])) {
                    System.out.println(new BigDecimal(x[0]).multiply(new BigDecimal(x[1])));
                }else {
                    System.out.println("数据输入有误");
                }
            }
            if(list.get(0).toString().equals("/")) {
                String[] x = a.trim().split("/");
                if (isDigit(x[0]) & isDigit(x[1])) {
                    System.out.println(new BigDecimal(x[0]).divide(new BigDecimal(x[1])));
                }else {
                    System.out.println("数据输入有误");
                }
            }

        }
    }



    private Boolean isDigit(String a ){

        if(a.matches("-?[0-9]+.*[0-9]*")){
            return true;
        }
        return false;
    }
}









