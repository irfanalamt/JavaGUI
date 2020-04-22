package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {


    public MainPage() {
        setTitle("Smart Converter v1");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        JButton currencyButton = new JButton("CURRENCY");
        currencyButton.setFont(new Font("TimesRoman", Font.PLAIN,15));
        JButton unitButton = new JButton("UNIT");
        unitButton.setFont(new Font("TimesRoman", Font.PLAIN,15));
        currencyButton.setBounds(70, 100, 150, 50);
        unitButton.setBounds(70, 200, 150, 50);
        currencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrencyPage cp = new CurrencyPage();
                dispose();

            }
        });
        add(currencyButton);
        unitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnitPage up = new UnitPage();
                dispose();
            }
        });
        add(unitButton);


        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        new MainPage();
    }

}
