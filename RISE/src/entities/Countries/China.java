package entities.Countries;

import entities.Troop.*;
import javafx.scene.input.GestureEvent;

import java.util.ArrayList;

public class China extends Country {

    String selected;
    Leader Kaishek = new Leader("Chiang Kai-shek", "Non-Aligned", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
    Leader inUse;
    Leader[] leaders = {Kaishek};

    //general oluştururken önce tüm trooplara etkisini giriyoz sonra belli bi ülkeye karşı varsa onları giriyoz, belli ülkeye yoksa null, 0, 0 gir
    General Jen = new General("Sun Li Jen", new float[]{0,0,0,0}, new float[]{4,4,4,4}, 4, null , 0, 0);
    General Zongnan = new General("Hu Zongnan", new float[]{4,4,4,4}, new float[]{0,0,0,0}, 0, null, 0, 0);
    General inUseForBattle;
    General[] generals = {Jen, Zongnan};

    //Land[] lands;    şimdilik boş kalsın bunlar
    //ResearchTree tree;

    public China(String leader){
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
    // @Override//her ülkeye farklı troop destesi verelim diye
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
