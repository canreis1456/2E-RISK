package UI;

import entities.Countries.Country;
import entities.Land;
import entities.Player;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Board{

    String currentDir;
   // Land[] lands;

  /*  public Board(){
         lands = new Land[42];
         initLands(lands, );
    }*/

    public void setLand(int landNo, Country owner){
   //     lands[landNo].setOwner(owner);
    }

    public void initLands(Land[] lands, int[] landNo, Player[] players) throws FileNotFoundException {
        File currentDirFile = new File("");
        currentDir = currentDirFile.getAbsolutePath();
        for(int i = 1; i < 5; i++) {
            lands[i] = new Land(i, new Image(new FileInputStream(currentDir + "\\src\\images\\countries\\1 ("+ i + ").png")));
        }
    }

    public Land[] getLands() {
        return lands;
    }

    public Land getLand(int landNo){
        return lands[landNo];
    }
}
