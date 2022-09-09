package celular;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

  @FXML
  private Button addButton;

  @FXML
  private Pane addPhonePane;

  @FXML
  private Button closeButton;

  @FXML
  private TextField inputAdd1;

  @FXML
  private TextField inputAdd2;

  @FXML
  private TextField inputAdd3;

  @FXML
  private TextField inputAdd4;

  @FXML
  private TextField inputAdd5;

  @FXML
  private Button addPhoneButton;

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
  
    addPhonePane.setVisible(false);

    addButton.setOnAction(event -> {
      addPhonePane.setVisible(true);
    });

    closeButton.setOnMouseClicked(event -> {
      addPhonePane.setVisible(false);
    });

    addPhoneButton.setOnAction(event -> {
      String marca = inputAdd1.getText();
      String modelo = inputAdd2.getText();
      String cor = inputAdd3.getText();
      String camera = inputAdd4.getText();
      int memoria = Integer.parseInt(inputAdd5.getText());
  
      celular.setMarca(marca);
      celular.setModelo(modelo);
      celular.setCor(cor);
      celular.setCamera(camera);
      celular.setMemoria(memoria);

      try (PrintWriter writer = new PrintWriter(new File("celulares.csv"))) {

        StringBuilder sb = new StringBuilder();
        sb.append("Marca");
        sb.append(',');
        sb.append("Modelo");
        sb.append(',');
        sb.append("Cor");
        sb.append(',');
        sb.append("Câmera");
        sb.append(',');
        sb.append("Memória");
        sb.append('\n');

        sb.append(celular.getMarca());
        sb.append(',');
        sb.append(celular.getModelo());
        sb.append(',');
        sb.append(celular.getCor());
        sb.append(',');
        sb.append(celular.getCamera());
        sb.append(',');
        sb.append(celular.getMemoria());
        sb.append('\n');

        writer.write(sb.toString());
        writer.close();
      } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
      }
    });

  }
}

