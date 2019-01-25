public class WorkerTask implements Runnable {

    private String message;

    public WorkerTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.printf("%s says hello #%s\n", Thread.currentThread().getName(), message);
    }
}
