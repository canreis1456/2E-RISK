package entities.Countries;

public class Leader implements BonusEffects{
    String ideology;
    String name;
    float pointBufferDefense;
    float pointBufferAttack;
    float researchTurnAmmount;

    public Leader(String name, String ideology, float def, float atck, float turn){
        this.name = name;
        this.ideology = ideology;
        pointBufferAttack = atck;
        pointBufferDefense = def;
        researchTurnAmmount = turn;
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
