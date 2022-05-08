package Jz;

public class RunTime extends Thread {
    private long startTime;
    private long endTime;
    private long time;

    public RunTime() {
        init();
    }

    public void init() {
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();
        time = 0;
    }

    public long getTime() {
        return time;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
        }
    }
}
