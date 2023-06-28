package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bitwa extends Main implements ActionListener, MouseListener {

    JButton wyjdz;
    JButton poddaj;
    JButton reset;
    JButton atak;
    JButton czar;

    JPanel smierc1;
    JPanel smierc2;
    JPanel smierc3;
    JPanel info;    //tło do opisu
    JLabel opis;    //opis - tytuł
    JLabel opis2;   //dokładny opis
    JLabel label0;  //potwór
    JLabel label1;  //bohater1
    JLabel label2;  //bohater2
    JLabel label3;  //bohater3

    JProgressBar HPpotwora;
    JProgressBar HPbohatera1;
    JProgressBar HPbohatera2;
    JProgressBar HPbohatera3;

    Border border = BorderFactory.createLineBorder(Color.GREEN,5);

    Bitwa(){

        HPpotwora = new JProgressBar(0,potwor.zycie);
        HPpotwora.setValue(potwor.aktualneHP);
        HPpotwora.setBounds(50,0,700,50);
        HPpotwora.setStringPainted(true);
        HPpotwora.setFont(new Font("MV Boli",Font.BOLD,25));
        HPpotwora.setForeground(Color.red);
        HPpotwora.setBackground(Color.black);
        HPpotwora.setString(potwor.zycie + "/" + potwor.zycie +" HP");

        HPbohatera1 = new JProgressBar(0,bohater1.zycie);
        HPbohatera1.setValue(bohater1.aktualneHP);
        HPbohatera1.setBounds(150,250,100,25);
        HPbohatera1.setStringPainted(true);
        HPbohatera1.setFont(new Font("MV Boli",Font.BOLD,10));
        HPbohatera1.setForeground(Color.red);
        HPbohatera1.setBackground(Color.black);
        HPbohatera1.setString(bohater1.zycie + "/" + bohater1.zycie);

        HPbohatera2 = new JProgressBar(0,bohater2.zycie);
        HPbohatera2.setValue(bohater2.aktualneHP);
        HPbohatera2.setBounds(350,250,100,25);
        HPbohatera2.setStringPainted(true);
        HPbohatera2.setFont(new Font("MV Boli",Font.BOLD,10));
        HPbohatera2.setForeground(Color.red);
        HPbohatera2.setBackground(Color.black);
        HPbohatera2.setString(bohater2.zycie + "/" + bohater2.zycie);

        HPbohatera3 = new JProgressBar(0,bohater3.zycie);
        HPbohatera3.setValue(bohater3.aktualneHP);
        HPbohatera3.setBounds(550,250,100,25);
        HPbohatera3.setStringPainted(true);
        HPbohatera3.setFont(new Font("MV Boli",Font.BOLD,10));
        HPbohatera3.setForeground(Color.red);
        HPbohatera3.setBackground(Color.black);
        HPbohatera3.setString(bohater3.zycie + "/" + bohater3.zycie);


        label0 = new JLabel();
        label0.setIcon(potwor.obrazek);
        label0.setBounds(350,50, 100, 100);

        label1 = new JLabel();
        label1.setIcon(bohater1.obrazek);
        label1.setBounds(150, 275, 100, 100);
        smierc1 = new JPanel();
        smierc1.setBackground(szary);
        smierc1.setBounds(150, 275, 100, 100);
        smierc1.setVisible(false);

        label2 = new JLabel();
        label2.setIcon(bohater2.obrazek);
        label2.setBounds(350, 275, 100, 100);
        smierc2 = new JPanel();
        smierc2.setBackground(szary);
        smierc2.setBounds(350, 275, 100, 100);
        smierc2.setVisible(false);

        label3 = new JLabel();
        label3.setIcon(bohater3.obrazek);
        label3.setBounds(550, 275, 100, 100);
        smierc3 = new JPanel();
        smierc3.setBackground(szary);
        smierc3.setBounds(550, 275, 100, 100);
        smierc3.setVisible(false);

        atak = new JButton();
        atak.setBounds(200, 425, 100, 100);
        atak.addActionListener(this);
        atak.setText("Atak!");
        atak.setFocusable(false);

        czar = new JButton();
        czar.setBounds(350, 425, 100, 100);
        czar.addActionListener(this);
        czar.setText("Czar!");
        czar.setFocusable(false);

        atak.addMouseListener(this);
        czar.addMouseListener(this);

        JPanel panel = new JPanel();
        panel.setBackground(ciemny);
        panel.setBounds(25,400, 450, 150);

        info = new JPanel();
        info.setBackground(ciemny);
        info.setBounds(500,400, 250, 150);

        opis2 = new JLabel();
        opis2.setText("");
        opis2.setBounds(525,425, 200, 125);
        opis2.setFont(new Font("Consolas",Font.PLAIN,15));

        opis = new JLabel();
        opis.setText("Opis umiejętności:");
        opis.setBounds(520, 405, 200, 30);
        opis.setFont(new Font("Consolas",Font.BOLD,20));
        opis.setForeground(czarny);

        wyjdz = new JButton();
        wyjdz.setBounds(50, 495, 100, 30);
        wyjdz.addActionListener(this);
        wyjdz.setText("Wyjdz");
        wyjdz.setFocusable(false);

        poddaj = new JButton();
        poddaj.setBounds(50, 425, 100, 30);
        poddaj.addActionListener(this);
        poddaj.setText("Poddaj");
        poddaj.setFocusable(false);

        reset = new JButton();
        reset.setBounds(50, 460, 100, 30);
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
        this.add(smierc1);
        this.add(smierc2);
        this.add(smierc3);
        this.add(HPpotwora);
        this.add(HPbohatera1);
        this.add(HPbohatera2);
        this.add(HPbohatera3);
        this.add(label0);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(atak);
        this.add(czar);
        this.add(opis);
        this.add(opis2);
        this.add(wyjdz);
        this.add(poddaj);
        this.add(reset);
        this.add(panel);
        this.add(info);

        this.setIconImage(ikona.getImage());
        this.getContentPane().setBackground(kolor);
        czyjaTura();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==poddaj) {
            new Przegrana();
            dispose();
        }
        if(e.getSource()==reset) {
            losujPotwora();
            przygotowanie(b1,b2,b3,p);
            new Bitwa();
            dispose();
        }
        if(e.getSource()==wyjdz) {
            poziomtrudnosci = 0;
            bohater1 = null;
            bohater2 = null;
            bohater3 = null;
            potwor = null;
            new Okno();
            dispose();
        }
        if(e.getSource()==atak) {
            System.out.println(najszybszaPostac().name + " atakuje potwora - HP:" + potwor.aktualneHP + "  Szybkość: " + najszybszaPostac().szybkosc + "  Życie bohatera: " + najszybszaPostac().aktualneHP);
            try {
                turaAtak(najszybszaPostac());
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            czyjaTura();
            System.out.println("         Skonczył atak - HP:" + potwor.aktualneHP);
            wszyscyNieZyja();
        }
        if(e.getSource()==czar) {
            //label0.setBorder(border);
            System.out.println("Spell wciśnięty Potwór HP:" + potwor.aktualneHP);
            turaCzar(najszybszaPostac());
            czyjaTura();
            System.out.println("Spell zakończony Potwór HP:" + potwor.aktualneHP);
            wszyscyNieZyja();
        }
        //while (!najszybszaPostac().zyje()) wykonajTure(najszybszaPostac());
    }

    public void wszyscyNieZyja(){
        if (!bohater1.zyje() && !bohater2.zyje()  && !bohater3.zyje()) {
            new Przegrana();
            dispose();
        }
    }

    public void wykonajTure() {
        if (najszybszaPostac() == bohater1) bohater1.szybkosc += b1.szybkosc;
        else if (najszybszaPostac() == bohater2) bohater2.szybkosc += b2.szybkosc;
        else if (najszybszaPostac() == bohater3) bohater3.szybkosc += b3.szybkosc;
        else potwor.szybkosc += p.szybkosc;
    }

    public Postac najszybszaPostac() {
        if (bohater1.szybkosc <= bohater2.szybkosc && bohater1.szybkosc <= bohater3.szybkosc && bohater1.szybkosc <= potwor.szybkosc) return bohater1;
        else if (bohater2.szybkosc <= bohater3.szybkosc && bohater2.szybkosc <= potwor.szybkosc) return bohater2;
        else if (bohater3.szybkosc <= potwor.szybkosc) return bohater3;
        else return potwor;
    }

    public void czyjaTura() {
        label0.setBorder(null);
        label1.setBorder(null);
        label2.setBorder(null);
        label3.setBorder(null);
        if (bohater1.zyje() && bohater1.szybkosc <= bohater2.szybkosc && bohater1.szybkosc <= bohater3.szybkosc && bohater1.szybkosc <= potwor.szybkosc) label1.setBorder(border);
        else if (bohater2.zyje() && bohater2.szybkosc <= bohater3.szybkosc && bohater2.szybkosc <= potwor.szybkosc) label2.setBorder(border);
        else if (bohater3.zyje() && bohater3.szybkosc <= potwor.szybkosc) label3.setBorder(border);
        else {
            label0.setBorder(border);  //?????
            System.out.println("Tu koloruje się border hydry na zielono");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        JButton source = (JButton) e.getSource();
        if (label1.getBorder() == border && source == atak) opis2.setText(opiszAtak(bohater1));
        if (label2.getBorder() == border && source == atak) opis2.setText(opiszAtak(bohater2));
        if (label3.getBorder() == border && source == atak) opis2.setText(opiszAtak(bohater3));
        if (label1.getBorder() == border && source == czar) opis2.setText(opiszCzar(bohater1));
        if (label2.getBorder() == border && source == czar) opis2.setText(opiszCzar(bohater2));
        if (label3.getBorder() == border && source == czar) opis2.setText(opiszCzar(bohater3));
    }

    @Override
    public void mouseExited(MouseEvent e) {

        opis2.setText(null);
    }

    public void turaAtak(Postac postac) throws InterruptedException {

        if (postac != potwor && postac.zyje()) {
            potwor.atakBohateraWPotwora(postac, potwor);
            wykonajTure();
            aktualizujHPPotwora(HPpotwora);
            aktualizujHPBohatera(HPbohatera1, bohater1);
            aktualizujHPBohatera(HPbohatera2, bohater2);
            aktualizujHPBohatera(HPbohatera3, bohater3);
        }
        if (postac != potwor && !postac.zyje()) postac.aktualneHP = 0;
        while (!najszybszaPostac().zyje()) wykonajTure();
        if (potwor.zyje()) {
            if (najszybszaPostac() == potwor) {
                czyjaTura();
                atak.setEnabled(false);
                czar.setEnabled(false);
                Thread.sleep(500);
                System.out.println(najszybszaPostac().name + " atakuje bohaterów - HP:" + potwor.aktualneHP + "  Szybkość: " + najszybszaPostac().szybkosc);
                Thread.sleep(500);
                potwor.atakowanieBohaterów(bohater1, bohater2, bohater3, potwor);
                wykonajTure();
                atak.setEnabled(true);
                czar.setEnabled(true);
                aktualizujHPBohatera(HPbohatera1, bohater1);
                aktualizujHPBohatera(HPbohatera2, bohater2);
                aktualizujHPBohatera(HPbohatera3, bohater3);
            }
        }
        else {
            new Wygrana();
            dispose();
        }
    }

    public void turaCzar(Postac postac){

        if (postac != potwor && postac.zyje()) {
            if(postac.spell == 1) spellBohateraWPotwora(postac, potwor);
            else spellBohateraWPotwora(postac, potwor);
            wykonajTure();
            aktualizujHPPotwora(HPpotwora);
            aktualizujHPBohatera(HPbohatera1, bohater1);
            aktualizujHPBohatera(HPbohatera2, bohater2);
            aktualizujHPBohatera(HPbohatera3, bohater3);
        }
        if (postac != potwor && !postac.zyje()) postac.aktualneHP = 0;
        while (!najszybszaPostac().zyje()) wykonajTure();
        if (potwor.zyje()) {
            if (najszybszaPostac() == potwor) {
                czyjaTura();
                atak.setEnabled(false);
                czar.setEnabled(false);
                System.out.println(najszybszaPostac().name + " atakuje bohaterów - HP:" + potwor.aktualneHP + "  Szybkość: " + najszybszaPostac().szybkosc);
                potwor.atakowanieBohaterów(bohater1, bohater2, bohater3, potwor);
                wykonajTure();
                atak.setEnabled(true);
                czar.setEnabled(true);
                aktualizujHPBohatera(HPbohatera1, bohater1);
                aktualizujHPBohatera(HPbohatera2, bohater2);
                aktualizujHPBohatera(HPbohatera3, bohater3);
            }
        }
        else {
            new Wygrana();
            dispose();
        }
    }

    public void aktualizujHPPotwora(JProgressBar bar){

        int i = bar.getValue();
        while(i>=potwor.aktualneHP) {
            bar.setValue(i);
            bar.setString(i + "/" + potwor.zycie +" HP");
            /*
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            i -= 10;
        }
    }

    public void aktualizujHPBohatera(JProgressBar bar, Postac b) {

        int i = bar.getValue();
        if (i >= b.aktualneHP) {
            while (i >= b.aktualneHP) {
                bar.setValue(i);
                bar.setString(i + "/" + b.zycie);
            /*
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
                i -= 10;
            }
        } else {
            while (i <= b.aktualneHP) {
                bar.setValue(i);
                bar.setString(i + "/" + b.zycie);
            /*
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
                i += 10;
            }
        }
        if (i < 0) {
            bar.setBounds(0, 0, 0, 0);
            if (b == bohater1) smierc1.setVisible(true);
            if (b == bohater2) smierc2.setVisible(true);
            if (b == bohater3) smierc3.setVisible(true);
        }
    }

    public void spellBohateraWPotwora(Postac b, Potwor p){
        switch (b.spell) {
            case 1:
                leczenieWszystkich(p.krytAtak);
                aktualizujHPBohatera(HPbohatera1, bohater1);
                aktualizujHPBohatera(HPbohatera2, bohater2);
                aktualizujHPBohatera(HPbohatera3, bohater3);
            case 2:
                int kradziez = b.uderzenie() - p.obrona;
                p.aktualneHP = p.aktualneHP - kradziez;
                leczenieWszystkichOWartosc(kradziez);
            default:
                p.aktualneHP = p.aktualneHP - (b.uderzenie() - p.obrona);
        }
    }

    public void leczenieWszystkich(int procent) {
        if (bohater1.zyje()) bohater1.aktualneHP = bohater1.aktualneHP + bohater1.zycie * procent/100;
        if (bohater1.aktualneHP > bohater1.zycie) bohater1.aktualneHP = bohater1.zycie;
        if (bohater2.zyje()) bohater2.aktualneHP = bohater2.aktualneHP + bohater2.zycie * procent/100;
        if (bohater2.aktualneHP > bohater2.zycie) bohater2.aktualneHP = bohater2.zycie;
        if (bohater3.zyje()) bohater3.aktualneHP = bohater3.aktualneHP + bohater3.zycie * procent/100;
        if (bohater3.aktualneHP > bohater3.zycie) bohater3.aktualneHP = bohater3.zycie;
    }

    public void leczenieWszystkichOWartosc(int wartosc) {
        if (bohater1.zyje()) bohater1.aktualneHP = bohater1.aktualneHP + wartosc;
        if (bohater1.aktualneHP > bohater1.zycie) bohater1.aktualneHP = bohater1.zycie;
        if (bohater2.zyje()) bohater2.aktualneHP = bohater2.aktualneHP + wartosc;
        if (bohater2.aktualneHP > bohater2.zycie) bohater2.aktualneHP = bohater2.zycie;
        if (bohater3.zyje()) bohater3.aktualneHP = bohater3.aktualneHP + wartosc;
        if (bohater3.aktualneHP > bohater3.zycie) bohater3.aktualneHP = bohater3.zycie;
    }


}


