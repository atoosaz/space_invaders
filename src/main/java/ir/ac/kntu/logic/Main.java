package ir.ac.kntu.logic;


import ir.ac.kntu.gui.Constant;
import ir.ac.kntu.gui.GameGui;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    private static Main singleInstance = null;

    public static Main getInstance() {
        if (singleInstance == null) {
            singleInstance = new Main();
        }

        return singleInstance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    GameGui gameGui = new GameGui();

    @Override
    public void start(Stage stage) throws Exception {
        Timer timer = new Timer();
        timer.start();
        Stage stage1 = new Stage();
        stage1 = gameGui.getStage();
        stage1.setResizable(false);
        stage1.setTitle("Space Invader");
        stage1.show();

    }

}
