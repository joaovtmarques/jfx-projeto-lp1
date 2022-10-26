package com.celular.model;

import javafx.scene.media.AudioClip;
import javafx.stage.FileChooser;
import java.io.File;

public class Celular {
    private Integer id;
    private String marca;
    private String modelo;
    private String cor;
    private String camera;
    private Integer memoria;

    private final String urlMusic = " ";

    public Celular() {

    }

    public Celular(
            Integer id,
            String marca,
            String modelo,
            String cor,
            String camera,
            Integer memoria
    ) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.camera = camera;
        this.memoria = memoria;
    }


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
