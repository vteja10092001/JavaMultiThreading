package threadsManipulation.threadsCreation;

public class ThreadByExtendingClass extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running by extending Thread class: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadByExtendingClass t1 = new ThreadByExtendingClass();
        t1.start();
    }
}
