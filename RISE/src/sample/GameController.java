package sample;

import UI.*;
import entities.Country;
import entities.Land;
import entities.Lands;
import entities.Player;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import UI.MainMenu;
import javafx.application.Application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    Lands lands;
    ArrayList<String> selectedCountries = new ArrayList<>();
    Country[] countries;
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        initUI(stage);
    }

    private void initUI(Stage stage) throws FileNotFoundException{
        men = new MenuController(stage, selectedCountries);
        initBoard();
        men.launch();
    }

    public Lands getLands() {
        return lands;
    }

    public ArrayList<String> getSelectedCountries() {
        return selectedCountries;
    }

    public void setPlayerCount(int playerCount){
        players= new Player[playerCount];
    }

    public void initBoard(){
        lands = new Lands(this);
    }

    public void initCountries(){
        //countries[i]= new Country();
    }

    public Player getPlayer(String country){
        for (Player a: players
             ) {
            if(a.getCountry().equals(country)){
                return a;
            }
        }
        return null;
    }

    public void initPlayer(String country, String leader, String playerName, int playerIndex){

        players[playerIndex] = new Player(country, leader, playerName);
        selectedCountries.add(country);
       // positionTroopOnLand(players[playerIndex],2, 1, 5);
        positionTroopOnLand(playerIndex,12, 1, 5);
        lands.setOwnedPlayer(country);
        lands.setDefForLands(country);
     //   printLands();
      //  players[playerIndex].print();
    }

    public void defensePointsAtLand(int landNo){
        System.out.println(lands.getDefensePointsAt(landNo));
    }

    //public

    public void printLands(){
        lands.getLandTroops();
    }

    public Player[] getPlayers() {
        return players;
    }

    public void relocateTroops(int turnIndex, int landNoFrom, int landNoTo, int unitType, int amount){
        System.out.println(unitType + "  " + landNoFrom + "  " + landNoTo + "  " + amount +  "  "  + turnIndex);
        players[turnIndex].relocateTroops(landNoFrom, landNoTo, unitType, amount);
        lands.positionTroopOnLand(unitType,amount,landNoTo);
        lands.positionTroopOnLand(unitType, - amount, landNoFrom);
    }

    public void positionTroopOnLand(int turnIndex, int landNo, int unitType, int amount){
        if(players[turnIndex].getCountry().equals(lands.getLand(landNo).getOwnerName())){
            if(players[turnIndex].isEnoughTroop(unitType, amount)) {
                lands.positionTroopOnLand(unitType, amount, landNo);
                players[turnIndex].positionTroops(unitType,amount, landNo);
            }
        }else
            System.out.println("not the owner");
    }

    public void gameplay(Stage stag) throws IOException {
        //stag.setFullScreen(true);
        GamePlay gmp = new GamePlay(stag, players.length, players, this);
        gmp.show();
    }

    public boolean attacking(Player player, int landNo){
        if(lands.isOwnedByPlayer(landNo)) {
            //System.out.println("koıjkıj: " + lands.getLand(landNo).getOwnerName());
            player.attackingTo(getPlayer(lands.getLand(landNo).getOwnerName()), landNo);

        }else
            player.attackingToBot(landNo, lands.getLand(landNo).getOwnerName());
        return true;
    }

    public static void launchApp(String[] args) {
        launch(args);
    }

    public void tradeCard(){

    }

}
