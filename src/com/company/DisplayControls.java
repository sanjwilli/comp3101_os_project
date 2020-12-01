package com.company;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vaun
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
public class DisplayControls extends Canvas {
    private Canvas can = null;
    private Graphics gr = null;
    private JTextPane p = null;

    DisplayControls(Canvas a, JTextPane pane) {
        this.can = a;
        this.gr = a.getGraphics();
        this.p = pane;
    }



    public void setup(){//function that sets up basic DMA layout
        gr.drawString("CPU", 55, 25);
        gr.drawRect(30, 30, 80, 40);

        gr.drawString("Cache", 55, 100);
        gr.drawRect(30, 105, 80, 40);

        gr.drawString("DMA Controller", 165, 75);
        gr.drawRect(160, 80, 110, 75);

        gr.drawString("CPU MEM BUS", 280, 145);
        gr.setColor(Color.LIGHT_GRAY);
        gr.fillRect(275, 115, 100, 10);

        gr.setColor(Color.black);
        gr.drawString("Memory", 410, 75);
        gr.drawRect(380, 80, 120, 100);

        gr.drawString("Buffer", 425, 105);
        gr.drawRect(410, 110, 60, 30);
        gr.drawLine(450, 110, 450, 140);
        gr.drawLine(430, 110, 430, 140);
        gr.setColor(Color.red);
        gr.drawString("X", 415, 130);
        gr.setColor(Color.black);


        gr.drawString("DISK Controller", 390, 245);
        gr.drawRect(380, 250, 120, 100);
        gr.setColor(Color.red);
        gr.drawString("C = 3", 425, 275);
        gr.setColor(Color.black);
        gr.drawRect(410, 280, 60, 30);
        gr.setColor(Color.CYAN);
        gr.fillRect(412, 282, 57, 27);
        gr.setColor(Color.black);
        gr.drawLine(430, 280, 430, 310);
        gr.drawLine(450, 280, 450, 310);

        gr.drawString("PCI BUS", 100, 233);
        gr.setColor(Color.LIGHT_GRAY);
        gr.fillRect(30, 238, 300, 10);

        //Sets up inter-connections
        gr.setColor(Color.BLUE);//Blue will represent interconnections
        //CPU and cahe connector
        gr.drawLine(115, 45, 315, 45);
        gr.drawLine(135, 130, 135, 45);
        gr.drawLine(135, 130, 115, 130);
        gr.drawLine(315, 45, 315, 110);

        //DMA
        gr.drawLine(225, 160, 225, 230);

        //DISK
        gr.drawLine(190, 250, 190, 290);
        gr.drawLine(190, 290, 375, 290);
        gr.setColor(Color.black);

    }

    public void steps(){
        try {
            TimeUnit.SECONDS.sleep(5);
            gr.drawString("DISK Controller initiates DMA Transfer", 340, 370);
        } catch (InterruptedException ex) {
            Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
        }


        try {
            //First Movement
            TimeUnit.SECONDS.sleep(5);
            gr.clearRect(410, 280, 20, 31);//Clear first byte
            gr.clearRect(320, 355, 300, 30);//Clear text
            gr.clearRect(420, 260, 50, 20);//Clear C number
            gr.setColor(Color.red);
            gr.drawString("C = 2", 425, 275);//New C value
            gr.setColor(Color.black);
            gr.drawString("DISK Controller sends each byte to DMA Controller", 300, 370);
            gr.drawRect(350, 300, 20 ,30 );
            gr.setColor(Color.CYAN);
            gr.fillRect(351, 301, 19, 29);
            gr.setColor(Color.black);

            //second movement - possibly loop?
            int x = 349;
            int y = 299;
            int l = 22;
            int w = 32;

            //moves horizontally left
            for(int a = 1; a<=4; a++){
                try{
                    TimeUnit.SECONDS.sleep(1);
                    gr.clearRect(x, y, 22, 32);
                    gr.drawRect(x-49, y+1, l-2 ,w-2 );
                    gr.setColor(Color.CYAN);
                    gr.fillRect(x-48, y+2, l-3, w-3);
                    gr.setColor(Color.black);
                    x-=50;

                }catch (InterruptedException ex) {
                    Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //Moves Vertically up
            for(int a = 1; a<=2; a++){
                try{
                    TimeUnit.SECONDS.sleep(1);
                    gr.clearRect(x, y, 22, 32);
                    gr.drawRect(x+1, y-49, l-2 ,w-2 );
                    gr.setColor(Color.CYAN);
                    gr.fillRect(x+2, y-48, l-3, w-3);
                    gr.setColor(Color.black);
                    y-=50;

                }catch (InterruptedException ex) {
                    Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Moves Horizontally right
            try{
                TimeUnit.SECONDS.sleep(1);
                gr.clearRect(x, y-1, 22, 33);
                gr.drawRect(x+49, y-1, l-2 ,w-2 );
                gr.setColor(Color.CYAN);
                gr.fillRect(x+50, y, l-3, w-3);
                gr.setColor(Color.black);
                x+=49;

            }catch (InterruptedException ex) {
                Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Moves Vertically up
            try{
                TimeUnit.SECONDS.sleep(1);
                gr.clearRect(x, y-1, 22, 33);
                gr.drawRect(x+10, y-100, l-2 ,w-2 );
                gr.setColor(Color.CYAN);
                gr.fillRect(x+11, y-99, l-3, w-3);
                gr.setColor(Color.black);
                gr.clearRect(250, 355, 600, 30);//Clear text
                gr.drawString("DMA control transfers bytes to buff X, increm mem addr", 240, 210);
                x+= 10;
                y-=100;

            }catch (InterruptedException ex) {
                Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Moves Horizontally right and into buffer location X
            try{
                TimeUnit.SECONDS.sleep(3);
                gr.clearRect(x, y-1, 22, 33);
                gr.drawRect(x+74, y-20, l-2 ,w-2 );
                gr.setColor(Color.CYAN);
                gr.fillRect(x+75, y-19, l-3, w-3);
                gr.setColor(Color.black);
                x+=74;
                y-=20;
                TimeUnit.SECONDS.sleep(1);
                gr.clearRect(x, y-1, 22, 33);
                gr.drawRect(x+65, y, l-2, w-2);
                gr.setColor(Color.CYAN);
                gr.fillRect(x+66, y+1, l-3, w-3);
                gr.setColor(Color.black);
                x+=65;
                TimeUnit.SECONDS.sleep(1);
                gr.clearRect(x, y-1, 22, 33);
                gr.setColor(Color.cyan);
                gr.fillRect(411, 111, l-3, w-3);
                gr.setColor(Color.red);
                gr.drawString("X", 435, 130);
                gr.setColor(Color.black);
                TimeUnit.SECONDS.sleep(5);
                gr.clearRect(10, 10, 700, 600);

            }catch (InterruptedException ex) {
                Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
            }




//            TimeUnit.SECONDS.sleep(1);
//            gr.clearRect(349, 299, 22, 32);
//            gr.drawRect(300, 300, 20 ,30 );
//            gr.setColor(Color.CYAN);
//            gr.fillRect(301, 301, 19, 29);
//            gr.setColor(Color.black);
//
//            //third movement
//            TimeUnit.SECONDS.sleep(1);
//            gr.clearRect(299, 299, 22, 32);
//            gr.drawRect(250, 300, 20 ,30 );
//            gr.setColor(Color.CYAN);
//            gr.fillRect(251, 301, 19, 29);
//            gr.setColor(Color.black);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//            gr.clearRect(249, 299, 22, 32);
//            gr.drawRect(200, 300, 20 ,30 );
//            gr.setColor(Color.CYAN);
//            gr.fillRect(201, 301, 19, 29);
//            gr.setColor(Color.black);
        } catch (InterruptedException ex) {
            Logger.getLogger(DisplayControls.class.getName()).log(Level.SEVERE, null, ex);
        }


    }





    public void CPU_to_DMA(){
        try {
            //CPU to DMA Controller
            TimeUnit.SECONDS.sleep(5);
            gr.setColor(Color.BLUE);
            gr.drawLine(131, 50, 190, 50);
            gr.drawString(">", 190, 54);
        } catch (InterruptedException ex) {
            Logger.getLogger(DMA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DMA_to_DISK(){
        try{
            //DMA Controller to disk Controller
            TimeUnit.SECONDS.sleep(5);
            gr.drawLine(310, 70, 373, 70);
            gr.drawString(">", 373, 74);
        } catch (InterruptedException ex) {
            Logger.getLogger(DMA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




}
