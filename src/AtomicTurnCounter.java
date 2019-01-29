import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTurnCounter {

    private AtomicInteger count;
    private int threadCount;

    public AtomicTurnCounter(int count, int threadCount) {
        this.count = new AtomicInteger(count);
        this.threadCount = threadCount;
    }

    public boolean isMyTurn(String threadName) {
        return Integer.parseInt(threadName) == count.intValue();
    }

    public void setNextTurn() {
        int currentCount = count.intValue();
        if(currentCount < threadCount - 1) {
            count.set(currentCount + 1);
        } else {
            count.set(0);
        }
    }
}
