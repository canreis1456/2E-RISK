package UI;

import entities.Land;
import entities.Lands;
import entities.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.GameController;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class LandInterface {

    Lands lands;
    Land land;
    LandInterface control;
    Pane root;

    int artil, inf, tnk, nrd, landNofrom;
    Stage stag;
    Board board;

    Button relocate, apply;

    @FXML
    Text Artillery;
    @FXML
    Text Infantry, Tank, Nerds, DefensePoints, isBot;

    @FXML
    TextField Artil, Infan, TankA, Nerd;

    public LandInterface() throws IOException {
        Artil = new TextField();
        Infan = new TextField();
        TankA = new TextField();
        Nerd = new TextField();
        artil = 0;
        inf = 0;
        tnk = 0;
        nrd = 0;
        stag = new Stage();
    }

    public void setControl() throws IOException {

    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void textFields(boolean flag) {
        Artil.setDisable(flag);
        Infan.setDisable(flag);
        TankA.setDisable(flag);
        Nerd.setDisable(flag);
    }

    public void setTexts(Lands lands, Land land, int landNo) {
        Artillery.setText(land.getArtilleryAmount() + " ");
        Infantry.setText(land.getInfantryAmount() + " ");
        Tank.setText(land.getTankAmount() + " ");
        Nerds.setText(land.getNerdsAmount() + " ");
        lands.setDefensePoints(landNo);
        DefensePoints.setText(land.getDefensePoints() + " ");
        //System.out.println(land.isOwnedByPlayer());
        if (land.isOwnedByPlayer()) {
            isBot.setText(board.getPlay().getControl().getPlayer(land.getOwnerName()).getName());
        } else
            isBot.setText(land.getOwnerName());
    }

    /*public LandInterface(Land land){
        this.land = land;
        stag = new Stage();
        Artillery.setText(land.getArtilleryAmount() + " ");
        Infantry.setText(land.getInfantryAmount() + " ");
        Tank.setText(land.getTankAmount() + " ");
        Nerds.setText(land.getNerdsAmount() + " ");
        DefensePoints.setText(land.getDefensePoints() + " ");
    }*/

    public void show(Lands lands, int landNo,Board board) throws IOException {
        land = lands.getLand(landNo);
        relocate = new Button();
        apply = new Button("Apply");
        apply.setDisable(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/LandUI.fxml"));
        root = (Pane) loader.load();
        BorderPane biggerPane = new BorderPane();

        relocate = new Button("Relocate");
        VBox bottom = new VBox();
        bottom.getChildren().addAll(relocate, apply);
        biggerPane.setCenter(root);
        biggerPane.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
        relocate.setAlignment(Pos.BOTTOM_LEFT);
        control = loader.<LandInterface>getController();
        control.setBoard(board);
        control.setTexts(lands, land, landNo);
        control.textFields(true);
        if (!land.getOwnerName().equals(board.getPlay().getControl().getPlayers()[board.getPlay().turnIndex].getCountry())) {
            relocate.setDisable(true);
        }
        relocate.setOnAction(this::handle);
        board.setLandNoFrom(land.getLandNo());


        apply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(artil > land.getArtilleryAmount() || inf > land.getInfantryAmount() || tnk > land.getTankAmount() || nrd > land.getNerdsAmount())
                    System.out.println("insufficient a: " +  artil + " i : " + inf );
                    else{
                        if(artil > 0 || inf > 0 || tnk > 0 || nrd > 0) {
                            board.getPlay().setInfoDisable(false);
                            board.setRelocate(artil,inf ,tnk, nrd, land.getLandNo());
                            stag.close();
                            try {
                                board.getPlay().relocateMap(board.relocateMap());
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                }
            }
        });
        Scene scene = new Scene(biggerPane);
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }

    public void setInts(int artil){
        this.artil = artil;
    }

    public void getAmounts(LandInterface control) {
        final int[] artil = new int[4];
        Artil.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    Artil.setText(newValue.replaceAll("[^\\d]", ""));
                //    System.out.println(artil[0]);
                }
                artil[0] = parseInt(Artil.getText());
                control.setInts(artil[0]);
            }
        });
        Infan.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    Infan.setText(newValue.replaceAll("[^\\d]", ""));

                }
                artil[1] = parseInt(Infan.getText());
                control.setInf(artil[1]);
            }
        });
        TankA.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    TankA.setText(newValue.replaceAll("[^\\d]", ""));
                //    tnk = parseInt(TankA.getText());
                }
                artil[2] = parseInt(TankA.getText());
                control.setTank(artil[2]);
            }
        });
        Nerd.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    Nerd.setText(newValue.replaceAll("[^\\d]", ""));
               //     nrd = parseInt(Nerd.getText());
                }
                artil[3] = parseInt(Nerd.getText());
                control.setNerd(artil[3]);
            }
        });
    }
    public void relocated() throws IOException {

    }

    public void setInf(int inf) {
        this.inf = inf;
    }

    public void setNerd(int nrd) {
        this.nrd  = nrd;
    }

    public void setTank(int tnk){
        this.tnk = tnk;
    }

    public void handle(ActionEvent e) {
        control.textFields(false);
        apply.setDisable(false);
        control.getAmounts(this);
     //   System.out.println("asd" + this.artil);
    }
}
