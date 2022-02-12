package ir.ac.kntu.logic;

import ir.ac.kntu.gui.Constant;
import ir.ac.kntu.gui.Difficulty;
import ir.ac.kntu.gui.Move;

import java.io.Serializable;

public class Player extends Thread implements Serializable {
    private double x;
    private double y;
    private String name;
    private double time;
    private int live;
    private int score;
    private Difficulty difficulty;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = time + 0.1;
        }
    }

    public void playerMove(Move move) {
        if (x > 0) {
            if (move.equals(Move.LEFT)) {
                this.setX(this.getX() - 10);
            }
        }
        if (x < (Constant.getBorderX() - 40)) {


            if (move.equals(Move.RIGHT)) {
                this.setX(this.getX() + 10);
            }
        }
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Player(String name, int live) {
        this.name = name;
        this.live = live;
    }

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public String getNamee() {
        return name;
    }


    public void setNamee(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }
}
