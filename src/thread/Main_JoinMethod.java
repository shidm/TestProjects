package thread;

public class Main_JoinMethod {
    static int a = 0;
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();

        thread1.start();
        try {
            thread1.join();
            System.out.println("MainThread end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MainThread end2-->"+a);
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (a < 10) {
                a++;
                System.out.printf(Thread.currentThread().getName()+",i=%d\n", a);
            }
        }
    }
}
