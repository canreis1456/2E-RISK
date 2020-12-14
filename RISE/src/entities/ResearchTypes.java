package entities;


import entities.Troops.Troop;

import java.util.ArrayList;

interface ResearchTypes {
    void researchBuff(Research res, Player player);
}

class TroopResearch implements ResearchTypes{

    int[] unitType;
    /*int def, atck;

   /* public TroopResearch(int def, int atck, int[] unitType){
        this.def = def;
        this.atck = atck;
        this.unitType = unitType;
    }*/

    public void researchBuff(Research res, Player player){
        unitType = res.getUnitType();
        for (int i = 0; i < unitType.length; i++){
            for (Troop a: player.getTroops().get(i)) {
                a.setDefense(a.getDefense() + res.getPointBufferDefense());
                a.setAttack(a.getAttack() + res.getPointBufferAttack());
            }
        }
    }
}

class ResearchTurnResearch implements ResearchTypes{


    public void researchBuff( Research res, Player player) {
        ;
    }
}

class ResourceResearch implements ResearchTypes{


    public void researchBuff( Research res, Player player) {
        player.setResourceBuff(player.getResourceBuff() + res.resource);
        System.out.println(player.getResourceBuff());
    }
}