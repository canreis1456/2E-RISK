package entities.Countries;

import entities.Troop.*;
import javafx.scene.input.GestureEvent;

public class Italy extends Country {

    String selected;
    Leader Mussolini = new Leader("Benito Mussolini", "Fascist", -2, 0, 4, 4, new int[]{0, 1, 2, 3}); // 2.5 desteklenmiyo kkn
    Leader Parri = new Leader("Ferruco Parri", "Democrat", 0, 0, 4, 4 , new int[]{0, 1, 2, 3});
    Leader inUse;
    Leader[] leaders = {Mussolini, Parri};

    //general oluştururken önce tüm trooplara etkisini giriyoz sonra belli bi ülkeye karşı varsa onları giriyoz, belli ülkeye yoksa null, 0, 0 gir
    General Cavallero = new General("Ugo Cavallero", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 4, "France" , 0, 2);
    General Messe = new General("Giovanni Messe", new float[]{0,0,2,0}, new float[]{0,0,2,0}, 0, "Soviet Union", -1, 0);
    General inUseForBattle;
    General[] generals = {Cavallero, Messe};

    //Land[] lands;    şimdilik boş kalsın bunlar
    //ResearchTree tree;

    public Italy(String leader){
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
