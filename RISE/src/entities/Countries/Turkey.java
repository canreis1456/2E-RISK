package entities.Countries;

import entities.Troop.*;
import javafx.scene.input.GestureEvent;

import java.util.ArrayList;

public class Turkey extends Country {

    String selected;
    Leader IsmetInonu = new Leader("Ismet Inonu", "Authoritarian", 0, -1, 4, 4, new int[]{0, 1, 2, 3});
    Leader Abdulmejid = new Leader("Abdulmejid II", "Emperor", 0, 2, 4, 4 , new int[]{0, 1, 2, 3});
    Leader inUse;
    Leader[] leaders = {IsmetInonu, Abdulmejid};

    //general oluştururken önce tüm trooplara etkisini giriyoz sonra belli bi ülkeye karşı varsa onları giriyoz, belli ülkeye yoksa null, 0, 0 gir
    General Cakmak = new General("Fevzi Cakmak", new float[]{1,1,1,1}, new float[]{1,1,1,1}, 4, null , 0, 0);
    General Karabekir = new General("Kazım Karabekir", new float[]{2,2,2,2}, new float[]{0,0,0,0}, 0, null, 0, 0);
    General Altay = new General("Fahrettin Altay", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 0, null, 0, 0);
    General inUseForBattle;
    General[] generals = {Cakmak, Karabekir, Altay};

    //Land[] lands;    şimdilik boş kalsın bunlar
    //ResearchTree tree;

    public Turkey(String leader){
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
