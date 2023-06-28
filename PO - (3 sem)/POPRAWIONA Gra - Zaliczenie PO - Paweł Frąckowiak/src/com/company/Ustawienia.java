package com.company;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Ustawienia extends Main implements ActionListener {

    JButton losowy;
    JButton zielony;
    JButton fioletowy;
    JButton pomarańczowy;
    JButton zapisz;


    Ustawienia(){

        JPanel panel = new JPanel();
        panel.setBackground(ciemny);
        panel.setBounds(50,25, 200, 400);
        JPanel panel2 = new JPanel();
        panel2.setBackground(jasny);
        panel2.setBounds(75,425, 150, 100);

        losowy = new JButton();
        losowy.setBounds(100, 50, 100, 50);
        losowy.addActionListener(this);
        losowy.setText("Losowy");
        losowy.setFocusable(false);

        zielony = new JButton();
        zielony.setBounds(100, 150, 100, 50);
        zielony.addActionListener(this);
        zielony.setText("Zielony");
        zielony.setFocusable(false);

        fioletowy = new JButton();
        fioletowy.setBounds(100, 250, 100, 50);
        fioletowy.addActionListener(this);
        fioletowy.setText("Fioletowy");
        fioletowy.setFocusable(false);
        
        pomarańczowy = new JButton();
        pomarańczowy.setBounds(100, 350, 100, 50);
        pomarańczowy.addActionListener(this);
        pomarańczowy.setText("Pomarańcz");
        pomarańczowy.setFocusable(false);

        zapisz = new JButton();
        zapisz.setBounds(100, 450, 100, 50);
        zapisz.addActionListener(this);
        zapisz.setText("Zapisz");
        zapisz.setFocusable(false);

        this.setTitle("Ustawienia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(300,575);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(losowy);
        this.add(zielony);
        this.add(fioletowy);
        this.add(pomarańczowy);
        this.add(zapisz);
        this.add(panel);
        this.add(panel2);

        this.setIconImage(ikona.getImage());
        this.getContentPane().setBackground(kolor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==losowy) {
            Random rand = new Random();
            kolor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        }
        if(e.getSource()==zielony) {
            kolor = new Color(104,217,102);
        }
        if(e.getSource()==fioletowy) {
            kolor = new Color(123,22,224);
        }
        if(e.getSource()==pomarańczowy) {
            kolor = new Color(232,177,109);
        }
        if(e.getSource()==zapisz) {
            new Okno();
            dispose();
        }
        this.getContentPane().setBackground(kolor);
    }
}
