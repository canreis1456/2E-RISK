package UI;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;

import entities.Player;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainMenu implements EventHandler {
    Button newG = new Button("New Game");
    Button credits;
    int selection;
    MenuController upperMenu;
    Stage stag;

    public MainMenu(Stage stage, MenuController upperMenu){
        stag = stage;
        this.upperMenu = upperMenu;
    }
    public void show() throws FileNotFoundException{
        Pane layout = new Pane();
        layout.setStyle("-fx-background-color: #701515;");

        newG.setLayoutX(1100);
        newG.setLayoutY(100);
        newG.setMinSize(230, 100);
        newG.setOnAction(this::handle);

        Button loadG = new Button("Load Game");
        loadG.setLayoutX(1100);
        loadG.setLayoutY(270);
        loadG.setMinSize(230, 100);
        credits = new Button("Credits");
        credits.setLayoutX(1100);
        credits.setLayoutY(440);
        credits.setMinSize(230, 100);
        credits.getStyleClass().add("country-Buttons");
        credits.setOnAction(this::handle);

        Button deneme = new Button("sona");
        deneme.setOnAction(e -> {
            upperMenu.setPlayerCount(3);
            upperMenu.initBoard();
            upperMenu.countrySelected("German Reich", "Adolf Hitler", "ben");
            upperMenu.countrySelected("Soviet Union", "Joseph Stalin", "sen");
            upperMenu.countrySelected("USA", "Franklin Delano Roosevelt", "biz");

            try {
                upperMenu.gameplay();
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        Button howtoPlay = new Button("How To Play");
        howtoPlay.setLayoutX(1100);
        howtoPlay.setLayoutY(610);
        howtoPlay.setMinSize(230, 100);
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();

        Image image = new Image(new FileInputStream(helper + "\\src\\images\\wp4615565.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(20);
        imageView.setY(20);
        imageView.setFitHeight(750);
        imageView.setFitWidth(1000);
        layout.getChildren().addAll(newG,loadG,credits,howtoPlay, imageView, deneme);
        Scene scene = new Scene(layout, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    public void handle(Event event) {
        if(event.getSource() == credits){
            upperMenu.credits();
        }else if(event.getSource() == newG){
            try {
                upperMenu.newGame();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
