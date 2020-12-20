package sample;

import UI.GamePlay;
import UI.MenuController;
import entities.Lands;
import entities.Player;

public class Save implements java.io.Serializable{
    private static final long serialVerisonUID = 1L;
    private Player[] players;
    private GameController controller;
 //   private MenuController upper;
    private GamePlay play;

    public Save(Player[] players, GameController controller, GamePlay play){
        this.players = players;
        this.controller = controller;
     //   this.upper = upper;
        this.play = play;
        play.setTurnIndex(play.getTurnIndex());
        play.setTurn(play.getTurn());

    }

  /*  public int getTurn() {
        return turn;
    }

    public int getTurnIndex() {
        return turnIndex;
    }*/

    public Player[]getPlayers(){
        return players;
    }

    public GameController getGameController(){
        return controller;
    }

   // public MenuController getMenuController(){
 //       return upper;
  //  }

    public GamePlay getGamePlay(){
        return play;
    }

}
