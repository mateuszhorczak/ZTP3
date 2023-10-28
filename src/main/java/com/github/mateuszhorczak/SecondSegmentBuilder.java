package com.github.mateuszhorczak;

import java.util.ArrayList;

public class SecondSegmentBuilder implements SegmentBuilder {
    private ArrayList<Segment> board = new ArrayList<>();
    private int x = 4;
    private int y = 4;
    private final int tileSize = 32;

    @Override
    public void addSegmentX(int value) {
        x += value * tileSize;
    }

    @Override
    public void addSegmentA(int value) {
        for (int i = 0; i < value; ++i) {
            Segment s = new SegmentBlock(x, y, "src/main/resources/img/block1.png");
            board.add(s);
            x += tileSize;
        }
    }

    @Override
    public void addSegmentB(int value) {
        for (int i = 0; i < value; ++i) {
            Segment s = new SegmentBlockV(x, y, "src/main/resources/img/block2.png");
            board.add(s);
            x += tileSize;
        }
    }

    @Override
    public void addSegmentC(int value) {
        for (int i = 0; i < value; ++i) {
            Segment s = new SegmentBlock(x, y, "src/main/resources/img/block3.png");
            board.add(s);
            x += tileSize;
        }
    }

    @Override
    public void addSegmentG(int value) {
        for (int i = 0; i < value; ++i) {
            Segment s = new SegmentAnim(x, y, "src/main/resources/img/bonus.png", new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 2, 2, 1, 1, 1, 0, 0});
            board.add(s);
            x += tileSize;
        }
    }

    @Override
    public void nextRow() {
        y += tileSize;
        x = 4;
    }

    public ArrayList<Segment> getBoard() {
        return board;
    }
}

