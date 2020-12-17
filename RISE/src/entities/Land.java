package entities;

import entities.Troops.Troop;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class Land {

    String name;
    int landNo;
    float defensePoints;
    boolean ownedByPlayer;
    String owner;
    int[] troopcounts, borders;
    String landName;
    Player own;
    ArrayList<ArrayList<Troop>> troop;

    public Land(int landNo, String owner, int[] borders, String landName){
        this.landNo = landNo;
        this.owner = owner;
        this.borders = borders;
        this.landName = landName;
        troopcounts = new int[4];
        defensePoints = 30;
        ownedByPlayer = false;
    }

    //   public void setOwner(Country owner) {
    //      this.owner = owner;
    // }

    @Override
    public String toString() {
        return "Land{" +
                "landNo=" + landNo +
                '}' +  "\n" + "owner: " + owner + "\n Artillery: " + troopcounts[0] + "\n Infantry: " + troopcounts[1] +
                "\n Tank: " + troopcounts[2] + "\n Nerds: " + troopcounts[3] + "\n is: " + ownedByPlayer + "\n defPoints: " + defensePoints;
    }

    public int[] getTroopcounts() {
        return troopcounts;
    }

    public void setTroopcounts(int[] troopcounts) {
        this.troopcounts = troopcounts;
    }

    public float getDefensePoints() {
        return defensePoints;

    }

    public boolean hasBorder(int landNo){
        for (int i = 0; i < borders.length; i++){
            if(borders[i] == landNo)
                return true;
        }
        return false;
    }

    public void isAttackable() {
        this.own = own;
    }

    public void setOwnedByPlayer(boolean ownedByPlayer) {
        this.ownedByPlayer = ownedByPlayer;
        defensePoints = 0;
    }

    public boolean isOwnedByPlayer() {
        return ownedByPlayer;
    }

    public void setDefensePoints(Player player)
    {
        this.defensePoints = player.defensePointsAt(landNo);
    }

    public int getLandNo() {
        return landNo;
    }
    public String getLandName(){
        return landName;
    }

    /*public Country getOwner() {
        return owner;
    }*/

    public int getArtilleryAmount(){
        return troopcounts[0];
    }

    public int getInfantryAmount(){
        return troopcounts[1];
    }

    public int getTankAmount(){
        return troopcounts[2];
    }
    public int getNerdsAmount(){
        return troopcounts[3];
    }

    public String getOwnerName(){
        return owner;
    }
}
