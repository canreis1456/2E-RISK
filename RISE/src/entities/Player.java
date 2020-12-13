package entities;


import entities.Troops.Troop;

import java.util.ArrayList;

public class Player {
    String countryName, leader, name;
    Country country;
    ArrayList<ArrayList<Troop>> troops = new ArrayList<>();
    Research res;
//    int attackingland;
    General selectedGeneral;
    int troopNumber, turnCount;

    public Player(String countr, String leade, String name){
        countryName = countr;
        leader = leade;
        this.name = name;
        turnCount = 0;
        if(countr.equals("German Reich")) {
            country = new Country(new GermanyInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr.equals("Soviet Union")){
            country = new Country(new SovietInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr.equals("France")){
            country = new Country(new FranceInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr.equals("Italy")){
            country = new Country(new ItalyInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr.equals("Japan")){
            country = new Country(new JapanInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr.equals("United Kingdom")){
            country = new Country(new UKInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr.equals("China")) {
            country = new Country(new ChinaInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        } else if(countr.equals("Turkey")){
            country = new Country(new TurkeyInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        }
        else if (countr.equals("USA")){
            country = new Country(new USAInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
        }
    }

    public String getCountry() {
        return countryName;
    }

    public Country getCountryObject(){
        return country;
    }

    public String getLeader() {
        return leader;
    }

    public void turnCounter() {
        turnCount++;
        if (res != null) {
            res.turnCounter(troops);
            for (ArrayList<Troop> a:troops
            ) {
                System.out.println(a.get(0).getType() +" \n atck: " + a.get(0).getAttack() + " def: "+ a.get(0).getDefense());
            }
        }
    }

    public void startResearch(){
        res = new Research("ıoıu", new TroopResearch(2,0, new int[]{0, 1}),3 );
        res.setAvailable(true);
        res.startResearch();
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
        String result = name  + "\n"  +  countryName+ " : "+ country.getInUse().getName() + "   " + country.getIdeology() + "\n";
        for (int i = 0; i< 4; i++)
            result += "\n " + troops.get(i).get(0).getType() + "\n " + troops.get(i).get(0).getAttack() + " " + troops.get(i).get(0).getDefense();
        return  result;
    }

}
