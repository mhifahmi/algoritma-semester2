package com.algoritmadanpemrograman.tugass2.pertemuan4;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFiles {
    private static final String NAMA_FILE = "M_H_Fahmi_24552011058.txt";

    public static void showUI(Stage stage) {
        TextField inputNama = new TextField();
        inputNama.setPromptText("Masukkan nama");

        TextField inputNim = new TextField();
        inputNim.setPromptText("Masukkan nim");

        Button tombolSimpan = new Button("Simpan ke File");
        Button tombolBaca = new Button("Baca dari File");
        Button tombolUbah = new Button("Ubah Data");

        TextArea areaTeks = new TextArea();
        areaTeks.setEditable(false);

        tombolSimpan.setOnAction(e -> {
            try (FileWriter writer = new FileWriter(NAMA_FILE, true)) {
                String data = "Nama: " + inputNama.getText() + ", NIM: " + inputNim.getText() + "\n";
                writer.write(data);
                inputNama.clear();
                inputNim.clear();
                areaTeks.setText("Berhasil menyimpan data.");
            } catch (IOException ex) {
                areaTeks.setText("Gagal menyimpan data.");
            }
        });

        tombolBaca.setOnAction(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(NAMA_FILE))) {
                StringBuilder isi = new StringBuilder();
                String baris;
                while ((baris = reader.readLine()) != null) {
                    isi.append(baris).append("\n");
                }
                areaTeks.setText(isi.toString());
            } catch (IOException ex) {
                areaTeks.setText("Gagal membaca file.");
            }
        });

        tombolUbah.setOnAction(e -> {
            String namaInput = inputNama.getText();
            String nimBaru = inputNim.getText();

            List<String> isiBaru = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(NAMA_FILE))) {
                String baris;
                boolean ditemukan = false;
                while ((baris = reader.readLine()) != null) {
                    if (baris.contains("Nama: " + namaInput + ",")) {
                        baris = "Nama: " + namaInput + ", NIM: " + nimBaru;
                        ditemukan = true;
                    }
                    isiBaru.add(baris);
                }

                if (!ditemukan) {
                    areaTeks.setText("Data dengan nama tersebut tidak ditemukan.");
                    return;
                }

            } catch (IOException ex) {
                areaTeks.setText("Gagal membaca file.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE, false))) {
                for (String baris : isiBaru) {
                    writer.write(baris);
                    writer.newLine();
                }
                areaTeks.setText("Data berhasil diubah.");
                inputNama.clear();
                inputNim.clear();
            } catch (IOException ex) {
                areaTeks.setText("Gagal menyimpan perubahan.");
            }
        });

        VBox layout = new VBox(10, inputNama, inputNim, tombolSimpan, tombolUbah, tombolBaca, areaTeks);
        layout.setStyle("-fx-padding: 20px");

        stage.setScene(new Scene(layout, 400, 400));
        stage.setTitle("Materi: Text File dengan JavaFX");
        stage.show();
    }
}
