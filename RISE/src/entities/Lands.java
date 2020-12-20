package entities;

import sample.GameController;

import java.util.ArrayList;

public class Lands implements java.io.Serializable{

    Land[] lands;
    GameController control;

    public Lands(GameController control) {
        this.control = control;
        lands = new Land[44];
        lands[0] = new Land(0, "Empty", null, "");
        lands[1] = new Land(1, "UK", new int[]{2, 3, 37},"Alaska");
        lands[2] = new Land(2, "UK", new int[]{1, 3, 4, 6},"Kuzeybatı Bölgesi");
        lands[3] = new Land(3, "USA", new int[]{1, 2, 4, 5, 7},"Alberta ");
        lands[4] = new Land(4, "USA", new int[]{2, 3, 5, 6, 8},"Ontario ");
        lands[5] = new Land(5, "USA", new int[]{4, 6, 8},"Doğu Kanada");
        lands[6] = new Land(6, "UK", new int[]{2, 4, 5, 14},"Grönland ");
        lands[7] = new Land(7, "USA", new int[]{3, 4, 8, 9},"BatıAmerika ");
        lands[8] = new Land(8, "USA", new int[]{4, 5, 7, 9},"DoğuAmerika ");
        lands[9] = new Land(9, "Italy", new int[]{7, 8, 10},"OrtaAmerika ");
        lands[10] = new Land(10, "Italy", new int[]{9, 11, 12},"Venezuala ");
        lands[11] = new Land(11, "Italy", new int[]{10, 12, 21},"Brezilya ");
        lands[12] = new Land(12, "Italy", new int[]{10, 11, 13},"Peru ");
        lands[13] = new Land(13, "Italy", new int[]{11, 12},"Arjantin ");
        lands[14] = new Land(14, "UK", new int[]{6, 15, 16},"İzlanda ");
        lands[15] = new Land(15, "UK", new int[]{14, 16, 18, 20},"BüyükBritanya ");
        lands[16] = new Land(16, "Soviet Union", new int[]{14, 15, 17, 18},"İskandinavya ");
        lands[17] = new Land(17, "Soviet Union", new int[]{16, 18, 19, 34, 29, 27},"Rusya ");
        lands[18] = new Land(18, "German Reich", new int[]{14, 15, 16, 17, 19, 20},"KuzeyAvrupa ");
        lands[19] = new Land(19, "German Reich", new int[]{17, 18, 20, 27},"GüneyAvrupa ");
        lands[20] = new Land(20, "German Reich", new int[]{15, 18, 19, 21},"BatıAvrupa ");
        lands[21] = new Land(21, "German Reich", new int[]{11, 19, 20, 22},"KuzeyAfrika ");
        lands[22] = new Land(22, "Turkey", new int[]{19, 21, 23, 27},"Mısır ");
        lands[23] = new Land(23, "France", new int[]{21, 22, 24, 25, 26},"DoğuAfrika ");
        lands[24] = new Land(24, "France", new int[]{21, 23, 25},"OrtaAfrika ");
        lands[25] = new Land(25, "France", new int[]{23, 26},"GüneyAfrika ");
        lands[26] = new Land(26, "France", new int[]{23, 25},"Madagaskar ");
        lands[27] = new Land(27, "Turkey", new int[]{17, 19, 22, 23, 28, 29},"OrtaDoğu ");
        lands[28] = new Land(28, "Turkey", new int[]{27, 29, 30, 31},"Hindistan ");
        lands[29] = new Land(29, "Turkey", new int[]{17, 27, 28, 30, 34},"Afganistan ");
        lands[30] = new Land(30, "China", new int[]{28, 29, 31, 32, 34, 35},"Çin ");
        lands[31] = new Land(31, "China", new int[]{28, 30, 39},"GüneydoğuAsya ");
        lands[32] = new Land(32, "Japan", new int[]{30, 33, 35, 36, 37},"Moğolistan ");
        lands[33] = new Land(33, "Japan", new int[]{32, 37},"Japonya ");
        lands[34] = new Land(34, "Soviet Union", new int[]{17, 29, 30, 35},"Ural ");
        lands[35] = new Land(35, "Soviet Union", new int[]{30, 32, 34, 36, 38},"Sibirya ");
        lands[36] = new Land(36, "Japan", new int[]{32, 35, 37, 38},"İrkut ");
        lands[37] = new Land(37, "Japan", new int[]{1, 32, 33, 36, 38},"Kamçatka ");
        lands[38] = new Land(38, "Japan", new int[]{35, 36, 37},"Yakut ");
        lands[39] = new Land(39, "Turkey", new int[]{31, 40, 41},"Endonezya ");
        lands[40] = new Land(42, "China", new int[]{39, 42},"YeniGine ");
        lands[41] = new Land(41, "China", new int[]{39, 42},"BatuAvusturalya ");
        lands[42] = new Land(42, "China", new int[]{40, 41},"DoğuAvusturalya ");
        lands[43] = new Land(43, "Empty", null, "attacking");

    }


    public String getLandsByOwner(String owner){
        int count = 0;
        String landsOf = "";
        for (Land a: lands
             ) {
            if (a.getOwnerName().equals(owner)) {
                landsOf += a.getLandName() + "\n";
                count++;
            }
        }
        return landsOf;
    }

    public void getTroopsFromLand(int unitType, int amount, int landNo){
        lands[landNo].setOneTypeTroop(unitType,amount);
    }

    public void removePartiallyFromLand(int landNo, int amount){
        int[] troops = new int[4];
        for (int i = 0; i < 4; i++){
            troops[i] = lands[landNo].getTroopcounts()[i] - amount;
        }
    }

    public void removeTroopFromLand(int landNo){
        int[] troops = new int[]{0,0,0,0};
        lands[landNo].setTroopcounts(troops);
    }

    public void positionTroopOnLand(int unitType, int amount, int landNo) {
        int[] troops = new int[4];
        for (int i = 0; i < 4; i++){
            if(i == unitType)
                troops[unitType] = amount + lands[landNo].getTroopcounts()[unitType];
            else {
                troops[i] = lands[landNo].getTroopcounts()[i];
            }
            System.out.println(i + " landsPositi:  "+ troops[i]);
        }
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