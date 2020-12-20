package UI;
import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
public class MusicPlayer extends Application implements java.io.Serializable
{
    File currentDirFile;
    String currentDir;
    @Override
    public void start (Stage primaryStage) throws Exception {
        currentDirFile = new File("");
        currentDir =  currentDirFile.getAbsolutePath();
        String path = currentDir + "\\src\\UI\\Music\\AOE2.mp3";

        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setAutoPlay(true);
        primaryStage.setTitle("Playing Audio");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}