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
package com.example.krokodilce.src.handlers;

import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.imports.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                              IMAGE HANDLER                                 \\
//****************************************************************************\\
 public class ImageHandler{
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
    //                              METHODS                                   \\
    //************************************************************************\\
        public BufferedImage createImage(File img){
        BufferedImage imgTemp = null;
        try {
            imgTemp = ImageIO.read(img);
        } catch (IOException e) {
        }
        return imgTemp;
        }
        //This are program specific methods, more general methods will be made
        //some other time and in some next itteration. Until then, let this stay
        //the way it is
        //
        //TBA!!! MAKE A NEW ENCAPSULATION OF ALL THIS METHODS, and AS BEFORE I LOVE YOU MAN :) gj :)
        public BufferedImage resizeImage(JLabel label, BufferedImage originalImage){
        BufferedImageOp op = null;
        Integer WIDTH = label.getWidth();
        Integer HEIGHT = label.getHeight();
        BufferedImage resize = Scalr.resize(originalImage, WIDTH, HEIGHT, op);
        
        return resize;
        }
        
        public void initImage(JLabel label, File file){
            BufferedImage original = createImage(file);
            BufferedImage resize = resizeImage(label, original);
            ImageIcon imgIcon = getImageIcon(resize);
            //TBA LABEL RESIZE
            label.setIcon(imgIcon);
        }

        public ImageIcon getImageIcon(BufferedImage img){
            return new ImageIcon(img);
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
//                              END                                           \\
//****************************************************************************\\
}
