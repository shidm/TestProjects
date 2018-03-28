package exception;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

//        System.out.println("请输入2个加数");
//        int result;
//        try
//        {
//            result = add();
//            System.out.println("结果:"+result);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        Father[] objs = new Father[2];
        objs[0] = new Father();
        objs[1] = new Son();

        for(Father obj:objs)
        {
            //因为Son类抛出的实质是SQLException，而IOException无法处理它。
            //那么这里的try。。catch就不能处理Son中的异常。
            //多态就不能实现了。
            try {
                obj.start();
            }catch(IOException e)
            {
                //处理IOException
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //获取输入的2个整数返回
    private static List<Integer> getInputNumbers()
    {
        List<Integer> nums = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        try {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            nums.add(new Integer(num1));
            nums.add(new Integer(num2));
        }catch(InputMismatchException immExp){
            throw immExp;
        }finally {
            scan.close();
        }
        return nums;
    }

    //执行加法计算
    private static int add() throws Exception
    {
        int result;
        try {
            List<Integer> nums =getInputNumbers();
            result = nums.get(0)  + nums.get(1);
        }catch(InputMismatchException immExp){
            throw new Exception("计算失败",immExp);  /////////////////////////////链化:以一个异常对象为参数构造新的异常对象。
        }
        return  result;
    }

    static class Father
    {
        public void start() throws IOException, Exception {
            throw new IOException();
        }
    }

    static class Son extends Father
    {
        public void start() throws Exception
        {
            throw new SQLException();
        }
    }
}
