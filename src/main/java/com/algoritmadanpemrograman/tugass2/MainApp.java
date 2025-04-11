package com.algoritmadanpemrograman.tugass2;

import com.algoritmadanpemrograman.tugass2.pertemuan3.MethodDanRecursion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {
    /*
        Menambahkan method sederhana untuk menampilkan data diri
        Menambahkan method recursion sederhana untuk membuat perpangkatan
     */
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        Label baseLabel = new Label("Masukkan angka basis (base):");
        TextField baseField = new TextField();
        baseField.setPromptText("Angka yang akan dipangkatkan. Contoh: 2");

        Label expLabel = new Label("Masukkan pangkat (exponent):");
        TextField expField = new TextField();
        expField.setPromptText("Pangkat pada angka. Contoh: 3");

        Button showButton = new Button("Tampilkan Data");

        showButton.setOnAction(event -> {
            String profile = MethodDanRecursion.showProfiles();

            try {
                int base = Integer.parseInt(baseField.getText());
                int exp = Integer.parseInt(expField.getText());
                if (exp < 0) {
                    outputArea.setText("Pangkat harus >= 0");
                } else {
                    int hasil = MethodDanRecursion.pangkat(base, exp);
                    outputArea.setText(profile + "\n" + base + " pangkat " + exp + " = " + hasil);
                }
            } catch (NumberFormatException e) {
                outputArea.setText("Masukkan angka yang valid untuk base dan exponent.");
            }
        });

        VBox root = new VBox(10, baseLabel, baseField, expLabel, expField, showButton, outputArea);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Data Diri & Perpangkatan (Rekursif)");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}