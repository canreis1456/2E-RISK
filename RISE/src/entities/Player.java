package entities;

import entities.Countries.Country;
import entities.Countries.Germany;
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

    public float attackPointsAt(int[] coordinates){
        float attack = 0;
        for(int i = 0; i < troopNumber; i++ ){
            if(artilleries[i].getPosition()[0] == coordinates[0] && artilleries[i].getPosition()[1] == coordinates[1])
                attack += artilleries[i].getAttack();
        }
        return attack;
    }

    public void print(){
        System.out.println(countryName+ " : "+ leader + "\n" + troopNumber + "   " + country.getIdeology());
        for (int i = 0 ; i < troopNumber ; i++){
            System.out.println(troops[0][i].getAttack());
            System.out.println(troops[0][i].getDefense());

        }
    }

}
