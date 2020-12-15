package entities;

import entities.Troops.Troop;

import java.util.ArrayList;

public class General {
    String name;
    boolean selected;
    String aggresion;
    float[] attackBuffers; //her element hangi unitin atakta ne kadar buff alıcağını gösteriyor, eğer attackBuffers[2] = 3 ise, Tankların atağı 3 artıyor demek
    float[] defenseBuffers; //size = 4
    float researchTurnAmmount;
    float aggresionAttack, aggresionDef;

    public General(String name, float[] atckBuffers, float[] defBuffers, float turn, String aggresion, float aggresionPointDef, float aggresionPointAttack){
        this.name = name;
        attackBuffers = atckBuffers;
        defenseBuffers = defBuffers;
        researchTurnAmmount = turn;
        this.aggresion = aggresion;
        if(aggresion != null){
            aggresionAttack = aggresionPointAttack;
            aggresionDef = aggresionPointDef;
        }
    }

    public void setSelected() {
        selected = true;
    }

    public float[] getAttackBuffers() {
        return attackBuffers;
    }

    public float[] getDefenseBuffers() {
        return defenseBuffers;
    }

    public float getResearchTurnAmmount() {
        return researchTurnAmmount;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getName() {
        return name;
    }

    public void setAggresion(String aggresion) {
        this.aggresion = aggresion;
    }

    public String getAggresion() {
        return aggresion;
    }



    public float againstCountryAttack(String enemy, ArrayList<ArrayList<Troop>> troops, int landNo) {
        float ammountOfPoints = 0;
        if (aggresion != null && aggresion.equals(enemy)) {
            for (int i = 0; i < 4; i++) {
                for (Troop a : troops.get(i)) {
                    if (a.getPosition() == landNo) {
                        ammountOfPoints += aggresionAttack;
                    }
                }
            }
        }
        return ammountOfPoints;
    }

    public float againstCountryDefense(String enemy, ArrayList<ArrayList<Troop>> troops, int landNo) {
        float ammountOfPoints = 0;
        if (aggresion != null && aggresion.equals(enemy)) {
            for (int i = 0; i < 4; i++) {
                for (Troop a : troops.get(i)) {
                    if (a.getPosition() == landNo) {
                        ammountOfPoints += aggresionDef;
                    }
                }
            }
        }
        return ammountOfPoints;
    }

    public float attackEffectOnCertainUnit(ArrayList<ArrayList<Troop>> troops, int unitType, int landNo){
        float attack= 0;
            for (Troop a : troops.get(unitType)) {
                if (a.getPosition() == landNo) {
                    attack += attackBuffers[unitType];
                    System.out.println(attackBuffers[unitType]);
                }
            }
        return attack;
    }

    public float defenseEffectOnCertainUnit(ArrayList<ArrayList<Troop>> troops, int unitType, int landNo){
        float defense = 0;
            for (Troop a : troops.get(unitType)) {
                if (a.getPosition() == landNo) {
                    defense += defenseBuffers[unitType];
                    System.out.println(defenseBuffers[unitType]);
                }
            }
        return defense;
    }
}
