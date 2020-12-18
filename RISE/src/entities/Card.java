package entities;
import javafx.scene.image.Image;

public class Card {
    private String landName;
    private String troopName;
    private int landNo;
    private Image image;

    public Card(String landName, String troopName, int landNo, Image image){
        this.landName = landName;
        this.troopName = troopName;
        this.landNo = landNo;
        this.image = image;
    }

    public String getName(){
        return landName;
    }
    public String getTroopType(){
        return troopName;
    }
    public int getLandNo(){
        return landNo;
    }
    public boolean equalsTroop(Card card){
        if(card.troopName == this.troopName)
            return true;
        else return false;
    }
    public boolean equalsLand(Card card){
        if(card.landName == this.troopName)
            return true;
        else return false;
    }
}
