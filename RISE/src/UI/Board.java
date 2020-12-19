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
    Board control;
    String currentDir;
    int artil, inf, tnk, nrd, landNoFrom, landNoTo;
    public Board(){
        artil = 0;
        inf = 0;
        tnk = 0;
        nrd = 0;
        landNoFrom = 0;
        landNoTo = 0;
    }

    public Board getControl() {
        return control;
    }

    public void setPlay(GamePlay play){
        this.play = play;
    }

    public GamePlay getPlay() {
        return play;
    }

    public void setRelocate(int artil, int inf, int tnk, int nrd, int landNoFrom){
        this.artil = artil;
        this.inf = inf;
        this.tnk = tnk;
        this.nrd = nrd;
        this.landNoFrom = landNoFrom;
    }


    public Pane show() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Map.fxml"));
        Pane root = (Pane) loader.load();
        control = loader.<Board>getController();
        control.setPlay(play);
        return root;
    }
    public void clicked(MouseEvent e) throws IOException {
        int a = parseInt(((Node) e.getSource()).getAccessibleText());
        LandInterface land = new LandInterface();
        land.show(play.getControl().getLands(),a, this);
        landNoFrom = parseInt(((Node) e.getSource()).getAccessibleText());
    }

    public void setLandNoFrom(int landNoFrom) {
        this.landNoFrom = landNoFrom;
    }

    public void clicke(MouseEvent e) throws IOException {

        if(this.getPlay() != null && this.getPlay().getControl().getLands().getLand(landNoFrom).getOwnerName().equals(this.getPlay().getControl().getLands().getLand(parseInt(((Node) e.getSource()).getAccessibleText())).getOwnerName())) {
            relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 0, artil);
            relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 1, inf);
            relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 2, tnk);
            relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 3, nrd);
          //  System.out.println(getPlay().getTurnIndex() + "  " + ((Node) e.getSource()).getAccessibleText());
            this.getPlay().setMap();
        }else if(this.getPlay().getControl().getLands().getLand(landNoFrom).hasBorder(parseInt(((Node) e.getSource()).getAccessibleText()))){
            relocateTroop(this.getPlay(), landNoFrom, 43, 0, artil);
            relocateTroop(this.getPlay(), landNoFrom, 43, 1, inf);
            relocateTroop(this.getPlay(), landNoFrom, 43, 2, tnk);
            relocateTroop(this.getPlay(), landNoFrom, 43, 3, nrd);
            AttackInterface attack = new AttackInterface(play.players[getPlay().turnIndex], parseInt(((Node) e.getSource()).getAccessibleText()),play, landNoFrom);
            attack.show();

            this.getPlay().setMap();
        }
    }

    public Pane relocateMap() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/RelocateMap.fxml"));
        Pane root2 = (Pane) loader.load();
        Board control = loader.<Board>getController();
        control.setPlay(play);
        control.setLandNoFrom(landNoFrom);
        control.setRelocate(artil,inf,tnk,nrd,landNoFrom);
        return root2;
    }


    public void relocateTroop(GamePlay play, int landNoFrom, int landNoTo, int unitType, int amount){
        System.out.println(unitType + "  " + landNoFrom + "  " + landNoTo + "  " + amount);
        play.relocateTroop(landNoFrom, landNoTo, unitType, amount);
    }
}
