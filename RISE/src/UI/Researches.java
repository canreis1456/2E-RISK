package UI;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;

public class Researches {

    Stage stag;
    GamePlay play;
    String selected;

    @FXML
    Button start;

    @FXML
    TextArea researchScreen;

    public Researches() {
        stag = new Stage();
        start = new Button("Start Research");
        start.setId("start");
        start.setDisable(true);
    }


    public void setGamePlay (GamePlay play){
        this.play = play;
    }

    public void show (GamePlay play) throws IOException {



        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Researches.fxml"));
        ScrollPane root = (ScrollPane) loader.load();
        Researches control = loader.<Researches>getController();
        control.setGamePlay(play);
        Scene scene = new Scene(root, 600, 450);
        control.hide(this);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    public void hide(Researches cont){
        start.setOnAction(event -> {
            System.out.println("selec: " +selected);
            play.players[play.getTurnIndex()].startResearch(selected);
            cont.stag.hide();
            play.researchh().setDisable(true);
        });

    }



    public void researchClicked(Event e){
        String id = "", full = e.getSource().toString();
        for (int i = 10; i < full.length(); i++) {
            if(full.charAt(i) == ',' )
                break;
            id += full.charAt(i);
        }
        boolean flag = play.players[play.getTurnIndex()].getTree().isAvailable(id);
        System.out.println(",d:  " + id);
        researchScreen.setText(play.players[play.getTurnIndex()].getTree().printResearch(id));
        if(flag){
            //System.out.println("yyyyy");
            start.setDisable(false);
            selected = id;
            play.players[play.getTurnIndex()].getTree().setFlag(false);
        }else{
            System.out.println("ugugn");
            start.setDisable(true);
        }
    }

    public void researchStarted(Event e){


        //stag.close();
    }
}


