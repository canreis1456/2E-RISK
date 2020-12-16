package UI;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Board{

    GamePlay play;
    String currentDir;
    public Board(){
    }

    public void setPlay(GamePlay play){
        this.play = play;
    }

    public GamePlay getPlay() {
        return play;
    }

    public Pane show() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Map.fxml"));
        Pane root = (Pane) loader.load();
        Board control = loader.<Board>getController();
        control.setPlay(play);
        return root;
    }
    public void clicked(MouseEvent e) throws IOException {
        int a = parseInt(((Node) e.getSource()).getAccessibleText());
        LandInterface land = new LandInterface();
        land.show(play.getControl().getLands().getLand(a), this);
        System.out.println(((Node) e.getSource()).getAccessibleText());
    }
    public void clicke(MouseEvent e){

        if(this.getPlay() != null)
        System.out.println(getPlay().getTurnIndex() + "  "  + ((Node) e.getSource()).getAccessibleText());
    }

    public Pane relocateMap() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/RelocateMap.fxml"));
        Pane root2 = (Pane) loader.load();
        Board control = loader.<Board>getController();
        control.setPlay(play);
        return root2;
    }

}
