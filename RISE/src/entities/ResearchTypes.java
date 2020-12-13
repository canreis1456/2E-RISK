package entities;


import entities.Troops.Troop;

import java.util.ArrayList;

interface ResearchTypes {
    void setTroopTypePoints(ArrayList<ArrayList<Troop>> troops);
}

class TroopResearch implements ResearchTypes{

    int def, atck;
    int[] unitType;
    public TroopResearch(int def, int atck, int[] unitType){
        this.def = def;
        this.atck = atck;
        this.unitType = unitType;
    }

    public void setTroopTypePoints(ArrayList<ArrayList<Troop>> troops){
        for (int i = 0; i < unitType.length; i++){
            for (Troop a: troops.get(i)) {
                a.setDefense(a.getDefense() + def);
                a.setAttack(a.getAttack() + atck);
            }
        }
    }
}

class ResearchTurnResearch implements ResearchTypes{

    public void setTroopTypePoints(ArrayList<ArrayList<Troop>> troops) {
        ;
    }
}