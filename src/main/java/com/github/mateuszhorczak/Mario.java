package com.github.mateuszhorczak;

import javax.swing.*;

public class Mario {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        JFrame frame = new JFrame("Mario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(new Game("src/main/resources/data/board1.txt")));
        frame.pack();
        frame.setVisible(true);
    }
}
