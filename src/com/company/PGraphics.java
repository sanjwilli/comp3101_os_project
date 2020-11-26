package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This class will implement the action, listen interface.
public class PGraphics extends JPanel implements ActionListener{

    private JLabel label;
    private JButton Introduction_button;
    private JButton DMA_button;
    private JButton Interrupt_button;
    private JButton drivers_button;
    private JPanel panel;


    public PGraphics() {

        // Giving an Heading to the panel
        label = new JLabel("COMP3101 I/O System Group Simulation");

        //Initializing the different button in the to Show the different Simulations
        Introduction_button = new JButton("Introduction");
        this.Introduction_button.addActionListener(this);
        drivers_button = new JButton("Device Controllers Simulation");
        this.drivers_button.addActionListener(this);
        Interrupt_button = new JButton("Interrupt Simulation");
        this.Interrupt_button.addActionListener(this);
        DMA_button = new JButton("DMA Simulation");
        this.DMA_button.addActionListener(this);



        this.setBounds(0, 0, 840,840);
        this.add(label);
        this.add(Introduction_button);
        this.add(drivers_button);
        this.add(Interrupt_button);
        this.add(DMA_button);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Introduction_button) {
            System.out.println("Intro was clicked");
            Introduction_button.setText("Intro was click");
        }else {
            System.out.println("Ntn should happen");
        }
    }

    /*Timer timer = new Timer(10, this);
    int x = 1;
    int y = 1;
    int velocityX = 1;
    int velocityY = 1;

    public PGraphics() {
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(new Color(50,255,255));

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.YELLOW);
        g2D.fillOval(x,y,100,100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(x>=740 || x<=0) {
            velocityX = -velocityX;
        }

        x = x + velocityX;
        repaint();
    }*/
}
