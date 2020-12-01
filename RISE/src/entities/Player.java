package entities;

import entities.Countries.Country;
import entities.Countries.Germany;
import entities.Countries.Leader;
import entities.Troop.Troop;

public class Player {
    String countryName, leader, name;
    Country country;
    Troop[] artilleries, tanks, nerds, infantries;
    Troop[][] troops;
    int troopNumber;

    public Player(String countr, String leade, String name){
        countryName = countr;
        leader = leade;
        this.name = name;
        troops = new Troop[4][];
        if(countr == "German Reich")
            country = new Germany(leader);
        country.initializeTroops(troops);
        troopNumber = country.getTroopNumber();
    }

    public String getCountry() {
        return countryName;
    }

    public String getLeader() {
        return leader;
    }

    public float getAttackPoints(){
        return 0;
    }

    //0 - Artillery, 1- Infantry, 2-Tank, 3-Nerds
    public void setTroopTypePoints(){
        for(int i = 0; i < country.getInUse().getHowManyUnitType(); i++)
            for (Troop a: troops[country.getInUse().getWhichUnits()[i]]) {
            a.setAttack(a.getAttack() + country.getInUse().getBufferAtack());
            a.setDefense(a.getDefense() + country.getInUse().getBufferDefense());
        }
    }

    public float attackPointsAt(int[] coordinates){
        float attack = 0;
        for(int i = 0; i < troopNumber; i++ ){
            if(artilleries[i].getPosition()[0] == coordinates[0] && artilleries[i].getPosition()[1] == coordinates[1])
                attack += artilleries[i].getAttack();
        }
        return attack;
    }

    public void print(){
        System.out.println(countryName+ " : "+ country.getInUse().getName() + "\n" + troopNumber + "   " + country.getIdeology());
        for (int i = 0 ; i < 4 ; i++) {
            for (Troop a : troops[i]){
                System.out.println(a.getType());
            System.out.println(a.getAttack() + " " + a.getDefense());
        }
        }
    }

}
