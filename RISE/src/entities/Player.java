package entities;

import entities.Countries.*;
import entities.Troop.Troop;

import java.util.ArrayList;

public class Player {
    String countryName, leader, name;
    Country country;
    ArrayList<ArrayList<Troop>> troops = new ArrayList<>();
//    int attackingland;
    General selectedGeneral;
    int troopNumber;

    public Player(String countr, String leade, String name){
        countryName = countr;
        leader = leade;
        this.name = name;
        if(countr.equals("German Reich")) {
            country = new Germany(leader);
            country.initializeTroops(troops);
            troopNumber = country.getTroopNumber();
            setTroopTypePoints();
        } else if(countr.equals("Soviet Union")){
            country = new SovietUnion(leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr == "France"){
            country = new France(leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr == "Italy"){
            country = new Italy(leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr == "Japan"){
            country = new Japan(leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr == "United Kingdom"){
            country = new UnitedKingdom(leader);
            country.initializeTroops(troops);
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
        for(int i = 0; i < country.getInUse().getHowManyUnitType(); i++){
            for(int j = 0; j < troops.get(country.getInUse().getWhichUnits()[i]).size(); j++){
                troops.get(country.getInUse().getWhichUnits()[i]).get(j).setAttack(troops.get(country.getInUse().getWhichUnits()[i]).get(j).getAttack() + country.getInUse().getBufferAtack());
                troops.get(country.getInUse().getWhichUnits()[i]).get(j).setDefense(troops.get(country.getInUse().getWhichUnits()[i]).get(j).getDefense() + country.getInUse().getBufferDefense());
            }
        }

    }

    public  void printTroops(){
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < troops.get(j).size(); i++) {
                System.out.println(troops.get(j).get(i).getType() + ":   " + troops.get(j).get(i).getAttack());
            }
        }
    }

    public float attackPointsAt(int coordinates){
        float attack = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < troops.get(j).size(); i++) {
                if (troops.get(j).get(i).getPosition() == coordinates)
                    attack += troops.get(j).get(i).getAttack();
            }
        }
        for(int i = 0; i < 4; i++) {
            attack += selectedGeneral.attackEffectOnCertainUnit(troops, i, coordinates);
        }
        return attack;
    }

    public float defensePointsAt(int coordinates){
        float def = 0;
        for(int j = 0; j < 4; j++) {
            for (int i = 0; i < troops.get(j).size(); i++) {
                if (troops.get(j).get(i).getPosition() == coordinates)
                    def += troops.get(j).get(i).getDefense();
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
       // System.out.println("enemyName: " + enemy + " attackingland:  " + attackingland+ "  selectedGeneral: "+ selectedGeneral.getName());
        return selectedGeneral.againstCountryDefense(enemy,troops, attackingland);
    }

    public float generalAggressionAttackEffect(String enemy, int attackingland){
       // System.out.println("enemyName: " + enemy + " attackingland:  " + attackingland+ "  selectedGeneral: "+ selectedGeneral.getName());
        return selectedGeneral.againstCountryAttack(enemy,troops, attackingland);
    }

    public boolean attackingTo(Player enemy, int attackingland) {
        float def = enemy.defensePointsAt(attackingland) + enemy.generalAggressionDefenseEffect(this.getCountry(), attackingland);
        System.out.println("defens:  " + def);
        float attack = this.attackPointsAt(attackingland) + this.generalAggressionAttackEffect(enemy.getCountry(), attackingland);
        System.out.println("attack : " + attack);
        return attack > def;
    }

    public void print(){
        System.out.println(name + "\n"  +  countryName+ " : "+ country.getInUse().getName() + "\n" + troopNumber + "   " + country.getIdeology());
        for (int i = 0 ; i < 4 ; i++) {
            System.out.println(troops.get(i).get(0).getType());
            System.out.println(troops.get(i).get(0).getAttack() + " " + troops.get(i).get(0).getDefense());
        }
    }

    public String toString(){
        String result = name;  //+ "\n"  +  countryName+ " : "+ country.getInUse().getName() + "\n" + troopNumber + "   " + country.getIdeology();
      //  for (int i = 0; i< 4; i++)
        //    result += "\n " + troops.get(i).get(0).getType() + "\n " + troops.get(i).get(0).getAttack() + " " + troops.get(i).get(0).getDefense();
        return  result;
    }

}
