package UI;

import javafx.stage.Stage;
import sample.GameController;

import java.io.FileNotFoundException;

public class MenuController {

    Stage stag;
    int playerCount;
    String selectedCountry, selectedLeader;
    GameController cntrl = new GameController();
    public MenuController(Stage stage){
        stag = stage;
    }

    public void launch() throws FileNotFoundException {
        stag.setResizable(false);
        MainMenu men = new MainMenu(stag);
        men.show();
    }

    public void credits(){
        Credits cre = new Credits(stag);
        cre.show();
    }
    public void newGame() throws FileNotFoundException {
        PlayersMenu playerMenu = new PlayersMenu(stag);
        playerMenu.askForPlayerCount(this);
    }

    public void countrySelection() throws  FileNotFoundException{
        System.out.println(playerCount);
        NewGame newG = new NewGame(stag);
        newG.show();
    }

    public void countrySelected(String country, String leader){
        selectedLeader = leader;
        selectedCountry = country;
        cntrl.initPlayer(country, leader);
    }
    public String getCountry(){
        return selectedCountry;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}
