package com.algoritmadanpemrograman.tugass2;

import com.algoritmadanpemrograman.tugass2.pertemuan3.MethodDanRecursion;
import com.algoritmadanpemrograman.tugass2.pertemuan4.TextFiles;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button materi1Btn = new Button("Pertemuan 3: Rekursi");
        Button materi2Btn = new Button("Pertemuan 4: Text File");

        materi1Btn.setOnAction(e -> MethodDanRecursion.showUI(new Stage()));
        materi2Btn.setOnAction(e -> TextFiles.showUI(new Stage()));

        VBox layout = new VBox(10, materi1Btn, materi2Btn);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        primaryStage.setScene(new Scene(layout, 300, 200));
        primaryStage.setTitle("Pilih Materi Pembelajaran");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}