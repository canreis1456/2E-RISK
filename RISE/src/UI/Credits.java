package UI;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileNotFoundException;

public class Credits implements EventHandler{
    private Event event;
    Stage stag;
    public Credits(Stage stage){
        stag = stage;
    }
    public void show(){
        Pane layout = new Pane();
        layout.setStyle("-fx-background-color: #701515;");
        String credits = "Devs:  Can Kılıç \n \t Ege Çetin \n \t Emre Erciyas \n \t Furkan Demir \n \t Depresyon Stayla";
        Text Muzoo;
        Text t = new Text(credits);
        t.setFont(Font.font("Times New Roman", 36));
        t.setY(100);
        Button back = new Button("Back");
        back.setLayoutX(1200);
        back.setLayoutY(600);
        back.setOnAction(this::handle);
        layout.getChildren().addAll(t, back);
        Scene scene = new Scene(layout, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }


    public void handle(Event event){
        MainMenu men = new MainMenu(stag);
        try {
            men.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
