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

    Land land;
    LandInterface control;
    Pane root;

    int artil, inf, tnk, nrd;
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

    public void setTexts(Land land) {
        Artillery.setText(land.getArtilleryAmount() + " ");
        Infantry.setText(land.getInfantryAmount() + " ");
        Tank.setText(land.getTankAmount() + " ");
        Nerds.setText(land.getNerdsAmount() + " ");
        DefensePoints.setText(land.getDefensePoints() + " ");
        System.out.println(land.isOwnedByPlayer());
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

    public void show(Land land, Board board) throws IOException {
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
        relocate.setAlignment(Pos.BOTTOM_CENTER);
        control = loader.<LandInterface>getController();
        control.setBoard(board);
        control.setTexts(land);
        control.textFields(true);

        relocate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                control.textFields(false);
                apply.setDisable(false);
                control.getAmounts(artil, inf, tnk, nrd);
            }
        });

        apply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.getPlay().setInfoDisable(false);
                System.out.println("a: " + artil + " i: " + inf + " t: " + tnk + " n: " + nrd);
                try {
                    board.getPlay().relocateMap(board.relocateMap());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
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

    public void getAmounts(int arti, int inf, int tnk, int nrd) {
        final int[] artil = new int[4];
        Artil.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    Artil.setText(newValue.replaceAll("[^\\d]", ""));
                        artil[0] = parseInt(Artil.getText());
                }
            }
        });
        Infan.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    Infan.setText(newValue.replaceAll("[^\\d]", ""));
                    artil[1] = parseInt(Infan.getText());
                }
            }
        });
        TankA.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    TankA.setText(newValue.replaceAll("[^\\d]", ""));
                //    tnk = parseInt(TankA.getText());
                }
            }
        });
        Nerd.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    Nerd.setText(newValue.replaceAll("[^\\d]", ""));
               //     nrd = parseInt(Nerd.getText());
                }
            }
        });
        System.out.println(artil[0]);
        arti = artil[0];
    }
    public void relocated() throws IOException {

    }
}
