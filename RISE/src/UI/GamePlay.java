package UI;

import entities.Land;
import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.BoardBuilder;
import sample.GameController;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GamePlay {

    Stage stag;
    int playerCount;
    Player[] players;
    int turn, turnIndex = 0;
    String currentDir;
    GameController control;

    public GamePlay(Stage stage, int playerCount, Player[] players, GameController control){
        this.control = control;
        stag = stage;
        this.playerCount = playerCount;
        this.players = players;
        turn = 0;
    }

    public void show() throws FileNotFoundException {

        File currentDirFile = new File("");
        currentDir = currentDirFile.getAbsolutePath();

        //map- center
        /*Land landTry = new Land(1, players[0].getCountryObject(), new Image(new FileInputStream(currentDir + "\\src\\images\\countries\\1 (1).png")));
        Land landTry2 = new Land(2, players[0].getCountryObject(), new Image(new FileInputStream(currentDir + "\\src\\images\\countries\\1 (2).png")));
        */Text landInfo = new Text();
        Pane map = new Pane();
        /*landTry.setPickOnBounds(false); // allows click on transparent areas
        landTry2.setPickOnBounds(false);
        landTry.maxHeight(100);
        landTry.maxWidth(100);
        landTry.setOnMouseClicked(event -> {
            landInfo.setText(landTry.toString());
        });
        landTry2.setOnMouseClicked(event -> {
            landInfo.setText(landTry2.toString());
        });
        map.getChildren().addAll(landTry, landTry2);*/

        //right
        VBox playerInfo = new VBox(10);
        Text info = new Text();

        Button attack = new Button("Attack!!");
        attack.setOnAction(e -> {
            control.attacking(players[turnIndex], 12);
        });

        Button research = new Button("Research");
        research.setOnAction(e -> {
            Researches researches = new Researches();
            try {
                researches.show(this);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Button turnEnd = new Button("Turn");
        playerInfo.getChildren().addAll(info, turnEnd, landInfo, research, attack);
        playerInfo.setAlignment(Pos.CENTER);
        playerInfo.setSpacing(10);
        info.setText(players[turnIndex].toString());
        turnEnd.setOnAction(e -> {
            if(turnIndex < playerCount-1)
                turnIndex++;
            else {
                System.out.println("turn ended");
                turnIndex = 0;
                for (Player a:players
                     ) {
                    a.turnCounter();
                }
            }
            info.setText(players[turnIndex].toString());
        });
        BorderPane pane = new BorderPane();
        pane.setMaxSize(1920,1080);


        pane.setCenter(map);
        map.setStyle("-fx-background-color: #0EA0F0");
        pane.setRight(playerInfo);
        Scene scene = new Scene(pane, 1440, 720);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();

    }

    public boolean isOver(){
        return false;
    }

    public int getTurnIndex() {
        return turnIndex;
    }

    public void endTurn(){

    }
}
