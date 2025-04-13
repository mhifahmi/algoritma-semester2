package com.algoritmadanpemrograman.tugass2.pertemuan4;

public class Mahasiswa {
    private String nama;
    private String pesan;

    public Mahasiswa(String nama, String pesan) {
        this.nama = nama;
        this.pesan = pesan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Pesan: " + pesan;
    }
}
