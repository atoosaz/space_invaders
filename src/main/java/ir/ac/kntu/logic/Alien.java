package ir.ac.kntu.logic;

public class Alien {
    private Level level;
    private int hp;
    private double x;
    private double y;

    public Alien(Level level, int x, int y, int hp) {
        this.level = level;
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
}
