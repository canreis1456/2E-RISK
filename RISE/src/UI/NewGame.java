package UI;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NewGame implements EventHandler {
    Stage stag;
    Button back, select,  germany, italy, france, turkey, soviet, china, japan, ukingdom, usa, lock;
    Button[] countryButtons;
    TextField playerName;
    ComboBox<String> Leaders;
    ImageView backgrond;
    String selection, currentDir;
    ArrayList<String> selectedCountries;
    MenuController upperMenu;
    int playerCount = 0;

    public NewGame(Stage stage, int playerCount, MenuController upper, ArrayList<String> selectedCountries){
        stag = stage;
        this.playerCount = playerCount;
        upperMenu = upper;
        this.selectedCountries = selectedCountries;
    }

    public void show() throws FileNotFoundException {

        VBox center = new VBox();
        VBox right = new VBox();
        //bottom
        HBox bottom = new HBox(100);
        lock = new Button("Ready");
        lock.setOnAction(this::handle);
        lock.setMinSize(40,15);
        lock.setDisable(true);
        back = new Button("< Back");
        back.setOnAction(this::handle);
        back.setMinSize(40,15);
        select = new Button("Select");
        select.setMinSize(40,15);
        select.setDisable(true);
        bottom.setPadding(new Insets(15, 12, 20, 12));
        bottom.setSpacing(10);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        bottom.getChildren().addAll(back);
	


        VBox countries = new VBox();
        countries.setStyle("-fx-background-color: #701515;");
        countries.setPadding(new Insets(15,12,15,12));
        countries.setSpacing(10);
        germany = new Button();
        france = new Button();
        italy = new Button();
        turkey = new Button();
        china = new Button();
        soviet = new Button();
        japan = new Button();
        ukingdom = new Button();
        usa = new Button();
        countryButtons = new Button[]{select ,germany, italy, france, turkey, soviet, china, japan, ukingdom, usa, lock};
        //String dir = FilenameUtils.getFullPathNoEndSeparator(file.getAbsolutePath());
        File currentDirFile = new File("");
        currentDir = currentDirFile.getAbsolutePath();

        Image german = new Image(new FileInputStream(currentDir + "\\src\\images\\flags\\330px-German_Reich.png"));
        Image franc = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\330px-France.png"));
        Image ital = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\Italy.png"));
        Image turk = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\330px-Turkey.png"));
        Image chin = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\China.png"));
        Image soviett = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\330px-Soviet_Union.png"));
        Image japann = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\330px-Japan.png"));
        Image kingdom = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\330px-United_Kingdom.png"));
        Image unitedsa = new Image(new FileInputStream(currentDir +"\\src\\images\\flags\\330px-United_States.png"));
        ImageView germanFlag = new ImageView(german);
        ImageView franceFlag = new ImageView(franc);
        ImageView italyFlag = new ImageView(ital);
        ImageView turkeyFlag = new ImageView(turk);
        ImageView chinaFlag = new ImageView(chin);
        ImageView sovietFlag = new ImageView(soviett);
        ImageView japanFlag = new ImageView(japann);
        ImageView ukFlag = new ImageView(kingdom);
        ImageView usaFlag = new ImageView(unitedsa);
        ImageView[] flags = {germanFlag, franceFlag, italyFlag, turkeyFlag, chinaFlag, sovietFlag, japanFlag, ukFlag, usaFlag};

        for (ImageView i:
             flags) {
            i.setFitHeight(70);
            i.setFitWidth(95);
        }

        germany.setGraphic(germanFlag);
        germany.setText("German Reich");
        italy.setGraphic(italyFlag);
        italy.setText("Italy");
        france.setGraphic(franceFlag);
        france.setText("France");
        turkey.setGraphic(turkeyFlag);
        turkey.setText("Turkey");
        china.setGraphic(chinaFlag);
        china.setText("China");
        soviet.setGraphic(sovietFlag);
        soviet.setText("Soviet Union");
        japan.setGraphic(japanFlag);
        japan.setText("Japan");
        ukingdom.setGraphic(ukFlag);
        ukingdom.setText("UK");
        usa.setGraphic(usaFlag);
        usa.setText("USA");

        String countryButtonCss = "-fx-background-color: #AA520E;\n" +
                "    -fx-border-color: rgb(49, 89, 23);\n" +
                "    ;\n" +
                "    ;\n" +
                "-fx-background-radius: 20;";
        for (Button b :
              countryButtons  ) {
            if(b != select && b != lock) {
                b.setMinSize(200, 70);
                b.getStyleClass().clear();
                b.setStyle(countryButtonCss);
            }
        }

        countries.getChildren().addAll(germany, france, italy, turkey, china, soviet, japan, ukingdom, usa);

        //center countries
        Image parsGermanBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenGermanBefore.png"));
        Image parsItalyBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenItalyBefore.png"));
        Image parsFranceBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenFranceBefore.png"));
        Image parsTurkeyBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenTurkeyBefore.png"));
        Image parsChinaBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenChinaBefore.png"));
        Image parsSovietBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenSovietBefore.png"));
        Image parsJapanBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenJapanBefore.png"));
        Image parsUKBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenUKBefore.png"));
        Image parsUsaBefore = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomenUSABefore.png"));

        Image pars = new Image(new FileInputStream(currentDir + "\\src\\images\\parsomens\\parsomen.png"));
        backgrond = new ImageView(pars);
        backgrond.fitWidthProperty().bind(center.widthProperty());
        backgrond.fitHeightProperty().bind(center.heightProperty());
        center.getChildren().add(backgrond);
        center.setStyle("-fx-background-color: #402030;");

        right.setPadding(new Insets(15,8,15,8));
        right.setMinWidth(200);
        right.setMaxWidth(200);
        Text ledr = new Text("Leader:          General: ");
        playerName = new TextField("Enter PlayerName for Player " + playerCount);

        ObservableList<String> leaders = FXCollections.observableArrayList();
        Leaders = new ComboBox<>();
        Leaders.setItems(leaders);
        Leaders.setPromptText("Select a Leader!");
        right.getChildren().addAll(playerName, Leaders, select, lock);
        Leaders.setMaxWidth(200);

        //German Reich
        germany.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsGermanBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled() && !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Adolf Hitler", "Wilhelm II");
                germany.setDisable(true);
                selection = "German Reich";
            }
        });

        //Soviet
        soviet.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsSovietBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled()&& !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                soviet.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Joseph Stalin", "Leon Trotsky");
                selection = "Soviet Union";
            }
        });

        //Italy
        italy.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsItalyBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled() && !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                italy.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Benito Mussolini", "Ferruccio Parri");
                selection = "Italy";
            }
        });

        //Turkey
        turkey.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsTurkeyBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled()&& !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                turkey.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Ismet Inonu", "Abdulmejid II");
                selection = "Turkey";
            }
        });

        //China
        china.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsChinaBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled()&& !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                china.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Chiang Kai-shek");
                selection = "China";
            }
        });

        //France
        france.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsFranceBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled()&& !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                france.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Charles de Gaulle", "Philippe Pétain");
                selection = "France";
            }
        });

        //Japan
        japan.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsJapanBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled()&& !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                japan.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Hirohito");
                selection = "Japan";
            }
        });

        //UK
        ukingdom.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsUKBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled()&& !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                ukingdom.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Winston Churchill", "Oswald Mosley");
                selection = "United Kingdom";
            }
        });

        //USA
        usa.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                backgrond.setImage(parsUsaBefore);
                for(Button b: countryButtons){
                    if(b.isDisabled()&& !selectedCountries.contains(b.getText()))
                        b.setDisable(false);
                }
                usa.setDisable(true);
                Leaders.getSelectionModel().clearSelection();
                leaders.setAll("Franklin Delano Roosevelt", "Alf London");
                selection = "USA";
            }
        });

        for (Button b: countryButtons) {
            if(selectedCountries.contains(b.getText()))
                b.setDisable(true);
        }


        select.setOnAction(this::handle);

        BorderPane borde = new BorderPane();
        borde.setLeft(countries);
        borde.setBottom(bottom);
        borde.setCenter(center);
        borde.setRight(right);
        Scene scene = new Scene(borde, 1440, 800);
        borde.setStyle("-fx-background-color: #701515;");
        stag.setTitle("RISE");
        stag.setScene(scene);
        stag.show();
    }


    @Override
    public void handle(Event event) {
        if(event.getSource() == back){
            try {
                upperMenu.newGame();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else if(event.getSource() == select){
            try {
                backgrond.setImage( new Image( new FileInputStream(currentDir + "\\src\\images\\parsomens\\" + Leaders.getValue() + ".png")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
	}else if(event.getSource() == lock){
            System.out.println("pl: " +playerCount);
            if(playerCount > 1) {
                upperMenu.countrySelected(selection, Leaders.getValue(), playerName.getText());
                playerCount--;
                try {
                    upperMenu.countrySelection();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("qasd");
                upperMenu.gameplay();
            }
        }
    }
}
