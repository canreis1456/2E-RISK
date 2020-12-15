package entities;

public class Leader {
    String ideology;
    String name;
    boolean selected = false;
    int howManyUnitType;
    int whichUnits[];  //Some leaders only effect certain unit types so to indicate this, If a leader only effects artillery,
    //howManyUnitType = 1, whichUnits[] = {0}.   Note that 0-Artillery, 1- Infantry, 2-Tank, 3-Nerds
    float pointBufferDefense;
    float pointBufferAttack;
    float researchTurnAmmount;

    public Leader(String name, String ideology, float def, float atck, float turn, int howMany, int whichUnits[]){
        this.name = name;
        this.ideology = ideology;
        pointBufferAttack = atck;
        pointBufferDefense = def;
        researchTurnAmmount = turn;
        howManyUnitType = howMany;
        this.whichUnits = whichUnits;

    }

    public void setSelected() {
        selected = true;
    }

    public int getHowManyUnitType() {
        return howManyUnitType;
    }

    public int[] getWhichUnits() {
        return whichUnits;
    }

    public boolean isSelected() {
        return selected;
    }



    public String getName(){
        return name;
    }

    public String getIdeology(){
        return ideology;
    }

    public float getBufferAtack(){
        return pointBufferAttack;
    }

    public float getBufferDefense(){
        return pointBufferDefense;
    }

    public float getResearchTurnAmmount(){
        return researchTurnAmmount;
    }
}
