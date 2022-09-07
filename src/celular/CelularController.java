package celular;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CelularController implements Initializable {

  @FXML
  private Button playMusicBtn;

  @FXML
  private Button button1;

  @FXML
  private TextField input1;

  @FXML
  private Label text1;

  @FXML
  private Button button2;

  @FXML
  private TextField input2;

  @FXML
  private Label text2;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Celular celular = new Celular();

    button1.setOnMouseClicked(event -> {
      String appName = input1.getText();

      if(appName.trim().isEmpty()) {
        text1.setText("Digite o nome de um app! =)");
      } else {
        String instaledApp = celular.installApp(appName);

        text1.setText(instaledApp);
      }
    });

    button2.setOnMouseClicked(event -> {
      String appName = input2.getText();

      if(appName.trim().isEmpty()) {
        text2.setText("Digite o nome de um app! =)");
      } else {
        String openedApp = celular.openApp(appName);

        text2.setText(openedApp);
      }
    });

    playMusicBtn.setOnMouseClicked(event -> {
      celular.playMusic();
    }); 
  }
}

