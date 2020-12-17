package UI;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Board{

    String currentDir;
   public Board(){

   }

   public Pane show(GamePlay a) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Map.fxml"));
       Pane root = (Pane) loader.load();
       return root;
   }
   public void clicked(Event e){
       System.out.print("001");
   }
    public void clicke(Event e){
        System.out.print("002");
    }
}
