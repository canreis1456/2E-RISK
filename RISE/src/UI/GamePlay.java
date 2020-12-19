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
//import sample.BoardBuilder;
import javafx.stage.StageStyle;
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
    Pane map;
    String currentDir;
    VBox playerInfo;
    BorderPane pane;
    GameController control;
    int inputLand;
    Text info;

    public GamePlay(Stage stage, int playerCount, Player[] players, GameController control){
        this.control = control;
        stag = stage;
        this.playerCount = playerCount;
        this.players = players;
        turn = 0;
        inputLand= -1;
    }

    public void setInputLand(int inputLand) {
        this.inputLand = inputLand;
    }

    public void show() throws IOException {

        File currentDirFile = new File("");
        currentDir = currentDirFile.getAbsolutePath();

        //map- center
        /*Land landTry = new Land(1, players[0].getCountryObject(), new Image(new FileInputStream(currentDir + "\\src\\images\\countries\\1 (1).png")));
        Land landTry2 = new Land(2, players[0].getCountryObject(), new Image(new FileInputStream(currentDir + "\\src\\images\\countries\\1 (2).png")));
        */Text landInfo = new Text();
        Board board = new Board();
        board.setPlay(this);
        map = board.show();


        //right
        playerInfo = new VBox(10);
        playerInfo.setMaxWidth(100);
        info = new Text();
        info.setWrappingWidth(200);

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


        Button cardButton = new Button("Cards");;
        Button turnEnd = new Button("Turn");
        Button selectGeneral = new Button("Select General");
                selectGeneral.setOnAction(e -> {
                    GeneralInterface generalInterface = new GeneralInterface(this);
                    try {
                        generalInterface.show();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    selectGeneral.setDisable(true);
                });
        playerInfo.getChildren().addAll(info, turnEnd, landInfo, research, attack, selectGeneral, cardButton);
       // playerInfo.getChildren().addAll(info, turnEnd, landInfo, research);
        playerInfo.setAlignment(Pos.CENTER);
        playerInfo.setSpacing(10);
        info.setText(players[turnIndex].toString());
        turnEnd.setOnAction(e -> {
            selectGeneral.setDisable(false);
            System.out.println("TUETNURN " + turnIndex);
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
            System.out.println("a " + players.length);
            PositionInterface pos = new PositionInterface(players[turnIndex], this);
            try {
                pos.show();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            info.setText(players[turnIndex].toString());
        });

        //BEGIN
        //Button cardButton = new Button("Cards");
        //playerInfo.getChildren().addAll(info, cardButton, landInfo, research, attack);
        //playerInfo.setAlignment(Pos.CENTER);
        //playerInfo.setSpacing(10);
        //info.setText(players[turnIndex].toString());
        cardButton.setOnAction(e -> {
            CardsInterface cardsIn = new CardsInterface(players[turnIndex], this);
            try {
                cardsIn.show();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        //END

        pane = new BorderPane();
        pane.setMaxSize(1920,1080);


        pane.setCenter(map);
        map.setStyle("-fx-background-color: #0EA0F0");
        pane.setRight(playerInfo);
        Scene scene = new Scene(pane, 1920, 1000);

        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.setX(0);
        stag.setY(0);
        stag.show();
        PositionInterface pos = new PositionInterface(players[0], this);
        pos.show();

    }

    public void positionTroop(int unitType, int amount,int landNo ){
        System.out.println(unitType  + "  " + amount + "  " + landNo);
        control.positionTroopOnLand(turnIndex,landNo, unitType, amount);

    }

    public void setInfoDisable(boolean flag){
        playerInfo.setVisible(flag);
    }

    public void relocateMap(Pane pane){
        this.pane.setCenter(pane);
    }


    public boolean isOver(){
        return false;
    }

    public int getTurnIndex() {
        return turnIndex;
    }

    public GameController getControl() {
        return control;
    }

    public void relocateTroop(int landNoFrom, int landNoTo, int unitType, int amount){
        System.out.println(unitType + "  " + landNoFrom + "  " + landNoTo + "  " + amount);
        control.relocateTroops(turnIndex,landNoFrom, landNoTo, unitType, amount);
    }

    public void setMap(){
        pane.setCenter(map);
        setInfoDisable(true);
    }

    public void endTurn(){

    }

    public void updateInfo(){
        info.setText(players[turnIndex].toString());
    }
}
