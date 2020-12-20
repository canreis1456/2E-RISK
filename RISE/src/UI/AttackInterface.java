package UI;

import entities.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class AttackInterface {

    Player attacking, defense;
    int landNo,landNoFrom;
    GamePlay play;
    Stage stag;
    AttackController controller;
    AnchorPane root;

    public AttackInterface(Player attacking, int landNo, GamePlay play, int landNoFrom){
        stag = new Stage();
        this.attacking = attacking;
        this.landNo = landNo;
        this.play = play;
        this.landNoFrom = landNoFrom;
    }

    public void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/AttackUI.fxml"));
        root = (AnchorPane) loader.load();
        controller = loader.getController();
        controller.setUpper(this);
        controller.hide();
        if(play.getControl().getLands().getLand(landNo).isOwnedByPlayer()){
            System.out.println("1");
            defense = play.getControl().getPlayer(play.getControl().getLands().getLand(landNo).getOwnerName());
            controller.setDefending(defense.getTroopTypeAtLand(0,landNo) + defense.getTroopTypeAtLand(1,landNo) + defense.getTroopTypeAtLand(2,landNo) + defense.getTroopTypeAtLand(3,landNo), defense.defensePointsAt(landNo) + "" , defense.getGeneral(), defense.getCountry());
            controller.setDefendingGeneral("" + defense.generalAggressionDefenseEffect(attacking.getCountry(), landNo));

            controller.setAttacking(attacking.getTroopTypeAtLand(0,43) + attacking.getTroopTypeAtLand(1,43) + attacking.getTroopTypeAtLand(2,43) + attacking.getTroopTypeAtLand(3,43), attacking.attackPointsAt(43, defense.getCountry()) + "" , attacking.getGeneral(), attacking.getCountry());
            controller.setAttackingGeneral("" + attacking.generalAggressionAttackEffect(defense.getCountry(), 43));
        }else{
            controller.setDefending(play.getControl().getLands().getLand(landNo).getTroopInfo(), play.getControl().getLands().getLand(landNo).getDefensePoints()+ "", "Bot", play.getControl().getLands().getLand(landNo).getOwnerName());
            controller.setDefendingGeneral("0");

            controller.setAttacking(attacking.getTroopTypeAtLand(0,43) + attacking.getTroopTypeAtLand(1,43) + attacking.getTroopTypeAtLand(2,43) + attacking.getTroopTypeAtLand(3,43), attacking.attackPointsAt(43, play.getControl().getLands().getLand(landNo).getOwnerName()) + "" , attacking.getGeneral(), attacking.getCountry());
            controller.setAttackingGeneral(""+ attacking.generalAggressionAttackEffect(play.getControl().getLands().getLand(landNo).getOwnerName(), 43));
        }
        Scene scene = new Scene(root);
        stag.setTitle("Attacking");
        stag.setScene(scene);
        stag.show();
    }


    public void declareWinner(boolean flag) throws IOException {
        if(play.getControl().getLands().getLand(landNo).isOwnedByPlayer()){
            int[] attackAmount = new int[]{attacking.getTroopTypeAtLandInt(0, 43), attacking.getTroopTypeAtLandInt(1, 43),attacking.getTroopTypeAtLandInt(2, 43) , attacking.getTroopTypeAtLandInt(3, 43)};
            int[] defAmount = new int[]{defense.getTroopTypeAtLandInt(0, landNo), defense.getTroopTypeAtLandInt(1, landNo), defense.getTroopTypeAtLandInt(2, landNo), defense.getTroopTypeAtLandInt(3, landNo)};
            int[] remainingAttackTroops = new int[4];
            int[] remainingDefenseTroops = new int[4];

            System.out.println("flga: " + flag);
            for(int i = 0; i < 4; i++) {
                if (flag) {
                    System.out.println("if: "+ defAmount[i] + "   " + attackAmount[i]);
                    if (attackAmount[i] > defAmount[i]) {
                        attacking.removeTroopTypeFromLand(i, 43, defAmount[i]);
                        defense.removeTroopTypeFromLand(i, landNo, defAmount[i]);
                    } else {
                        attacking.removeTroopTypeFromLand(i, 43, (attackAmount[i]*80/100));
                        defense.removeTroopTypeFromLand(i, landNo, defAmount[i]);
                    }
                    play.getControl().getLands().positionTroopOnLand(i,-(defAmount[i]), landNo);

                    remainingAttackTroops[i] = attacking.getTroopTypeAtLandInt(i, 43);
                    play.relocateTroop(43,landNo, i,remainingAttackTroops[i]);
                    play.getControl().getLands().positionTroopOnLand(i, -(attackAmount[i] - remainingAttackTroops[i]),43);

                    System.out.println("attaccking end");
                    System.out.println(attacking.isHasWon());
                    System.out.println(play.getControl().getLands().getLand(43).getArtilleryAmount());
                    System.out.println(play.getControl().getLands().getLand(43).getInfantryAmount());
                    System.out.println(play.getControl().getLands().getLand(43).getTankAmount());
                    System.out.println(play.getControl().getLands().getLand(43).getNerdsAmount());
                    System.out.println(attacking.getTroopTypeAtLandInt(0,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(1,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(2,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(3,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(0,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(1,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(2,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(3,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(0,landNo));
                    System.out.println(attacking.getTroopTypeAtLandInt(1,landNo));
                    System.out.println(attacking.getTroopTypeAtLandInt(2,landNo));
                    System.out.println(attacking.getTroopTypeAtLandInt(3,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(0,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(1,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(2,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(3,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(0,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(1,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(2,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(3,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(0,43));
                    System.out.println(defense.getTroopTypeAtLandInt(1,43));
                    System.out.println(defense.getTroopTypeAtLandInt(2,43));
                    System.out.println(defense.getTroopTypeAtLandInt(3,43));


                } else {
                    System.out.println("if: "+ defAmount[i] + "   " + attackAmount[i]);
                    if (attackAmount[i] >= defAmount[i]) {
                        System.out.println("Defans Amount" + defAmount[i]);
                        attacking.removeTroopTypeFromLand(i, 43, (attackAmount[i]*80/100));
                        defense.removeTroopTypeFromLand(i, landNo, (defAmount[i]*50/100));
                    } else {
                        attacking.removeTroopTypeFromLand(i, 43, attackAmount[i]);
                        defense.removeTroopTypeFromLand(i, landNo, attackAmount[i]);
                    }


                    remainingDefenseTroops[i] = defense.getTroopTypeAtLandInt(i, landNo);

                    play.getControl().getLands().positionTroopOnLand(i,-(defAmount[i]-remainingDefenseTroops[i]),landNo);

                    remainingAttackTroops[i] = attacking.getTroopTypeAtLandInt(i, 43);

                    play.relocateTroop(43, landNoFrom, i, remainingAttackTroops[i]);
                    play.getControl().getLands().positionTroopOnLand(i,-(attackAmount[i]-remainingAttackTroops[i]), 43);

                    System.out.println("attaccking end");
                    System.out.println(play.getControl().getLands().getLand(43).getArtilleryAmount());
                    System.out.println(play.getControl().getLands().getLand(43).getInfantryAmount());
                    System.out.println(play.getControl().getLands().getLand(43).getTankAmount());
                    System.out.println(play.getControl().getLands().getLand(43).getNerdsAmount());
                    System.out.println(attacking.getTroopTypeAtLandInt(0,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(1,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(2,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(3,43));
                    System.out.println(attacking.getTroopTypeAtLandInt(0,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(1,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(2,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(3,landNoFrom));
                    System.out.println(attacking.getTroopTypeAtLandInt(0,landNo));
                    System.out.println(attacking.getTroopTypeAtLandInt(1,landNo));
                    System.out.println(attacking.getTroopTypeAtLandInt(2,landNo));
                    System.out.println(attacking.getTroopTypeAtLandInt(3,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(0,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(1,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(2,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(3,landNo));
                    System.out.println(defense.getTroopTypeAtLandInt(0,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(1,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(2,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(3,landNoFrom));
                    System.out.println(defense.getTroopTypeAtLandInt(0,43));
                    System.out.println(defense.getTroopTypeAtLandInt(1,43));
                    System.out.println(defense.getTroopTypeAtLandInt(2,43));
                    System.out.println(defense.getTroopTypeAtLandInt(3,43));

                }
            }
            if (flag) {
                attacking.setHasWon(true);
                play.getControl().getLands().getLand(landNo).setOwner(attacking.getCountry());
                play.getControl().getLands().getLand(landNo).setOwn(attacking);
                attacking.setLandCount(attacking.getLandCount() + 1);
                defense.setLandCount(defense.getLandCount() - 1);
                play.getControl().Give(play.getTurnIndex());
            }

        }else {// vsBot
            int[] attackAmount = new int[]{attacking.getTroopTypeAtLandInt(0, 43), attacking.getTroopTypeAtLandInt(1, 43),attacking.getTroopTypeAtLandInt(2, 43) , attacking.getTroopTypeAtLandInt(3, 43)};
            int[] remainingAttackTroops = new int[4];
            for(int i = 0; i < 4; i++) {
                if (flag) {

                    attacking.removeTroopTypeFromLand(i, 43, (attackAmount[i]*20/100));

                    remainingAttackTroops[i] = attacking.getTroopTypeAtLandInt(i, 43);

                    play.relocateTroop(43, landNo, i, remainingAttackTroops[i]);
                    play.getControl().getLands().positionTroopOnLand(i,-(attackAmount[i] - remainingAttackTroops[i]),43);
                    //attacking.relocateTroops(43, landNoFrom, i, remainingAttackTroops[i]);




                } else {

                    attacking.removeTroopTypeFromLand(i, 43, (attackAmount[i]*80/100));

                    remainingAttackTroops[i] = attacking.getTroopTypeAtLandInt(i, 43);

                    play.relocateTroop(43, landNoFrom, i, remainingAttackTroops[i]);
                    play.getControl().getLands().positionTroopOnLand(i,-(attackAmount[i] - remainingAttackTroops[i]),43);

                }
            }
            if (flag) {
                attacking.setHasWon(true);
                attacking.setLandCount(attacking.getLandCount() + 1);
                play.getControl().getLands().getLand(landNo).setOwner(attacking.getCountry());
                play.getControl().getLands().getLand(landNo).setOwn(attacking);
                play.getControl().getLands().getLand(landNo).setOwnedByPlayer(true);
                play.getControl().Give(play.getTurnIndex());
            }
        }
        play.hasFallen();
    }
}
