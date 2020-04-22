package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitPage extends JFrame {

    JComboBox unitType, fromUnit, toUnit;
    JTextField fromText, toText;
    JButton convert, back;
    JLabel unitType_label, from_label, to_label, enter_label, converted_label,
            string_check_label;
    double input = 0, result = 0;

    public UnitPage() {
        setTitle("Unit Converter");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        back = new JButton("Back");
        back.setBounds(30, 400, 70, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage mp = new MainPage();
                dispose();
            }
        });

        unitType_label = new JLabel("Unit Type:");
        unitType_label.setBounds(30, 40, 250, 50);
        add(unitType_label);

        from_label = new JLabel("From:");
        from_label.setBounds(30, 110, 250, 50);
        add(from_label);

        unitType = new JComboBox();
        unitType.setBounds(30, 75, 150, 35);
        unitType.addItem("-Select Unit Type-");
        unitType.addItem("Length");
        unitType.addItem("Time");
        unitType.addItem("Temperature");
        unitType.addItem("Weight");
        unitType.addItem("Speed");

        add(unitType);
        fromUnit = new JComboBox();
        fromUnit.setBounds(30, 150, 150, 30);
        add(fromUnit);
        toUnit = new JComboBox();
        toUnit.setBounds(300, 150, 140, 30);
        add(toUnit);
        unitType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unitType.getSelectedItem() == "Length") {
                    fromUnit.removeAllItems();
                    toUnit.removeAllItems();
                    fromUnit.addItem("Millimetre");
                    fromUnit.addItem("Centimetre");
                    fromUnit.addItem("Metre");
                    toUnit.addItem("Millimetre");
                    toUnit.addItem("Centimetre");
                    toUnit.addItem("Metre");
                } else if (unitType.getSelectedItem() == "Time") {
                    fromUnit.removeAllItems();
                    toUnit.removeAllItems();
                    fromUnit.addItem("Second");
                    fromUnit.addItem("Minute");
                    fromUnit.addItem("Hour");
                    toUnit.addItem("Second");
                    toUnit.addItem("Minute");
                    toUnit.addItem("Hour");
                } else if (unitType.getSelectedItem() == "Temperature") {
                    fromUnit.removeAllItems();
                    toUnit.removeAllItems();
                    fromUnit.addItem("Celsius");
                    fromUnit.addItem("Fahrenheit");
                    fromUnit.addItem("Kelvin");
                    toUnit.addItem("Celsius");
                    toUnit.addItem("Fahrenheit");
                    toUnit.addItem("Kelvin");
                } else if (unitType.getSelectedItem() == "Weight") {
                    fromUnit.removeAllItems();
                    toUnit.removeAllItems();
                    fromUnit.addItem("Gram");
                    fromUnit.addItem("Kilogram");
                    fromUnit.addItem("Pound");
                    toUnit.addItem("Gram");
                    toUnit.addItem("Kilogram");
                    toUnit.addItem("Pound");
                } else if (unitType.getSelectedItem() == "Speed") {
                    fromUnit.removeAllItems();
                    toUnit.removeAllItems();
                    fromUnit.addItem("Metre per second");
                    fromUnit.addItem("Kilometre per hour");
                    fromUnit.addItem("Miles per hour");
                    toUnit.addItem("Metre per second");
                    toUnit.addItem("Kilometre per hour");
                    toUnit.addItem("Miles per hour");

                }
            }
        });

        to_label = new JLabel("To:");
        to_label.setBounds(300, 110, 250, 50);
        add(to_label);

        enter_label = new JLabel("Enter Value To Convert:");
        enter_label.setBounds(30, 190, 250, 30);
        add(enter_label);

        fromText = new JTextField(15);
        fromText.setBounds(30, 220, 200, 30);
        add(fromText);

        converted_label = new JLabel("Converted Value:");
        converted_label.setBounds(30, 250, 250, 30);
        add(converted_label);

        toText = new JTextField(15);
        toText.setBounds(30, 280, 200, 30);
        toText.setEditable(false);
        add(toText);

        string_check_label = new JLabel(" ");
        string_check_label.setBounds(150, 180, 150, 50);
        add(string_check_label);

        convert = new JButton("CONVERT");
        convert.setBounds(300, 220, 100, 30);
        add(convert);
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regex = new String("^\\d+\\.?\\d*$");
                String regex_negativeIncluded = new String("^[+-]?\\d+\\.?\\d*$");
                if ((!unitType.getSelectedItem().equals("Temperature") && fromText.getText().matches(regex)) || (unitType.getSelectedItem() == "Temperature" && fromText.getText().matches(regex_negativeIncluded))) {
                    string_check_label.setForeground(Color.green);
                    string_check_label.setText("✓");
                } else {
                    string_check_label.setForeground(Color.red);
                    string_check_label.setText("INVALID VALUE ENTERED");
                    return;
                }


                input = Double.parseDouble(fromText.getText());
                if (unitType.getSelectedItem() == "Length") {
                    if (fromUnit.getSelectedItem() == "Millimetre")
                        fromMillimetre();
                    else if (fromUnit.getSelectedItem() == "Centimetre")
                        fromCentimetre();
                    else fromMetre();
                } else if (unitType.getSelectedItem() == "Time") {
                    if (fromUnit.getSelectedItem() == "Second")
                        fromSecond();
                    else if (fromUnit.getSelectedItem() == "Minute")
                        fromMinute();
                    else if (fromUnit.getSelectedItem() == "Hour")
                        fromHour();
                } else if (unitType.getSelectedItem() == "Temperature") {
                    if (fromUnit.getSelectedItem() == "Celsius")
                        fromCelsius();
                    else if (fromUnit.getSelectedItem() == "Fahrenheit")
                        fromFahrenheit();
                    else fromKelvin();
                } else if (unitType.getSelectedItem() == "Weight") {
                    if (fromUnit.getSelectedItem() == "Gram")
                        fromGram();
                    else if (fromUnit.getSelectedItem() == "Kilogram")
                        fromKilogram();
                    else fromPound();

                } else if (unitType.getSelectedItem() == "Speed") {
                    if (fromUnit.getSelectedItem() == "Metre per second")
                        fromMps();
                    else if (fromUnit.getSelectedItem() == "Kilometre per hour")
                        fromKmph();
                    else if (fromUnit.getSelectedItem() == "Miles per hour")
                        fromMph();

                }
            }
        });
    }

    public void fromMillimetre() {
        if (toUnit.getSelectedItem() == "Millimetre")
            result = input;
        else if (toUnit.getSelectedItem() == "Centimetre")
            result = input / 10;
        else result = input / 1000;
        toText.setText("" + result);
    }

    public void fromCentimetre() {
        if (toUnit.getSelectedItem() == "Millimetre")
            result = input * 10;
        else if (toUnit.getSelectedItem() == "Centimetre")
            result = input;
        else result = input / 100;
        toText.setText("" + result);
    }

    public void fromMetre() {
        if (toUnit.getSelectedItem() == "Millimetre")
            result = input * 1000;
        else if (toUnit.getSelectedItem() == "Centimetre")
            result = input * 100;
        else result = input;
        toText.setText("" + result);
    }

    public void fromSecond() {
        if (toUnit.getSelectedItem() == "Second")
            result = input;
        else if (toUnit.getSelectedItem() == "Minute")
            result = input / 60;
        else result = input / 3600;
        toText.setText("" + result);
    }

    public void fromMinute() {
        if (toUnit.getSelectedItem() == "Second")
            result = input * 60;
        else if (toUnit.getSelectedItem() == "Minute")
            result = input;
        else result = input / 60;
        toText.setText("" + result);
    }

    public void fromHour() {
        if (toUnit.getSelectedItem() == "Second")
            result = input * 3600;
        else if (toUnit.getSelectedItem() == "Minute")
            result = input * 60;
        else result = input;
        toText.setText("" + result);
    }

    public void fromCelsius() {
        if (toUnit.getSelectedItem() == "Celsius")
            result = input;
        else if (toUnit.getSelectedItem() == "Fahrenheit")
            result = input * (9 / 5) + 32;
        else result = input + 273.15;
        toText.setText("" + result);
    }

    public void fromFahrenheit() {
        if (toUnit.getSelectedItem() == "Celsius")
            result = (input - 32) * (5 / 9);
        else if (toUnit.getSelectedItem() == "Fahrenheit")
            result = input;
        else result = (input - 32) * (5 / 9) + 273.15;
        toText.setText("" + result);
    }

    public void fromKelvin() {
        if (toUnit.getSelectedItem() == "Celsius")
            result = input - 273.15;
        else if (toUnit.getSelectedItem() == "Fahrenheit")
            result = (input - 273.15) * (9 / 5) + 32;
        else result = input;
        toText.setText("" + result);
    }

    public void fromGram() {
        if (toUnit.getSelectedItem() == "Gram")
            result = input;
        else if (toUnit.getSelectedItem() == "Kilogram")
            result = input / 1000;
        else result = input / 454;
        toText.setText("" + result);
    }

    public void fromKilogram() {
        if (toUnit.getSelectedItem() == "Gram")
            result = input * 1000;
        else if (toUnit.getSelectedItem() == "Kilogram")
            result = input;
        else result = input * 2.2046;
        toText.setText("" + result);
    }

    public void fromPound() {
        if (toUnit.getSelectedItem() == "Gram")
            result = input * 454;
        else if (toUnit.getSelectedItem() == "Kilogram")
            result = input / 2.2046;
        else result = input;
        toText.setText("" + result);
    }

    public void fromMps()
    {
        if (toUnit.getSelectedItem()=="Metre per second")
            result=input;
        else if (toUnit.getSelectedItem()=="Kilometre per hour")
            result=input*3.6;
        else result=input*2.237;
        toText.setText("" + result);
    }
    public void fromKmph()
    {
        if (toUnit.getSelectedItem()=="Metre per second")
            result=input/3.6;
        else if (toUnit.getSelectedItem()=="Kilometre per hour")
            result=input;
        else result=input/1.609;
        toText.setText("" + result);
    }
    public void fromMph()
    {
        if (toUnit.getSelectedItem()=="Metre per second")
            result=input/2.237;
        else if (toUnit.getSelectedItem()=="Kilometre per hour")
            result=input*1.609;
        else result=input;
        toText.setText("" + result);
    }


}







