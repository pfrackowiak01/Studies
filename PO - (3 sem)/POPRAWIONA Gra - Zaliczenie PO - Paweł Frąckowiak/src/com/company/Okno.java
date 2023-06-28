package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno extends Main implements ActionListener {

    JButton zamknij;
    JButton graj;
    JButton ustawienia;

    Okno(){

        ImageIcon tytulo = new ImageIcon("Tytul.png");
        JLabel tytul = new JLabel();
        tytul.setIcon(tytulo);
        tytul.setBounds(200,40, 400, 200);

        JLabel potworek = new JLabel(new ImageIcon("potworek.png"));
        potworek.setBounds(0,40, 200, 200);

        JLabel czlowiek = new JLabel(new ImageIcon("czlowiek.png"));
        czlowiek.setBounds(600,40, 200, 200);

        JPanel panel = new JPanel();
        panel.setBackground(ciemny);
        panel.setBounds(150,225, 500, 300);

        zamknij = new JButton();
        zamknij.setBounds(200, 450, 400, 50);
        zamknij.addActionListener(this);
        zamknij.setText("Zamknij");
        zamknij.setFocusable(false);

        graj = new JButton();
        graj.setBounds(200, 250, 400, 50);
        graj.addActionListener(this);
        graj.setText("Nowa gra");
        graj.setFocusable(false);

        ustawienia = new JButton();
        ustawienia.setBounds(200, 350, 400, 50);
        ustawienia.addActionListener(this);
        ustawienia.setText("Ustawienia");
        ustawienia.setFocusable(false);

        this.setTitle("Summoners Battle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(800,600);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(tytul);
        this.add(potworek);
        this.add(czlowiek);
        this.add(zamknij);
        this.add(graj);
        this.add(ustawienia);
        this.add(panel);

        this.setIconImage(ikona.getImage());
        this.getContentPane().setBackground(kolor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==graj) {
            new Imie();
            dispose();
        }
        if(e.getSource()==ustawienia) {
            new Ustawienia();
            dispose();
        }
        if(e.getSource()==zamknij) {
            dispose();
        }
    }
}
