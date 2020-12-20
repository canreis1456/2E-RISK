package UI;

import entities.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CardsInterface {
    Stage stag;
    CardsController control;
    Player player;
    GamePlay play;
    AnchorPane root;
    Pane map;
    Scene scene;

    public CardsInterface(Player player, GamePlay play){
        stag = new Stage();
        this.player = player;
        this.play = play;
    }

    public GamePlay getPlay() {
        return play;
    }

    public void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/CardsUI.fxml"));
        //System.out.println(loader.getController().toString());
        root = (AnchorPane) loader.load();
        control = loader.getController();
        control.setUpperClass(this);
        control.setPlayer(player);
        control.setCards();
        //control.setSelectCard();
        scene = new Scene(root);

        stag.setScene(scene);
        stag.setTitle("Position Troops");

        stag.show();
    }

    public void setMap(){
        play.setInfoDisable(true);
        play.updateInfo();
        play.setMap();
    }
}
