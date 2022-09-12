package celular;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Celular extends Application {

    // atributos
    private String marca;
    private String modelo;
    private String cor;
    private String camera;

    private int memoria;

    private final String urlMusic = getClass().getResource("./assets/musica_elevador.mp3").toString();

    @Override
    public void start(Stage primaryStage) throws IOException {  
      Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

      Scene scene = new Scene(root, 900, 600);
      
      primaryStage.setTitle("Projeto LP1");
      primaryStage.setResizable(false);
      primaryStage.setScene(scene);
      primaryStage.show();
    }

    public static void main(String[] args) {
      launch(args);
    }

    public Celular() {}

    public String installApp(String appName) {
      String instaledApp = String.format("O app %s foi instalado", appName);

      return instaledApp;
    }
    
    public String openApp(String appName) {
      return(String.format("App %s aberto", appName));
    }

    public void playMusic() {
      AudioClip clip = new AudioClip(urlMusic);
        clip.play();
    }

    public File chooseImage() {
      final FileChooser fileChooser = new FileChooser();

      File file = fileChooser.showOpenDialog(null);

      if (file != null) {
        return file;
      }

      return null;
    }

    public void createCsv() {
      
    }

    public String getMarca() {
      return marca;
    }

    public void setMarca(String marca) {
      this.marca = marca;
    }

    public String getModelo() {
      return modelo;
    }

    public void setModelo(String modelo) {
      this.modelo = modelo;
    }

    public String getCor() {
      return cor;
    }

    public void setCor(String cor) {
      this.cor = cor;
    }

    public String getCamera() {
      return camera;
    }

    public void setCamera(String camera) {
      this.camera = camera;
    }
      
    public int getMemoria() {
      return memoria;
    }

    public void setMemoria(int memoria) {
      this.memoria = memoria;
    } 
}
