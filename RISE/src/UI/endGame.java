package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class endGame {


    @FXML
    Text winner, def;
    public endGame(){

    }

    public void hide(Stage stag, String a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/endScreen.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        endGame control = loader.<endGame>getController();
        control.show(stag,a, root);
    }

    public void show(Stage stag, String a, AnchorPane root){
        File currentDirFile = new File("");
        String currentDir = currentDirFile.getAbsolutePath();
        Font font = Font.loadFont((currentDir + "\\src\\UI\\fonts\\joffrey.ttf"), 130);
        def.setFont(font);
        def.setStyle("-fx-font-size: 130");
        winner.setText("Winner: " + a);
        winner.setFont(font);
        winner.setStyle("-fx-font-size: 90");
        Scene scene = new Scene(root);
        stag.setScene(scene);
        stag.setTitle("RISE");
        stag.show();
    }
}
