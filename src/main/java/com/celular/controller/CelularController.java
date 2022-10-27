package com.celular.controller;


import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import com.celular.model.Celular;
import com.celular.model.Loja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;

public class CelularController implements Initializable  {

    @FXML
    private Button playMusicBtn,
            button1,
            button2,
            addButton,
            closeButton,
            addPhoneButton,
            openImageBtn,
            closeButton2,
            searchPhone,
            searchButton,
            closeSearch;

    @FXML
    private TextField input1,
            input2,
            inputAdd1,
            inputAdd2,
            inputAdd3,
            inputAdd4,
            inputAdd5,
            searchInput;

    @FXML
    private Label text1, text2;

    @FXML
    private Pane addPhonePane, paneImage, searchPane;

    @FXML
    private ImageView imageView;

    @FXML
    private VBox list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Celular celular = new Celular();
        Loja loja = new Loja();

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
            System.out.println("-------------------------------------------");

            for(Celular c:loja.getCelular()) {
                System.out.println("Id: "+c.getId());
                System.out.println("Marca: "+c.getMarca());
                System.out.println("Modelo: "+c.getModelo());
                System.out.println("Cor: "+c.getCor());
                System.out.println("Camera: "+c.getCamera());
                System.out.println("Memória: "+c.getMemoria());
                System.out.println("Tamanho: "+loja.getCelular().size());
            }
            System.out.println("-------------------------------------------");
            for(Integer id:loja.getHashCelular()) {
                System.out.println("Id: "+id);
            }
            System.out.println("-------------------------------------------");
            int i = 1;
            while(i <= loja.getDicCelular().size()) {
                System.out.println("CELULAR: "+loja.getDicCelular().get(i));
                i++;
            }
        });

        addPhoneButton.setOnAction(event -> {
            String marca = inputAdd1.getText();
            String modelo = inputAdd2.getText();
            String cor = inputAdd3.getText();
            String camera = inputAdd4.getText();
            int memoria = Integer.parseInt(inputAdd5.getText());

            List<Celular> celulares = loja.getCelular();

            Integer id = null;
            id = (celulares.size()+1);

            if(id == -1) {
                id = 1;
            }

            Celular cel = new Celular(
                id,
                marca,
                modelo,
                cor,
                camera,
                memoria
            );

            loja.setNome("newPhone");
            loja.setTelefone(new Long(1296438656));
            loja.addCelular(cel);

            HashSet<Celular> dset = new HashSet<Celular>();
            dset.add(new Celular());

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cadastrado com sucesso");
            alert.setHeaderText("Seu celular foi adicionado ao csv!");
            alert.setContentText("Você pode conferir indo até a raíz do projeto e abrindo o arquivo celulares.csv");

            alert.showAndWait();
        });

        searchPane.setVisible(false);

        searchPhone.setOnAction(event -> {
            searchPane.setVisible(true);
        });

        searchButton.setOnAction(event -> {
            ObservableList<Celular> obList = FXCollections.observableArrayList(loja.getCelulares());
            ListView<Celular> listView = new ListView<>(obList);

            list.getChildren().add(listView);
        });


        closeSearch.setOnAction(event -> {
            searchPane.setVisible(false);
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
