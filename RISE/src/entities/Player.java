package entities;


import entities.Troops.*;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Player {
    private String countryName, leader, name;
    private Country country;
    private ArrayList<ArrayList<Troop>> troops = new ArrayList<>();
    private float[] trpInstance;
    private String[] trpnms;
    private ArrayList<Card> cards = new ArrayList<>();
    private Research res;
    private ResearchTree.Node current;
    private ResearchTree tree;
    private int resourceBuff;
    private General selectedGeneral;
    private int troopNumber, turnCount, researchBuff, setsTraded;
    private boolean researching, defeated;
    int landCount;
    private Card defaultCard;
    private File currentDirFile;
    String currentDir;



    public Player(String countr, String leade, String name) throws FileNotFoundException {
        trpnms = new String[]{"Artillery", "Infantry", "Tank", "Nerds"};
        trpInstance = new float[8];
        countryName = countr;
        leader = leade;
        this.name = name;
        turnCount = 0;
        researchBuff = 0;
        setsTraded = 0;
        defeated = false;

        currentDirFile = new File("");
        currentDir = currentDirFile.getAbsolutePath();
        defaultCard = new Card("", "", -1, new Image(new FileInputStream(currentDir + "\\src\\UI\\ProjeResimler\\blank.png")));
        if(countr.equals("German Reich")) {
            country = new Country(new GermanyInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        } else if(countr.equals("Soviet Union")){
            country = new Country(new SovietInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        } else if(countr.equals("France")){
            country = new Country(new FranceInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        } else if(countr.equals("Italy")){
            country = new Country(new ItalyInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        } else if(countr.equals("Japan")){
            country = new Country(new JapanInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        } else if(countr.equals("United Kingdom")){
            country = new Country(new UKInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        } else if(countr.equals("China")) {
            country = new Country(new ChinaInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        } else if(countr.equals("Turkey")){
            country = new Country(new TurkeyInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        }
        else if (countr.equals("USA")){
            country = new Country(new USAInitializer(), leader);
            country.initializeTroops(troops);
            setTroopTypePoints();
            landCount = country.initializeLandCount(landCount);
        }
        tree = new ResearchTree();
        current = tree.getHead();
        researching = false;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    public void setLandCount(int landCount) {
        this.landCount = landCount;
    }

    public int getLandCount() {
        return landCount;
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

    public boolean isResearching() {
        return researching;
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
            trpInstance[0] = troops.get(0).get(0).getAttack();
            trpInstance[1] = troops.get(0).get(0).getDefense();
            trpInstance[2] = troops.get(1).get(0).getAttack();
            trpInstance[3] = troops.get(1).get(0).getDefense();
            trpInstance[4] = troops.get(2).get(0).getAttack();
            trpInstance[5] = troops.get(2).get(0).getDefense();
            trpInstance[6] = troops.get(3).get(0).getAttack();
            trpInstance[7] = troops.get(3).get(0).getDefense();
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


    public float attackPointsAt(int coordinates, String enemy){
        float attack = 0;
            for (int j = 0; j < 4; j++) {
            for (int i = 0; i < troops.get(j).size(); i++) {
                if (troops.get(j).get(i).getPosition() == coordinates) {
                    attack += troops.get(j).get(i).getAttack();
                    System.out.println("aatt " + attack);
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            if (selectedGeneral != null)
            attack += selectedGeneral.attackEffectOnCertainUnit(troops, i, coordinates);
        }
        return attack;
    }

    public String getGeneral(){
        if(selectedGeneral != null)
        return selectedGeneral.name;
        else
            return "";
    }

    public void removeTroopFromLand(int[] troops, int landNo){
        removeTroopTypeFromLand(0, landNo, troops[0]);
        removeTroopTypeFromLand(1, landNo, troops[1]);
        removeTroopTypeFromLand(2, landNo, troops[2]);
        removeTroopTypeFromLand(3, landNo, troops[3]);
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
        float attack = this.attackPointsAt(attackingland,enemy.getCountry());
        System.out.println("attack : " + attack);
        return attack > def;
    }

    public boolean attackingToBot(int attackingLand, String enemy){
        float def = 30;
        System.out.println("defens:  " + def);
        float attack = this.attackPointsAt(attackingLand, enemy);
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
            if(a.getPosition() == landNoFrom && count < amount) {
                a.setPosition(landNoTo);
                System.out.println(count + "   ::   " + a.getPosition() + "   " + a.getType());
                count++;
            }
        }
    }

    public int removeTroopTypeFromLand(int unitType, int landNo, int amount){
        int count = 0;
        System.out.println("amount: " + amount);
        int index;
        boolean flag = false;
        for (int i = 0; i < amount; i++){
            if (troops.get(unitType).get(i).getPosition() == landNo){
                flag = true;
                count++;
            }
            if (flag) {
                troops.get(unitType).remove(i);
                System.out.println("size " + troops.get(unitType).size());
                i--;
                flag = false;
            }

            if (count >= amount)
                break;
        }
        return troops.get(unitType).size();
    }

    public int getTroopTypeAtLandInt(int unitType, int landNo){
        int count = 0;
        for (Troop a: troops.get(unitType)
        ) {
            if(a.getPosition() == landNo)
                count++;
        }
        return count;
    }

    public String getTroopTypeAtLand(int unitType, int landNo){
        String result ="";
        int count = 0;
        for (Troop a: troops.get(unitType)
             ) {
            if(a.getPosition() == landNo)
                count++;
        }
        return troops.get(unitType).get(0).getType() + " :  "  + count+ "\n" + troops.get(unitType).get(0).getAttack() + " " + troops.get(unitType).get(0).getDefense() + "\n";
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
    public ArrayList<Card> tradeCards(ArrayList <Card> cardRem){
        ArrayList<Card> toBoard = new ArrayList<Card>();
        for(int j = 0; j < cardRem.size(); j++){
            for(int i = 0; i < cards.size(); i++){
                if(cards.get(i).getSelected() == true){
                    toBoard.add(cards.remove(i));
                    break;
                }
            }
        }

        System.out.println("New cards size = " + cards.size());
        return toBoard;
    }

    public void addCard(Card card){
            cards.add(card);
    }

    public String getGeneralInfo(String s){

        for (General g: country.generals) {
            if (g.getName().equals(s)) {
                String a = "Attack Buffs \n Artillery = " + g.attackBuffers[0] + " \n Infantry = " + g.attackBuffers[1] + "\n Tanks = " + g.attackBuffers[2] + "\n Nerds = " + g.attackBuffers[3]
                        + "\nDefense Buffs \n Artillery = " + g.defenseBuffers[0] + " \n Infantry = " + g.defenseBuffers[1] + "\n Tanks = " + g.defenseBuffers[2] + "\n Nerds = " + g.defenseBuffers[3]
                        + "\nAgression = ";
                if (g.getAggresion() != null) {
                     a = a + g.getAggresion() + "\n Attack = " + g.aggresionAttack + "\n Defence = " + g.aggresionDef;
                }
                return a;
            }

        }
     return "";
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public Card getCard( int index){
        return cards.get(index);
    }

    public Card getDefaultCard(){
        return defaultCard;
    }

    public void turnEndAdd(){
        int infNumber;
        infNumber = 2 * landCount + resourceBuff;
        int artNumber;
        artNumber = 2 * landCount + resourceBuff;
        int tankNumber;
        tankNumber = 2 * landCount + resourceBuff;
        int nerdNumber;
        nerdNumber = 2 * landCount + resourceBuff;
        for(int i = 0; i < artNumber; i++){
            troops.get(0).add(new Artillery());
            troops.get(0).get(troops.get(0).size() - 1).setAttack(trpInstance[0]);
            troops.get(0).get(troops.get(0).size() - 1).setAttack(trpInstance[1]);
        }

        for(int i = 0; i < infNumber; i++){
            troops.get(1).add(new Infantry());
            troops.get(1).get(troops.get(1).size() - 1).setAttack(trpInstance[2]);
            troops.get(1).get(troops.get(1).size() - 1).setAttack(trpInstance[3]);
        }

        for(int i = 0; i < tankNumber; i++){
            troops.get(2).add(new Tank());
            troops.get(2).get(troops.get(2).size() - 1).setAttack(trpInstance[4]);
            troops.get(2).get(troops.get(2).size() - 1).setAttack(trpInstance[5]);
        }

        for(int i = 0; i < nerdNumber; i++){
            troops.get(3).add(new Nerds());
            troops.get(3).get(troops.get(3).size() - 1).setAttack(trpInstance[6]);
            troops.get(3).get(troops.get(3).size() - 1).setAttack(trpInstance[7]);
        }

    }
}
