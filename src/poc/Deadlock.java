package poc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        Deadlock deadlock = new Deadlock();
        new Thread(deadlock::worker1, "Worker1").start();
        new Thread(deadlock::worker2, "Worker2").start();

         /*Using the same Deadlock object for both threads,
         so worker1 and worker2 share the same lock1 and lock2 instances.*/
    }

    public void worker1() {
        lock1.lock();
        System.out.println("Worker1 acquires the lock1..");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("Worker1 acquires the lock2..");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        lock2.lock();
        System.out.println("worker2 acquired the lock2..");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock();
        System.out.println("worker2 acquires the lock1");

        lock1.unlock();
        lock2.unlock();
    }
}
