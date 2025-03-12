/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg42_kuis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Hitung{
    String halo;
    Hitung(){
        halo = "Halo";
    }
    
    public int HitungPerUnit(int jumlah, int harga){
        int hargaBarang = 0;
        
        hargaBarang = jumlah * harga;
        
        return hargaBarang;
    }
    
    public int HitungSubTotal(int a, int b, int c){
        int SubTotal = 0;
        
        SubTotal = a + b + c;
        
        return SubTotal;
    }
    
    public int Diskon(int harga){
        int Diskon = 0;
        
        if(harga >= 100000){
            Diskon = (harga * 2) / 10;
        }else if(harga >= 50000){
            Diskon = (harga * 1) / 10;
        }else{
            Diskon = 0;
        }
        
        return Diskon;
    }
    
    public int TotalHarga(int total, int diskon){
        int harga = 0;
        
        harga = total - diskon;
        
        return harga;
    }
}

/**
 *
 * @author Lab Informatika
 */
public class Hasil extends JFrame implements ActionListener{
    
    Hitung hitung = new Hitung();
    
    int persen = 0;
    
    int jumlah1 = 0;
    int jumlah2 = 0;
    int jumlah3 = 0;

    int Barang1 = 0;
    int Barang2 = 0;
    int Barang3 = 0;
    
    int subTotal = 0;
    int diskon = 0;
    int totalHarga = 0;
    
    AlatTulis pensil = new Pensil("Pensil");
    AlatTulis pulpen = new Pulpen("Pulpen");
    AlatTulis buku = new Buku("Buku");
    
    JLabel titel = new JLabel("Daftar Pembelian : ");
    JLabel pensilTitel = new JLabel("");
    JLabel pulpenTitel = new JLabel("");
    JLabel bukuTitel = new JLabel("");
    JLabel subTotalTitel = new JLabel("");
    JLabel diskonTitel = new JLabel("");
    JLabel totalTitel = new JLabel("");
    JButton kembaliButton = new JButton("Kembali");
    
    Hasil(int jumlahPensil,int jumlahPulpen,int jumlahBuku){
        setVisible(true);
        setSize(480,500);
        setTitle("Toko Alat Tulis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        jumlah1 = jumlahPensil;
        jumlah2 = jumlahPulpen;
        jumlah3 = jumlahBuku;
                
        ProsesHitung();
        
        add(titel);
        
        pensilTitel.setText("Pensil : " + jumlah1 + " x Rp" + pensil.getHarga() + " = Rp " + Barang1);
        pulpenTitel.setText("Pulpen : " + jumlah2 + " x Rp" + pulpen.getHarga() + " = Rp " + Barang2);
        bukuTitel.setText("Buku Tulis : " + jumlah3 + " x Rp" + buku.getHarga() + " = Rp " + Barang3);
        add(pensilTitel);
        add(pulpenTitel);
        add(bukuTitel);
        
        subTotalTitel.setText("Subtotal : Rp" + subTotal);
        diskonTitel.setText("Diskon " + persen + "% : Rp" + diskon);
        totalTitel.setText("Total Harga : Rp" + totalHarga);
        add(subTotalTitel);
        add(diskonTitel);
        add(totalTitel);
        
        add(kembaliButton);
        
        titel.setBounds(50,50,300,30);
        pensilTitel.setBounds(50,90,300,30);
        pulpenTitel.setBounds(50,130,300,30);
        bukuTitel.setBounds(50,170,300,30);
        subTotalTitel.setBounds(50,240,300,30);
        diskonTitel.setBounds(50,280,300,30);
        totalTitel.setBounds(50,320,300,30);
        
        kembaliButton.setBounds(50,380,350,40);
        
        kembaliButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == kembaliButton){
                new HomePage("irham");
                this.dispose();
            }
        }catch(Exception error){
            
        }
    }
    
    public void ProsesHitung(){
        Barang1 = hitung.HitungPerUnit(jumlah1, pensil.getHarga());
        Barang2 = hitung.HitungPerUnit(jumlah2, pulpen.getHarga());
        Barang3 = hitung.HitungPerUnit(jumlah3, buku.getHarga());
        
        subTotal = hitung.HitungSubTotal(Barang1, Barang2, Barang3);
        diskon = hitung.Diskon(subTotal);
        
        if(subTotal >= 100000){
            persen = 20;
        }else if(subTotal >= 50000){
            persen = 10;
        }
        
        totalHarga = hitung.TotalHarga(subTotal, diskon);
    }
}
