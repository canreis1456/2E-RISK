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
    int tradeCount = 0;
    Lands lands;
    ArrayList<String> selectedCountries = new ArrayList<>();
    Country[] countries;
    GamePlay gmp;
    File currentDirFile = new File("");
    String currentDir;
    MusicPlayer musicPlayer;
    ArrayList<Card> deck;
    @Override
    public void start(Stage stage) throws Exception {
        initUI(stage);
        musicPlayer = new MusicPlayer();
        musicPlayer.start(stage);
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

        /*
        if(playerIndex == 0) {
            players[playerIndex].addCard(deck.get(16));
            players[playerIndex].addCard(deck.get(32));
            players[playerIndex].addCard(deck.get(1));
            players[playerIndex].addCard(deck.get(15));
        }
         */
    }

    public void initDeck() throws FileNotFoundException {
        currentDir = currentDirFile.getAbsolutePath();
        deck = new ArrayList<Card>();
        Image image1 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Afganistan.png"));
        deck.add(new Card("Afganistan", "Tank", 29, image1));
        Image image2 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Alaska.png"));
        deck.add(new Card("Alaska", "Infantry", 1, image2));
        Image image3 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Alberta.png"));
        deck.add(new Card("Alberta", "Tank", 3, image3));
        Image image4 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Arjantin.png"));
        deck.add(new Card("Arjantin", "Infantry", 13, image4));
        Image image5 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAmerika.png"));
        deck.add(new Card("BarıAmerika", "Artillery", 7, image5));
        Image image6 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAvrupa.png"));
        deck.add(new Card("BatıAvrupa", "Artillery", 20, image6));
        Image image7 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAvustralya.png"));
        deck.add(new Card("BatıAvustralya", "Artillery", 41, image7));
        Image image8 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Brezilya.png"));
        deck.add(new Card("Brezilya", "Artillery", 11, image8));
        Image image9 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BüyükBritanya.png"));
        deck.add(new Card("BüyükBritanya", "Artillery", 15, image9));
        Image image10 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Çin.png"));
        deck.add(new Card("Çin", "Artillery", 30, image10));
        Image image11 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAfrika.png"));
        deck.add(new Card("DoğuAfrika", "Artillery", 23, image11));
        Image image12 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAmerika.png"));
        deck.add(new Card("DoğuAmerika", "Artillery", 8, image12));
        Image image13 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAvustralya.png"));
        deck.add(new Card("DoğuAvustralya", "Artillery", 42, image13));
        Image image14 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuKanada.png"));
        deck.add(new Card("DoğuKanada", "Tank", 5, image14));
        Image image15 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Endonezya.png"));
        deck.add(new Card("Endonezya", "Artillery", 39, image15));
        Image image16 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Grönland.png"));
        deck.add(new Card("Grönland", "Tank", 6, image16));
        Image image17 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyAfrika.png"));
        deck.add(new Card("GüneyAfrika", "Artillery", 25, image17));
        Image image18 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyAvrupa.png"));
        deck.add(new Card("GüneyAvrupa", "Artillery", 19, image18));
        Image image19 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyDoğuAsya.png"));
        deck.add(new Card("GüneyDoğuAsya", "Infantry", 31, image19));
        Image image20 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Hindistan.png"));
        deck.add(new Card("Hindistan", "Tank", 28, image20));
        Image image21 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İrkut.png"));
        deck.add(new Card("İrkut", "Tank", 36, image21));
        Image image22 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İskandinavya.png"));
        deck.add(new Card("İskandinavya", "Tank", 16, image22));
        Image image23 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İzlanda.png"));
        deck.add(new Card("İzlanda", "Infantry", 14, image23));
        Image image24 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Japonya.png"));
        deck.add(new Card("Japonya", "Artillery", 33, image24));
        Image image25 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Joker1.png"));
        deck.add(new Card("Joker1", "Infantry", 0, image25));
        Image image26 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Joker2.png"));
        deck.add(new Card("Joker2", "Infantry", 0, image26));
        Image image27 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Kamcatka.png"));
        deck.add(new Card("Kamcatka", "Infantry", 37, image27));
        Image image28 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeyAfrika.png"));
        deck.add(new Card("KuzeyAfrika", "Tank", 21, image28));
        Image image29 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeyAvrupa.png"));
        deck.add(new Card("KuzeyAvrupa", "Artillery", 18, image29));
        Image image30 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeybatıBölgesi.png"));
        deck.add(new Card("KuzeybatıBölgesi", "Artillery", 2, image30));
        Image image31 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Madagaskar.png"));
        deck.add(new Card("Madagaskar", "Tank", 26, image31));
        Image image32 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Mısır.png"));
        deck.add(new Card("Mısır", "Infantry", 22, image32));
        Image image33 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Moğolistan.png"));
        deck.add(new Card("Moğolistan", "Infantry", 32, image33));
        Image image34 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Ontario.png"));
        deck.add(new Card("Ontario", "Tank", 4, image34));
        Image image35 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaAfrika.png"));
        deck.add(new Card("OrtaAfrika", "Infantry", 24, image35));
        Image image36 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaAmerika.png"));
        deck.add(new Card("OrtaAmerika", "Artillery", 9, image36));
        Image image37 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaDoğu.png"));
        deck.add(new Card("OrtaDoğu", "Infantry", 27, image37));
        Image image38 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Peru.png"));
        deck.add(new Card("Peru", "Infantry", 12, image38));
        Image image39 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Rusya.png"));
        deck.add(new Card("Rusya", "Tank", 17, image39));
        Image image40 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Sibirya.png"));
        deck.add(new Card("Sibirya", "Tank", 35, image40));
        Image image41 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Ural.png"));
        deck.add(new Card("Ural", "Tank", 34, image41));
        Image image42 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Venezuela.png"));
        deck.add(new Card("Venezuela", "Infantry", 10, image42));
        Image image43 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Yakut.png"));
        deck.add(new Card("Yakut", "Tank", 38, image43));
        Image image44 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\YeniGine.png"));
        deck.add(new Card("YeniGine", "Infantry", 40, image44));

    }

    public void setCardDeck(ArrayList<Card> cards){
        deck = cards;
    }

    public ArrayList<Card> getCardDeck(){
        return deck;
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

    public void Give(int turnIndex){
        int random = (int) ((Math.random() * (43 - 0)) + 0);
        getPlayers()[turnIndex].addCard(deck.get(random));
        deck.remove(random);
        tradeCount++;
    }

    public int getTradeCount(){
        return tradeCount;
    }
}
