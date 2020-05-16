package day02;

//#### 给定一个字符串，判断其是否回文
//        * 回文: 即正反都一样
public class HomeWorkTwo {

    public static void main(String[] args) {
        System.out.println(StringEqual("aaaa"));
        System.out.println(StringEqual("aaab"));
    }

    public static Boolean StringEqual(String a){
        char[] b =a.toCharArray();
        String c=new StringBuilder(a).reverse().toString();
        System.out.println(c);
        char[] d=c.toCharArray();
        for (int i = 0; i <b.length ; i++) {
            if(b[i] !=d[i]){
                return false;
            }
        }
        return true;
    }


}
