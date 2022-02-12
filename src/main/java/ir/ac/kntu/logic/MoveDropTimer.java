package ir.ac.kntu.logic;

public class MoveDropTimer extends Thread{
    private static MoveDropTimer singleInstance = null;
    public static MoveDropTimer getInstance() {
        if (singleInstance == null) {
            singleInstance = new MoveDropTimer();
        }

        return singleInstance;
    }
    private int time=50;
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
