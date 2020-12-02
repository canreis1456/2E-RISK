package entities;

import entities.Countries.Country;
import entities.Countries.General;
import entities.Countries.Germany;
import entities.Countries.Leader;
import entities.Troop.Troop;

public class Player {
    String countryName, leader, name;
    Country country;
    Troop[] artilleries, tanks, nerds, infantries;
    Troop[][] troops;
//    int attackingland;
    General selected;
    int troopNumber;

    public Player(String countr, String leade, String name){
        countryName = countr;
        leader = leade;
        this.name = name;
        troops = new Troop[4][];
        if(countr == "German Reich") {
            country = new Germany(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
        }
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

    public float attackPointsAt(int coordinates){
        float attack = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < troops[j].length; i++) {
                if (troops[j][i].getPosition() == coordinates)
                    attack += troops[j][i].getAttack();
            }
        }
        return attack;
    }

    public float defensePointsAt(int coordinates){
        float def = 0;
        for(int j = 0; j < 4; j++) {
            for (int i = 0; i < troopNumber; i++) {
                if (troops[j][i].getPosition() == coordinates)
                    def += troops[j][i].getDefense();
            }
        }
        return def;
    }

    public void selectGeneral(String name){//name of general
        selected = country.selectGeneral(name);
    }

    public float generalEffect(String enemy, int attackingland){
        System.out.println("enemyName: " + enemy + " attackingland:  " + attackingland+ "  selectedGeneral: "+ selected.getName());
        return selected.againstCountryAttack(enemy, selected.getPointBufferDefense(), selected.getPointBufferAttack(),troops, attackingland);
    }

    public boolean attackingTo(Player enemy, int attackingland){
        float def = enemy.defensePointsAt(attackingland);
        System.out.println("defens:  " + def);
        float attack = attackPointsAt(attackingland);
        System.out.println("attack : " + attack);
        attack += this.generalEffect(enemy.getCountry(), attackingland);
        System.out.println(attack);
        return true;
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
