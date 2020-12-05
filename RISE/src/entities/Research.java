package entities;

import entities.Countries.BonusEffects;
import entities.Troop.Troop;

import java.util.ArrayList;

public class Research{

    String name, aggressionCountry, aggressionIdeology;
    float[] pointBufferAttack, pointBufferDefense, aggressionAttack, aggressionDefense;
    float researchTurnAmmount;
    int cost, remaining;
    boolean available;
    public Research(String name, float[] atck, float[] def, float turn, int cost){
        this.name = name;
        pointBufferAttack = atck;
        pointBufferDefense = def;
        researchTurnAmmount = turn;
        this.cost = cost;
        available = false;
    }

    public void setAggressionCountry(String aggressionCountry, float[] atck, float[] def) {
        this.aggressionCountry = aggressionCountry;
        aggressionAttack = atck;
        aggressionDefense = def;
    }

    public boolean startResearch(){
        if(!isAvailable())
            return false;
        else{
            remaining = cost;
            return true;
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void researchDone(ArrayList<ArrayList<Troop>> troops){
        setTroopTypePoints(troops);
        System.out.println("research: " + name + " is done");
    }

    public void setTroopTypePoints(ArrayList<ArrayList<Troop>> troops){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < troops.get(i).size(); j++){
                troops.get(i).get(j).setAttack(troops.get(i).get(j).getAttack() + pointBufferAttack[i]);
                troops.get(i).get(j).setDefense(troops.get(i).get(j).getDefense() + pointBufferDefense[i]);
            }
        }

    }

    public float[] getPointBufferAttack() {
        return pointBufferAttack;
    }

    public float[] getPointBufferDefense() {
        return pointBufferDefense;
    }

    public float getResearchTurnAmmount() {
        return researchTurnAmmount;
    }
}
