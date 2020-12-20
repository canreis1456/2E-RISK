package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class endGame {

    Stage stag;
    GamePlay play;
    Text winner, def;
    @FXML
    Button quit, playAgain;


    public endGame(){
        winner = new Text();
        def = new Text();
        quit = new Button();
        playAgain = new Button();
    }

    public void setPlay(GamePlay play){
        this.play = play;
    }

    public void hide(Stage stag, String a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/endScreen.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        endGame control = loader.<endGame>getController();
        control.show(stag,a, root, play);
    }

    public void show(Stage stag, String a, AnchorPane root, GamePlay play){
        File currentDirFile = new File("");
        String currentDir = currentDirFile.getAbsolutePath();
        Font font = Font.loadFont((currentDir + "\\src\\UI\\fonts\\and.ttf"), 130);
        System.out.println("asdff " + (font != null));
       // def.setFont();
        this.stag = stag;
        this.play = play;

        def.setText("VICTORY");

        def.setTextAlignment(TextAlignment.CENTER);
        def.setWrappingWidth(1440);
        winner.setFont(Font.loadFont(currentDir + "\\src\\UI\\fonts\\and.ttf", 130));
        winner.setText("Winner: " + a);

        winner.setTextAlignment(TextAlignment.CENTER);
        winner.setWrappingWidth(1440);
        winner.setStyle("-fx-font-size: 90; -fx-fill: #fe0807;");
        def.setStyle("-fx-font-size: 130; -fx-fill: #fe0807;");
        def.setLayoutX(0);
        def.setLayoutY(180);
        winner.setLayoutX(0);
        winner.setLayoutY(500);
        root.getChildren().addAll(def,winner);
        Scene scene = new Scene(root);
        stag.setScene(scene);
        stag.setTitle("RISE");
        stag.show();
    }

    public void playAgain() throws Exception {
        System.out.println("wasdfasfas");
        play.getControl().start(stag);
    }

    public void endGame(){
        System.out.println("SD");
        stag.close();
    }
}
