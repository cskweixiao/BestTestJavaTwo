package day02;



//#### IO作业题
//        * 给定路径后完成文件的复制


import java.io.*;
import java.util.ArrayList;


public class HomeWorkFour {

    public static void main(String[] args) {

        new HomeWorkFour().readFile("");
    }


    //传入目录
    public ArrayList readFile(String filePath){
        ArrayList<String> filepaths=new ArrayList<>();
        File file=new File(filePath);
        //获取所有文件
        File[] files=file.listFiles();
        if(files ==null |files.length==0){
            return filepaths;
        }
        for (File file1 : files) {
            //如果是文件夹继续调用方法遍历
            if (file.isDirectory()) {
                readFile(file1.getAbsolutePath());
            } else {
                filepaths.add(file1.toString());
            }
        }
        return filepaths;

    }

    public void readAndWrite(String homepath){
        ArrayList files=readFile(homepath);
        for (int i = 0; i < files.size(); i++) {
            String filepath=  files.get(i).toString();
            byte[] text=new String(read(filepath)).getBytes();
            write(filepath,text);
        }

    }


    public StringBuilder read(String path){
        File file =new File(path);
        StringBuilder sb=new StringBuilder();
        InputStream inputStream=null;
        try {
             inputStream=new FileInputStream(file);
            int len;
            byte[] bytes=new byte[256];

            while((len=inputStream.read(bytes) )!=-1){
                String str=new String(bytes ,0,len);
                sb.append(str);
                return sb;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream !=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb;
    }

    public void write(String path,byte[] result){
        File file =new File(path);
        OutputStream outputStream=null;
        try {
             outputStream =new FileOutputStream(file);
            outputStream.write(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null !=outputStream){
                try {
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   //FileWrite
    public void FileWrite(){
        File file =new File("");
        FileWriter fileWriter=null;
        byte[] result =new byte[256];
        try {
            fileWriter=new FileWriter(file);
            fileWriter.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter !=null){

            }
        }

    }


}
