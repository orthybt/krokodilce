/*
 * Copyright (C) 2022 Stefan Todorovic <orthybt@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.example.krokodilce.src.util;

import com.example.krokodilce.src.cloud.Cloud;

import java.awt.*;

/**
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                                  PEN                                       \\
//****************************************************************************\\
public class Pen{
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    //************************************************************************\\
    //                          CONSTRUCTORS                                  \\
    //************************************************************************\\
    //************************************************************************\\
    //                          METHODS                                       \\
    //************************************************************************\\
    public void magentaThick(OrthyLine l){
        Drawer.drawLine_Magenta_Thick(l.getLine(), c.getGfx());
    }
    public void magenta(OrthyLine l){
        Drawer.drawLine_Magenta_Thin(l.getLine(), c.getGfx());
    }
    public void yellow(OrthyLine l){
        Drawer.drawLine_Yellow_Thick(l.getLine(), c.getGfx());
    }
    public void green(OrthyLine l){
        Drawer.drawLine_Green_Thin(l.getLine(), c.getGfx());
    }
    public void drawTestLine(OrthyLine l){
        Drawer.drawLine_Green_Thin(l.getLine(), c.getGfx());
    }
    public void drawText(String txt, Point destination){
        Drawer.drawText(txt, destination, c.guiHandler().getGfx());
    }
    //************************************************************************\\
    //                          GETTERS AND SETTERS                           \\
    //*************************|*|********************************************\\
    public Cloud getC() {
        return c;
    }
    public void setC(Cloud c) {
        this.c = c;
    }
//****************************************************************************\\
//                                  END                                       \\
//****************************************************************************\\
}
