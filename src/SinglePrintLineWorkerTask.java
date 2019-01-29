import java.util.Queue;

public class SinglePrintLineWorkerTask implements Runnable {

    private AtomicTurnCounter turnCounter;
    private Queue queue;

    public SinglePrintLineWorkerTask(AtomicTurnCounter turnCounter, Queue queue) {
        this.turnCounter = turnCounter;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.peek() != null) {
            String threadName = Thread.currentThread().getName();

            if(turnCounter.isMyTurn(threadName)) {
                System.out.printf("thread %s says hello #%s\n", threadName, queue.poll());
                turnCounter.setNextTurn();
            }
        }
    }
}
