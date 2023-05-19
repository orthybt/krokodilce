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
package com.example.krokodilce.src.dataObjects;

import java.awt.*;

/**
 * Data object = OrthyPoint - serializable object
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//              ORTHY POINT - SERIALIZABLE OBJECT OF TYPE POINT               \\
//*************|*|*************|*|********************************************\\
public class OrthyPoint {
    //*************************************************************************\\
    //                              CLASS VARIABLES                            \\
    //*************|*|*************|*|*****************************************\\
    private String x;
    private String y;
    //****************************************************************************\\
    //                              CONSTRUCTORS                                       \\
    //*************|*|*************|*|********************************************\\   
    public OrthyPoint(){
        this.x = "";
        this.y = "";
    }
    
    public OrthyPoint(Point p){
        this.x = Double.toString(p.getX());
        this.y = Double.toString(p.getY());
    }
    
    public OrthyPoint(double x, double y){
        this.x = Double.toString(x);
        this.y = Double.toString(y);
    }
    //****************************************************************************\\
    //                              METHODS                                       \\
    //*************|*|*************|*|********************************************\\
    public Point getPoint(){
        return new Point(Integer.parseInt(this.x), Integer.parseInt(this.y));
    }
    //****************************************************************************\\
    //                              GETTERS/SETTERS                               \\
    //*************|*|*************|*|********************************************\\
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
    
//****************************************************************************\\
//                              END                                           \\
//*************|*|*************|*|********************************************\\
}
