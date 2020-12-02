package entities.Countries;

import entities.Troop.Troop;

public class General implements BonusEffects{
    String name;
    boolean selected;
    String aggresion;
  //  int howManyUnitType;
  //  int whichUnits[];
    float pointBufferDefense;
    float pointBufferAttack;
    float researchTurnAmmount;

    public General(String name, float def, float atck, float turn, String aggresion){
        this.name = name;
        pointBufferDefense = def;
        pointBufferAttack = atck;
        researchTurnAmmount = turn;
        this.aggresion = aggresion;
    }

    public void setSelected() {
        selected = true;
    }

    public float getPointBufferAttack() {
        return pointBufferAttack;
    }

    public float getPointBufferDefense() {
        return pointBufferDefense;
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

    public String getAggresion() {
        return aggresion;
    }

    public float againstCountryAttack(String enemy, float def, float attack, Troop[][] troops, int landNo) {
        float ammountOfPoints = 0;
        if (aggresion.equals(enemy)) {
            for (int i = 0; i < 4; i++) {
                for (Troop a : troops[i]) {
                    if (a.getPosition() == landNo) {
                        ammountOfPoints += def;
                    }
                }
            }
        }
        return ammountOfPoints;
    }
}
