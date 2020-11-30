package entities.Countries;

import entities.Troop.Artillery;
import entities.Troop.Troop;

public class Germany extends Country {

    String selected;

    public Germany(String leader){
        selected = leader;
        troopNumber = 15;
    }
    Leader Hitler = new Leader("Adolf Hitler", "Fascist", -5, 3, 4);
    Leader Wilhelm = new Leader("Wilhelm II", "Emperor", -5, 3, 4);
    Leader[] leader = {Hitler, Wilhelm};

    //Troops
    @Override//her ülkeye farklı troop destesi verelim diye
    public Troop[][] initializeTroops(Troop[][] troops) {
        troops[0] = new Artillery[15];
        for (int i = 0; i < 15; i++) {
            troops[0][i] = new Artillery();
        }
        return troops;
    }

    /*public void positionTroops(int[] troopNumbers, int targetPosition){
        for(int i = 0; i < troopNumber; i++){

        }
    }*/



}
