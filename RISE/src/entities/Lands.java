package entities;

import sample.GameController;

public class Lands {

    Land[] lands;
    GameController control;

    public Lands(GameController control) {
        this.control = control;
        lands = new Land[42];
        lands[0] = new Land(0, "Empty", null);
        lands[1] = new Land(1, "USA", new int[]{2,3,37});


    }

    public void positionTroopOnLand(int unitType, int amount, int landNo) {
        int[] troops = new int[]{0, 0, 0, 0};
        troops[unitType] = amount;
        lands[landNo].setTroopcounts(troops);
    }

    public Land getLand(int landNo) {
        return lands[landNo];
    }

    public void getLandTroops() {
        for (Land a : lands) {
            System.out.println(a.toString());
        }
    }

    public void setOwnedPlayer(String owner) {
        for (Land land : lands) {
            if (land.getOwnerName().equals(owner))
                land.setOwnedByPlayer(true);
        }
    }

    public boolean isOwnedByPlayer(int landNo) {
        for (String a : control.getSelectedCountries()
        ) {
            if (a.equals(lands[landNo].getOwnerName())) {
                lands[landNo].setOwnedByPlayer(true);
                return true;
            }
        }
        lands[landNo].setOwnedByPlayer(false);
        return false;
    }

    public void setDefForLands(String country){
        for (Land a :lands
             ) {
            if(a.getOwnerName().equals(country)){
                a.setDefensePoints(control.getPlayer(country));
            }
        }
    }

    public void setDefensePoints(int landNo){
        if(lands[landNo].isOwnedByPlayer())
            lands[landNo].setDefensePoints(control.getPlayer(lands[landNo].getOwnerName()));
    }

    public float getDefensePointsAt(int landNo) {
        return lands[landNo].getDefensePoints();
    }
}