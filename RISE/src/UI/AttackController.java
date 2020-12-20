package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Random;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class AttackController {

    @FXML
    Text attacking, defending, attackPoints, defensePoints, attackingGeneral, defendingGeneral, attackingGN, defendingGN;

    @FXML
    Text pointsBeforeAttack, pointsBeforeDefense, dice1, dice2, totalDefense, totalAttack, attackingCountry, defendingCountry;

    @FXML
    Text declare1, declare2;

    @FXML
    Button roll1, roll2;

    boolean at,df;
    float defenseP, attackP;
    AttackInterface upper;

    public AttackController(){
        attacking = new Text();
        defending = new Text();
    }

    public void setUpper(AttackInterface upper){
        this.upper = upper;
    }

    public void declareWinner() throws IOException {
        System.out.println("att: " + parseFloat(totalAttack.getText()) + "def: " + parseFloat(totalDefense.getText()));
        upper.declareWinner(parseFloat(totalAttack.getText()) > parseFloat(totalDefense.getText()));
        if (parseFloat(totalAttack.getText()) > parseFloat(totalDefense.getText())){
            declare1.setText("Defeat");
            declare2.setText("Victory");
        }else{
            declare1.setText("Victory");
            declare2.setText("Defeat");
        }
        declare1.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-text-fill: #e90805;");
        declare2.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-text-fill: #e90805;");
        declare1.setVisible(true);
        declare2.setVisible(true);

    }

    public void setDefending(String res, String points, String general, String country){
        df = false;
        defendingCountry.setText(country);
        defendingGN.setText(general);
        defending.setText(res);
        defensePoints.setText(points);
    }

    public void setDefendingGeneral(String res){
        defendingGeneral.setText(res);
        float a = parseFloat(defensePoints.getText());
        float b = parseFloat(defendingGeneral.getText());
        defenseP = a+b;
        pointsBeforeDefense.setText("" + (a+b));
    }

    public void setAttackingGeneral(String res){
        attackingGeneral.setText(res);
        float a = parseFloat(attackPoints.getText());
        float b = parseFloat(attackingGeneral.getText());
        attackP = a+b;
        pointsBeforeAttack.setText("" + (a+b));
    }

    public void setAttacking(String res, String points, String general, String country) {
        at = false;
        attackingGN.setText(general);
        attackingCountry.setText(country);
        attacking.setText(res);
        attackPoints.setText(points);
    }


    public void roll1(ActionEvent e) throws IOException {
        Random rand = new Random();
        dice1.setText("" + (rand.nextInt(1)+12));
        roll1.setDisable(true);
        totalDefense.setText((defenseP*parseFloat(dice1.getText())+ ""));
        showD(this);
        System.out.println(" as  " + at);
        if(!at)
            df = true;
        else
            declareWinner();
    }

    public void roll2(ActionEvent e) throws IOException {
        Random rand = new Random();
        dice2.setText("" + (rand.nextInt(2)+2));
        roll2.setDisable(true);
        totalAttack.setText((attackP*parseFloat(dice2.getText()))+ "");
        showA(this);
        System.out.println(" as  " + df);
        if(!df)
            at = true;
        else
            declareWinner();
    }

    public void hide(){
        dice1.setVisible(false);
        dice2.setVisible(false);
        totalDefense.setVisible(false);
        totalAttack.setVisible(false);
        declare1.setVisible(false);
        declare2.setVisible(false);
    }

    public void showD(AttackController controller){
        controller.dice1.setVisible(true);
        controller.totalDefense.setVisible(true);
    }

    public void showA(AttackController controller){
        controller.dice2.setVisible(true);
        controller.totalAttack.setVisible(true);
    }

}
