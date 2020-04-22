package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyPage extends JFrame {
    JComboBox fromCurrency, toCurrency;
    JTextField fromText, toText;
    JButton calculate, back;
    JLabel from_label, to_label, enter_label, converted_label, string_check_label;
    double input = 0, result = 0;

    public CurrencyPage() {
        setTitle("Currency Converter");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage mp = new MainPage();
                dispose();
            }
        });
        back.setBounds(20, 300, 70, 30);
        add(back);
        from_label = new JLabel("From:");
        from_label.setBounds(30, 40, 250, 30);
        add(from_label);
        fromCurrency = new JComboBox();
        fromCurrency.setBounds(30, 70, 150, 30);
        fromCurrency.addItem("US Dollar");
        fromCurrency.addItem("Canadian Dollar");
        fromCurrency.addItem("Indian Rupee");
        fromCurrency.addItem("European Euro");
        fromCurrency.addItem("British Pound");
        add(fromCurrency);

        to_label = new JLabel("To:");
        to_label.setBounds(200, 40, 250, 30);
        add(to_label);
        toCurrency = new JComboBox();
        toCurrency.setBounds(200, 70, 150, 30);
        toCurrency.addItem("US Dollar");
        toCurrency.addItem("Canadian Dollar");
        toCurrency.addItem("Indian Rupee");
        toCurrency.addItem("European Euro");
        toCurrency.addItem("British Pound");
        add(toCurrency);

        enter_label = new JLabel("Enter amount to convert:");
        enter_label.setBounds(50, 110, 250, 30);
        add(enter_label);
        fromText = new JTextField(15);
        fromText.setBounds(50, 140, 300, 30);
        add(fromText);

        converted_label = new JLabel("Converted amount:");
        converted_label.setBounds(50, 170, 250, 30);
        add(converted_label);
        toText = new JTextField(15);
        toText.setBounds(50, 200, 300, 30);
        toText.setEditable(false);
        add(toText);

        string_check_label = new JLabel(" ");
        string_check_label.setBounds(170, 100, 150, 50);
        add(string_check_label);

        calculate = new JButton("CALCULATE");
        calculate.setBounds(150, 250, 100, 30);
        add(calculate);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regex = new String("^\\d+\\.?\\d*$");
                if (fromText.getText().matches(regex)) {
                    string_check_label.setForeground(Color.green);
                    string_check_label.setText("✓");
                } else {
                    string_check_label.setForeground(Color.red);
                    string_check_label.setText("INVALID AMOUNT ENTERED");
                    return;
                }


                input = Double.parseDouble(fromText.getText());

                if (fromCurrency.getSelectedItem() == "US Dollar") {
                    ConvertDollar();
                } else if (fromCurrency.getSelectedItem() == "Canadian Dollar") {
                    ConvertCDollar();
                } else if (fromCurrency.getSelectedItem() == "Indian Rupee") {
                    ConvertRupee();
                } else if (fromCurrency.getSelectedItem() == "European Euro") {
                    ConvertEuro();
                } else {
                    ConvertPound();
                }
            }
        });
    }


    public void ConvertDollar() {
        if (toCurrency.getSelectedItem() == "US Dollar") {
            result = (input);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Canadian Dollar") {
            result = (input * 1.39);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Indian Rupee") {
            result = (input * 76.18);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "European Euro") {
            result = (input * 0.91);
            toText.setText("" + result);
        } else {
            result = (input * 0.8);
            toText.setText("" + result);
        }
    }

    public void ConvertCDollar() {
        if (toCurrency.getSelectedItem() == "US Dollar") {
            result = (input * 0.72);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Canadian Dollar") {
            result = (input);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Indian Rupee") {
            result = (input * 54.70);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "European Euro") {
            result = (input * 0.66);
            toText.setText("" + result);
        } else {
            result = (input * 0.58);
            toText.setText("" + result);
        }
    }

    public void ConvertRupee() {
        if (toCurrency.getSelectedItem() == "US Dollar") {
            result = (input * 0.013);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Canadian Dollar") {
            result = (input * 0.018);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Indian Rupee") {
            result = (input);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "European Euro") {
            result = (input * 0.012);
            toText.setText("" + result);
        } else {
            result = (input * 0.011);
            toText.setText("" + result);
        }
    }

    public void ConvertEuro() {
        if (toCurrency.getSelectedItem() == "US Dollar") {
            result = (input * 1.09);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Canadian Dollar") {
            result = (input * 1.52);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Indian Rupee") {
            result = (input * 83.38);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "European Euro") {
            result = (input);
            toText.setText("" + result);
        } else {
            result = (input * 0.88);
            toText.setText("" + result);
        }
    }

    public void ConvertPound() {
        if (toCurrency.getSelectedItem() == "US Dollar") {
            result = (input * 1.24);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Canadian Dollar") {
            result = (input * 1.73);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "Indian Rupee") {
            result = (input * 94.82);
            toText.setText("" + result);
        } else if (toCurrency.getSelectedItem() == "European Euro") {
            result = (input * 1.14);
            toText.setText("" + result);
        } else {
            result = (input);
            toText.setText("" + result);
        }
    }

}
