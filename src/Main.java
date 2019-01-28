import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
          System.err.println("Please supply two arguments.");
          return;
        }

        int messages = Integer.parseInt(args[0]);
        int threads = Integer.parseInt(args[1]);

        System.out.printf("messages: %d, threads: %d\n", messages, threads);

        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int i = 1; i <= messages; i++) {
            Runnable worker = new WorkerTask(Integer.toString(i));
            executor.execute(worker);
        }
        executor.shutdown();
    }
}
