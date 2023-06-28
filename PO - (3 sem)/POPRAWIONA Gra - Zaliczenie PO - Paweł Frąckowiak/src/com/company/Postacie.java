package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Postacie extends Main implements ActionListener, MouseListener {

    JButton wróć;
    JButton bitwa;
    JButton reset;
    JComboBox wybierzpoziom;

    JPanel latwy;
    JPanel info;
    JLabel tekst;
    JLabel label0;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel label12;
    JOptionPane error;

    private List<JLabel> labels = new ArrayList<>();
    Border border = BorderFactory.createLineBorder(Color.BLACK,5);
    Border border2 = BorderFactory.createLineBorder(Color.GREEN,5);

    Postacie(){

        label0 = new JLabel();
        label0.setBounds(545,120, 185, 300);

        label1 = new JLabel();
        label1.setIcon(super.czarownicao);
        label1.setBounds(25, 75, 100, 100);
        label2 = new JLabel();
        label2.setIcon(super.wampiro);
        label2.setBounds(25, 200, 100, 100);
        label3 = new JLabel();
        label3.setIcon(super.palladyno);
        label3.setBounds(25, 325, 100, 100);

        label4 = new JLabel();
        label4.setIcon(super.szamankao);
        label4.setBounds(150, 75, 100, 100);
        label5 = new JLabel();
        label5.setIcon(super.mago);
        label5.setBounds(150, 200, 100, 100);
        label6 = new JLabel();
        label6.setIcon(super.pirato);
        label6.setBounds(150, 325, 100, 100);

        label7 = new JLabel();
        label7.setIcon(super.uzdrowicielkao);
        label7.setBounds(275, 75, 100, 100);
        label8 = new JLabel();
        label8.setIcon(super.ninjao);
        label8.setBounds(275, 200, 100, 100);
        label9 = new JLabel();
        label9.setIcon(super.rycerzo);
        label9.setBounds(275, 325, 100, 100);

        label10 = new JLabel();
        label10.setIcon(super.druido);
        label10.setBounds(400, 75, 100, 100);
        label11 = new JLabel();
        label11.setIcon(super.assasino);
        label11.setBounds(400, 200, 100, 100);
        label12 = new JLabel();
        label12.setIcon(super.demono);
        label12.setBounds(400, 325, 100, 100);

        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(label8);
        labels.add(label9);
        labels.add(label10);
        labels.add(label11);
        labels.add(label12);

        label1.addMouseListener(this);
        label2.addMouseListener(this);
        label3.addMouseListener(this);
        label4.addMouseListener(this);
        label5.addMouseListener(this);
        label6.addMouseListener(this);
        label7.addMouseListener(this);
        label8.addMouseListener(this);
        label9.addMouseListener(this);
        label10.addMouseListener(this);
        label11.addMouseListener(this);
        label12.addMouseListener(this);

        JPanel panel = new JPanel();
        panel.setBackground(ciemny);
        panel.setBounds(75,450, 650, 100);

        info = new JPanel();
        info.setBackground(ciemny);
        info.setBounds(525,75, 225, 350);

        latwy = new JPanel();
        if (poziomtrudnosci == 0) latwy.setBackground(zielony);
        if (poziomtrudnosci == 1) latwy.setBackground(zolty);
        if (poziomtrudnosci == 2) latwy.setBackground(czerwony);
        latwy.setBounds(525, 475, 175, 50);

        tekst = new JLabel();
        tekst.setText("<html><b>Witaj <i>" + imie + "!</i> Potrzebujemy pilnie twojej pomocy.</b><br>Wybierz 3 śmiałków i pomóż im pokonać okrutną bestię, która terroryzuje naszą wioskę od wielu miesięcy. Proszę, uwolnij nas od tego POTWORA!</html>");
        tekst.setBounds(25, 2, 750, 75);
        tekst.setFont(new Font("Consolas",Font.PLAIN,16));
        tekst.setForeground(czarny);

        JLabel poziom = new JLabel();
        poziom.setText("Poziom Trudności:");
        poziom.setBounds(527, 461, 200, 50);
        poziom.setFont(new Font("Consolas",Font.BOLD,18));
        poziom.setForeground(czarny);

        JLabel statystyki = new JLabel();
        statystyki.setText("Statystyki:");
        statystyki.setBounds(564, 85, 200, 50);
        statystyki.setFont(new Font("Consolas",Font.BOLD,24));
        statystyki.setForeground(czarny);

        String[] poziomy = {"Łatwy","Średni","Trudny"};
        wybierzpoziom = new JComboBox(poziomy);
        wybierzpoziom.addActionListener(this);
        wybierzpoziom.setBounds(556,499,100,22);
        wybierzpoziom.setSelectedIndex(poziomtrudnosci);

        wróć = new JButton();
        wróć.setBounds(100, 475, 100, 50);
        wróć.addActionListener(this);
        wróć.setText("Wróć");
        wróć.setFocusable(false);

        bitwa = new JButton();
        bitwa.setBounds(400, 475, 100, 50);
        bitwa.addActionListener(this);
        bitwa.setText("Bitwa!");
        bitwa.setFocusable(false);

        reset = new JButton();
        reset.setBounds(250, 475, 100, 50);
        reset.addActionListener(this);
        reset.setText("Reset");
        reset.setFocusable(false);

        this.setTitle("Summoners Battle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(800,625);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(label0);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(label10);
        this.add(label11);
        this.add(label12);
        this.add(wybierzpoziom);
        this.add(tekst);
        this.add(poziom);
        this.add(statystyki);
        this.add(wróć);
        this.add(bitwa);
        this.add(reset);
        this.add(latwy);
        this.add(panel);
        this.add(info);

        this.setIconImage(ikona.getImage());
        this.getContentPane().setBackground(kolor);
    }



    public void wybierz(int i,JLabel source) {
        switch (i) {
            case 1:
                if (source == label1) b1 = czarownica;
                if (source == label2) b1 = wampir;
                if (source == label3) b1 = palladyn;
                if (source == label4) b1 = szamanka;
                if (source == label5) b1 = mag;
                if (source == label6) b1 = pirat;
                if (source == label7) b1 = uzdrowicielka;
                if (source == label8) b1 = ninja;
                if (source == label9) b1 = rycerz;
                if (source == label10) b1 = druid;
                if (source == label11) b1 = assasin;
                if (source == label12) b1 = demon;
                break;
            case 2:
                if (source == label1) b2 = czarownica;
                if (source == label2) b2 = wampir;
                if (source == label3) b2 = palladyn;
                if (source == label4) b2 = szamanka;
                if (source == label5) b2 = mag;
                if (source == label6) b2 = pirat;
                if (source == label7) b2 = uzdrowicielka;
                if (source == label8) b2 = ninja;
                if (source == label9) b2 = rycerz;
                if (source == label10) b2 = druid;
                if (source == label11) b2 = assasin;
                if (source == label12) b2 = demon;
                break;
            case 3:
                if (source == label1) b3 = czarownica;
                if (source == label2) b3 = wampir;
                if (source == label3) b3 = palladyn;
                if (source == label4) b3 = szamanka;
                if (source == label5) b3 = mag;
                if (source == label6) b3 = pirat;
                if (source == label7) b3 = uzdrowicielka;
                if (source == label8) b3 = ninja;
                if (source == label9) b3 = rycerz;
                if (source == label10) b3 = druid;
                if (source == label11) b3 = assasin;
                if (source == label12) b3 = demon;
                break;
        }
    }

    public void wyczysc(int i) {
        switch (i) {
            case 1:
                bohater1 = null;
                break;
            case 2:
                bohater2 = null;
                break;
            case 3:
                bohater3 = null;
                break;
        }
    }

    int i = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bitwa) {
            if (i == 3) {
                poziomtrudnosci = wybierzpoziom.getSelectedIndex();
                losujPotwora();
                przygotowanie(b1, b2, b3, p);
                new Bitwa();
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(error, "Wybierz 3 bohaterów, aby zacząć bitwe.");
            }
        }
        if(e.getSource()==reset) {
            poziomtrudnosci = 0;
            bohater1 = null;
            bohater2 = null;
            bohater3 = null;
            new Postacie();
            dispose();
        }
        if(e.getSource()==wróć) {
            new Okno();
            dispose();
        }
        if(e.getSource()==wybierzpoziom) {
            poziomtrudnosci = wybierzpoziom.getSelectedIndex();
            if (poziomtrudnosci == 0) latwy.setBackground(zielony);
            if (poziomtrudnosci == 1) latwy.setBackground(zolty);
            if (poziomtrudnosci == 2) latwy.setBackground(czerwony);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel) e.getSource();
            if (source.getBorder() != border2) {
                if (i < 3) {
                    source.setBorder(border2);
                    i++;
                    wybierz(i,source);
                }
            }
            else {
                source.setBorder(border);
                wyczysc(i);
                i--;
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        JLabel source = (JLabel) e.getSource();
        for (JLabel label : labels) {
            if (label.getBorder() != border2 && source == label) label.setBorder(border);
        }
        if (source == label1) label0.setText(czarownica.toString());
        if (source == label2) label0.setText(wampir.toString());
        if (source == label3) label0.setText(palladyn.toString());
        if (source == label4) label0.setText(szamanka.toString());
        if (source == label5) label0.setText(mag.toString());
        if (source == label6) label0.setText(pirat.toString());
        if (source == label7) label0.setText(uzdrowicielka.toString());
        if (source == label8) label0.setText(ninja.toString());
        if (source == label9) label0.setText(rycerz.toString());
        if (source == label10) label0.setText(druid.toString());
        if (source == label11) label0.setText(assasin.toString());
        if (source == label12) label0.setText(demon.toString());
    }

    @Override
    public void mouseExited(MouseEvent e) {

        JLabel source = (JLabel) e.getSource();
        for (JLabel label : labels) {
            if (label.getBorder() != border2 && source == label) label.setBorder(null);
        }
        //label0.setText(null);
    }
}

