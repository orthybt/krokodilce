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

package com.example.krokodilce.src.XML_Wrappers;

import com.example.krokodilce.src.dataObjects.OrthyPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data object = OrthyPath - essential paths to the patient data
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//              ORTHY POINTS - XML WRAPPER TYPE                               \\
//****************************************************************************\\
public class OrthyPoints {
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    //@XmLElement specifies XML element name for each object in the list
    //@XmlElement(name="orthyPoint")
    private List<OrthyPoint> orthyPoints = new ArrayList();//stores points
    //************************************************************************\\
    //                          CONSTRUCTORS                                  \\
    //*********|*|*************|*|********************************************\\
    public OrthyPoints(){
        //EMPTY CONSTRUCTOR IS A MUST!
    }
     //***********************************************************************\\
    //                          GETTERS/SETT                                  \\
    //************************************************************************\\
    //must make getters
    public List<OrthyPoint> getOrthyPoints() {
        return orthyPoints;
    }
    public List<Point> getPoints(){
        List<Point> tempPoints = new ArrayList<Point>();
        getOrthyPoints().forEach((t) -> {
            Double x = Double.valueOf(t.getX());
            Double y = Double.valueOf(t.getY());
            Point pp = new Point(x.intValue(), y.intValue());
            tempPoints.add(new Point(pp));
        });
        return tempPoints;
    }
}
//****************************************************************************\\
//                              END                                           \\
//****************************************************************************\\
