
package UI;
import entities.Player;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

public class PlayerViewController {
    private Player player;
    @FXML private Image image;

    public void initObjs(Player player){
        this.player = player;
    }
}
