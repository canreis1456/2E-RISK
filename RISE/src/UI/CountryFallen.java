package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class CountryFallen {

    Stage stag;

    @FXML
    Text country;

    public CountryFallen(){
        stag = new Stage();
    }

    public void call(String s) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/CountryFallen.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        CountryFallen control = loader.<CountryFallen>getController();
        control.show(s, root);
    }

    public void show(String s, AnchorPane root){
        Scene scene = new Scene(root);
        country.setText(s + " has fallen!");
        country.setTextAlignment(TextAlignment.CENTER);
        stag.setTitle("Defeat");
        stag.setScene(scene);
        stag.show();
    }
}
