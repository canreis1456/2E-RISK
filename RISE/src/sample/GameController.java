package sample;

import UI.MainMenu;
import UI.MenuController;
import UI.NewGame;
import entities.Player;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import UI.MainMenu;
import javafx.application.Application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController extends Application{

    MenuController men;
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        initUI(stage);
    }

    private void initUI(Stage stage) throws FileNotFoundException{
        men = new MenuController(stage);
        men.launch();
    }

    public void initPlayer(String country, String leader){
        Player player1 = new Player(country, leader, "ben");
        //player1.print();
        player1.selectGeneral("Erich von Manstein");
        player1.print();
        Player player2 = new Player("Soviet Union", "Stalin", "sen");
        player2 .attackingTo(player1, 1);
        player1.print();
    }

    public boolean attacking(Player player, Player enemy, int landNo){
        player.attackingTo(enemy, landNo);
        return true;
    }

    public static void launchApp(String[] args) throws FileNotFoundException {
        launch(args);
    }

}
