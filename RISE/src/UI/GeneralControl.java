package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.*;

import static java.lang.Integer.parseInt;

public class GeneralControl {

    @FXML
    TextArea infoBox;
    @FXML
    Button gen1;
    @FXML
    Button gen2;
    @FXML
    Button gen3, selectGen;
    String id;
    GeneralInterface upperClass;
    public GeneralControl(){
        infoBox = new TextArea();
    }

    public void setUpperClass(GeneralInterface upperClass) {
        this.upperClass = upperClass;
    }

    public void setInfoBox(Event e) {
        id = "";
        String full = e.getSource().toString();
        for (int i = 35; i < full.length(); i++) {
            if(full.charAt(i) == '\'' )
                break;
            id += full.charAt(i);
        }
    infoBox.setText(upperClass.getPlay().getControl().getPlayers()[upperClass.getPlay().turnIndex].getGeneralInfo(id));

    }
    public void setGeneral(Event e){
        upperClass.getPlay().getControl().getPlayers()[upperClass.getPlay().turnIndex].selectGeneral(id);
    }
}
