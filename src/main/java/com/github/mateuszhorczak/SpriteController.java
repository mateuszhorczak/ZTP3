package com.github.mateuszhorczak;

import javax.swing.*;
import java.util.*;

class SpriteController implements Runnable {
    private final Sprite sprite;
    private final ArrayList<Segment> board;
    private final JPanel panel;

    public SpriteController(Sprite sp, ArrayList<Segment> pl, JPanel pan) {
        sprite = sp;
        board = pl;
        panel = pan;
    }

    public void run() {
        while (true) {
            sprite.tick();
            for (Segment s : board)
                s.tick();
            panel.repaint();
            Thread.currentThread().yield();
            try {
                Thread.currentThread().sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
