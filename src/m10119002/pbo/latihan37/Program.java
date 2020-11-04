/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m10119002.pbo.latihan37;

import java.util.Scanner;

/**
 *
 * @author
 * NAMA     : Firman Sahita
 * KELAS    : IF-1
 * NIM      : 10119002
 * Deskripsi Program : Program ini berisi program Rata-Rata Nilai
 * (OBJECT ORIENTED)
 * 
 */
public class Program {
    public static Scanner scanner;
    
    public static Integer masukkanBanyakMhs() {
        String input;
        Integer banyakMhs;
        System.out.print("Masukkan Banyaknya Mahasiswa : ");
        input = scanner.nextLine();
        try {
            banyakMhs = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: Pastikan Banyak Mahasiswa berupa Angka!");
            banyakMhs = null;
        } catch (Exception ex) {
            System.err.println("ERROR: Terjadi Kesalahan Sistem!");
            banyakMhs = 0;
        }
        return banyakMhs;
    }
    
    public static Mahasiswa masukkanNilaiMahasiswa(int index) {
        Mahasiswa Mhs = new Mahasiswa();
        String input;
        Mhs.nim = (index+1);
        System.out.print("Nilai Mahasiswa ke-".
                concat(Integer.toString(Mhs.nim)).concat(" : "));
        input = scanner.nextLine();
        try {
            Mhs.nilai = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: Pastikan Nilai Mahasiswa berupa Angka!");
            return null;
        } catch (Exception ex) {
            System.err.println("ERROR: Terjadi Kesalahan Sistem!");
            Mhs.nilai = 0;
        }
        return Mhs;
    }
    
    public static Mahasiswa[] masukkanDataNilai(int banyakMhs) {
        if((banyakMhs==0) || (banyakMhs<0)) return null;
        String input;
        Mahasiswa[] dataMhs = new Mahasiswa[banyakMhs];
        for (int i=0; i<banyakMhs; i++) {
            Mahasiswa mhs = masukkanNilaiMahasiswa(i);
            while(mhs==null) {
                mhs = masukkanNilaiMahasiswa(i);
            }
            dataMhs[i] = mhs;
        }
        return dataMhs;
    }
    
    public static void tampilHasil(Mahasiswa[] dataMhs) {
        int totalNilai = 0;
        int banyakMhs = dataMhs.length;
        for (int i=0; i<banyakMhs; i++) {
            totalNilai += dataMhs[i].nilai;
        }
        double rataNilai = (double)totalNilai / (double)banyakMhs;
        System.out.println("Maka, Rata-rata Nilainya adalah ".
                concat(Double.toString(rataNilai)));
        System.out.println("Developed by : Firman Sahita");
    }
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Integer banyakMhs_T = masukkanBanyakMhs();
        while(banyakMhs_T==null) {
            banyakMhs_T = masukkanBanyakMhs();
        }
        Mahasiswa[] dataMhs = masukkanDataNilai(banyakMhs_T);
        System.out.println("");
        if (dataMhs==null) {
            System.out.println("Developed by : Firman Sahita");
            return;
        }
        tampilHasil(dataMhs);
    }
}
