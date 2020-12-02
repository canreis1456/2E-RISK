package entities.Troop;

public abstract class Troop {
    String type;
    float attack, defense;
    int position;
    int resourceValue;

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public int getResourceValue() {
        return resourceValue;
    }

    public int getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setResourceValue(int resourceValue) {
        this.resourceValue = resourceValue;
    }

    public void setType(String type) {
        this.type = type;
    }
}

