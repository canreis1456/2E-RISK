package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static java.lang.Integer.parseInt;


public class PlayersMenu {

    Stage stag;
    int givenCount;

    public PlayersMenu(Stage stage){
        stag = stage;
    }

    public void askForPlayerCount(MenuController men){

        ComboBox<Integer> playerCounts = new ComboBox<>();
        playerCounts.setMaxWidth(200);
        playerCounts.setPromptText("How many players?");
        ObservableList<Integer> counts = FXCollections.observableArrayList();
        playerCounts.setItems(counts);
        counts.setAll(3,4,5,6);
        VBox pane = new VBox();
        Button confirm = new Button("Select");
        confirm.setStyle("-fx-background-color: #333949; -fx-text-fill: #CAD0E0;");
        Button back = new Button("< Back");
        back.setStyle("-fx-background-color: #333949; -fx-text-fill: #CAD0E0;");
        back.setOnAction(e -> {
            try {
                men.launch();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        confirm.setOnAction(e -> {men.setPlayerCount(playerCounts.getValue());
            try {
                men.countrySelection();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        pane.getChildren().addAll(playerCounts,confirm, back);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);
        pane.setStyle("-fx-background-color: #701515;");
        Scene scene = new Scene(pane, 1440, 800);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

}
