package com.uwbothell.softwaremanagement.util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {
    public static ImageIcon createCompressedImage(BufferedImage pic, int width, int height) {
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = newImage.createGraphics();
        g.drawImage(pic, 0, 0, width, height, null);
        g.dispose();

        return new ImageIcon(newImage);
    }
}
