import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
          System.err.println("Please supply three arguments.");
          return;
        }

        String method = args[0];
        int messages = Integer.parseInt(args[1]);
        int threads = Integer.parseInt(args[2]);

        // TODO: is there a better data type to use for the 'queue'?
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        AtomicTurnCounter turnCounter = new AtomicTurnCounter(0, threads);
        Runnable workerTask;

        switch(method) {
            case "--single-printf":
                workerTask = new SinglePrintLineWorkerTask(turnCounter, queue);
                break;
            case "--multi-printf":
                workerTask = new MultiplePrintLineWorkerTask(turnCounter, queue);
                break;
            default:
                System.err.println("Unrecognized print method.");
                return;
        }

        // TODO: could a pub/sub strategy work better than sync adding messages at start?
        for(int i = 1; i <= messages; i++) {
            queue.add(i);
        }

        System.out.printf("method: %s, messages: %d, threads: %d\n", method, messages, threads);

        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(workerTask, Integer.toString(i));
            thread.start();
        }
    }
}
