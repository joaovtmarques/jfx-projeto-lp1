package celular;

import java.net.URL;
import java.util.ResourceBundle;

import celular.model.Celular;
import celular.model.Loja;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CelularController implements Initializable {

  @FXML
  private Button playMusicBtn, 
    button1, 
    button2, 
    addButton, 
    closeButton, 
    addPhoneButton, 
    openImageBtn, 
    closeButton2;

  @FXML
  private TextField input1, 
    input2, 
    inputAdd1, 
    inputAdd2, 
    inputAdd3, 
    inputAdd4, 
    inputAdd5;

  @FXML
  private Label text1, text2;

  @FXML
  private Pane addPhonePane, paneImage;

  @FXML
  private ImageView imageView;

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

      Celular cel = new Celular(
        marca,
        modelo,
        cor,
        camera,
        memoria
      );

      Loja loja = new Loja();

      loja.setNome("newPhone");
      loja.setTelefone(new Long(1296438656));
      loja.addCelular(cel);
  
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Cadastrado com sucesso");
      alert.setHeaderText("Seu celular foi adicionado ao csv!");
      alert.setContentText("Você pode conferir indo até a raíz do projeto e abrindo o arquivo celulares.csv");

      alert.showAndWait();

      for(Celular c:loja.getCelular()) {
        System.out.println("Marca: "+c.getMarca());
        System.out.println("Modelo: "+c.getModelo());
        System.out.println("Cor: "+c.getCor());
        System.out.println("Camera: "+c.getCamera());
        System.out.println("Memória: "+c.getMemoria());
      }
    });

    paneImage.setVisible(false);

    openImageBtn.setOnAction(event -> {
      File file = celular.chooseImage();

      System.out.println(file.toURI().toString());

      Image img = new Image(file.toURI().toString());

      imageView.setImage(img);
      paneImage.setVisible(true);
    });

    closeButton2.setOnMouseClicked(event -> {
      paneImage.setVisible(false);
    });
  }
}

