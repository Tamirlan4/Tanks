package com.tamirlan4.main;

import com.tamirlan4.display.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Main {
    public static void main(String[] args) {
        Display.create(800,600,"Tanks");
        Timer t = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.render();
            }
        });

        t.setRepeats(true);
        t.start();

    }
}