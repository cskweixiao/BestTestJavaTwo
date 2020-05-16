package day01;



//给一个乱序的数组，基于冒泡排序算法进行排序
public class HomeWorkTwo {

    public static void main(String[] args) {

      mp(new int[]{1,5,8,2,3,9,4});//1523849 1235489 1234589
    }




    public static void mp(int[] numbers){

        for (int i = 0; i <numbers.length-1 ; i++) {
            for (int j = 0; j <numbers.length-i-1 ; j++) {
                if(numbers[j]>numbers[j+1]){
                    int tmp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=tmp;
                }
            }
        }
        for (int i = 0; i <numbers.length ; i++) {
            System.out.println(numbers[i]);
        }
    }


}
