package sample;

import UI.Board;
import entities.Country;
import entities.Land;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class BoardBuilder extends Pane {

    private Board board;
    Land[] lands = new Land[42];

    public void buildBoard() throws FileNotFoundException {

    }

    public void setOwner(int landNo, Country owner){
        board.setLand(landNo, owner);
    }

    public Board getBoard() {
        return board;
    }
}
