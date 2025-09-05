package threadsManipulation.threadsCreation;

public class ThreadByRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread running by implementing Runnable: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadByRunnable());
        t1.start();
    }
}
