package ir.ac.kntu.logic;

import java.io.*;
import java.util.*;

public class HighScore implements Serializable {
    private static HighScore singleInstance = null;

    public static HighScore getInstance() {
        if (singleInstance == null) {
            singleInstance = new HighScore();
        }

        return singleInstance;
    }

    private ArrayList<Player> highScore = new ArrayList<>();
    private int checkNum = 0;

    public ArrayList<Player> getHighScore() {
        read();
        sort();
        return new ArrayList<>(highScore);
    }

    public void setHighScore(ArrayList<Player> highScore) {
        this.highScore = new ArrayList<>(highScore);
        sort();
        write();
    }

    public ArrayList<Player> getH() {
        return highScore;
    }

    public void sort() {
        Comparator<Player> score = (p1, p2) -> p2.getScore() - p1.getScore();
        Collections.sort(highScore, score);
    }

    public void add(Player player) {
        read();
        try {
            for (Player player1 : highScore) {
                if (player1.getNamee().equals(player.getNamee())) {
                    highScore.remove(player1);
                }

            }
        } catch (ConcurrentModificationException e) {
            System.out.println(player.getNamee());
        }
        highScore.add(player);
        checkNum++;
        write();
    }

    public void write() {
        sort();
        try {

            String filename = "save.bin";
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(HighScore.getInstance());

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public void read() {

        int i = 1;
        try {

            FileInputStream file = new FileInputStream("save.bin");
            ObjectInputStream in = new ObjectInputStream(file);
            HighScore samp = (HighScore) in.readObject();
            highScore = samp.getH();
            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println(ex.toString());

        } catch (ClassNotFoundException ex) {
            System.out.println("error");
        }
    }
}
