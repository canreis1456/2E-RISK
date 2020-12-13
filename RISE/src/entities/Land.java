package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Land extends ImageView {

    int landNo;
    Country owner;

    public Land(int landNo, Country owner, Image img){
        this.setImage(img);
        this.landNo = landNo;
        this.owner = owner;
        this.setAccessibleText(owner.getName());
    }

    public void setOwner(Country owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Land{" +
                "landNo=" + landNo +
                '}' +  "\n" + "owner: " + owner.getName() ;
    }
}
