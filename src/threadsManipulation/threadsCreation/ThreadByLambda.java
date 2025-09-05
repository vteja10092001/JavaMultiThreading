package threadsManipulation.threadsCreation;

public class ThreadByLambda {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread running with Lambda: " + Thread.currentThread().getName());
        });
        t1.start();
    }
}
