package celular;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import java.io.IOException;

public class Celular extends Application {

    // atributos
    private String marca;
    private String modelo;
    private String cor;
    private String camera;

    private int memoria;

    private String urlMusic = getClass().getResource("./assets/musica_elevador.mp3").toString();
	
    // métodos de classe
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
        System.out.println("Tocando música");
    }

    @Override
    public void start(Stage primaryStage) throws IOException {  
        Parent root = FXMLLoader.load(getClass().getResource("celular.fxml"));

        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
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
