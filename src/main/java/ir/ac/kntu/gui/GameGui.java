package ir.ac.kntu.gui;

import com.sun.jdi.LongValue;
import ir.ac.kntu.logic.*;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameGui {
    private boolean start = true;
    private boolean play = false;
    private boolean stage1Bool = true;
    private ArrayList<Alien> aliens = new ArrayList<>();
    private Player player = new Player("", 5);
    private ArrayList<ImageView> alienIm1 = new ArrayList<>();
    private ArrayList<ImageView> alienIm2 = new ArrayList<>();
    private ImageView playerIm;
    private LongValue startNanoTime;
    private AnimationTimer timer;
    private Scene menu1 = new Scene(menu1(), Constant.getBorderX(), Constant.getBorderY());//opening
    private Scene menu2 = new Scene(menu2(HighScore.getInstance().getHighScore()),
            Constant.getBorderX(), Constant.getBorderY());//new game -- choosing player
    private Scene menu3 = new Scene(menu3(), Constant.getBorderX(), Constant.getBorderY()); //difficulty
    private Scene menu4 = new Scene(menu4(), Constant.getBorderX(), Constant.getBorderY()); //new player
    private Scene menu5 = new Scene(menu5(HighScore.getInstance().getHighScore()),
            Constant.getBorderX(), Constant.getBorderY()); //high score
    private Scene stage1 = new Scene(stage1(), Constant.getBorderX(), Constant.getBorderY()); //level one
    private Scene win = new Scene(winPane(), Constant.getBorderX(), Constant.getBorderY()); //level two
    private Scene stage3 = new Scene(new Pane(), Constant.getBorderX(), Constant.getBorderY()); //level three
    private Stage stage = new Stage();
    private ImageView drop = new ImageView(new Image("assets/drop.png"));
    private ArrayList<Player> dropLoc = new ArrayList<>();
    private int counter = 0;
    private int counter1 = 0;
    private int marhale = 0;
    private Alien ufo = new Alien(Level.TWO, 0, 50, 6);
    private boolean ufoWay = true;
    private Scene loading = new Scene(loadingSet(), Constant.getBorderX(), Constant.getBorderY());
    private boolean ufoDead = false;
    private ArrayList<Player> obtacle = new ArrayList<>();
    private boolean save = false;

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStage1Bool() {
        return stage1Bool;
    }

    public void setStage1Bool(boolean stage1Bool) {
        this.stage1Bool = stage1Bool;
    }

    public GameGui() {
        stage.setScene(menu1);
    }

    public ArrayList<Alien> getAliens() {
        return aliens;
    }

    public ArrayList<ImageView> getAlienIm1() {
        return alienIm1;
    }

    public void setAlienIm1(ArrayList<ImageView> alienIm1) {
        this.alienIm1 = alienIm1;
    }

    public ArrayList<ImageView> getAlienIm2() {
        return alienIm2;
    }

    public void setAlienIm2(ArrayList<ImageView> alienIm2) {
        this.alienIm2 = alienIm2;
    }

    public ImageView getPlayerIm() {
        return playerIm;
    }

    public void setPlayerIm(ImageView playerIm) {
        this.playerIm = playerIm;
    }

    public Scene getMenu4() {
        return menu4;
    }

    public void setMenu4(Scene menu4) {
        this.menu4 = menu4;
    }

    public Scene getMenu5() {
        return menu5;
    }

    public void setMenu5(Scene menu5) {
        this.menu5 = menu5;
    }

    public Scene getMenu1() {
        return menu1;
    }

    public void setMenu1(Scene menu1) {
        this.menu1 = menu1;
    }

    public Scene getMenu2() {
        return menu2;
    }

    public void setMenu2(Scene menu2) {
        this.menu2 = menu2;
    }

    public Scene getMenu3() {
        return menu3;
    }

    public void setMenu3(Scene menu3) {
        this.menu3 = menu3;
    }

    public Scene getStage1() {
        return stage1;
    }

    public void setStage1(Scene stage1) {
        this.stage1 = stage1;
    }

    public Scene getStage3() {
        return stage3;
    }

    public void setStage3(Scene stage3) {
        this.stage3 = stage3;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setAliens(ArrayList<Alien> aliens) {
        this.aliens = aliens;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Pane loadingSet() {
        VBox vBox = new VBox();
        Text loading = new Text("Loading...");
        loading = setMenuFontColor(loading);
        loading.setFill(Color.YELLOW);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().addAll(logo(), loading);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("assets/background.jpg"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));
        vBox.setSpacing(25);
        return vBox;
    }

    public void placeAliens() {
        //update alien places
        alienIm1 = new ArrayList<>();
        alienIm2 = new ArrayList<>();
        for (Alien alien : aliens) {
            new ImageView(new Image("assets/alien_one_white.png"));
            if (alien.getLevel() == Level.ONE) {
                ImageView imageView = new ImageView(new Image("assets/alien_one_white.png"));
                imageView.setX(alien.getX());
                imageView.setY(alien.getY());
                imageView.setFitWidth(Constant.getAlienW());
                imageView.setFitHeight(Constant.getAlienY());
                alienIm1.add(imageView);
            } else if (alien.getLevel() == Level.TWO) {
                ImageView imageView = new ImageView(new Image("assets/alien_two_white.png"));
                imageView.setX(alien.getX());
                imageView.setY(alien.getY());
                imageView.setFitWidth(Constant.getAlienW());
                imageView.setFitHeight(Constant.getAlienY());
                alienIm2.add(imageView);
            }
        }
    }

    public void placePlayer() {
        //update player place
        playerIm = new ImageView(new Image("assets/spaceship.png"));
        playerIm.setY(player.getY());
        playerIm.setX(player.getX());
        playerIm.setFitHeight(70);
        playerIm.setFitWidth(40);

    }

    public void newGameClickAction(Text text) {
        text.setOnMouseClicked(e -> {
            stage.setScene(menu2);
        });
    }

    public void backPressed(Text text) {
        text.setOnMouseClicked(e -> {
            stage.setScene(menu1);
        });
    }

    public void newPlayerButton(TextField textField, Button button) {
        button.setOnMouseClicked(e -> {
            stage.setScene(menu3);
            player = EventHandlers.newPlayerField(textField, player);
            HighScore.getInstance().add(player);
        });
    }

    public Text setMenuFontColor(Text text) {
        text.setFont(Font.font("verdana", FontWeight.BOLD, 24));
        text.setFill(Color.YELLOW);
        return text;
    }

    public Text setGameFontColor(Text text) {
        text.setFont(Font.font("verdana", FontWeight.MEDIUM, 14));
        text.setFill(Color.YELLOW);
        return text;
    }

    public void heart(GraphicsContext gc) {
        for (int i = 0; i < player.getLive(); i++) {
            gc.drawImage(new Image("assets/heart.png"), i * 20, 0, 20, 20);
        }
    }

    public void easyClicked(Text text) {
        text.setOnMouseClicked(e -> {
            player.setDifficulty(Difficulty.EASY);
            play = true;
            stage1.setRoot(stage1());
            stage.setScene(stage1);
            controller();
            player.start();
            stage1Bool = false;
        });
    }

    public void mediumClicked(Text text) {
        text.setOnMouseClicked(e -> {
            player.setDifficulty(Difficulty.MEDIUM);
            play = true;
            stage1.setRoot(stage1());
            stage.setScene(stage1);
            controller();
            player.start();
            stage1Bool = false;
        });
    }

    public void hardClicked(Text text) {
        text.setOnMouseClicked(e -> {
            player.setDifficulty(Difficulty.HARD);
            play = true;
            stage1.setRoot(stage1());
            stage.setScene(stage1);
            controller();
            player.start();
            stage1Bool = false;
        });
    }

    public ArrayList<Player> maxHighScores(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getScore() < players.get(j).getScore()) {
                    Player samp;
                    samp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, samp);
                }
            }
        }
        return players;
    }

    public void newPlayerClicked(Text text) {
        text.setOnMouseClicked(e -> {
            stage.setScene(menu4);
        });
    }

    public void highScoreClickAction(Text text) {
        text.setOnMouseClicked(e -> {
            stage.setScene(menu5);
        });
    }

    public void player1Clicked(Player player, Text text) {
        text.setOnMouseClicked(e -> {
            this.player = player;
            stage.setScene(menu3);
        });
    }

    public void player2Clicked(Player player, Text text) {
        text.setOnMouseClicked(e -> {
            this.player = player;
            stage.setScene(menu3);
        });
    }

    public void player3Clicked(Player player, Text text) {
        text.setOnMouseClicked(e -> {
            this.player = player;
            stage.setScene(menu4);
        });
    }

    public Pane menu1() {
        Pane pane = new Pane();
        Text newGame = new Text();
        Text highScore = new Text();
        Text quit = new Text();
        newGame.setText("New Game");
        highScore.setText("High Score");
        quit.setText("Quit");
        newGame.setY(Constant.getBorderY() / 2 + 100);
        highScore.setY(Constant.getBorderY() / 2 + 150);
        quit.setY(Constant.getBorderY() / 2 + 200);
        quit.setX(Constant.getBorderX() / 2 - 30);
        newGame.setX(Constant.getBorderX() / 2 - 70);
        highScore.setX(Constant.getBorderX() / 2 - 70);
        newGame = setMenuFontColor(newGame);
        highScore = setMenuFontColor(highScore);
        quit = setMenuFontColor(quit);
        pane.getChildren().addAll(backGround(), newGame, highScore, quit, logo());
        newGameClickAction(newGame);
        highScoreClickAction(highScore);
        return pane;

    }

    public Pane menu2(ArrayList<Player> players) {
        Pane pane = new Pane();
        players = maxHighScores(players);
        Text player1 = new Text();
        Text player2 = new Text();
        Text player3 = new Text();
        Text newPlayer = new Text("New Player");
        if (players.size() >= 1) {
            player1.setText(players.get(0).getNamee());
            player1Clicked(players.get(0), player1);
            if (players.size() >= 2) {
                player2.setText(players.get(1).getNamee());
                player2Clicked(players.get(1), player2);
                if (players.size() >= 3) {
                    player3.setText(players.get(2).getNamee());
                    newPlayer.setY(Constant.getBorderY() / 2 + 250);
                    player3Clicked(players.get(2), player3);
                } else {
                    newPlayer.setY(Constant.getBorderY() / 2 + 200);
                }
            } else {

                newPlayer.setY(Constant.getBorderY() / 2 + 150);
            }
        } else {
            player1.setText("not set yet");
            newPlayer.setY(Constant.getBorderY() / 2 + 150);
        }
        player1 = setMenuFontColor(player1);
        player2 = setMenuFontColor(player2);
        player3 = setMenuFontColor(player3);
        newPlayer.setFont(Font.font("verdana", FontWeight.BOLD, 25));
        newPlayer.setFill(Color.YELLOWGREEN);
        player1.setY(Constant.getBorderY() / 2 + 100);
        player1.setX(Constant.getBorderX() / 2 - 60);
        player2.setY(Constant.getBorderY() / 2 + 150);
        player2.setX(Constant.getBorderX() / 2 - 60);
        player3.setY(Constant.getBorderY() / 2 + 200);
        player3.setX(Constant.getBorderX() / 2 - 60);
        newPlayer.setX(Constant.getBorderX() / 2 - 65);
        pane.getChildren().addAll(backGround(), newPlayer, player1, player2, player3, logo());
        newPlayerClicked(newPlayer);
        return pane;

    }

    public Pane menu3() {
        Pane pane = new Pane();
        Text easy = new Text();
        Text medium = new Text();
        Text hard = new Text();
        easy.setText("Easy");
        medium.setText("Medium");
        hard.setText("Hard");
        easy = setMenuFontColor(easy);
        medium = setMenuFontColor(medium);
        hard = setMenuFontColor(hard);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BASELINE_CENTER);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("assets/background.jpg"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));
        vBox.setSpacing(25);
        vBox.getChildren().addAll(logo(), easy, medium, hard);
        easyClicked(easy);
        mediumClicked(medium);
        hardClicked(hard);
        return vBox;
    }

    public Pane menu4() {
        TextField newPlayer = new TextField();
        newPlayer.setBackground(Background.EMPTY);
        newPlayer.setFont(Font.font("verdana", 20));
        newPlayer.setAlignment(Pos.CENTER);
        newPlayer.setMaxWidth(300);
        newPlayer.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button submit = new Button();
        submit.setText("Submit");
        submit.setMaxHeight(40);
        submit.setMaxWidth(80);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BASELINE_CENTER);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("assets/background.jpg"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));
        vBox.setSpacing(50);
        vBox.getChildren().addAll(logo(), newPlayer, submit);
        newPlayerButton(newPlayer, submit);
        return vBox;


    }

    public Pane menu5(ArrayList<Player> players) {
        VBox vBox = new VBox();
        players = maxHighScores(players);
        Text player1 = new Text();
        Text player2 = new Text();
        Text player3 = new Text();
        Text back = new Text("back");
        back = setMenuFontColor(back);
        if (players.size() >= 1) {
            player1.setText(players.get(0).getNamee() + " time:" + players.get(0).getTime() + " score:" +
                    players.get(0).getScore());
            player1 = setMenuFontColor(player1);
            if (players.size() >= 2) {
                player2.setText(players.get(1).getNamee() + " time:" + players.get(1).getTime() + " score:" +
                        players.get(1).getScore());
                player2 = setMenuFontColor(player2);
                if (players.size() >= 3) {
                    player3.setText(players.get(2).getNamee() + " time:" + players.get(2).getTime() + " score:" +
                            players.get(2).getScore());
                    player3 = setMenuFontColor(player3);
                    vBox.getChildren().addAll(logo(), player1, player2, player3, back);
                } else {
                    vBox.getChildren().addAll(logo(), player1, player2, back);
                }
            } else {
                vBox.getChildren().addAll(logo(), player1, back);
            }
        } else {
            vBox.getChildren().addAll(logo(), player1, back);
            player1.setText("not set yet");
            player1 = setMenuFontColor(player1);
        }
        vBox.setAlignment(Pos.BASELINE_CENTER);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("assets/background.jpg"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));
        vBox.setSpacing(25);
        backPressed(back);
        return vBox;


    }

    public void controller() {
        stage1.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode code = keyEvent.getCode();
            player.playerMove(PlaceGame.movePlayer(code));
        });
        stage1.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            return;

        });

    }

    public void moveDrops() {
        if (dropLoc != null) {
            for (int i = 0; i < dropLoc.size(); i++) {
                dropLoc.get(i).setY(dropLoc.get(i).getY() - 20);
                if (dropLoc.get(i).getY() < 50) {
                    dropLoc.remove(i);
                }
            }
        }

    }

    public void dropShow(GraphicsContext gc) {

        for (Player drops : dropLoc) {
            gc.drawImage(drop.getImage(), drops.getX(), drops.getY(), 10, 50);
        }

    }

    public boolean dropInAlien(Player drop, Alien alien) {
        if (drop.getY() < alien.getY() + Constant.getAlienY() && drop.getY() > alien.getY() &&
                drop.getX() < alien.getX() + Constant.getAlienW() && drop.getX() > alien.getX()) {
            return true;
        }
        return false;
    }

    public void checkHitUfo() {
        for (int j = 0; j < dropLoc.size(); j++) {
            try {
                if (dropInAlien(dropLoc.get(j), ufo)) {
                    ufo.setHp(ufo.getHp() - 1);
                    dropLoc.remove(j);
                    if (ufo.getHp() <= 0) {
                        ufoDead = true;
                        player.setScore(player.getScore() + 500);
                    }

                }
            } catch (IndexOutOfBoundsException e) {
                j++;
            }

        }
    }

    public void checkHit() {
        for (int j = 0; j < dropLoc.size(); j++) {
            for (int i = 0; i < aliens.size(); i++) {
                try {
                    if (dropInAlien(dropLoc.get(j), aliens.get(i))) {
                        Alien alien = aliens.get(i);
                        //System.out.println(alien.getHp());
                        alien.setHp(aliens.get(i).getHp() - 1);
                        aliens.set(i, alien);
                        dropLoc.remove(j);
                        //System.out.println(alien.getHp());
                        if (aliens.get(i).getHp() <= 0) {
                            player.setScore(player.getScore() + plusScore(aliens.get(i)));
                            aliens.remove(i);
                        }

                    }
                } catch (IndexOutOfBoundsException e) {
                    i++;
                }
            }
        }
    }

    public int plusScore(Alien alien) {
        if (alien.getLevel() == Level.ONE) {
            return Constant.scoreAlienL1;
        } else {
            return Constant.scoreAlienL2;
        }
    }

    public double mostRight() {
        double x = 0;
        for (Alien alien : aliens) {
            if (alien.getX() > x) {
                x = alien.getX();
            }
        }
        //System.out.println(x);
        return x;
    }

    public void moveAliens() {
        if (Constant.getBorderX() - mostRight() > (Constant.getAlienW() + 10)) {
            for (int i = 0; i < aliens.size(); i++) {
                aliens.get(i).setX(aliens.get(i).getX() + 20);
            }
        } else {
            for (int i = 0; i < aliens.size(); i++) {
                aliens.get(i).setY(aliens.get(i).getY() + 20);
                aliens.get(i).setX(aliens.get(i).getX() - (Constant.getBorderX() - 700));
            }
        }

    }

    public Pane winPane() {
        VBox vBox = new VBox();
        Text win = new Text("you won!");
        Text score = new Text("Score: " + String.valueOf(player.getScore()));
        Text time = new Text("time: " + String.valueOf(player.getTime()));
        win = setMenuFontColor(win);
        win.setFill(Color.YELLOW);
        score = setMenuFontColor(score);
        score.setFill(Color.YELLOW);
        time = setMenuFontColor(time);
        time.setFill(Color.YELLOW);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("assets/background.jpg"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(backgroundImage));
        vBox.getChildren().addAll(logo(), win, score, time);
        return vBox;
    }

    public void checkNextL() {

        if (aliens.size() == 0 && !start) {
            marhale++;
            start = true;
            stage1.setRoot(stage1());
            stage.setScene(stage1);

        }
    }

    public void checkWin() {
        if (marhale >= 3) {
            if (!save) {
                HighScore.getInstance().add(player);
                save = true;
                win.setRoot(winPane());
            }
            player.stop();
            stage.setScene(win);
        }

    }

    public Group stage1() {
        if (play) {
            if (start) {
                ufoDead = false;
                if (player.getDifficulty() == Difficulty.EASY) {
                    aliens = PlaceGame.startUpAliensEasy(marhale);
                    player = PlaceGame.startUpPlayer(player);

                } else if (player.getDifficulty() == Difficulty.MEDIUM) {
                    aliens = PlaceGame.startUpAliensMedium(marhale);
                    player = PlaceGame.startUpPlayer(player);

                } else {
                    aliens = PlaceGame.startUpAliensHard(marhale);
                    player = PlaceGame.startUpPlayer(player);

                }
            }
            start = false;
        }
        Group root = new Group();
        Canvas gameCanvas = new Canvas(Constant.getBorderX(), Constant.getBorderY());
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        root.getChildren().addAll(backGround(), gameCanvas);


        startNanoTime = new LongValue(System.nanoTime());
        timer = new AnimationTimer() {
            double elapsedTime;

            @Override
            public void handle(long now) {

                gc.clearRect(0, 0, Constant.getBorderX(), Constant.getBorderY());
                elapsedTime = (now - startNanoTime.value) / 1000000000.0;
                startNanoTime.value = now;
                placePlayer();
                placeAliens();
                for (ImageView imageView : alienIm1) {
                    gc.drawImage(alienIm1.get(0).getImage(), imageView.getX(), imageView.getY()
                            , Constant.getAlienW(), Constant.getAlienY());
                }
                for (ImageView imageView : alienIm2) {
                    gc.drawImage(alienIm2.get(0).getImage(), imageView.getX(), imageView.getY()
                            , Constant.getAlienW(), Constant.getAlienY());
                }
                gc.fillText("time:" + (double) ((int) (player.getTime() * 10)) / 10, Constant.getBorderX() - 100, 40);
                gc.fillText("score:" + player.getScore(), Constant.getBorderX() - 100, 20);
                gc.setFont(Font.font("verdana", FontWeight.MEDIUM, 14));
                gc.setFill(Color.YELLOW);
                if (!ufoDead) {
                    gc.drawImage(new Image("assets/ufo.png"), ufo.getX(), 40, 100, 40);
                }
                heart(gc);

                if (!stage1Bool) {
                    Timer.getInstance().start();
                    MoveDropTimer.getInstance().start();
                    stage1Bool = true;
                }
                if (Timer.getInstance().getCounter() > counter) {
                    double samp = player.getX();
                    dropLoc.add(new Player(samp, Constant.getBorderY() - 90));
                    counter = Timer.getInstance().getCounter();
                    moveUfo();
                    moveAliens();
                }
                if (MoveDropTimer.getInstance().getCounter() > counter1) {
                    moveDrops();

                    counter1 = Timer.getInstance().getCounter();
                }
                dropShow(gc);
                checkHit();
                checkHitUfo();
                gc.drawImage(new Image("assets/spaceship1.png"), playerIm.getX(), playerIm.getY());
                checkWin();
                checkNextL();


            }
        };
        timer.start();
        return root;


    }

    public void moveUfo() {
        if (ufoWay) {
            ufo.setX(ufo.getX() + 20);
        } else {
            ufo.setX(ufo.getX() - 20);
        }
        if (ufo.getX() == 0) {
            ufoWay = true;
        }
        if (ufo.getX() == Constant.getBorderX() - 100) {
            ufoWay = false;
        }
    }

    public Node logo() {
        Image image = new Image("assets/logo.png");
        ImageView logo = new ImageView(image);
        logo.setX(-300 + Constant.getBorderX() / 2);
        logo.setY(-250 + Constant.getBorderY() / 2);
        logo.setFitHeight(300);
        logo.setFitWidth(600);
        return logo;
    }

    public Node backGround() {
        ImageView backGround = new ImageView(new Image("assets/background.jpg"));
        backGround.setFitWidth(Constant.getBorderX());
        backGround.setFitHeight(Constant.getBorderY());
        return backGround;
    }


    public class LongValue {
        public long value;

        public LongValue(long i) {
            this.value = i;
        }
    }
}
