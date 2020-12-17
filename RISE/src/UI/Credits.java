package UI;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

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

    @FXML
    private Button nbutton;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private StackPane parentStack;




    File currentDirFile = new File("");
    String currentDir = currentDirFile.getAbsolutePath();

    public void show() throws IOException{

        BorderPane bPane = new BorderPane();
        bPane.setStyle("-fx-background-color: #701515;");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("\\src\\UI\\scene1.fxml"));
        Pane root = (Pane) loader.load();
        bPane.getChildren().addAll(root);

        Scene scene = new Scene(bPane, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    @FXML
    public void nextscene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("\\src\\UI\\scene2.fxml"));
        Scene scene = nbutton.getScene();

        root.translateYProperty().set(scene.getHeight());
        parentStack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event1 ->
        {
            parentStack.getChildren().remove(anchorpane);
        });
        timeline.play();
    }

    public void handle(Event event){
        try {
            men.launch();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
