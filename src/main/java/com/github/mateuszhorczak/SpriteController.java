package com.github.mateuszhorczak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class SpriteController implements Runnable {
    private final Sprite sprite;
    private final ArrayList<Segment> plansza;
    private final JPanel panel;
    public SpriteController(Sprite sp, ArrayList<Segment> pl, JPanel pan) {
        sprite=sp;
        plansza=pl;
        panel=pan;
    }
    public void run() {
        while(true) {
            sprite.tick();
            for(Segment s:plansza)
                s.tick();
            panel.repaint();
            Thread.currentThread().yield();
            try {
                Thread.currentThread().sleep(40);
            }catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
