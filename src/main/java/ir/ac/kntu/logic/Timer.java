package ir.ac.kntu.logic;

public class Timer extends Thread{
    private static Timer singleInstance = null;
    public static Timer getInstance() {
        if (singleInstance == null) {
            singleInstance = new Timer();
        }

        return singleInstance;
    }
    private int time=500;
    private int counter;
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(time);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
