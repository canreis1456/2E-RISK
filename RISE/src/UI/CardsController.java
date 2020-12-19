package UI;
import entities.Card;
import entities.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CardsController {
    @FXML
    ImageView imageV;
    @FXML
    Button selectCard;
    @FXML
    Button endTrade;
    Player player;
    Image image;
    @FXML
    ComboBox<Card> cards;
    CardsInterface upperClass;
    File currentDirFile = new File("");
    String currentDir;
    int tempIndex;
    Card selected;
    Card defaultCard;
    ArrayList<Card> tempTrade;
    int tempTradeIndex;
    ObservableList<Card> cardsList;
    public CardsController() throws FileNotFoundException {
        selectCard = new Button();
        endTrade = new Button();
        imageV = new ImageView();
        tempTrade = new ArrayList<Card>();
        cards = new ComboBox<Card>();
        currentDir = currentDirFile.getAbsolutePath();
        selected = new Card();
        defaultCard = new Card();
        tempIndex = 0;
        tempTradeIndex = 0;
        //image = new Image(new FileInputStream(currentDir + "\\src\\UI\\ProjeResimler\\interruption.png"));
       // C:\Users\Poseidon\IdeaProjects\2E-RISK\RISE\src\UI\ProjeResimler
    }

    public void setCards(){


        cardsList = FXCollections.observableArrayList();
        System.out.println("The card size = " + player.getCards().size());
        for(int i = 0; i < player.getCards().size(); i++){
            cardsList.add(player.getCard(i));
        }

        cards.setItems(cardsList);
        cards.setOnAction((event) -> {

            int selectedIndex = cards.getSelectionModel().getSelectedIndex();
            //Card selectedItem = cards.getSelectionModel().getSelectedItem();

            Card selectedItem = cards.getSelectionModel().getSelectedItem();
            if(selectedItem == null)
                selectedItem = player.getDefaultCard();
            setSelected(selectedItem);

            image = selected.getImage();

            imageV.setImage(image);

        });
        selectCard.setOnAction((event) -> {
            System.out.println("Select Card pressed");
            if(!selected.getTroopType().equals("") && !selected.getSelected()){
                selected.setSelected(true);
                tempTrade.add(selected);
                tempTradeIndex = setVal(tempTradeIndex);
                System.out.println("Temptradeindex is " + tempTradeIndex);
                System.out.println("Troop Type = " + selected.getTroopType() + " and landNo = " + selected.getLandNo());
                System.out.println(tempTrade.size());
            }
            else if (selected.getSelected()){
                   System.out.println("This card was already chosen. Choose a new one");
            }
            else
                System.out.println("No card has been chosen");
        });
        endTrade.setOnAction((event) -> {
            System.out.println("End Trade Pressed");
            boolean flag = true;
            if(tempTrade.size() == 3){
                for(int i = 0; i < tempTrade.size() - 1; i++){
                    if(!(tempTrade.get(i).equalsLand(tempTrade.get(i + 1)) && tempTrade.get(i).equalsTroop(tempTrade.get(i + 1)))){
                        for(int j = 0; j < tempTrade.size(); j++){
                            tempTrade.get(j).setSelected(false);
                        }
                        for(int j = 0; j < tempTrade.size(); j++)
                            System.out.println("HAH Troop type = " + tempTrade.get(j).getTroopType() + " selected flag = "  + tempTrade.get(j).getSelected());
                        flag = false;
                        System.out.println("flag deemed false");
                        tempTrade.clear();
                    }
                }
                if(flag){
                    //selected = player.getDefaultCard();
                    //image = selected.getImage();
                    for(int i = 0; i < tempTrade.size(); i++)
                        System.out.println("Troop type = " + tempTrade.get(i).getTroopType() + " selected flag = "  + tempTrade.get(i).getSelected());
                    player.tradeCards(tempTrade);
                    cardsList.removeAll();
                    cards.getItems().clear();
                    for(int i = 0; i < player.getCards().size(); i++){
                        cardsList.add(player.getCard(i));
                    }
                    cards.setItems(cardsList);
                    tempTrade.clear();

                }
                else{
                    System.out.println("Invalid cards to trade");
                    //tempTrade.clear();
                }
            }
            else
                System.out.println("Not enough cards to trade");
        });
    }

    public int setVal( int val){
        if(val == 2)
            return 0;
        else
           return ++val;
    }

    public void setSelected(Card selected){
        this.selected = selected;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setUpperClass(CardsInterface classInterface){
        this.upperClass = classInterface;
    }
}
