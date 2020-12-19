package UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GeneralInterface {

    Stage stage;
    GamePlay game;
    GeneralControl control;
    Pane pane;
    Scene scene;

    public GeneralInterface(GamePlay a) {
        stage = new Stage();
        game = a;

    }

    public GamePlay getPlay() {
        return game;
    }

    public void show() throws IOException {

        String a = game.getControl().getPlayers()[game.turnIndex].getCountry();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/" + a + "General.fxml"));
//        System.out.println(loader.getController().toString());
        pane = (Pane) loader.load();
        control = loader.getController();
        control.setUpperClass(this);
        scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }

}
