package UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ConvertInterface {

    Stage stage;
    GamePlay game;
    ConvertController control;
    Pane pane;
    Scene scene;
    PositionController upperControl;
    int art,inf,tnk,nrd;

    public ConvertInterface(GamePlay a) {
        stage = new Stage();
        game = a;
    }
    public GamePlay getPlay() {
        return game;
    }

    public void show() throws IOException {

        String a = game.getControl().getPlayers()[game.turnIndex].getCountry();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/ConvertUI.fxml"));
//        System.out.println(loader.getController().toString());
        pane = (Pane) loader.load();
        control = loader.getController();
        control.setUpperClass(this);
        control.getAmounts();
        scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }


    public void setAmounts(int art, int inf, int tnk, int nrd) {
        control.artGot = art;
        control.infGot = inf;
        control.tnkGot = tnk;
        control.nrdGot = nrd;
        System.out.println(control.artGot);
        System.out.println(control.infGot);
        System.out.println(control.tnkGot);
        System.out.println(control.nrdGot);
    }

    public void setResourceBox(int a){
        control.setResourceInfoBox(a + "");
    }
}
