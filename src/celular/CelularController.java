package celular;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CelularController implements Initializable {

  @FXML
  private Button playMusicBtn;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Celular celular = new Celular();
  
    playMusicBtn.setOnMouseClicked(event -> {
      celular.playMusic();
    });
  }
}

