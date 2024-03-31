/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasSerialisasi;

import java.io.*;

/**
 *
 * @author Wiwiet Aditya
 */

class Siswa implements Serializable {
    String nama;
    int umur;
    String alamat;
    
 public Siswa(String nama, int umur, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Objek Siswa
        Siswa siswa = new Siswa("rani", 17, "Jl. Merdeka No. 12");
        
// Serialisasi objek Siswa
        try (FileOutputStream fileOut = new FileOutputStream("siswa.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(siswa);
            System.out.println("Objek Siswa berhasil di-serialize.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
// Deserialisasi objek Siswa
        try (FileInputStream fileIn = new FileInputStream("siswa.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Siswa siswaTerbaca = (Siswa) in.readObject();
            System.out.println("Informasi Siswa yang telah di-serialize:");
            System.out.println("Nama: " + siswaTerbaca.nama);
            System.out.println("Umur: " + siswaTerbaca.umur);
            System.out.println("Alamat: " + siswaTerbaca.alamat);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
    






    