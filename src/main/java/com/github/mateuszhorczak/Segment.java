package com.github.mateuszhorczak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//klasa bazowa dla segmentow
class Segment {
    protected Image img;
    protected int x, y;
    protected int W, H;

    public Segment(int x, int y, String file) {
        this.x = x;
        this.y = y;
        img = new ImageIcon(file).getImage();
        W = img.getWidth(null);
        H = img.getHeight(null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, W, H);
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public void tick() {
    }

    public void collisionV(Sprite sprite) {
    }

    public void collisionH(Sprite sprite) {
    }
}