package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main_Lock {
    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//        lock.lock();
//        lock.tryLock();

        System.out.println("result:"+test());
    }

    private static int test() {
        int i = 0;

        try {
            i++;
            System.out.println("try:"+i);
            throwE();
            return i;
        }catch (Exception e){
            i++;
            System.out.println("catch:"+i);
            return i;
        }finally {
            i++;
            System.out.println("finally:"+i);
//            return i;
        }
    }

    private static void throwE() throws Exception{
        throw new Exception();
    }
}
