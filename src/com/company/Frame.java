package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    PGraphics pgraphics = new PGraphics();
    public Frame() {
        this.setSize(840, 840);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(pgraphics);
        this.setTitle("I/O System");
        //this.pack();
        this.setVisible(true);
    }
}
