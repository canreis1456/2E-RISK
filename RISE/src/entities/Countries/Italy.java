package entities.Countries;

import entities.Troop.*;
import javafx.scene.input.GestureEvent;

import java.util.ArrayList;

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
    public ArrayList<ArrayList<Troop>> initializeTroops(ArrayList<ArrayList<Troop>> troops) {

        //  ArrayList<Troop> artill = new ArrayList<>();
        troops.add( 0,new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(0).add( new Artillery());
        }
        troops.add(1, new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(1).add( new Infantry());
        }
        troops.add(2, new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(2).add( new Tank());
        }
        troops.add(3, new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(3).add( new Nerds());
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
