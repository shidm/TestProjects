package synchronized_test;

public class Main_Synchronized {

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        SynchronizedTest test1 = new SynchronizedTest();

        new Thread(()->{
//            test.c();
            test.a();
            test.b();
//            test.d();
        }).start();

        new Thread(()->{
//            test.c();
            test1.b();
            test1.a();
//            test.d();
        }).start();
    }

    static class SynchronizedTest {

        public synchronized static void a() {
            System.out.println(Thread.currentThread()+"::method：a()---->running："+System.currentTimeMillis());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"::method：a()---->end："+System.currentTimeMillis());
        }

        public synchronized static void b() {
            System.out.println(Thread.currentThread()+"::method：b()---->running："+System.currentTimeMillis());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"::method：b()---->end："+System.currentTimeMillis());
        }

        public synchronized void c() {
            System.out.println(Thread.currentThread()+"::method：c()---->running："+System.currentTimeMillis());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"::method：c()---->end："+System.currentTimeMillis());
        }

        public synchronized void d() {
            System.out.println(Thread.currentThread()+"::method：d()---->running："+System.currentTimeMillis());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"::method：d()---->end："+System.currentTimeMillis());
        }

//        public static void e(){
//            synchronized (SynchronizedTest.class){
//                ......
//            }
//        }
//
//        public void f(){
//            synchronized (this){
//                ......
//            }
//        }

    }
}
