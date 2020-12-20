package entities;
import javafx.scene.image.Image;

public class Card implements java.io.Serializable{
    private String landName;
    private String troopName;
    private int landNo;
    private transient Image image;
    boolean selected;

    public Card(String landName, String troopName, int landNo, Image image){
        this.landName = landName;
        this.troopName = troopName;
        this.landNo = landNo;
        this.image = image;
        selected = false;
    }

    public Card(){
        this.landName = "";
        this.troopName = "";
        this.landNo = 0;
        //this.image = new Image();
        selected = false;
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
        if(card.landNo == this.getLandNo())
            return true;
        else return false;
    }

    public Image getImage(){
        return image;
    }

    public void setSelected(boolean bool){
        selected = bool;
    }

    public boolean getSelected(){
        return selected;
    }
}
