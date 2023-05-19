/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.krokodilce.src.util;

//import objects.*;

import java.awt.*;
import java.awt.geom.Line2D;
import com.example.krokodilce.src.memory.GuiComponents;
import com.example.krokodilce.src.memory.Lines;

/**
 *
 * @author stali
 */
public final class Drawer {
    private static final Drawer template = new Drawer();

    public static Drawer get(){
        return template;
    }
    //************************************************************************\\
    public static void drawPoint_Black(Point p, Graphics2D gfx){
        gfx.setColor(Color.BLACK);
        gfx.drawOval(p.x, p.y, 3, 3);
    }
    public static void drawPoint_Red(Point p, Graphics2D gfx){
        gfx.setColor(Color.RED);
        gfx.drawOval(p.x, p.y, 9, 9);
    }
    public static void drawPoint_Green(Point p, Graphics2D gfx){
        gfx.setColor(Color.GREEN);
        gfx.drawOval(p.x, p.y, 9, 9);
    }
    public static void drawPoint_White(Point p, Graphics2D gfx){
        gfx.setColor(Color.WHITE);
        gfx.drawOval(p.x, p.y, 9, 9);
    }
    public static void drawPoint_Yellow(Point p, Graphics2D gfx){
        gfx.setColor(Color.YELLOW);
        gfx.drawOval(p.x, p.y, 9, 9);
    }
    ///////************************************************//////////
    public static void drawLine_Black_Thin(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(1);
        gfx.setColor(Color.BLACK);
        gfx.draw(line);
    }
    public static void drawLine_Black_Thick(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(3);
        gfx.setColor(Color.BLACK);
        gfx.draw(line);
    }
    public static void drawLine_Yellow_Thin(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(1);
        gfx.setColor(Color.YELLOW);
        gfx.draw(line);
    }
    public static void drawLine_Yellow_Thick(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(3);
        gfx.setColor(Color.YELLOW);
        gfx.draw(line);
    }
    public static void drawLine_Red_Thin(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(1);
        gfx.setColor(Color.RED);
        gfx.draw(line);
    }
    public static void drawLine_Red_Thick(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(3);
        gfx.setColor(Color.RED);
        gfx.draw(line);
    }
    public static void drawLine_Green_Thin(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(1);
        gfx.setColor(Color.GREEN);
        gfx.draw(line);
    }
    public static void drawLine_Green_Thick(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(3);
        gfx.setColor(Color.GREEN);
        gfx.draw(line);
    }
    public static void drawLine_Magenta_Thin(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(1);
        gfx.setColor(Color.MAGENTA);
        gfx.setStroke(s);
        gfx.draw(line);
    }
    public static void drawLine_Magenta_Thick(Line2D line, Graphics2D gfx){
        BasicStroke s = new BasicStroke(3);
        gfx.setColor(Color.MAGENTA);
        gfx.setStroke(s);
        gfx.draw(line);
    }
    
    public static void drawText(String txt, Point destination, Graphics2D gfx){
        Font font = new Font("TimesRoman", Font.PLAIN, 30);
        gfx.setFont(font);
        gfx.drawString(txt, destination.x, destination.y);
    }
    ///////************************************************//////////
    public static void drawArc(Point coord, Graphics2D gfx){
        gfx.drawArc(5, 5, 200, 600, 180, 180);
    }
}
