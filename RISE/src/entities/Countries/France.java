package entities.Countries;

import entities.Troop.*;
import javafx.scene.input.GestureEvent;

public class France extends Country {

    String selected;
    Leader Charles = new Leader("Charles de Gaulle", "Democrat", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
    Leader Philippe = new Leader("Philippe Pétain", "Fascist", 0, 0, 4, 4 , new int[]{0, 1, 2, 3});
    Leader inUse;
    Leader[] leaders = {Charles, Philippe};

    //general oluştururken önce tüm trooplara etkisini giriyoz sonra belli bi ülkeye karşı varsa onları giriyoz, belli ülkeye yoksa null, 0, 0 gir
    General Tassigny = new General("Jean de Lattre de Tassigny", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 4, "Germany" , 0, 3);
    General Georges = new General("Alphonse Georges", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 0, "Germany", 3, 0);

    General inUseForBattle;
    General[] generals = {Tassigny, Georges};

    //Land[] lands;    şimdilik boş kalsın bunlar
    //ResearchTree tree;

    public France(String leader){
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

    public General[] getGenerals() {
        return generals;
    }

    //Troops
    @Override//her ülkeye farklı troop destesi verelim diye
    public Troop[][] initializeTroops(Troop[][] troops) {
        troops[0] = new Artillery[20];
        for (int i = 0; i < 20; i++) {
            troops[0][i] = new Artillery();
        }
        troops[1] = new Infantry[15];
        for (int i = 0; i < 15; i++) {
            troops[1][i] = new Infantry();
        }
        troops[2] = new Tank[20];
        for (int i = 0; i < 20; i++) {
            troops[2][i] = new Tank();
        }
        troops[3] = new Nerds[8];
        for (int i = 0; i < 8; i++) {
            troops[3][i] = new Nerds();
        }
        return troops;
    }

    public General selectGeneral(String name){
        for (General g: generals) {
            if(g.getName().equals(name))
                return g;
        }
        return null;
    }


    /*public void positionTroops(int[] troopNumbers, int targetPosition){
        for(int i = 0; i < troopNumber; i++){

        }
    }*/



}
