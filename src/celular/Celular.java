package celular;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Celular extends Application {

    // atributos
    private String marca;
    private String modelo;
    private String cor;
    private String camera;

    private int memoria;

    private String urlMusic = getClass().getResource("/assets/musica_elevador.mp3").toString();

    public StackPane root = new StackPane();
	
	// métodos de classe
	public String installApp(String appName) {
        String instaledApp = String.format("O app %s foi instalado", appName);

		return instaledApp;
	}
	
	public String openApp(String appName) {
		return("Oi");
	}

    public void playMusic() {
		AudioClip clip = new AudioClip(urlMusic);
        clip.play();
        root.getChildren().add(new Text("Tocando Música "));
	}

    @Override
    public void start(Stage primaryStage) {  
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
