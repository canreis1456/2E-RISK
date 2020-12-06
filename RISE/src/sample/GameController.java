package sample;

import UI.*;
import entities.Player;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import UI.MainMenu;
import javafx.application.Application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
    Player[] players = new Player[6];
    ArrayList<String> selectedCountries = new ArrayList<>();
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        initUI(stage);
    }

    private void initUI(Stage stage) throws FileNotFoundException{
        men = new MenuController(stage, selectedCountries);
        men.launch();
    }

    public void setPlayerCount(int playerCount){
        players= new Player[playerCount];
    }

    public void initPlayer(String country, String leader, String playerName, int playerIndex){

        players[playerIndex] = new Player(country, leader, playerName);
        selectedCountries.add(country);
        players[playerIndex].print();
//
        /*players[playerIndex].selectGeneral("Erich von Manstein");
        //player1.print();
        Player player2 = new Player("Soviet Union", "Joseph Stalin", "sen");
        player2.selectGeneral("Georgy Zhukov");
        player2.print();
        System.out.println(player2.attackingTo(players[playerIndex], 1));*/
    }

    public void gameplay(Stage stag) throws FileNotFoundException {
        //stag.setFullScreen(true);
        GamePlay gmp = new GamePlay(stag, players.length, players);
        gmp.show();
    }

    public boolean attacking(Player player, Player enemy, int landNo){
        player.attackingTo(enemy, landNo);
        return true;
    }

    public static void launchApp(String[] args) {
        launch(args);
    }

}
