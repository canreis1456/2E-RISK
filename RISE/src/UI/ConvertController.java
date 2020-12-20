package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ConvertController {
    @FXML
    Text resourceInfoBox;
    @FXML
    Button convertBut;
    @FXML
    TextField artTextField, infTextField, tankTextField, nerdTextField;
    @FXML
    Text costText, artCost, infCost, tankCost, nerdCost, artText, infText, tankText, nerdText, resourceText, convertAmountText;

    ConvertInterface upperClass;
    PositionInterface superClass;
    int art,inf,tnk,nrd;
    int artGot,infGot,tnkGot,nrdGot;

    public ConvertController(){
        resourceInfoBox = new Text();
        artCost = new Text();
        infCost = new Text();
        tankCost = new Text();
        nerdCost = new Text();
        artText = new Text();
        infText = new Text();
        tankText = new Text();
        nerdText = new Text();
        resourceText = new Text();
        convertAmountText = new Text();
    }

    public void setUpperClass(ConvertInterface upperClass) {
        this.upperClass = upperClass;
    }
    public void setSuperClass(PositionInterface upperClass) {
        this.superClass = superClass;
    }

    public void convertTroop(){

    }

    public void getAmounts(){
        artTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    artTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                art = parseInt(artTextField.getText());
            }
        });
        infTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    infTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                inf = parseInt(infTextField.getText());
            }
        });
        tankTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    tankTextField.setText(newValue.replaceAll("[^\\d]", ""));
                    //    tnk = parseInt(TankA.getText());
                }
                tnk = parseInt(tankTextField.getText());
            }
        });
        nerdTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    nerdTextField.setText(newValue.replaceAll("[^\\d]", ""));
                    //     nrd = parseInt(Nerd.getText());
                }
                nrd = parseInt(nerdTextField.getText());
            }
        });
    }

    public void convert() throws IOException {
        if (((9 * art) + (3 * inf) + (9 * tnk) + (nrd)) > parseFloat(resourceInfoBox.getText()))
            System.out.println("Insufficient Troop");
        else {
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].removeTroopTypeFromLand(0,0,artGot);
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].removeTroopTypeFromLand(1,0,infGot);
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].removeTroopTypeFromLand(2,0,tnkGot);
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].removeTroopTypeFromLand(3,0,nrdGot);
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].addTroop(0, art);
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].addTroop(1, inf);
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].addTroop(2, tnk);
            upperClass.getPlay().players[upperClass.getPlay().turnIndex].addTroop(3, nrd);
            if(((9 * art) + (3 * inf) + (9 * tnk) + (nrd)) < parseFloat(resourceInfoBox.getText())){
                int left = (int) parseFloat(resourceInfoBox.getText()) - ((9 * art) + (3 * inf) + (9 * tnk) + (nrd));
                upperClass.getPlay().players[upperClass.getPlay().turnIndex].addTroop(3, left);
            }
            upperClass.getPlay().updateInfo();
            upperClass.stage.close();
        }

        //superClass.control.setTexts(upperClass.);
    }

    public void setResourceInfoBox(String a){
        resourceInfoBox.setText(a);
    }
}
