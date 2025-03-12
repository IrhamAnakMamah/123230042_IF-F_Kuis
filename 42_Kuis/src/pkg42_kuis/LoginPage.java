package pkg42_kuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Lab Informatika
 */
public class LoginPage extends JFrame implements ActionListener{
    
    int percobaan = 3;
    
    JLabel usernameLabel = new JLabel("Username : ");
    JLabel passwordLabel = new JLabel("Password : ");
    
    JTextField usernameInput = new JTextField();
    JPasswordField passwordInput = new JPasswordField();
    
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    
    LoginPage(){
        setVisible(true);
        setSize(480,300);
        setTitle("Toko Alat Tulis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        add(usernameLabel);
        add(usernameInput);
        
        add(passwordLabel);
        add(passwordInput);
        
        add(loginButton);
        add(resetButton);
        
        usernameLabel.setBounds(20,20,100,20);
        usernameInput.setBounds(200,20,250,30);
        
        passwordLabel.setBounds(20,100,100,20);
        passwordInput.setBounds(200,100,250,30);
        
        loginButton.setBounds(20,180,150,30);
        resetButton.setBounds(300,180,150,30);
        
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==loginButton){
                String username = usernameInput.getText();
                char[] temp_password = passwordInput.getPassword();
                String password = new String(temp_password);
                
                if(username.equals("irham") && password.equals("123230042")){
                    new HomePage(username);
                    this.dispose();
                }else{
                    throw new Exception("Username atau password salah");
                }
            }else{
                
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(this, "Error : " + error.getMessage());
            percobaan = percobaan - 1;
            if(percobaan > 0){
                JOptionPane.showMessageDialog(this, "Percobaan anda tersisa : " + percobaan);
            }
            else if(percobaan == 0 ){
                JOptionPane.showMessageDialog(this, "Percobaan anda telah habis, anda tidak dapat melakukan login");
                loginButton.setEnabled(false);
            }
            ResetAll();
        }
    }
    
    public void ResetAll(){
        usernameInput.setText("");
        passwordInput.setText("");
    }
}
