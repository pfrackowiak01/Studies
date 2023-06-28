package com.company;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.Flow;

public class Imie extends Main implements ActionListener {

    JButton potwierdz;
    JTextField pole;
    JOptionPane error;

    Imie() {

        JPanel panel = new JPanel();
        panel.setBackground(ciemny);
        panel.setBounds(25, 25, 500, 100);

        potwierdz = new JButton();
        potwierdz.setBounds(50, 50, 100, 50);
        potwierdz.addActionListener(this);
        potwierdz.setText("Potwierdź");
        potwierdz.setFocusable(false);

        pole = new JTextField();
        pole.setBounds(200, 55, 300, 40);
        pole.setFont(new Font("Consolas",Font.PLAIN,30));
        pole.setForeground(Color.GREEN);
        pole.setBackground(Color.BLACK);
        pole.setCaretColor(Color.WHITE);
        pole.setText(imie);
        pole.setEditable(true);


        this.setTitle("Summoners Battle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(575, 200);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(potwierdz);
        this.add(pole);
        this.add(panel);
        this.setVisible(true);
        this.setIconImage(ikona.getImage());
        this.getContentPane().setBackground(kolor);
    }
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == potwierdz) {
                if (pole.getText() != null) {
                    imie = pole.getText();
                    new Postacie();
                    dispose();
                }
                else JOptionPane.showMessageDialog(error, "Musisz wpierw wpisać swoje imię.");
            }
        }
}





