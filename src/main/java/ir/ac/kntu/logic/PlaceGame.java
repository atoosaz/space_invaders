package ir.ac.kntu.logic;

import com.sun.javafx.collections.MappingChange;
import ir.ac.kntu.gui.Constant;
import ir.ac.kntu.gui.Move;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PlaceGame {
    public static ArrayList<Alien> startUpAliensEasy(int stage) {
        ArrayList<Alien> aliens = new ArrayList<>();
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = 0; j < Constant.getAliensLineEasy() / 2; j++) {
                Alien alien = new Alien(Level.TWO, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                if (stage == 0) {
                    alien.setHp(Constant.getHpLevelOne());
                } else if (stage == 1) {
                    alien.setHp(Constant.getHpLevelTwo());
                } else {
                    alien.setHp(Constant.getHpLevelThree());
                }
                aliens.add(alien);
            }
        }
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = (int) Constant.getAliensLineEasy() / 2; j < Constant.getAliensLineEasy(); j++) {
                Alien alien = new Alien(Level.ONE, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                alien.setHp(Constant.getHpLevelOne());
                aliens.add(alien);
                if (stage == 0) {
                    alien.setHp(Constant.getHpLevelOne());
                } else if (stage == 1) {
                    alien.setHp(Constant.getHpLevelTwo());
                } else {
                    alien.setHp(Constant.getHpLevelThree());
                }
            }
        }
        return aliens;
    }

    public static ArrayList<Alien> startUpAliensMedium(int stage) {
        ArrayList<Alien> aliens = new ArrayList<>();
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = 0; j < Constant.getAliensLineMedium() / 2 - 1; j++) {
                Alien alien = new Alien(Level.TWO, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                if (stage == 0) {
                    alien.setHp(Constant.getHpLevelOne());
                } else if (stage == 1) {
                    alien.setHp(Constant.getHpLevelTwo());
                } else {
                    alien.setHp(Constant.getHpLevelThree());
                }
                aliens.add(alien);
            }
        }
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = (int) Constant.getAliensLineMedium() / 2; j < Constant.getAliensLineMedium(); j++) {
                Alien alien = new Alien(Level.ONE, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                alien.setHp(Constant.getHpLevelOne());
                aliens.add(alien);
                if (stage == 0) {
                    alien.setHp(Constant.getHpLevelOne());
                } else if (stage == 1) {
                    alien.setHp(Constant.getHpLevelTwo());
                } else {
                    alien.setHp(Constant.getHpLevelThree());
                }
            }
        }
        return aliens;
    }

    public static ArrayList<Alien> startUpAliensHard(int stage) {
        ArrayList<Alien> aliens = new ArrayList<>();
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = 0; j < Constant.getAliensLineHard() / 2; j++) {
                Alien alien = new Alien(Level.TWO, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                if (stage == 0) {
                    alien.setHp(Constant.getHpLevelOne());
                } else if (stage == 1) {
                    alien.setHp(Constant.getHpLevelTwo());
                } else {
                    alien.setHp(Constant.getHpLevelThree());
                }
                aliens.add(alien);
            }
        }
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = (int) Constant.getAliensLineHard() / 2; j < Constant.getAliensLineHard(); j++) {
                Alien alien = new Alien(Level.ONE, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                alien.setHp(Constant.getHpLevelOne());
                aliens.add(alien);
                if (stage == 0) {
                    alien.setHp(Constant.getHpLevelOne());
                } else if (stage == 1) {
                    alien.setHp(Constant.getHpLevelTwo());
                } else {
                    alien.setHp(Constant.getHpLevelThree());
                }
            }
        }
        return aliens;
    }

    public static ArrayList<Alien> startUpAliensMedium() {
        ArrayList<Alien> aliens = new ArrayList<>();
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = 0; j < Constant.getAliensLineMedium() / 2; j++) {
                Alien alien = new Alien(Level.TWO, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                aliens.add(alien);
            }
        }
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = 2; j < Constant.getAliensLineMedium(); j++) {
                Alien alien = new Alien(Level.ONE, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                aliens.add(alien);
            }
        }
        return aliens;
    }

    public static ArrayList<Alien> startUpAliensHard() {
        ArrayList<Alien> aliens = new ArrayList<>();
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = 0; j < Constant.getAliensLineHard() / 2; j++) {
                Alien alien = new Alien(Level.TWO, i * 100 + 50, j * 50 + 50, Constant.getHpLevelOne());
                aliens.add(alien);
            }
        }
        for (int i = 0; i < Constant.getAliensPerLine(); i++) {
            for (int j = 2; j < Constant.getAliensLineHard(); j++) {
                Alien alien = new Alien(Level.ONE, i * 100 + 50, j * 50 + 100, Constant.getHpLevelOne());
                aliens.add(alien);
            }
        }
        return aliens;
    }

    public static Player startUpPlayer(Player player) {
        player.setX(Constant.getBorderX() / 2 - 20);
        player.setY(Constant.getBorderY() - 70);
        return player;

    }

    public static Move movePlayer(KeyCode code) {
        Player player = Main.getInstance().gameGui.getPlayer();
        Move move;
        if (code.equals(KeyCode.LEFT)) {
            move = Move.LEFT;
        } else if (code.equals(KeyCode.RIGHT)) {
            move = Move.RIGHT;
        } else {
            move = Move.NONE;
        }
        player.playerMove(move);
        return move;

    }

}
