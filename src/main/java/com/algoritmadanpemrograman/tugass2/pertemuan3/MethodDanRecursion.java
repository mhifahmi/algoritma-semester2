package com.algoritmadanpemrograman.tugass2.pertemuan3;

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
}
