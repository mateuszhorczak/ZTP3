package com.github.mateuszhorczak;

import java.util.ArrayList;

public interface SegmentBuilder {
    void addSegmentX(int value);
    void addSegmentA(int value);
    void addSegmentB(int value);
    void addSegmentC(int value);
    void addSegmentG(int value);
    void nextRow();
    ArrayList<Segment> getBoard();
}
