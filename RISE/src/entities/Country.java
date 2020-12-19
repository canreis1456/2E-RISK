package entities;

import entities.Troops.*;

import java.util.ArrayList;
import java.util.List;

public class Country{
    String name;
    String ideology;
    Leader inUse;
    List<Leader> leaders;
    List<General> generals;
    General inUseForBattle;
    CountryInitializer strategy;


    public Country(CountryInitializer strategy, String leader){
        this.strategy = strategy;
        initializeGenerals();
        initializeLeaders();
        for (Leader a: leaders) {
            System.out.println(a.getName());
            if(leader.equals(a.getName()))
                inUse = a;
        }
        ideology = inUse.getIdeology();
    }

    int troopNumber;

    float pointBufferDefense;
    float getPointBufferAttack;
    float researchTurnAmmount;

    public Leader getInUse() {
        return inUse;
    }

    public String getName(){
        return name;
    }

    public String getIdeology(){
        return ideology;
    }

    public int getTroopNumber() {
        return troopNumber;
    }

    public ArrayList<ArrayList<Troop>> initializeTroops(ArrayList<ArrayList<Troop>> troops) {

        //  ArrayList<Troop> artill = new ArrayList<>();
        troops.add( 0,new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(0).add( new Artillery());
        }
        troops.add(1, new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(1).add( new Infantry());
        }

        troops.add(2, new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(2).add( new Tank());
        }
        troops.add(3, new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            troops.get(3).add( new Nerds());
        }
        return troops;
    }

    public void initializeGenerals(){
        generals = new ArrayList<General>();
        strategy.initializeGenerals(generals);
        for (General a: generals
             ) {
            System.out.println(a.getName());
        }
    }


    public void initializeLeaders(){
        leaders = new ArrayList<Leader>();
        strategy.initializeLeaders(leaders);
    }

    public General selectGeneral(String name){
        for (General g: generals) {
            if(g.getName().equals(name))
                return g;
        }
        return null;
    }
    public int initializeLandCount(int landCount){
        return strategy.initializeLandCount(landCount);
    }
}
