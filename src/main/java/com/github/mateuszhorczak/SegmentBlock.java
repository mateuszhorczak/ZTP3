package com.github.mateuszhorczak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//segment bez mozliwosci przejscia
class SegmentBlock extends Segment {
    public SegmentBlock(int x, int y, String file) {
        super(x, y, file);
    }

    public void collisionV(Sprite sprite) {
        sprite.stopJump();
    }

    public void collisionH(Sprite sprite) {
        sprite.stopMove();
    }
}
