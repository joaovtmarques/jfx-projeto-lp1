package celular;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CelularController implements Initializable {

  @FXML
  private Button btn;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Celular celular = new Celular(
      "Apple", 
      "Iphone 12", 
      "Grafite", 
      "12mpx", 
      128
    );
  
    btn.setOnMouseClicked(event -> {
      celular.playMusic();
    });
  }
}

