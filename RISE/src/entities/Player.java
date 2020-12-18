package entities;


import entities.Troops.Troop;

import java.util.ArrayList;

public class Player {
    private String countryName, leader, name;
    private Country country;
    private ArrayList<ArrayList<Troop>> troops = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();
    private Research res;
    private ResearchTree.Node current;
    private ResearchTree tree;
    private int resourceBuff;
    private General selectedGeneral;
    private int troopNumber, turnCount, researchBuff, setsTraded;
    private boolean researching;

    public Player(String countr, String leade, String name){
        countryName = countr;
        leader = leade;
        this.name = name;
        turnCount = 0;
        researchBuff = 0;
        setsTraded = 0;
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
        tree = new ResearchTree();
        current = tree.getHead();
        researching = false;
    }

    public String getName() {
        return name;
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

    public int getResearchBuff() {
        return researchBuff;
    }

    public void setResearchBuff(int researchBuff) {
        this.researchBuff = researchBuff;
    }

    public void turnCounter() {
        turnCount++;
        if (tree != null && researching) {
            tree.turnCounter(this);
            for (ArrayList<Troop> a:troops
            ) {
                System.out.println(a.get(0).getType() +" \n atck: " + a.get(0).getAttack() + " def: "+ a.get(0).getDefense());
            }
        }
    }

    public ArrayList<ArrayList<Troop>> getTroops() {
        return troops;
    }

    public void startResearch(String name){


        tree.startResearch(name, this);
        researching = true;
    }

    public void setResearching(boolean researching) {
        this.researching = researching;
    }

    public ResearchTree getTree() {
        return tree;
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

    public void setResourceBuff(int resourceBuff) {
        this.resourceBuff = resourceBuff;
    }

    public int getResourceBuff() {
        return resourceBuff;
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
            if (selectedGeneral != null)
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
        for(int i = 0; i < 4; i++) {
             if (selectedGeneral != null)
                def += selectedGeneral.defenseEffectOnCertainUnit(troops, i, coordinates);
        }
        return def;
    }

    public void selectGeneral(String name){//name of general
        selectedGeneral = country.selectGeneral(name);
    }

    public float generalAggressionDefenseEffect(String enemy, int attackingland){
       // System.out.println("enemyName: " + enemy + " attackingland:  " + attackingland+ "  selectedGeneral: "+ selectedGeneral.getName());
        if (selectedGeneral != null)
        return selectedGeneral.againstCountryDefense(enemy,troops, attackingland);
        else
            return 0;
    }

    public float generalAggressionAttackEffect(String enemy, int attackingland){
       // System.out.println("enemyName: " + enemy + " attackingland:  " + attackingland+ "  selectedGeneral: "+ selectedGeneral.getName());
        if (selectedGeneral != null)
        return selectedGeneral.againstCountryAttack(enemy,troops, attackingland);
        else
            return 0;
    }

    public boolean attackingTo(Player enemy, int attackingland) {
        float def = enemy.defensePointsAt(attackingland) + enemy.generalAggressionDefenseEffect(this.getCountry(), attackingland);
        System.out.println("defens:  " + def);
        float attack = this.attackPointsAt(attackingland) + this.generalAggressionAttackEffect(enemy.getCountry(), attackingland);
        System.out.println("attack : " + attack);
        return attack > def;
    }

    public boolean attackingToBot(int attackingLand, String enemy){
        float def = 30;
        System.out.println("defens:  " + def);
        float attack = this.attackPointsAt(attackingLand) + this.generalAggressionAttackEffect(enemy, attackingLand);
        System.out.println("attack : " + attack);
        return attack > def;
    }

    public void positionTroops(int unitType, int amount, int landNo){
        int i = 0;
        for (Troop a :troops.get(unitType)
        ) {
            if(i == amount)
                break;

            if(a.getPosition() == 0) {
                a.setPosition(landNo);
                i++;
            }
        }
    }

    public void relocateTroops(int landNoFrom, int landNoTo, int unitType, int amount){
        int count = 0;
            for (Troop a:troops.get(unitType)
             ) {
                System.out.println("asd" + a.getType() + "  " + a.getPosition());
            if(a.getPosition() == landNoFrom && count < amount) {
                a.setPosition(landNoTo);
                count++;
                System.out.println(count + "   ::   " + a.getPosition() + "   " + a.getType());
            }
        }
    }

    public boolean isEnoughTroop(int unitType, int amount){
        int ammnt = 0;
        for (Troop a :troops.get(unitType)
             ) {
            if(a.getPosition() == 0)
                ammnt++;
        }
        return ammnt >= amount;
    }

    public int troopsAtHand(int unitType){
        int number = 0;
            for ( Troop a: troops.get(unitType)
             ) {
            if(a.getPosition() == 0)
                number++;
        }
            return number;
    }

    public void print(){
        System.out.println(name + "\n"  +  countryName+ " : "+ country.getInUse().getName() + "\n" + troopNumber + "   " + country.getIdeology());
        for (int i = 0 ; i < 4 ; i++) {
            System.out.print(troops.get(i).get(0).getType() + ":  ");
            int count  = 0;
            for (Troop a: troops.get(i)
                 ) {
                if(a.getPosition() == 0)
                    count++;
            }
            System.out.println(count);
            System.out.println(troops.get(i).get(0).getAttack() + " " + troops.get(i).get(0).getDefense() + "  " + troops.get(i).get(0).getPosition());
        }
    }

    public String toString(){
        String result ="Name:  " +  name  + "\n"  +"  " + countryName+ " :  "+ country.getInUse().getName() + " \n   " + country.getIdeology() + "\n";
        for (int i = 0; i< 4; i++)
            result += "\n " + troops.get(i).get(0).getType() +"  :  " + troopsAtHand(i) +"\n " + troops.get(i).get(0).getAttack() + " " + troops.get(i).get(0).getDefense();
        return  result;
    }

    //NOT CORRECTLY IMPLEMENTED!!!!!
    public void tradeCards(Card[] cardRem){
            for(int i = 0; i < cardRem.length; i++){
                for(int j = 0; j < cards.size(); j++){
                    if(cardRem[i].getTroopType() == cards.get(j).getTroopType() && cardRem[i].getLandNo() == cards.get(j).getLandNo()){
                        cards.remove(j);
                    }
                }
            }
    }

    public void addCard(Card card){
            cards.add(card);
    }
}
