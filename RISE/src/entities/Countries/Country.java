package entities.Countries;

import entities.Troop.Troop;

public abstract class Country implements BonusEffects {
    String name;
    String ideology;
    String generals[];
    Leader inUse;
    General inUseForBattle;

    int troopNumber;

    float pointBufferDefense;
    float getPointBufferAttack;
    float researchTurnAmmount;

    public General selectGeneral(String name){ return inUseForBattle; }

    public Leader getInUse() {
        return inUse;
    }

    public String getName(){
        return name;
    }

    public String getIdeology(){
        return ideology;
    }

    public Troop[][] initializeTroops(Troop troops[][]){
        return troops;
    }

    public int getTroopNumber() {
        return troopNumber;
    }
}
