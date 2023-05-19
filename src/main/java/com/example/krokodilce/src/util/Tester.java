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

import com.example.krokodilce.src.XML_Wrappers.OrthyPaths;
import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.dataObjects.OrthyPath;
import com.example.krokodilce.src.dataObjects.Patient;

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                                  TESTER                                    \\
//****************************************************************************\\
public class Tester{
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
    //                          PATH METHODS                                  \\
    //************************************************************************\\
    public void testPath(Path path, String whatPathAreYouTesting){
        String test = String.format("%s\t%10s", 
                                    whatPathAreYouTesting,
                                    path.toAbsolutePath().toString());
        print(test);
    }
    public void testOrthyPath(OrthyPath path){
        print(path.toString());
    }
    public void testOrthyPaths(OrthyPaths paths){
        if(paths.equals(null)){
            print("THE PATHS ARE NULL");
        }
        if (!paths.equals(null)) {
            print("THE PATHS ARE NOT NULL");
        }
    }
    //************************************************************************\\
    //                          FILE METHODS                                  \\
    //************************************************************************\\
    public void testFile(File file){
        String filePath = file.getAbsolutePath();
        String fileName = file.getName();
        System.out.println(String.format("FILE PATH%10s", filePath));
        System.out.println(String.format("FILE NAME%10s", fileName));
    }
    //************************************************************************\\
    //                          PATIENT METHODS                               \\
    //************************************************************************\\
    public void testPatient(Patient p){
        print(p.getId());
        print(p.getFirstName());
        print(p.getLastName());
        testOrthyPaths(p.getOrthyPaths());
        testOrthyPath(p.getOrthyPath());
    }
    //************************************************************************\\
    //                          MISC METHODS                                  \\
    //************************************************************************\\
    public void count(int i, String whatAreYouCounting){
        System.out.println(String.format("The count of %s is: %d",
                                        whatAreYouCounting, i));
    }
    public void testLine(OrthyLine line){
        Drawer.drawLine_Black_Thick(line.getLine(), c.guiHandler().getGfx());
    }
    public void testString(String test){
        System.out.println(test);
    }
    public void print(Object obj){
        System.out.println();
        System.out.println(obj.toString());
    }
    public void testPrint(){
        System.out.println("THIS IS A TEST PRINT");
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
