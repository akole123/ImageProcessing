package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

class ColourSwatch extends BufferedImage {
    public ColourSwatch(int width, int height, Color colour){
        super(width,height,BufferedImage.TYPE_INT_RGB);
        int iCol = (colour.getRed()<<16) + (colour.getGreen()<<8) + colour.getBlue();
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                setRGB(x, y, iCol);

    }
}