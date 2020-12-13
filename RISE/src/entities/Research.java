package entities;

import entities.Troops.Troop;

import java.util.ArrayList;

public class Research{

    //String name, aggressionCountry, aggressionIdeology;
    String name;
    int cost, remaining;
    boolean available;
    ResearchTypes type;

    public Research(String name, ResearchTypes type, int cost){
        this.name = name;
        this.type = type;
        this.cost = cost;
        available = false;
    }

   /* public void setAggressionCountry(String aggressionCountry, float[] atck, float[] def) {
        this.aggressionCountry = aggressionCountry;
        aggressionAttack = atck;
        aggressionDefense = def;
    }*/

    public boolean startResearch(){
        System.out.println("55436");
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


    public void turnCounter(ArrayList<ArrayList<Troop>> troops){
        if(remaining > 0)
            remaining--;
        else {
            researchDone(troops);
            System.out.println("ıgıgı");

        }
    }

    public void setTroopTypePoints(ArrayList<ArrayList<Troop>> troops){
       /* for(int i = 0; i < 4; i++){
            for(int j = 0; j < troops.get(i).size(); j++){
                troops.get(i).get(j).setAttack(troops.get(i).get(j).getAttack() + pointBufferAttack[i]);
                troops.get(i).get(j).setDefense(troops.get(i).get(j).getDefense() + pointBufferDefense[i]);
            }
        }*/
        type.setTroopTypePoints(troops);
    }

   /*public float[] getPointBufferAttack() {
        return pointBufferAttack;
    }

    public float[] getPointBufferDefense() {
        return pointBufferDefense;
    }

    public float getResearchTurnAmmount() {
        return researchTurnAmmount;
    }*/
}
