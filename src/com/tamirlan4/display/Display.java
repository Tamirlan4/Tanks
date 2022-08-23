package com.tamirlan4.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;


public abstract class Display {

    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;

    private static BufferedImage buffer;
    private static int[] bufferData;
    private static Graphics bufferGraphics;
    private static int clearColor;

    public static void create(int width, int height, String title, int _clearColor){

        if (created)
            return;
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas(){
            public void paint(Graphics g){
                super.paint(g);
                render(g);
            }
        };

        Dimension size = new Dimension(width,height);
        content.setPreferredSize(size);
        content.setBackground(Color.BLUE);

        window.setResizable(false);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        buffer = new BufferedImage(width, height , BufferedImage.TYPE_INT_ARGB);
        bufferData = ( (DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();
        clearColor = _clearColor;
        created = true;

    }

    public static void clear(){
        Arrays.fill(bufferData, clearColor);
    }
    public static void render() {
        content.repaint();
    }
    private static void render(Graphics g){
        g.setColor(Color.black);
        g.fillOval(400-50,300-50,100,100);
    }
}
