public class WorkerTask implements Runnable {

    private String message;

    public WorkerTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.printf("%s says ", Thread.currentThread().getName());
        System.out.printf("hello #%s", message);
        System.out.println();
        //System.out.printf("%s says hello #%s\n", Thread.currentThread().getName(), message);
    }
}
