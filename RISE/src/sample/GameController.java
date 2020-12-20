package sample;

import UI.*;
import entities.*;
import javafx.stage.Stage;

import java.io.*;

import UI.MainMenu;
import javafx.application.Application;

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

public class GameController extends Application implements java.io.Serializable{

    MenuController men;
    Player[] players = new Player[6];
    Lands lands;
    ArrayList<String> selectedCountries = new ArrayList<>();
    Country[] countries;
    GamePlay gmp;
    File currentDirFile = new File("");
    String currentDir;
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

    public void setBoard(Lands land){
        lands = land;
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

    public void initPlayer(String country, String leader, String playerName, int playerIndex) throws FileNotFoundException {

        players[playerIndex] = new Player(country, leader, playerName);
        selectedCountries.add(country);
       // positionTroopOnLand(players[playerIndex],2, 1, 5);
        positionTroopOnLand(playerIndex,12, 1, 5);
        lands.setOwnedPlayer(country);
        lands.setDefForLands(country);
        currentDir = currentDirFile.getAbsolutePath();
        Image image1 = new Image(new FileInputStream(currentDir + "\\src\\UI\\ProjeResimler\\sorryforwhat.png"));
        Image image2 = new Image(new FileInputStream(currentDir + "\\src\\UI\\ProjeResimler\\interruption.png"));
        Image image3 = new Image(new FileInputStream(currentDir + "\\src\\UI\\ProjeResimler\\GoddHoward.png"));
        Image image4 = new Image(new FileInputStream(currentDir + "\\src\\UI\\ProjeResimler\\hmm.jpg"));

        Card card1 = new Card("Kamçatka", "Infantry", 5, image1);
        players[playerIndex].addCard(card1);

        Card card2 = new Card("America", "Infantry", 5, image2);
        players[playerIndex].addCard(card2);

        Card card3 = new Card("Middle East", "Infantry", 5, image3);
        players[playerIndex].addCard(card3);

        Card card4 = new Card("ahha", "Cavallary", 5, image4);
        players[playerIndex].addCard(card4);

        System.out.println("The size of player's deck is " + players[playerIndex].getCards().size());
     //   printLands();
      //  players[playerIndex].print();
    }

    public void setPlayers(Player[] players){
        this.players = players;
    }

    public MenuController getMenu(){
        return men;
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

    public GamePlay getGmp() {
        return gmp;
    }

    public void gameplay(Stage stag) throws IOException {
        //stag.setFullScreen(true);
        gmp = new GamePlay(stag, players.length, players, this);
        gmp.show();
    }

    public void loadGame(Stage stag, int turn, int turnIndex) throws IOException {
        gmp = new GamePlay(stag, players.length, players, this);
        gmp.showFrom(turn, turnIndex);
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
