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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GamePlay {

    Stage stag;
    int playerCount;
    Player[] players;
    int turn, turnIndex = 0;
    String currentDir;

    public GamePlay(Stage stage, int playerCount, Player[] players){
        stag = stage;
        this.playerCount = playerCount;
        this.players = players;
        turn = 0;
    }

    public void show() throws FileNotFoundException {

        File currentDirFile = new File("");
        currentDir = currentDirFile.getAbsolutePath();

        //map- center
        Land landTry = new Land(1, players[0].getCountryObjejct(), new Image(new FileInputStream(currentDir + "\\src\\images\\countries\\germany.png")));
        Text landInfo = new Text();
        Group map = new Group();
        landTry.setPickOnBounds(true); // allows click on transparent areas
        landTry.setOnMouseClicked( (MouseEvent e) -> {
            landInfo.setText(landTry.toString());
        });
        landTry.setOnMouseClicked(event -> {
            landInfo.setText(landTry.toString());
        });
        map.getChildren().add(landTry);

        //right
        VBox playerInfo = new VBox(10);
        Text info = new Text();

        Button turnEnd = new Button("Turn");
        playerInfo.getChildren().addAll(info, turnEnd, landInfo);
        //playerInfo.setAlignment(Pos.CENTER);
        playerInfo.setSpacing(10);
        info.setText(players[turnIndex].toString());
        turnEnd.setOnAction(e -> {
            if(turnIndex < playerCount-1)
                turnIndex++;
            else
                turnIndex = 0;
            info.setText(players[turnIndex].toString());
        });
        BorderPane pane = new BorderPane();
        pane.setRight(playerInfo);
        pane.setCenter(map);
        Scene scene = new Scene(pane, 1920, 1080);
        stag.setFullScreen(true);
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
