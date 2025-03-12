/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg42_kuis;

/**
 *
 * @author Lab Informatika
 */
class AlatTulis{
    String nama;
    int harga;
    int jumlah = 0;

    AlatTulis(String nama) {
        this.nama = nama;
        jumlah = 0;
    }
    
    void inputJumlah(int data){
        jumlah = data;
    }
    
    int getHarga(){
        return harga;
    }
}

class Pensil extends AlatTulis{
    
    Pensil(String nama){
        super(nama);
        harga = 2000;
    }
}
class Pulpen extends AlatTulis{
    
    Pulpen(String nama){
        super(nama);
        harga = 5000;
    }
}
class Buku extends AlatTulis{
    
    Buku(String nama){
        super(nama);
        harga = 10000;
    }
}
