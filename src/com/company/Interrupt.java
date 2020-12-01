package com.company;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

//Eversley Francis - 620106294

public class Interrupt extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    JButton startBtn;
    JTextArea textArea;
    JScrollPane scrollPane;

    /*public static void main(String[] args) {
        Interrupt start = new Interrupt();
        start.paint(null);

    }*/

    public Interrupt(){
        setTitle("I/O Interrupt");
        setSize(1000, 600);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);


        textArea= new JTextArea(10, 25);
        textArea.setBounds(720, 20, 250, 420);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setEditable(true);


        startBtn = new JButton("Start");
        startBtn.setBounds(820, 470, 100, 50);
        startBtn.addActionListener(this);

        add(textArea);
        add(startBtn);


        setVisible(true);
    }

    public void paint(Graphics g){
        g.drawRect(20, 50, 250, 100); // CPU
        g.drawString("CPU", 125, 100);//CPU Text

        g.drawRect(20,  250, 250, 50);//Device Driver
        g.drawString("Device Driver",100 , 275);//Device Driver Text

        g.drawRect(20, 370, 250, 50);//Device Controller
        g.drawString("Device Controller", 105, 395);//Device Controller Text

        g.drawRect(20, 500, 250, 50); // Device
        g.drawString("Device", 125, 525);//Device Text

        g.drawRect(450, 50, 250, 420);//Memory
        g.drawString("Memory",460,60);//Memory Text
        g.drawString("Instructions and \n Data", 525, 250);

        //Down
        g.drawLine(100, 150, 100, 250);
        g.drawLine(150, 150, 150,250);
        g.drawLine(100, 300, 100 , 370);
        g.drawLine(100, 420, 100, 500);

        //Up
        g.drawLine(200, 500, 200, 420);
        g.drawLine(200, 370, 200, 300);
        g.drawLine(200, 250, 200, 150);

        //Across
        g.drawLine(270, 70, 450, 70);
        g.drawLine(270, 140, 450, 140);



        g.drawString("I/O Request", 20, 200);
        g.drawString("Comm. with DC register", 20, 350);
        g.drawString("Carries out operation", 20, 450);
        g.drawString("Interrupt (CPU performs other tasks)", 205, 200);
        g.drawString("Fetch-Execute cycle", 275, 65);
        g.drawString("Data Movement", 275, 135);
    }

    public void actionPerformed(ActionEvent e){
        textArea.setText("CPU is fetching instruction ...\n");


    }


}
