package java_core_technology;

public class Datatype {

    static int test_i = 0;

    public static void main(String[] args) {

        //数字后加下划线便于更方便的知道数值大小
        float d = 1_0000_0000;
        int i = (int) 0x1p2;
//        System.out.println(i);
//        System.out.println(d);
//        System.out.printf("%,.2f",d);//科学计数显示(.)并保留两位小数（.2）

        System.out.println(func());
        System.out.println(test_i);

        int a = -4>>>2;
        System.out.println(a);

        int b = 2;
        b += 3+1;
        System.out.println(b);

        int aa = 8,bb = 4;
        int expr = aa++%++bb*2;
        System.out.println(expr);

        int aaa = 2,bbb=3;
        int res = aaa *= bbb -= 2;
        System.out.println(bbb);
        System.out.println(res);
    }

    private static int func(){
        int temp = 5;
        return test_i++;
    }
}
