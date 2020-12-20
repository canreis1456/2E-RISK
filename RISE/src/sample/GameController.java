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
    }

    public void initDeck() throws FileNotFoundException {
        currentDir = currentDirFile.getAbsolutePath();
        Image image1 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Afganistan"));
        deck.add(new Card("Afganistan", "Tank", 29, image1));
        Image image2 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Alaska"));
        deck.add(new Card("Alaska", "Infantry", 1, image2));
        Image image3 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Alberta"));
        deck.add(new Card("Alberta", "Infantry", 3, image3));
        Image image4 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Arjantin"));
        deck.add(new Card("Arjantin", "Infantry", 13, image4));
        Image image5 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAmerika"));
        deck.add(new Card("BarıAmerika", "Infantry", 7, image5));
        Image image6 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAvrupa"));
        deck.add(new Card("BatıAvrupa", "Infantry", 20, image6));
        Image image7 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BatıAvustralya"));
        deck.add(new Card("BatıAvustralya", "Infantry", 41, image7));
        Image image8 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Brezilya"));
        deck.add(new Card("Brezilya", "Infantry", 11, image8));
        Image image9 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\BüyükBritanya"));
        deck.add(new Card("BüyükBritanya", "Infantry", 15, image9));
        Image image10 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Çin"));
        deck.add(new Card("Çin", "Infantry", 30, image10));
        Image image11 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAfrika"));
        deck.add(new Card("DoğuAfrika", "Infantry", 23, image11));
        Image image12 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAmerika"));
        deck.add(new Card("DoğuAmerika", "Infantry", 8, image12));
        Image image13 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuAvustralya"));
        deck.add(new Card("DoğuAvustralya", "Infantry", 42, image13));
        Image image14 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\DoğuKanada"));
        deck.add(new Card("DoğuKanada", "Infantry", 5, image14));
        Image image15 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Endonezya"));
        deck.add(new Card("Endonezya", "Infantry", 39, image15));
        Image image16 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Grönland"));
        deck.add(new Card("Grönland", "Infantry", 6, image16));
        Image image17 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyAfrika"));
        deck.add(new Card("GüneyAfrika", "Infantry", 25, image17));
        Image image18 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyAvrupa"));
        deck.add(new Card("GüneyAvrupa", "Infantry", 19, image18));
        Image image19 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\GüneyDoğuAsya"));
        deck.add(new Card("GüneyDoğuAsya", "Infantry", 31, image19));
        Image image20 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Hindistan"));
        deck.add(new Card("Hindistan", "Infantry", 28, image20));
        Image image21 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İrkut"));
        deck.add(new Card("İrkut", "Infantry", 36, image21));
        Image image22 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İskandinavya"));
        deck.add(new Card("İskandinavya", "Infantry", 16, image22));
        Image image23 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\İzlanda"));
        deck.add(new Card("İzlanda", "Infantry", 14, image23));
        Image image24 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Japonya"));
        deck.add(new Card("Japonya", "Infantry", 33, image24));
        Image image25 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Joker1"));
        deck.add(new Card("Joker1", "Infantry", 0, image25));
        Image image26 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Joker2"));
        deck.add(new Card("Joker2", "Infantry", 0, image26));
        Image image27 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Kamcatka"));
        deck.add(new Card("Kamcatka", "Infantry", 37, image27));
        Image image28 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeyAfrika"));
        deck.add(new Card("KuzeyAfrika", "Infantry", 21, image28));
        Image image29 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeyAvrupa"));
        deck.add(new Card("KuzeyAvrupa", "Infantry", 18, image29));
        Image image30 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\KuzeybatıBölgesi"));
        deck.add(new Card("KuzeybatıBölgesi", "Infantry", 2, image30));
        Image image31 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Madagaskar"));
        deck.add(new Card("Madagaskar", "Infantry", 26, image31));
        Image image32 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Mısır"));
        deck.add(new Card("Mısır", "Infantry", 22, image32));
        Image image33 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Moğolistan"));
        deck.add(new Card("Moğolistan", "Infantry", 32, image33));
        Image image34 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Ontario"));
        deck.add(new Card("Ontario", "Infantry", 4, image34));
        Image image35 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaAfrika"));
        deck.add(new Card("OrtaAfrika", "Infantry", 24, image35));
        Image image36 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaAmerika"));
        deck.add(new Card("OrtaAmerika", "Infantry", 9, image36));
        Image image37 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\OrtaDoğu"));
        deck.add(new Card("OrtaDoğu", "Infantry", 27, image37));
        Image image38 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Peru"));
        deck.add(new Card("Peru", "Infantry", 12, image38));
        Image image39 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Rusya"));
        deck.add(new Card("Rusya", "Infantry", 17, image39));
        Image image40 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Sibirya"));
        deck.add(new Card("Sibirya", "Infantry", 35, image40));
        Image image41 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Ural"));
        deck.add(new Card("Ural", "Infantry", 34, image41));
        Image image42 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Venezuela"));
        deck.add(new Card("Venezuela", "Infantry", 10, image42));
        Image image43 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\Yakut"));
        deck.add(new Card("Yakut", "Infantry", 38, image43));
        Image image44 = new Image(new FileInputStream(currentDir + "\\src\\UI\\Cards\\YeniGine"));
        deck.add(new Card("YeniGine", "Infantry", 40, image44));

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
