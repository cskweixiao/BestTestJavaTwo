package day04.course;

import day03.User;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
    Runnable runnable= () -> {

    };


    Comparable<Integer> comparable= o -> 0;


    interface Foo {
        String foo(Integer i1, Date time, Map<String, String> mapping);
    }


    Foo foo = (  i1, time,mapping) -> "123";


    public static void main(String[] args) throws FileNotFoundException,IndexOutOfBoundsException,IOException {
        File file =new File("D:\\BTJAVA\\BestTestJavaTwo\\HomeWork\\src\\main\\java\\day03\\Food.java");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        List<String> results=bufferedReader.lines().
                flatMap(line -> Stream.of(line.split(" "))).
                filter(f->Integer.valueOf(f)>10).sorted().collect(Collectors.toList());

        Integer[] arr = {-12345, 9999, 520, 0,-38,-7758520,941213};
        List<Integer> integerStream = Arrays.stream(arr).filter(ar -> ar >= 0).collect(Collectors.toList());


    }

}
