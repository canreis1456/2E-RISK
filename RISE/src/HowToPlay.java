package UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HowToPlay implements EventHandler{
    private Event event;
    MenuController men;
    Stage stag;
    File currentDirFile = new File("");
    String helper = currentDirFile.getAbsolutePath();
    Button back;
    Button prev;
    Button next;
    int counter = 1;
    public HowToPlay(Stage stage, MenuController men){
        stag = stage;
        this.men = men;
    }
    public void show()throws FileNotFoundException{
        javafx.scene.image.Image image = new Image(new FileInputStream(helper + "\\src\\images\\howToPlay\\" + counter + ".png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(20);
        imageView.setY(20);
        imageView.setFitHeight(750);
        imageView.setFitWidth(1000);
        HBox layout = new HBox();
        layout.setStyle("-fx-background-color: #701515;");
        layout.setAlignment(Pos.CENTER);
        back = new Button("Back");
        back.setLayoutX(0);
        back.setLayoutY(0);
        back.setOnAction(this::handle);
        prev = new Button("Prev");
        prev.setLayoutX(1200);
        prev.setLayoutY(1200);
        prev.setOnAction(this::handle);
        next = new Button("Next");
        next.setLayoutX(1800);
        next.setLayoutY(1200);
        next.setOnAction(this::handle);
        if(counter <= 1) {
            layout.getChildren().addAll(back, next, imageView);
        }
        else if(counter >= 7){
            layout.getChildren().addAll(back, prev, imageView);
        }
        else{
            layout.getChildren().addAll(back, prev,next, imageView);
        }
        Scene scene = new Scene(layout, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }


    public void handle(Event event){
        if(event.getSource() == back){
            try {
                men.launch();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if(event.getSource() == prev){
            counter -= 1;
            try{
                show();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        } else if(event.getSource() == next){
            counter += 1;
            try{
                show();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}


