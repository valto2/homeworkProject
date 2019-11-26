import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Assembly {

    private static class Seat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Seat is made");
        }
    }

    private static class Tyre implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tyre is made");
        }
    }

    public static void main(String[] args) {

        Runnable engine = () -> {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Engine is made");
        };
        Runnable frame = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Frame is made");
        };
        Runnable seat1 = new Seat();
        Runnable seat2 = new Seat();
        Runnable seat3 = new Seat();
        Runnable seat4 = new Seat();
        Runnable seat5 = new Seat();
        Runnable tyre1 = new Tyre();
        Runnable tyre2 = new Tyre();
        Runnable tyre3 = new Tyre();
        Runnable tyre4 = new Tyre();

        ExecutorService executor = Executors.newFixedThreadPool(3);


        executor.execute(engine);
        executor.execute(frame);
        executor.execute(seat1);
        executor.execute(seat2);
        executor.execute(seat3);
        executor.execute(seat4);
        executor.execute(seat5);
        executor.execute(tyre1);
        executor.execute(tyre2);
        executor.execute(tyre3);
        executor.execute(tyre4);

        executor.shutdown();
    }
}
