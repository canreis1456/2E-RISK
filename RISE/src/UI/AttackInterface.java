package UI;

import entities.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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


    public void declareWinner(boolean flag){
        if(play.getControl().getLands().getLand(landNo).isOwnedByPlayer()){
            int[] attackAmount = new int[]{attacking.getTroopTypeAtLandInt(0, 43), attacking.getTroopTypeAtLandInt(1, 43),attacking.getTroopTypeAtLandInt(2, 43) , attacking.getTroopTypeAtLandInt(3, 43)};
            int[] defAmount = new int[]{defense.getTroopTypeAtLandInt(0, landNo), defense.getTroopTypeAtLandInt(1, landNo), defense.getTroopTypeAtLandInt(2, landNo), defense.getTroopTypeAtLandInt(3, landNo)};
            int[] remainingAttackTroops = new int[4];
            int[] remainingDefenseTroops = new int[4];

            System.out.println("flga: " + flag);
        for(int i = 0; i < 4; i++) {
            if (flag) {
                System.out.println("if: "+ defAmount[i] + "   " + attackAmount[i]);
                if (attackAmount[i] >= defAmount[i]) {
                    attacking.removeTroopTypeFromLand(i, 43, defAmount[i]);
                    defense.removeTroopTypeFromLand(i, landNo, defAmount[i]);
                } else {
                    attacking.removeTroopTypeFromLand(i, 43, (attackAmount[i] * 80 / 100));
                    defense.removeTroopTypeFromLand(i, landNo, defAmount[i]);
                }
                remainingDefenseTroops[i] = defense.getTroopTypeAtLandInt(i, landNo);

                play.getControl().getLands().positionTroopOnLand(i, -defAmount[i], landNo);
                play.getControl().getLands().getLand(landNo).setOwner(attacking.getCountry());
                play.getControl().getLands().getLand(landNo).setOwn(attacking);

                remainingAttackTroops[i] = attacking.getTroopTypeAtLandInt(i, 43);

                play.relocateTroop(43, landNo, i, remainingAttackTroops[i]);
                play.getControl().getLands().positionTroopOnLand(i,-(attackAmount[i] - remainingAttackTroops[i]),43);
                attacking.relocateTroops(43, landNo, i, remainingAttackTroops[i]);
                System.out.println(play.getControl().getLands().getLand(43).getArtilleryAmount());
                System.out.println(play.getControl().getLands().getLand(43).getInfantryAmount());
                System.out.println(play.getControl().getLands().getLand(43).getTankAmount());
                System.out.println(play.getControl().getLands().getLand(43).getNerdsAmount());


            } else {
                System.out.println("if: "+ defAmount[i] + "   " + attackAmount[i]);
                if (attackAmount[i] >= defAmount[i]) {
                    attacking.removeTroopTypeFromLand(i, 43, (attackAmount[i]*80/100));
                    defense.removeTroopTypeFromLand(i, landNo, (defAmount[i]*50/100));
                } else {
                    attacking.removeTroopTypeFromLand(i, 43, attackAmount[i]);
                    defense.removeTroopTypeFromLand(i, landNo, attackAmount[i]);
                }

                remainingDefenseTroops[i] = defense.getTroopTypeAtLandInt(i, landNo);

                play.getControl().getLands().positionTroopOnLand(i,-(defAmount[i]-remainingDefenseTroops[i]),landNo);
           //             positionTroop(i, -(defAmount[i]-remainingDefenseTroops[i]), landNo);
      //          defense.removeTroopTypeFromLand(i,landNo, defAmount[i]-remainingDefenseTroops[i]);

                remainingAttackTroops[i] = attacking.getTroopTypeAtLandInt(i, 43);

                play.relocateTroop(43, landNoFrom, i, remainingAttackTroops[i]);
                play.getControl().getLands().positionTroopOnLand(i,-(attackAmount[i]-remainingAttackTroops[i]), 43);
                attacking.relocateTroops(43, landNoFrom, i, remainingAttackTroops[i]);
                System.out.println(play.getControl().getLands().getLand(43).getArtilleryAmount());
                System.out.println(play.getControl().getLands().getLand(43).getInfantryAmount());
                System.out.println(play.getControl().getLands().getLand(43).getTankAmount());
                System.out.println(play.getControl().getLands().getLand(43).getNerdsAmount());
            }
        }


        }else {// vsBot
            int a = attacking.getTroopTypeAtLandInt(0, 43);
            int[] remainingTroops = new int[4];
            if(flag) {
                System.out.println("trp:  " + a);
                attacking.removeTroopFromLand(new int[]{(a*20/100),(a*20/100),(a*20/100),(a*20/100)}, 43);
                remainingTroops[0] = attacking.getTroopTypeAtLandInt(0, 43);
                play.relocateTroop(43,landNo,0,remainingTroops[0]);
                attacking.relocateTroops(43,landNo,0,remainingTroops[0]);

                remainingTroops[1] = attacking.getTroopTypeAtLandInt(1, 43);
                play.relocateTroop(43,landNo,1,remainingTroops[1]);
                attacking.relocateTroops(43,landNo,1,remainingTroops[1]);

                remainingTroops[2] = attacking.getTroopTypeAtLandInt(2, 43);
                play.relocateTroop(43,landNo,2,remainingTroops[2]);
                attacking.relocateTroops(43,landNo,2,remainingTroops[2]);

                remainingTroops[3] = attacking.getTroopTypeAtLandInt(3, 43);
                play.relocateTroop(43,landNo,3,remainingTroops[3]);
                attacking.relocateTroops(43,landNo,3,remainingTroops[3]);

                play.getControl().getLands().getLand(landNo).setOwner(attacking.getCountry());
                play.getControl().getLands().getLand(landNo).setOwn(attacking);
                play.getControl().getLands().getLand(landNo).setOwnedByPlayer(true);


            }else{
                System.out.println("trp:  " + a);
                attacking.removeTroopFromLand(new int[]{(a*80/100),(a*80/100),(a*80/100),(a*80/100)}, 43);

                remainingTroops[0] = attacking.getTroopTypeAtLandInt(0, 43);
                play.relocateTroop(43,landNoFrom,0,remainingTroops[0]);
                attacking.relocateTroops(43,landNoFrom,0,remainingTroops[0]);

                remainingTroops[1] = attacking.getTroopTypeAtLandInt(1, 43);
                play.relocateTroop(43,landNoFrom,1,remainingTroops[1]);
                attacking.relocateTroops(43,landNoFrom,1,remainingTroops[1]);

                remainingTroops[2] = attacking.getTroopTypeAtLandInt(2, 43);
                play.relocateTroop(43,landNoFrom,2,remainingTroops[2]);
                attacking.relocateTroops(43,landNoFrom,2,remainingTroops[2]);

                remainingTroops[3] = attacking.getTroopTypeAtLandInt(3, 43);
                play.relocateTroop(43,landNoFrom,3,remainingTroops[3]);
                attacking.relocateTroops(43,landNoFrom,3,remainingTroops[3]);
            }
        }
    }
}
