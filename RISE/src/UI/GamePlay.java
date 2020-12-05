package UI;

import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class GamePlay {

    Stage stag;
    int playerCount;
    Player[] players;
    int turn, turnIndex = 0;

    public GamePlay(Stage stage, int playerCount, Player[] players){
        stag = stage;
        this.playerCount = playerCount;
        this.players = players;
        turn = 0;
    }

    public void show(){
        HBox playerInfo = new HBox(10);
        Text info = new Text();
        Button turnEnd = new Button("Turn");
        playerInfo.getChildren().addAll(info, turnEnd);
        playerInfo.setAlignment(Pos.CENTER);
        info.setText(players[turnIndex].toString());
        turnEnd.setOnAction(e -> {
            if(turnIndex < playerCount-1)
                turnIndex++;
            else
                turnIndex = 0;
            info.setText(players[turnIndex].toString());
        });
        Pane pane = new Pane();
        Scene scene = new Scene(playerInfo, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();

    }

    public boolean isOver(){
        return false;
    }

    public void endTurn(){

    }
}
