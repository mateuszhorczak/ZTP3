package com.github.mateuszhorczak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class Game extends JPanel {
    private ArrayList<Segment> board;
    private Sprite sprite;
    private SegmentBuilder builder;

    private void createBoard(String file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
//            builder = new ConcreteSegmentBuilder();   // to switch builder comment / uncomment
            builder = new SecondSegmentBuilder();   //  to switch builder comment / uncomment

            String line;
            int characters;

            while ((line = br.readLine()) != null) {
                characters = 0;
                while ((line.length() - characters) >= 3) {
                    char character = line.charAt(characters++);
                    char number1 = line.charAt(characters++);
                    char number2 = line.charAt(characters++);
                    int number = (number1 - '0') * 10 + (number2 - '0');

                    switch (character) {
                        case 'X':
                            builder.addSegmentX(number);
                            break;
                        case 'A':
                            builder.addSegmentA(number);
                            break;
                        case 'B':
                            builder.addSegmentB(number);
                            break;
                        case 'C':
                            builder.addSegmentC(number);
                            break;
                        case 'G':
                            builder.addSegmentG(number);
                            break;
                    }
                }
                builder.nextRow();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Blad wczytania planszy");
            e.printStackTrace();
        }
        board = builder.getBoard();
//        return board;
    }


    public Game(String plik) {
        setPreferredSize(new Dimension(424, 268));
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        sprite.stop();
                        break;
                }
            }

            public void keyPressed(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        sprite.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        sprite.right();
                        break;

                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_UP:
                        sprite.jump();
                        break;
                }
            }
        });

        setFocusable(true);
        createBoard(plik);
        sprite = new Sprite(board);

        new Thread(new SpriteController(sprite, board, this)).start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Segment s : board)
            s.draw(g);
        sprite.draw(g);
    }
}
