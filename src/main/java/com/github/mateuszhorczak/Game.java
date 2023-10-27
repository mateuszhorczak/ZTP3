package com.github.mateuszhorczak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class Game extends JPanel {
    private final int TILESIZE = 32;

    private ArrayList<Segment> plansza;
    private Sprite sprite;

    private ArrayList<Segment> stworzPlansze(String plik) {
        BufferedReader br=null;
        try {
            br=new BufferedReader(new FileReader(plik));
            ArrayList<Segment> plansza=new ArrayList<Segment>();
            String linia;
            int x, y=4, liczba, znaki;
            char znak, cyfra1, cyfra2;
            while ((linia=br.readLine())!=null)  {
                x=4;znaki=0;
                while ((linia.length()-znaki)>=3) {
                    znak=linia.charAt(znaki++);
                    cyfra1=linia.charAt(znaki++);
                    cyfra2=linia.charAt(znaki++);
                    liczba=(cyfra1-'0')*10+(cyfra2-'0');
                    switch (znak) {
                        case 'X':
                            x+=liczba*TILESIZE;
                            break;
                        case 'A':
                            for (int i=0;i<liczba;++i) {
                                Segment s=new SegmentBlock(x, y, "src/main/resources/img/block1.png");
                                plansza.add(s);
                                x+=TILESIZE;
                            }
                            break;
                        case 'B':
                            for (int i=0;i<liczba;++i) {
                                Segment s=new SegmentBlockV(x, y, "src/main/resources/img/block2.png");
                                plansza.add(s);
                                x+=TILESIZE;
                            }
                            break;
                        case 'C':
                            for (int i=0;i<liczba;++i) {
                                Segment s=new Segment(x, y, "src/main/resources/img/block3.png");
                                plansza.add(s);
                                x+=TILESIZE;
                            }
                            break;
                        case 'G':
                            for (int i=0;i<liczba;++i) {
                                Segment s=new SegmentAnim(x, y, "src/main/resources/img/bonus.png", new int[] {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 2, 2, 1, 1, 1, 0, 0});
                                plansza.add(s);
                                x+=TILESIZE;
                            }
                            break;
                    }
                }
                y+=TILESIZE;
            }
            br.close();
            return plansza;
        } catch (IOException e) {
            System.out.println("Blad wczytania planszy");
            e.printStackTrace();
            return null;
        }
    }
    public Game(String plik) {
        setPreferredSize(new Dimension(424, 268));
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ev) {
                switch(ev.getKeyCode())	{
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        sprite.stop();
                        break;
                }
            }
            public void keyPressed(KeyEvent ev) {
                switch(ev.getKeyCode())	{
                    case KeyEvent.VK_LEFT:	sprite.left(); break;
                    case KeyEvent.VK_RIGHT:	sprite.right(); break;

                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_UP:
                        sprite.jump(); break;
                }
            }
        });

        setFocusable(true);
        plansza=stworzPlansze(plik);
        sprite=new Sprite(plansza);

        new Thread(new SpriteController(sprite, plansza, this)).start();
    }
    public void paint(Graphics g)	{
        super.paint(g);
        for(Segment s:plansza)
            s.draw(g);
        sprite.draw(g);
    }
}
