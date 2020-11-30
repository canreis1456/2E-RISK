package UI;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.EventListener;

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
    Stage stag;

    public MainMenu(Stage stage){
        stag = stage;
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
        credits.setOnAction(this::handle);

        Button howtoPlay = new Button("How To Play");
        howtoPlay.setLayoutX(1100);
        howtoPlay.setLayoutY(610);
        howtoPlay.setMinSize(230, 100);

        Image image = new Image(new FileInputStream("D:\\RISE\\src\\images\\wp4615565.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(20);
        imageView.setY(20);
        imageView.setFitHeight(750);
        imageView.setFitWidth(1000);
        layout.getChildren().addAll(newG,loadG,credits,howtoPlay, imageView);
        Scene scene = new Scene(layout, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    public void handle(Event event) {
        MenuController upperMenu = new MenuController(stag);
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
