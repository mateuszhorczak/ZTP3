package com.github.mateuszhorczak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//segment, na ktory mozna wskoczyc
class SegmentBlockV extends Segment {
    public SegmentBlockV(int x, int y, String file) {
        super(x, y, file);
    }

    public void collisionV(Sprite sprite) {
        if (sprite.jumpingDown() && sprite.getBottomY() == y)
            sprite.stopJump();
    }
}