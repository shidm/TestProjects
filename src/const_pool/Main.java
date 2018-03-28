package const_pool;

public class Main {

    static final String s1 = "a";
    static final String s2 = "b";
    static final String s;
    static {
        s = "a";
    }

    public static void main(String[] args) {

        String s4 = "a";
        String s5 = "b";
        String s3 = "ab";
        String s6 = s1 + s2;//方法区中相加
        String s7 = "a" + "b";
        String s8 = s4 + s5;
        String s9 = s + s2;

        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s3 == s8);
        System.out.println(s9 == s6);
    }
}
