package UI;

import entities.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PositionInterface {

    Stage stag;
    PositionController control;
    Player player;
    GamePlay play;
    int art,inf,tnk,nrd;
    AnchorPane root;
    Pane map;
    Scene scene;

    public PositionInterface(Player player, GamePlay play){
        stag = new Stage();
        this.player = player;
        this.play = play;
    }

    public void setAmounts(int art, int inf, int tnk, int nrd){
        this.art = art;
        this.inf = inf;
        this.tnk = tnk;
        this.nrd = nrd;
//        System.out.println(art + " " + inf + " " + tnk + " " + nrd);
    }

    public void positionTroop(int landNo){
        play.positionTroop(0,art, landNo);
        play.positionTroop(1,inf, landNo);
        play.positionTroop(2,tnk, landNo);
        play.positionTroop(3,nrd, landNo);
    }

    public GamePlay getPlay() {
        return play;
    }

    public void positionMap() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/PositionMap.fxml"));
        map = loader.load();
        PositionController control = loader.getController();
        control.setUpperClass(this);
        play.relocateMap(map);
    }

    public void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/PositionUI.fxml"));
//        System.out.println(loader.getController().toString());
        root = (AnchorPane) loader.load();
        control = loader.getController();
        control.setTexts(player);
        control.setUpperClass(this);
        control.getAmounts();
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
