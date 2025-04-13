package com.algoritmadanpemrograman.tugass2.pertemuan3;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MethodDanRecursion {
    public static String showProfiles() {
        return """
                Nama: Mochamad Hilman Fahmi
                NIM: 24552011058
                Jurusan: Teknik Informatika
                Universitas: Universitas Teknologi Bandung
                """;
    }

    public static int pangkat(int base, int exp) {
        if (exp == 0) return 1;
        return base * pangkat(base, exp - 1);
    }

    public static void showUI(Stage stage) {
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        Label baseLabel = new Label("Masukkan angka basis (base):");
        TextField baseField = new TextField();

        Label expLabel = new Label("Masukkan pangkat (exponent):");
        TextField expField = new TextField();

        Button showButton = new Button("Tampilkan Data");

        showButton.setOnAction(event -> {
            String profile = showProfiles();
            try {
                int base = Integer.parseInt(baseField.getText());
                int exp = Integer.parseInt(expField.getText());
                if (exp < 0) {
                    outputArea.setText("Pangkat harus >= 0");
                } else {
                    int hasil = pangkat(base, exp);
                    outputArea.setText(profile + "\n" + base + " pangkat " + exp + " = " + hasil);
                }
            } catch (NumberFormatException e) {
                outputArea.setText("Masukkan angka yang valid.");
            }
        });

        VBox root = new VBox(10, baseLabel, baseField, expLabel, expField, showButton, outputArea);
        root.setStyle("-fx-padding: 20");

        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Materi: Method & Rekursi");
        stage.show();
    }
}
