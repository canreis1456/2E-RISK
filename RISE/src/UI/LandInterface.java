package UI;

import entities.Land;
import entities.Lands;
import entities.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.GameController;

import java.io.IOException;

public class LandInterface {

    Land land;


    Stage stag;
    Board board;
    @FXML
    Text Artillery;
    @FXML
    Text Infantry, Tank, Nerds, DefensePoints, isBot;

    public LandInterface(){
        stag = new Stage();
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public void setTexts(Land land){
        Artillery.setText(land.getArtilleryAmount() + " ");
        Infantry.setText(land.getInfantryAmount() + " ");
        Tank.setText(land.getTankAmount() + " ");
        Nerds.setText(land.getNerdsAmount() + " ");
        DefensePoints.setText(land.getDefensePoints() + " ");
        System.out.println(land.isOwnedByPlayer());
        if(land.isOwnedByPlayer()){
            isBot.setText(board.getPlay().getControl().getPlayer(land.getOwnerName()).getName());
        }else
            isBot.setText(land.getOwnerName());
    }

    /*public LandInterface(Land land){
        this.land = land;
        stag = new Stage();
        Artillery.setText(land.getArtilleryAmount() + " ");
        Infantry.setText(land.getInfantryAmount() + " ");
        Tank.setText(land.getTankAmount() + " ");
        Nerds.setText(land.getNerdsAmount() + " ");
        DefensePoints.setText(land.getDefensePoints() + " ");
    }*/

    public void show(Land land, Board board) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/LandUI.fxml"));
        Pane root = (Pane) loader.load();
        LandInterface control = loader.<LandInterface>getController();

        control.setBoard(board);
        control.setTexts(land);

        Scene scene = new Scene(root);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    public void relocated() throws IOException {
        board.getPlay().setInfoDisable(false);
        setBoard(board);
        board.getPlay().relocateMap(board.relocateMap());
    }
}
