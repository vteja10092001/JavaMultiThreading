package poc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockSolution1 {
    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        DeadlockSolution1 deadlock = new DeadlockSolution1();
        new Thread(deadlock::worker1, "Worker1").start();
        new Thread(deadlock::worker2, "Worker2").start();


         /*Using the same DeadlockSolution1 object for both threads,
         so worker1 and worker2 share the same lock1 and lock2 instances.*/

    }

    public void worker1() {
        lock1.lock();
        System.out.println("Worker1 acquires the lock1..");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("Worker1 acquires the lock2..");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        lock1.lock();
        System.out.println("worker2 acquired the lock1..");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("worker2 acquires the lock2..");

        lock1.unlock();
        lock2.unlock();
    }
}


/*
    To avoid deadlock, always acquire locks in the same order across all threads.
    This prevents cyclic dependencies in lock acquisition (e.g., both threads
    trying to hold one lock while waiting for the other).
 */
