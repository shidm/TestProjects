package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main_ReentrantLock {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Test test = new Test();

        LockThread t1 = new LockThread(test, ThreadEnum.LOCK, "A线程：");
        LockThread t2 = new LockThread(test, ThreadEnum.INTERRUPT_LOCK, "B线程：");

        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("准备中断");
        t2.interrupt();
    }

    static class Test {

        public void lock() throws InterruptedException {
            lock.lock();
            simulationTimeConsumingOpreation();
        }

        public void interruptLock() throws InterruptedException {
            lock.lockInterruptibly();
            simulationTimeConsumingOpreation();
        }

        public void tryLock(long l, TimeUnit seconds) throws InterruptedException {
            if (lock.tryLock(l, seconds)) {
                simulationTimeConsumingOpreation();
            } else {
                System.out.println("没有等到锁");
            }
        }

        public void tryLock() throws InterruptedException {
            if (lock.tryLock()) {
                simulationTimeConsumingOpreation();
            } else {
                System.out.println("没有等到锁");
            }
        }

        private void simulationTimeConsumingOpreation() throws InterruptedException {
            try {
                System.out.println("Time：" + System.currentTimeMillis() + "__" + Thread.currentThread().getName() + "running");
                Thread.sleep(5000);
            } finally {
                System.out.println("Time：" + System.currentTimeMillis() + "__" + Thread.currentThread().getName() + "ending");
                lock.unlock();
            }
        }
    }

    static class LockThread extends Thread {
        Test test;
        ThreadEnum e;

        public LockThread(Test test, ThreadEnum e, String threadName) {
            this.test = test;
            this.e = e;
            setName(threadName);
        }

        @Override
        public void run() {
            switch (e) {
                case LOCK:
                    try {
                        test.lock();
                    } catch (InterruptedException e1) {
                        System.out.println(Thread.currentThread() + "被中断");
                    }
                    break;
                case TYR_LOCK:
                    try {
                        test.tryLock();
                    } catch (InterruptedException e1) {
                        System.out.println(Thread.currentThread() + "被中断");
                    }
                    break;
                case TRY_LOCK_TIME:
                    try {
                        test.tryLock(4L, TimeUnit.SECONDS);
                    } catch (InterruptedException e1) {
                        System.out.println(Thread.currentThread() + "被中断");
                    }
                    break;
                case INTERRUPT_LOCK:
                    try {
                        test.interruptLock();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread() + "被中断");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    enum ThreadEnum {
        LOCK, TYR_LOCK, INTERRUPT_LOCK, TRY_LOCK_TIME
    }
}
