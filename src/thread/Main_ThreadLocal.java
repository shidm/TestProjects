package thread;

public class Main_ThreadLocal {

    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public static void main(String[] args) {
        int a = ~-35;
        System.out.println(a);
    }
}
