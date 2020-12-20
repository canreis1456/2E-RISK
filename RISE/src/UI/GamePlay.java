package UI;

import entities.Land;
import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
import sample.ResourceManager;
import sample.Save;

import javax.swing.*;
import java.io.*;


public class GamePlay implements java.io.Serializable {

    transient Stage stag;
    int playerCount;
    Player[] players;
    int turn, turnIndex = 0;
    transient Pane map;
    transient Button research, position;
    String currentDir;
    transient VBox playerInfo;
    transient BorderPane pane;
    GameController control;
    CountryFallen defet;
    int inputLand;
    transient Text info;

    public GamePlay(Stage stage, int playerCount, Player[] players, GameController control){
        this.control = control;
        stag = stage;
        this.playerCount = playerCount;
        this.players = players;
        turn = 0;
        inputLand= -1;
    }

    public void setTurn(int turn){
        this.turn = turn;
    }

    public void setTurnIndex(int turnIndex) {
        this.turnIndex = turnIndex;
    }

    public Button researchh(){
        return research;
    }

    public void setInputLand(int inputLand) {
        this.inputLand = inputLand;
    }

    public void showFrom(int turn, int turnIndex) throws IOException {
        this.turn = turn;
        this.turnIndex = turnIndex;
        show();
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
        TextArea landsof = new TextArea();

        //right
        playerInfo = new VBox(10);
        playerInfo.setMaxWidth(100);
        info = new Text();
        info.setWrappingWidth(200);

        Button attack = new Button("Attack!!");
        attack.setOnAction(e -> {
            control.attacking(players[turnIndex], 12);
        });

        research = new Button("Research");
        research.setOnAction(e -> {
            Researches researches = new Researches();
            try {
                researches.show(this);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        position = new Button("Position");
        Button cardButton = new Button("Cards");
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

        Button saveButton = new Button ("Save");
        saveButton.setOnAction(e -> {
            Save save = new Save(players,control,this);
            try {
                String adsas = "asdfas asd";
                /*System.out.println("pl: " + (players != null));
                System.out.println("pl: " + (control != null));
                System.out.println("pl: " + (control.getMenu() != null));
                System.out.println("pl: " + (this != null));
                System.out.println("pl: " + (players != null));*/
                FileOutputStream fout = new FileOutputStream(currentDir+ "\\src\\saveGame.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(save);
               // ResourceManager.save(save, "saveGame.ser");
                System.out.println("Game is saved somewhere");
            }
            catch(Exception ev){
                System.out.println("The game could not be saved:" + ev.getMessage());
            }
        });


        //playerInfo.getChildren().addAll(info, turnEnd, landInfo, research, attack, selectGeneral, cardButton, saveButton);
        playerInfo.getChildren().addAll(info, turnEnd, landInfo, position, research, selectGeneral, cardButton, landsof, saveButton);
       // playerInfo.getChildren().addAll(info, turnEnd, landInfo, research);
        playerInfo.setAlignment(Pos.CENTER);
        playerInfo.setSpacing(10);
        info.setText(players[turnIndex].toString());
        turnEnd.setOnAction(e -> {
     //       System.out.println("plpl: " + playerCount );
            int toDelete = -1;

            players[turnIndex].turnEndAdd();
            selectGeneral.setDisable(false);
     //       System.out.println("TUETNURN " + turnIndex);
            if(turnIndex < playerCount-1)
                turnIndex++;
            else {
         //       System.out.println("turn ended");
                turnIndex = 0;
                turn++;
                for (Player a:players
                     ) {
                    a.turnCounter();
                }
            }
     //       System.out.println(players[turnIndex].isResearching());
            if (players[turnIndex].isResearching())
                research.setDisable(true);
            else
                research.setDisable(false);
            landsof.setText( "Land Count:  "+ players[turnIndex].getLandCount()+ "\n" + getControl().getLands().getLandsByOwner(players[turnIndex].getCountry())); // Bu kullanıcının landlerinin isimlerini string arraylisti döndürüyo
      //      System.out.println("a " + players.length);
            PositionInterface pos = new PositionInterface(players[turnIndex], this);
            try {
                pos.show();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            info.setText(players[turnIndex].toString());

        });

        position.setOnAction(event -> {
            PositionInterface pos = new PositionInterface(players[turnIndex], this);
            try {
                pos.show();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
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

        landsof.setText(getControl().getLands().getLandsByOwner(players[0].getCountry()));

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
        PositionInterface pos = new PositionInterface(players[turnIndex], this);
        pos.show();

    }

    public void positionTroop(int unitType, int amount,int landNo ){
  //      System.out.println(unitType  + "  " + amount + "  " + landNo);
        control.positionTroopOnLand(turnIndex,landNo, unitType, amount);

    }

    public int getTurn() {
        return turn;
    }

    public void setInfoDisable(boolean flag){
        playerInfo.setVisible(flag);
    }

    public void relocateMap(Pane pane){
        this.pane.setCenter(pane);
    }

    public void hasFallen() throws IOException {
        for (int a = 0; a < playerCount; a++){
            if(players[a].getLandCount() == 0 && !players[a].isDefeated()){
                defet = new CountryFallen();
                try {
                    defet.call(players[a].getCountry());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                players[a].setDefeated(true);
                for (int i = a; i < playerCount-1; i++ ) {
                    players[i] = players[i + 1];
                }
                playerCount--;
                a--;
            }
        }
        if(playerCount == 1){
            endGame();
        }
    }

    public void endGame() throws IOException {
        endGame end = new endGame();
        end.setPlay(this);
        end.hide(stag, (players[0].getName() + "\n" + players[0].getCountry()));
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
      //  System.out.println(unitType + "  " + landNoFrom + "  " + landNoTo + "  " + amount);
        control.relocateTroops(turnIndex,landNoFrom, landNoTo, unitType, amount);
    }

    public void setMap(){
        pane.setCenter(map);
        setInfoDisable(true);
    }


    public void updateInfo(){
        info.setText(players[turnIndex].toString());
    }
}
