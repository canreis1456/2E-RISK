package UI;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Date;
import java.util.Timer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TimerTask;

public class Credits implements EventHandler{
    private Event event;
    MenuController men;
    Stage stag;
    public Credits(Stage stage, MenuController men)
    {
        stag = stage;
        this.men = men;
    }
    ArrayList<Image> credits = new ArrayList<>();
    File currentDirFile = new File("");
    String currentDir = currentDirFile.getAbsolutePath();

    public void imageLoad() throws FileNotFoundException {
        credits.add(new Image(new FileInputStream(currentDir + "\\src\\images\\flags\\330px-German_Reich.png")));
        credits.add(new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenItalyBefore.png")));

    }
    public void show() throws FileNotFoundException{

        imageLoad();

        HBox layout = new HBox();
        BorderPane bPane1 = new BorderPane();
        bPane1.setStyle("-fx-background-color: #701515;");
        //bPane1.setCenter(Pos);
        VBox pane = new VBox();
        Timer timer = new Timer();

        Image im3 = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenItalyBefore.png"));

        ImageView iv1 = new ImageView(credits.get(0));
        ImageView iv2 = new ImageView( im3 );
        ImageView[] ivarr = {iv1, iv2};

        for (ImageView i:
                ivarr) {
            i.setFitHeight(350);
            i.setFitWidth(500);
        }


        pane.getChildren().addAll(iv1);
        //try {
        //   Thread.sleep(5000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        pane.getChildren().addAll(iv2);


        Button back = new Button("Back");
        back.setLayoutX(1200);
        back.setLayoutY(600);
        back.setOnAction(this::handle);
        pane.getChildren().addAll(back);
        bPane1.setCenter(pane);
        Scene scene = new Scene(bPane1, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
        /*
        String credits = "Devs:  Can Kılıç \n \t   Ege Çetin \n \t   Emre Erciyas \n \t   Furkan Demir \n \t   Muzaffer Köksal";
        Text t = new Text(credits);
        t.setFont(Font.font("Times New Roman", 36));
        t.setY(100);

        Development Team
        Design Team
        Marketing Team
        Directors
        Customer Support Team
        special thanks
         */
    }


    public void handle(Event event){
        try {
            men.launch();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
