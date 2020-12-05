package entities.Countries;

import entities.Troop.*;
import javafx.scene.input.GestureEvent;

import java.util.ArrayList;

public class Germany extends Country {

    String selected;
    Leader Hitler = new Leader("Adolf Hitler", "Fascist", -5, 3, 4, 4, new int[]{0, 1, 2, 3});
    Leader Wilhelm = new Leader("Wilhelm II", "Emperor", 2, 2, 4, 4 , new int[]{0, 1, 2, 3});
    Leader inUse;
    Leader[] leaders = {Hitler, Wilhelm};

    //general oluştururken önce tüm trooplara etkisini giriyoz sonra belli bi ülkeye karşı varsa onları giriyoz, belli ülkeye yoksa null, 0, 0 gir
    General Manstein = new General("Erich von Manstein", new float[]{0,0,0,0}, new float[]{-2,-2,-2,-2}, 4, null , 0, 0);
    General Rommel = new General("Erwin Rommel", new float[]{1,1,1,1}, new float[]{1,1,1,1}, 0, "Soviet Union", -4, -4);
    General Bock = new General("Fedor von Bock",new float[]{0,2,-1,0}, new float[]{0,2,-1,0}, 0,null, 0,0 );
    General inUseForBattle;
    General[] generals = {Manstein, Rommel, Bock};

    //Land[] lands;    şimdilik boş kalsın bunlar
    //ResearchTree tree;

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
