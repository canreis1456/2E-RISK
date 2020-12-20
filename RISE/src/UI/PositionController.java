package UI;

import entities.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import javax.swing.text.html.ImageView;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class PositionController {

    @FXML
    Text artillery, infantry, tank, nerds, warning;


    @FXML
    TextField Artil, Infan, TankA, Nerd;

    int art, inf, tnk, nrd;
    PositionInterface upperClass;
    ConvertInterface lowerClass;

    public PositionController(){
        Artil = new TextField();
        Infan = new TextField();
        TankA = new TextField();
        Nerd = new TextField();
        artillery = new Text();
        infantry = new Text();
        tank = new Text();
        nerds = new Text();
        warning = new Text();
    }

    public void setUpperClass(PositionInterface upperClass) {
        this.upperClass = upperClass;
    }

    public void setLowerClass(ConvertInterface upperClass) {
        this.lowerClass = lowerClass;
    }

    public void positioning(ActionEvent e) throws IOException {
        if(art > parseInt(artillery.getText()) || inf > parseInt(infantry.getText()) || tnk > parseInt(tank.getText()) || nrd > parseInt(nerds.getText()))
            warning.setText("Insufficient Troop");
        else {
            upperClass.setAmounts(art, inf, tnk, nrd);
            upperClass.stag.close();
            upperClass.getPlay().setInfoDisable(false);
            upperClass.positionMap();
        }
    }

    public void getAmounts(){
        Artil.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    Artil.setText(newValue.replaceAll("[^\\d]", ""));
                }
                art = parseInt(Artil.getText());
            }
        });
        Infan.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    Infan.setText(newValue.replaceAll("[^\\d]", ""));
                }
                inf = parseInt(Infan.getText());
            }
        });
        TankA.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    TankA.setText(newValue.replaceAll("[^\\d]", ""));
                    //    tnk = parseInt(TankA.getText());
                }
                tnk = parseInt(TankA.getText());
            }
        });
        Nerd.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    Nerd.setText(newValue.replaceAll("[^\\d]", ""));
                    //     nrd = parseInt(Nerd.getText());
                }
                nrd = parseInt(Nerd.getText());
            }
        });
    }


    public void setTexts(Player player){
        artillery.setText(player.troopsAtHand(0) + "");
        infantry.setText(player.troopsAtHand(1) + "");
        tank.setText(player.troopsAtHand(2) + "");
        nerds.setText(player.troopsAtHand(3) + "");
    }

    public void clicked(MouseEvent e) throws IOException {
        System.out.println(((Node) e.getSource()).getAccessibleText());
        if(upperClass.getPlay().getControl().getLands().getLand(parseInt(((Node) e.getSource()).getAccessibleText())).getOwnerName().equals(upperClass.getPlay().players[upperClass.getPlay().turnIndex].getCountry())) {
            upperClass.positionTroop(parseInt(((Node) e.getSource()).getAccessibleText()));
            upperClass.setMap();
        }
        /* if(this.getPlay() != null && this.getPlay().getControl().getLands().getLand(landNoFrom).hasBorder(parseInt(((Node) e.getSource()).getAccessibleText()))) {
            // relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 0, artil);
            relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 1, inf);
            // relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 0, artil);
            //  relocateTroop(this.getPlay(), landNoFrom, parseInt(((Node) e.getSource()).getAccessibleText()), 0, artil);
            System.out.println(getPlay().getTurnIndex() + "  " + ((Node) e.getSource()).getAccessibleText());
            this.getPlay().setMap();
        }*/
    }

    public void convertShow(Event e) throws IOException {
        lowerClass = new ConvertInterface(upperClass.getPlay());
        lowerClass.show();
        lowerClass.setAmounts(art, inf, tnk, nrd);
        lowerClass.control.setSuperClass(upperClass);
        lowerClass.setResourceBox((art*9 + inf*3 + tnk*9 + nrd));
        upperClass.stag.close();
    }


}
