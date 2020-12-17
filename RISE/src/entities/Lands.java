package entities;

import sample.GameController;

public class Lands {

    Land[] lands;
    GameController control;

    public Lands(GameController control) {
        this.control = control;
        lands = new Land[43];
        lands[0] = new Land(0, "Empty", null);
        lands[1] = new Land(1, "USA", new int[]{2, 3, 37});
        lands[2] = new Land(2, "USA", new int[]{1, 3, 4, 6});
        lands[3] = new Land(3, "USA", new int[]{1, 2, 4, 5, 7});
        lands[4] = new Land(4, "USA", new int[]{2, 3, 5, 6, 8});
        lands[5] = new Land(5, "USA", new int[]{4, 6, 8});
        lands[6] = new Land(6, "USA", new int[]{2, 4, 5, 14});
        lands[7] = new Land(7, "USA", new int[]{3, 4, 8, 9});
        lands[8] = new Land(8, "USA", new int[]{4, 5, 7, 9});
        lands[9] = new Land(9, "USA", new int[]{7, 8, 10});
        lands[10] = new Land(10, "USA", new int[]{11, 12});
        lands[11] = new Land(11, "USA", new int[]{10, 12, 21});
        lands[12] = new Land(12, "USA", new int[]{10, 11, 13});
        lands[13] = new Land(13, "USA", new int[]{11, 12});
        lands[14] = new Land(14, "USA", new int[]{6, 15, 16});
        lands[15] = new Land(15, "USA", new int[]{14, 16, 18, 20});
        lands[16] = new Land(16, "USA", new int[]{14, 15, 17, 18});
        lands[17] = new Land(17, "USA", new int[]{16, 18, 19, 34, 29, 27});
        lands[18] = new Land(18, "USA", new int[]{14, 15, 16, 17, 19, 20});
        lands[19] = new Land(19, "USA", new int[]{17, 18, 20, 27});
        lands[20] = new Land(20, "USA", new int[]{15, 18, 19, 21});
        lands[21] = new Land(21, "USA", new int[]{11, 19, 20, 22});
        lands[22] = new Land(22, "German Reich", new int[]{19, 21, 23, 27});
        lands[23] = new Land(23, "German Reich", new int[]{21, 22, 24, 25, 26});
        lands[24] = new Land(24, "German Reich", new int[]{21, 23, 25});
        lands[25] = new Land(25, "German Reich", new int[]{23, 26});
        lands[26] = new Land(26, "German Reich", new int[]{23, 25});
        lands[27] = new Land(27, "German Reich", new int[]{17, 19, 22, 23, 28, 29});
        lands[28] = new Land(28, "German Reich", new int[]{27, 29, 30, 31});
        lands[29] = new Land(29, "German Reich", new int[]{17, 27, 28, 30, 34});
        lands[30] = new Land(30, "German Reich", new int[]{28, 29, 31, 32, 34, 35});
        lands[31] = new Land(31, "German Reich", new int[]{28, 30, 39});
        lands[32] = new Land(32, "German Reich", new int[]{30, 33, 35, 36, 37});
        lands[33] = new Land(33, "German Reich", new int[]{32, 37});
        lands[34] = new Land(34, "German Reich", new int[]{17, 29, 30, 35});
        lands[35] = new Land(35, "German Reich", new int[]{30, 32, 34, 36, 38});
        lands[36] = new Land(36, "German Reich", new int[]{32, 35, 37, 38});
        lands[37] = new Land(37, "German Reich", new int[]{1, 32, 33, 36, 38});
        lands[38] = new Land(38, "German Reich", new int[]{35, 36, 37});
        lands[39] = new Land(39, "German Reich", new int[]{31, 40, 41});
        lands[40] = new Land(42, "German Reich", new int[]{39, 42});
        lands[41] = new Land(41, "German Reich", new int[]{39, 42});
        lands[42] = new Land(42, "German Reich", new int[]{40, 41});


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

    public void setDefForLands(String country) {
        for (Land a : lands
        ) {
            if (a.getOwnerName().equals(country)) {
                a.setDefensePoints(control.getPlayer(country));
            }
        }
    }

    public void setDefensePoints(int landNo) {
        if (lands[landNo].isOwnedByPlayer())
            lands[landNo].setDefensePoints(control.getPlayer(lands[landNo].getOwnerName()));
    }

    public float getDefensePointsAt(int landNo) {
        return lands[landNo].getDefensePoints();
    }
}