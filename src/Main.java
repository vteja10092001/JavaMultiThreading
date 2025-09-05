import java.util.Date;
import java.text.SimpleDateFormat;



public class Main {
    public static void main(String[] args) {
        // Use SimpleDateFormat for millisecond precision
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

        // Runnable for the first thread
        Runnable r1 = () -> {
            for(int i=0;i<10;i++){
                // Get the current time in nanoseconds for higher precision
                long nanoTime = System.nanoTime();
                System.out.println("Runner1 : " + i + " " + sdf.format(new Date()) + " | Nano: " + nanoTime);
            }
        };

        // Runnable for the second thread
        Runnable r2 = () -> {
            for(int i=0;i<10;i++){
                // Get the current time in nanoseconds for higher precision
                long nanoTime = System.nanoTime();
                System.out.println("Runner2 : " + i + " " + sdf.format(new Date()) + " | Nano: " + nanoTime);
            }
        };

        var t1 = new Thread(r1);
        var t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
