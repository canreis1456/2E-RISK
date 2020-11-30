import sample.GameController;

import java.io.FileNotFoundException;

import static javafx.application.Application.launch;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        GameController control = new GameController();
        control.launchApp(args);

    }
}
