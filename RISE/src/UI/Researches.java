package UI;

import entities.Research;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Researches {

    Stage stag;

    public Researches(){
        stag = new Stage();
    }

    public void show() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        File currentDirFile = new File("");
        String currentDir = currentDirFile.getAbsolutePath();
        String fxml = currentDir + "\\src\\UI\\Researches.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxml);
        ScrollPane root = (ScrollPane) loader.load(fxmlStream);

        Scene scene = new Scene(root, 600,600);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    @FXML
    public boolean researchClicked(ActionEvent event){
        System.out.println(event.getSource().toString());
        return true;
    }
}
