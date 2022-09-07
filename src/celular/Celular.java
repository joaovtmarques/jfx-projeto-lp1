package celular;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class Celular extends Application {

    // atributos
    private String marca;
    private String modelo;
    private String cor;
    private String camera;

    private int memoria;

    private final String urlMusic = getClass().getResource("./assets/musica_elevador.mp3").toString();

    private static final String CSV_PATH = "/tmp/test.csv";

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
      try {
        FileWriter fw = new FileWriter(new File(CSV_PATH));
  
        CSVWriter CW = new CSVWriter(fw);
  
        String[] headers = {"marca", "modelo", "cor", "camera", "memoria"};
  
        List<String[]> data = new ArrayList<String[]>();
  
        String[] cel1 = {"Apple", "iPhone 12", "preto", "12mpx", "128"};
        String[] cel2 = {"Motorola", "Moto g9", "preto", "20mpx", "256"};
        String[] cel3 = {"Samsung", "Galaxy s7", "vermelho", "12mpx", "64"};
  
        data.add(headers);
        data.add(cel1);
        data.add(cel2);
        data.add(cel3);
  
        CW.writeAll(data);
  
        CW.close();
        fw.close();
  
        } catch (IOException e) {
          System.out.println(e);
        }

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
