import java.util.Queue;

public class MultiplePrintLineWorkerTask implements Runnable {

    private AtomicTurnCounter turnCounter;
    private Queue queue;

    public MultiplePrintLineWorkerTask(AtomicTurnCounter turnCounter, Queue queue) {
        this.turnCounter = turnCounter;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.peek() != null) {
            String threadName = Thread.currentThread().getName();

            if(turnCounter.isMyTurn(threadName)) {
                System.out.printf("thread %s says ", threadName);
                System.out.printf("hello #%s", queue.poll());
                System.out.println();
                turnCounter.setNextTurn();
            }
        }
    }
}
