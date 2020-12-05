package UI;

import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class GamePlay {

    Stage stag;
    int playerCount;
    Player[] players;
    int turn, turnIndex;

    public GamePlay(Stage stage, int playerCount, Player[] players){
        stag = stage;
        this.playerCount = playerCount;
        this.players = players;
        turn = 0;
    }

    public void show(){
        HBox playerInfo = new HBox(10);
        Text info = new Text();
        playerInfo.getChildren().add(info);
        playerInfo.setAlignment(Pos.CENTER);
        while(!isOver()){
            turnIndex = 0;
            while(turnIndex < playerCount){
                info.setText(players[turnIndex].toString());
                turnIndex++;
            }
        }
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();

    }

    public boolean isOver(){
        return false;
    }
}
