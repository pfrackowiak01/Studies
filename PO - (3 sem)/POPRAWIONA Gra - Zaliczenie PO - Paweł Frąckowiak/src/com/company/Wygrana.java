package com.company;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Wygrana extends Main implements ActionListener {

    JButton wyjdz;
    JButton zmiana;
    JButton ponownie;
    JLabel label;

    Wygrana(){

        label = new JLabel();
        label.setBounds(200,100,600,50);
        label.setText("GRATULACJE! Wygrałeś :D");
        label.setFont(new Font("Consolas",Font.BOLD,30));
        label.setForeground(czarny);

        JPanel panel = new JPanel();
        panel.setBackground(ciemny);
        panel.setBounds(150,225, 500, 300);

        wyjdz = new JButton();
        wyjdz.setBounds(200, 450, 400, 50);
        wyjdz.addActionListener(this);
        wyjdz.setText("Wyjdź do Menu");
        wyjdz.setFocusable(false);

        zmiana = new JButton();
        zmiana.setBounds(200, 250, 400, 50);
        zmiana.addActionListener(this);
        zmiana.setText("Zmień drużynę");
        zmiana.setFocusable(false);

        ponownie = new JButton();
        ponownie.setBounds(200, 350, 400, 50);
        ponownie.addActionListener(this);
        ponownie.setText("Jeszcze raz?");
        ponownie.setFocusable(false);

        this.setTitle("Summoners Battle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(800,600);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(label);
        this.add(wyjdz);
        this.add(zmiana);
        this.add(ponownie);
        this.add(panel);

        this.setIconImage(ikona.getImage());
        this.getContentPane().setBackground(kolor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==zmiana) {
            poziomtrudnosci = 0;
            bohater1 = null;
            bohater2 = null;
            bohater3 = null;
            new Postacie();
            dispose();
        }
        if(e.getSource()==ponownie) {
            losujPotwora();
            przygotowanie(b1,b2,b3,p);
            new Bitwa();
            dispose();
        }
        if(e.getSource()==wyjdz) {
            new Okno();
            dispose();
        }
    }
}


