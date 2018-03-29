package lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main_ReentrantReadWriteLock {

    public static void main(String[] args) {

        LockTest test = new LockTest();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.readTest();
                }
            }).start();
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                test.writeTest();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.readTest();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.readTest();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.writeTest();
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.readTest();
            }
        });

        try {
            Thread.sleep(100);
            t.start();
            Thread.sleep(100);
            t1.start();
            Thread.sleep(100);
            t2.start();
            Thread.sleep(100);
            t3.start();
            Thread.sleep(100);
            t4.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class LockTest {
        ReadWriteLock lock = new ReentrantReadWriteLock(true);

        public void readTest() {
            lock.readLock().lock();
            System.out.println("Time："+System.currentTimeMillis()+"："+Thread.currentThread().getName()+"：read_begin");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Time："+System.currentTimeMillis()+"："+Thread.currentThread().getName()+"：reading_unlock");
                lock.readLock().unlock();
            }
        }

        public void writeTest() {
            lock.writeLock().lock();
            System.out.println("Time："+System.currentTimeMillis()+"："+Thread.currentThread() + "：Writting_begin");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Time："+System.currentTimeMillis()+"："+Thread.currentThread() + "：Writting_unlock");
                lock.writeLock().unlock();
            }
        }
    }
}
