package entities.Countries;

public class General implements BonusEffects{
    String name;
    boolean selected;
    int howManyUnitType;
    int whichUnits[];
    float pointBufferDefense;
    float pointBufferAttack;
    float researchTurnAmmount;

    public General(String name, float def, float atck, float turn, int howMany, int whichUnits[]){
        this.name = name;
        pointBufferDefense = def;
        pointBufferAttack = atck;
        researchTurnAmmount = turn;
        howManyUnitType = howMany;
        this.whichUnits = whichUnits;
    }

    public int[] getWhichUnits() {
        return whichUnits;
    }

    public int getHowManyUnitType() {
        return howManyUnitType;
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
}
