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
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.Time;
import java.util.*;

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
import java.util.Timer;

public class Credits implements EventHandler {
    private Event event;
    MenuController men;
    Stage stag;

    public Credits(Stage stage, MenuController men)
    {
        stag = stage;
        this.men = men;
    }


    private Button nbutton = new Button("Development Team");
    private Button nbutton2 = new Button("Design Team");
    private Button nbutton3 = new Button("Directors");
    private Button nbutton4 = new Button("Marketing Team");
    private Button nbutton5 = new Button("Customer Support Team");
    private Button nbutton6 = new Button("Special Thanks");
    private  Button nbutton7 = new Button("Back");

    File currentDirFile = new File("");
    String currentDir = currentDirFile.getAbsolutePath();

    public void show() throws IOException{

        FlowPane bPane = new FlowPane();
        bPane.setStyle("-fx-background-color: #701515;");


        Image image1 = new Image(new FileInputStream(currentDir + "\\src\\images\\Credits\\DevelopmentTeam.png"));
        Image image2 = new Image(new FileInputStream(currentDir + "\\src\\images\\Credits\\DesignTeam.png"));
        Image image3 = new Image(new FileInputStream(currentDir + "\\src\\images\\Credits\\Directors.png"));
        Image image4 = new Image(new FileInputStream(currentDir + "\\src\\images\\Credits\\MarketingTeam.png"));
        Image image5 = new Image(new FileInputStream(currentDir + "\\src\\images\\Credits\\CustomerSup.png"));
        Image image6 = new Image(new FileInputStream(currentDir + "\\src\\images\\Credits\\specialThanks.png"));
        ImageView imageView1 = new ImageView( image1 );



            imageView1.setFitHeight(800);
            imageView1.setFitWidth(1440);



        Button[] buttons = {nbutton, nbutton2, nbutton3, nbutton4, nbutton5, nbutton6, nbutton7};

        for (Button i:
                buttons) {
            i.setPadding(new Insets(5, 54, 5, 54));
        }

        bPane.getChildren().addAll( nbutton, nbutton2, nbutton3, nbutton4, nbutton5, nbutton6, nbutton7);

        //nextScene(bPane, imageView1);
        bPane.getChildren().addAll(imageView1);
        nbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    nextScene(bPane, imageView1, image1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        nbutton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    nextScene(bPane, imageView1, image2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        nbutton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    nextScene(bPane, imageView1, image3);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        nbutton4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    nextScene(bPane, imageView1, image4);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        nbutton5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    nextScene(bPane, imageView1, image5);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        nbutton6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    nextScene(bPane, imageView1, image6);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });



        nbutton7.setOnAction(this::handle);
        Scene scene = new Scene(bPane, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    public void nextScene(FlowPane flowPane, ImageView imageView, Image image ) throws FileNotFoundException
    {
        imageView.setImage(image);
    }

    public void handle(Event event){
        try {
            men.launch();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
