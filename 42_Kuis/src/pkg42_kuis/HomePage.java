/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg42_kuis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Lab Informatika
 */
public class HomePage extends JFrame implements ActionListener{
    
    AlatTulis pensil = new Pensil("Pensil");
    AlatTulis pulpen = new Pulpen("Pulpen");
    AlatTulis buku = new Buku("Buku");
    
    JLabel ucapan = new JLabel("");
    JLabel pensilTitel = new JLabel("Pensil (Rp2.000) : ");
    JLabel pulpenTitel = new JLabel("Pulpen (Rp5.000) : ");
    JLabel bukuTitel = new JLabel("Buku Tulis (Rp10.000) : ");
    
    JTextField pensilInput = new JTextField("0");
    JTextField pulpenInput = new JTextField("0");
    JTextField bukuInput = new JTextField("0");
    
    JButton beliButton = new JButton("Beli");
    JButton logoutButton = new JButton("Logout");
    HomePage(String nama){
        setVisible(true);
        setSize(480,500);
        setTitle("Toko Alat Tulis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        ucapan.setText("Selamat Datang, " + nama);
        add(ucapan);
        
        add(pensilTitel);
        add(pulpenTitel);
        add(bukuTitel);
        
        add(pensilInput);
        add(pulpenInput);
        add(bukuInput);
        
        add(logoutButton);
        add(beliButton);
        
        ucapan.setBounds(50,50,150,30);
        pensilTitel.setBounds(50,100,150,30);
        pulpenTitel.setBounds(50,170,150,30);
        bukuTitel.setBounds(50,240,150,30);
        
        pensilInput.setBounds(220,100,170,30);
        pulpenInput.setBounds(220,170,170,30);
        bukuInput.setBounds(220,240,170,30);
        
        beliButton.setBounds(50,310,350,40);
        logoutButton.setBounds(50,370,350,40);
        
        beliButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==beliButton){
                int jumlahPensil = Integer.parseInt(pensilInput.getText());
                int jumlahPulpen = Integer.parseInt(pulpenInput.getText());
                int jumlahBuku = Integer.parseInt(bukuInput.getText());
                
                if(jumlahPensil >= 0 && jumlahPulpen >= 0 && jumlahBuku>= 0){
                    int total = HitungTotal(jumlahPensil, jumlahPulpen, jumlahBuku);
                    System.out.println(jumlahPensil + " " + jumlahPulpen + " " + jumlahBuku);
                    Diskon(total);
                    new Hasil(jumlahPensil,jumlahPulpen,jumlahBuku);
                    this.dispose();
                }else{
                    throw new Exception("tidak boleh ada yang negatif");
                }
            }else{
                new LoginPage();
                this.dispose();
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(this, "Error : " + error.getMessage());
            ResetAll();
        }
    }
    
    public void ResetAll(){
        pensilInput.setText("");
        pulpenInput.setText("");
        bukuInput.setText("");
    }
    
    public int HitungTotal(int jumlahPensil,int jumlahPulpen, int jumlahBuku){
        int totalHarga = (jumlahPensil * pensil.getHarga()) + (jumlahPulpen * pulpen.getHarga()) + (jumlahBuku * buku.getHarga()); 
        
        return totalHarga;
    }
    
    public void Diskon(int data){
        String pesan;
        if(data >= 100000){
            pesan = "Selamat, anda mendapatkan diskon sebesar 20%";
            JOptionPane.showMessageDialog(this, pesan);
        }else if(data >= 50000){
            pesan = "Selamat, anda mendapatkan diskon sebesar 10%";
            JOptionPane.showMessageDialog(this, pesan);
        }
    }
}
