package entities;

import entities.Countries.Country;
import entities.Countries.General;
import entities.Countries.*;
import entities.Countries.Leader;
import entities.Troop.Troop;

public class Player {
    String countryName, leader, name;
    Country country;
    Troop[] artilleries, tanks, nerds, infantries;
    Troop[][] troops;
//    int attackingland;
    General selectedGeneral;
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
            setTroopTypePoints();
        }
        else if(countr == "Italy") {
            country = new Italy(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        }
        else if(countr == "Japan") {
            country = new Japan(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        }
        else if(countr == "Soviet Union") {
            country = new SovietUnion(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        }
        else if(countr == "France") {
            country = new France(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        }
        else if(countr == "United Kingdom") {
            country = new UnitedKingdom(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        }
        else if(countr == "Turkey") {
            //country = new Turkey(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        }
        else if(countr == "China") {
            //country = new China(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        }
        else {
            country = new UnitedStatesofAmerica(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
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

    public  void printTroops(){
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < troops[j].length; i++) {
                System.out.println(troops[j][i].getType() + ":   " + troops[j][i].getAttack());
            }
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
        for(int i = 0; i < 4; i++) {
            attack += selectedGeneral.attackEffectOnCertainUnit(troops, i, coordinates);
            System.out.println("attackPoints : " + attack);
        }
        return attack;
    }

    public float defensePointsAt(int coordinates){
        float def = 0;
        for(int j = 0; j < 4; j++) {
            for (int i = 0; i < troops[j].length; i++) {
                if (troops[j][i].getPosition() == coordinates)
                    def += troops[j][i].getDefense();
            }
        }
        for(int i = 0; i < 4; i++)
            def += selectedGeneral.defenseEffectOnCertainUnit(troops,i, coordinates);
        return def;
    }

    public void selectGeneral(String name){//name of general
        selectedGeneral = country.selectGeneral(name);
    }

    public float generalAggressionDefenseEffect(String enemy, int attackingland){
        System.out.println("enemyName: " + enemy + " attackingland:  " + attackingland+ "  selectedGeneral: "+ selectedGeneral.getName());
        return selectedGeneral.againstCountryDefense(enemy,troops, attackingland);
    }

    public float generalAggressionAttackEffect(String enemy, int attackingland){
        System.out.println("enemyName: " + enemy + " attackingland:  " + attackingland+ "  selectedGeneral: "+ selectedGeneral.getName());
        return selectedGeneral.againstCountryAttack(enemy,troops, attackingland);
    }

    public boolean attackingTo(Player enemy, int attackingland){
        float def = enemy.defensePointsAt(attackingland) + enemy.generalAggressionDefenseEffect(this.getCountry(), attackingland);
        System.out.println("defff:  " + def);

     //   System.out.println("defens:  " + def);
        float attack = this.attackPointsAt(attackingland) + this.generalAggressionAttackEffect(enemy.getCountry(), attackingland);
        System.out.println("attacjjjjk : " + attack);
        System.out.println(attack);
        if(attack > def)
            return true;
        else
            return false;
    }

    public void print(){
        System.out.println(countryName+ " : "+ country.getInUse().getName() + "\n" + troopNumber + "   " + country.getIdeology());
        for (int i = 0 ; i < 4 ; i++) {
            System.out.println(troops[i][0].getType());
            System.out.println(troops[i][0].getAttack() + " " + troops[i][0].getDefense());
        }
    }

}
