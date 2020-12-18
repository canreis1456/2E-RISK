package entities;

import entities.Troops.Troop;

import java.util.ArrayList;

public class Research{

    //String name, aggressionCountry, aggressionIdeology;
    int[] unitType;
    String name, text;
    boolean done;
    int cost, remaining, resource;
    boolean available;
    ResearchTypes type;
    float attack, def;
    int turn;

    public Research(String name, ResearchTypes type, int cost, float attack, float def, int turn, int resource,int[] unitType){
        this.unitType = unitType;
        this.name = name;
        this.type = type;
        this.resource = resource;
        this.cost = cost;
        this.attack = attack;
        this.def = def;
        this.turn = turn;
        available = false;
        done = false;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public boolean startResearch(){
     //   System.out.println("55436");
        if(!isAvailable())
            return false;
        else{
            remaining = cost;
            return true;
        }
    }

    public String print(){
        System.out.println("res: " + cost);
        return name + "\n" + text + "\n Cost: " + cost + " turn";
    }

    public boolean isDone() {
        return done;
    }

    public void done() {
        done = true;
    }

    public int getCost() {
        return cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void researchDone(Player player){
        researchBuff(player);
        System.out.println("research: " + name + " is done");
        this.available = false;
    }


    public void turnCounter(Player player){
        if(remaining > 0)
            remaining--;
        else {
            researchDone(player);
            System.out.println("ıgıgı");
        }
    }

    public void researchBuff(Player player){
        type.researchBuff(this, player);
    }

    public void resourceBuff(){

    }

   public float getPointBufferAttack() {
        return attack;
    }

    public float getPointBufferDefense() {
        return def;
    }

    public int getResearchTurnAmmount() {
        return turn;
    }

    public int[] getUnitType() {
        return unitType;
    }
}
