package entities.Countries;

import entities.Troop.*;

public class Germany extends Country {

    String selected;
    Leader Hitler = new Leader("Adolf Hitler", "Fascist", -5, 3, 4, 4, new int[]{0, 1, 2, 3});
    Leader Wilhelm = new Leader("Wilhelm II", "Emperor", -5, 3, 4, 4 , new int[]{0, 1, 2, 3});
    Leader inUse;
    Leader[] leaders = {Hitler, Wilhelm};

    public Germany(String leader){
        selected = leader;
        for (Leader a: leaders) {
            if (a.getName().equals(selected)){
                a.setSelected();
                inUse = a;
            }
        }
        ideology = inUse.getIdeology();
        troopNumber = 15;
    }

    public Leader getInUse() {
        return inUse;
    }

    //Troops
    @Override//her ülkeye farklı troop destesi verelim diye
    public Troop[][] initializeTroops(Troop[][] troops) {
        troops[0] = new Artillery[15];
        for (int i = 0; i < 15; i++) {
            troops[0][i] = new Artillery();
        }
        troops[1] = new Infantry[13];
        for (int i = 0; i < 13; i++) {
            troops[1][i] = new Infantry();
        }
        troops[2] = new Tank[25];
        for (int i = 0; i < 25; i++) {
            troops[2][i] = new Tank();
        }
        troops[3] = new Nerds[5];
        for (int i = 0; i < 5; i++) {
            troops[3][i] = new Nerds();
        }
        return troops;
    }


    /*public void positionTroops(int[] troopNumbers, int targetPosition){
        for(int i = 0; i < troopNumber; i++){

        }
    }*/



}
