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
        deck.add(new Card("Afganistan", "Tank", 29, currentDir + "\\src\\UI\\Cards\\Afganistan.png"));
        deck.add(new Card("Alaska", "Infantry", 1,currentDir + "\\src\\UI\\Cards\\Alaska.png" ));
   //     Image image3 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Alberta.png"));
        deck.add(new Card("Alberta", "Tank", 3, currentDir + "\\src\\UI\\Cards\\Alberta.png"));
     //   Image image4 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Arjantin.png"));
        deck.add(new Card("Arjantin", "Infantry", 13, currentDir + "\\src\\UI\\Cards\\Arjantin.png"));
       // Image image5 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAmerika.png"));
        deck.add(new Card("BarıAmerika", "Artillery", 7, currentDir + "\\src\\UI\\Cards\\BatıAmerika.png"));
      //  Image image6 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAvrupa.png"));
        deck.add(new Card("BatıAvrupa", "Artillery", 20, currentDir + "\\src\\UI\\Cards\\BatıAvrupa.png"));
    //    Image image7 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAvustralya.png"));
        deck.add(new Card("BatıAvustralya", "Artillery", 41, currentDir + "\\src\\UI\\Cards\\BatıAvustralya.png"));
  //      Image image8 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Brezilya.png"));
        deck.add(new Card("Brezilya", "Artillery", 11, currentDir + "\\src\\UI\\Cards\\Brezilya.png"));
//        Image image9 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BüyükBritanya.png"));
        deck.add(new Card("BüyükBritanya", "Artillery", 15, currentDir + "\\src\\UI\\Cards\\BüyükBritanya.png"));
       // Image image10 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Çin.png"));
        deck.add(new Card("Çin", "Artillery", 30, currentDir + "\\src\\UI\\Cards\\Çin.png"));
     //   Image image11 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAfrika.png"));
        deck.add(new Card("DoğuAfrika", "Artillery", 23, currentDir + "\\src\\UI\\Cards\\DoğuAfrika.png"));
   //     Image image12 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAmerika.png"));
        deck.add(new Card("DoğuAmerika", "Artillery", 8, currentDir + "\\src\\UI\\Cards\\DoğuAmerika.png"));
 //       Image image13 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAvustralya.png"));
        deck.add(new Card("DoğuAvustralya", "Artillery", 42, currentDir + "\\src\\UI\\Cards\\DoğuAvustralya.png"));
        //Image image14 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuKanada.png"));
        deck.add(new Card("DoğuKanada", "Tank", 5, currentDir + "\\src\\UI\\Cards\\DoğuKanada.png"));
      //  Image image15 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Endonezya.png"));
        deck.add(new Card("Endonezya", "Artillery", 39, currentDir + "\\src\\UI\\Cards\\Endonezya.png"));
    //    Image image16 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Grönland.png"));
        deck.add(new Card("Grönland", "Tank", 6, currentDir + "\\src\\UI\\Cards\\Grönland.png"));
  //      Image image17 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyAfrika.png"));
        deck.add(new Card("GüneyAfrika", "Artillery", 25, currentDir + "\\src\\UI\\Cards\\GüneyAfrika.png"));
//        Image image18 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyAvrupa.png"));
        deck.add(new Card("GüneyAvrupa", "Artillery", 19, currentDir + "\\src\\UI\\Cards\\GüneyAvrupa.png"));
      //  Image image19 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyDoğuAsya.png"));
        deck.add(new Card("GüneyDoğuAsya", "Infantry", 31, currentDir + "\\src\\UI\\Cards\\GüneyDoğuAsya.png"));
    //    Image image20 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Hindistan.png"));
        deck.add(new Card("Hindistan", "Tank", 28, currentDir + "\\src\\UI\\Cards\\Hindistan.png"));
  //      Image image21 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İrkut.png"));
        deck.add(new Card("İrkut", "Tank", 36, currentDir + "\\src\\UI\\Cards\\İrkut.png"));
//        Image image22 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İskandinavya.png"));
        deck.add(new Card("İskandinavya", "Tank", 16, currentDir + "\\src\\UI\\Cards\\İskandinavya.png"));
      //  Image image23 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İzlanda.png"));
        deck.add(new Card("İzlanda", "Infantry", 14, currentDir + "\\src\\UI\\Cards\\İzlanda.png"));
    //    Image image24 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Japonya.png"));
        deck.add(new Card("Japonya", "Artillery", 33, currentDir + "\\src\\UI\\Cards\\Japonya.png"));
  //      Image image25 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Joker1.png"));
        deck.add(new Card("Joker1", "Infantry", 0, currentDir + "\\src\\UI\\Cards\\Joker1.png"));
//        Image image26 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Joker2.png"));
        deck.add(new Card("Joker2", "Infantry", 0, currentDir + "\\src\\UI\\Cards\\Joker2.png"));
      //  Image image27 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Kamcatka.png"));
        deck.add(new Card("Kamcatka", "Infantry", 37, currentDir + "\\src\\UI\\Cards\\Kamcatka.png"));
    //    Image image28 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeyAfrika.png"));
        deck.add(new Card("KuzeyAfrika", "Tank", 21, currentDir + "\\src\\UI\\Cards\\KuzeyAfrika.png"));
  //      Image image29 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeyAvrupa.png"));
        deck.add(new Card("KuzeyAvrupa", "Artillery", 18, currentDir + "\\src\\UI\\Cards\\KuzeyAvrupa.png"));
//        Image image30 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeybatıBölgesi.png"));
        deck.add(new Card("KuzeybatıBölgesi", "Artillery", 2, currentDir + "\\src\\UI\\Cards\\KuzeybatıBölgesi.png"));
     //   Image image31 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Madagaskar.png"));
        deck.add(new Card("Madagaskar", "Tank", 26, currentDir + "\\src\\UI\\Cards\\Madagaskar.png"));
    //    Image image32 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Mısır.png"));
        deck.add(new Card("Mısır", "Infantry", 22, currentDir + "\\src\\UI\\Cards\\Mısır.png"));
  //      Image image33 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Moğolistan.png"));
        deck.add(new Card("Moğolistan", "Infantry", 32, currentDir + "\\src\\UI\\Cards\\Moğolistan.png"));
//        Image image34 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Ontario.png"));
        deck.add(new Card("Ontario", "Tank", 4, currentDir + "\\src\\UI\\Cards\\Ontario.png"));
       // Image image35 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaAfrika.png"));
        deck.add(new Card("OrtaAfrika", "Infantry", 24, currentDir + "\\src\\UI\\Cards\\OrtaAfrika.png"));
     //   Image image36 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaAmerika.png"));
        deck.add(new Card("OrtaAmerika", "Artillery", 9, currentDir + "\\src\\UI\\Cards\\OrtaAmerika.png"));
     //   Image image37 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaDoğu.png"));
        deck.add(new Card("OrtaDoğu", "Infantry", 27, currentDir + "\\src\\UI\\Cards\\OrtaDoğu.png"));
     //   Image image38 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Peru.png"));
        deck.add(new Card("Peru", "Infantry", 12, currentDir + "\\src\\UI\\Cards\\Peru.png"));
    //    Image image39 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Rusya.png"));
        deck.add(new Card("Rusya", "Tank", 17, currentDir + "\\src\\UI\\Cards\\Rusya.png"));
     //   Image image40 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Sibirya.png"));
        deck.add(new Card("Sibirya", "Tank", 35, currentDir + "\\src\\UI\\Cards\\Sibirya.png"));
    //    Image image41 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Ural.png"));
        deck.add(new Card("Ural", "Tank", 34, currentDir + "\\src\\UI\\Cards\\Ural.png"));
     //   Image image42 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Venezuela.png"));
        deck.add(new Card("Venezuela", "Infantry", 10, currentDir + "\\src\\UI\\Cards\\Venezuela.png"));
     //   Image image43 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Yakut.png"));
        deck.add(new Card("Yakut", "Tank", 38, currentDir + "\\src\\UI\\Cards\\Yakut.png"));
     //   Image image44 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\YeniGine.png"));
        deck.add(new Card("YeniGine", "Infantry", 40, currentDir + "\\src\\UI\\Cards\\YeniGine.png"));

    }

    public void loadDeck(ArrayList<Card> cards) throws FileNotFoundException {
        deck = cards;
//        for (int i = 0; i < cards.size(); i++) {
    //        deck.add(cards.get(i));
  //      }
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
