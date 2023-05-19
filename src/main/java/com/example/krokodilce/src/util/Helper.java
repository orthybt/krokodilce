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
import java.awt.geom.Point2D;
import java.nio.file.Path;

/**
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
public class Helper{// Misc class for everything, stuff you put that has no other place to go :)
    //************************************************************************\\
    private Cloud c;
        
        public Graphics2D castGraphics(Graphics gfx){
            return (Graphics2D)gfx;
        }
    
        public Double getDiff_R(Double line1, Double line2){
            //Double line1 = getCalibratedValue(d1);
            //Double line2 = getCalibratedValue(d2);
            return line1-line2;
        }
        public Double getDiff_L(Double line1, Double line2){
            //Double line1 = getCalibratedValue(d1);
            //Double line2 = getCalibratedValue(d2);
            return line2-line1;
        }
        //********************************************************************\\
        public Point compareY_Points(Point p1, Point p2){
            //Return the point with greater y value 
            Double Y1 = p1.getY();
            Double Y2 = p2.getY();
            
            if (Y1 == Y2) {
                return p1;
            }
            if (Y1 < Y2) {
                return p2;
            }
            if (Y1 > Y2) {
                return p1;
            }
            else {
                return null;
            }
        }
        public Point compareX_Points(Point p1, Point p2){
            //Return the point with greater x value 
            Double X1 = p1.getX();
            Double X2 = p2.getX();
            
            if (X1 == X2) {
                return p1;
            }
            if (X1 < X2) {
                return p2;
            }
            if (X1 > X2) {
                return p1;
            }
            else {
                return null;
            }
        }
        public Point compareY_Points_RefLine(Point p1, Point p2, OrthyLine refLine){
            //Return the point with greater y value relative to the reference line
            OrthyLine line1 = LineFactory.perpendicular_intersection_line(p1, refLine);
            Point intersectionP1 = OrthyMath.findIntersection(line1, refLine);
            OrthyLine line2 = LineFactory.perpendicular_intersection_line(p2, refLine);
            Point intersectionP2 = OrthyMath.findIntersection(line2, refLine);
            
            Double Y1 = intersectionP1.getY();
            Double Y2 = intersectionP2.getY();
            
            if (Y1 == Y2) {
                return p1;
            }
            if (Y1 < Y2) {
                return p2;
            }
            if (Y1 > Y2) {
                return p1;
            }
            else {
                return null;
            }
        }
        public Point compareX_Points_RefLine(Point p1, Point p2, OrthyLine refLine){
            //Return the point with greater y value relative to the reference line
            OrthyLine line1 = LineFactory.perpendicular_intersection_line(p1, refLine);
            Point intersectionP1 = OrthyMath.findIntersection(line1, refLine);
            OrthyLine line2 = LineFactory.perpendicular_intersection_line(p2, refLine);
            Point intersectionP2 = OrthyMath.findIntersection(line2, refLine);
            
            Double X1 = intersectionP1.getX();
            Double X2 = intersectionP2.getX();
            
            if (X1 == X2) {
                return p1;
            }
            if (X1 < X2) {
                return p2;
            }
            if (X1 > X2) {
                return p1;
            }
            else {
                return null;
            }
        }
        public Integer compareX_Point_Line(Point p1, OrthyLine refLine){
            Point intersection = OrthyMath.findIntersection(LineFactory.horizontalLine(p1), refLine);
            
            if(p1.getX() > intersection.getX()){
                return 3;
            }
            if(p1.getX() < intersection.getX()){
                return 2;
            }
            if(p1.getX()== intersection.getX()){
                return 1;
            }
            else
                return 0;
        }
        public Integer compareY_Point_Line(Point p1, OrthyLine refLine){
            Point intersection = OrthyMath.findIntersection(LineFactory.verticalLine(p1), refLine);
            
            if(p1.getY() > intersection.getY()){
                return 3;
            }
            if(p1.getY() < intersection.getY()){
                return 2;
            }
            if(p1.getY()== intersection.getY()){
                return 1;
            }
            else
                return 0;
        }
        public String compareX_Point_Line_Str(Point p1, OrthyLine refLine){
            Point intersection = OrthyMath.findIntersection(LineFactory.horizontalLine(p1), refLine);
            
            if(p1.getX() > intersection.getX()){
                return "Anterior";
            }
            if(p1.getX() < intersection.getX()){
                return "Posterior";
            }
            if(p1.getX()== intersection.getX()){
                return "Same AP position";
            }
            else
                return "";
        }
        public String compareY_Point_Line_Str(Point p1, OrthyLine refLine){
            Point intersection = OrthyMath.findIntersection(LineFactory.verticalLine(p1), refLine);
            
            if(p1.getY() > intersection.getY()){
                return "Superior";
            }
            if(p1.getY() < intersection.getY()){
                return "Inferior";
            }
            if(p1.getY()== intersection.getY()){
                return "Same Vertical position";
            }
            else
                return "";
        }
        public String compareX_Points_Str(Point p1, Point p2){
                       
            if(p1.getX() > p2.getX()){
                return "Anterior";
            }
            if(p1.getX() < p2.getX()){
                return "Posterior";
            }
            if(p1.getX()== p2.getX()){
                return "Same AP position";
            }
            else
                return "";
        }
        public String compareY_Points_Str(Point p1, Point p2){
                       
            if(p1.getY() > p2.getY()){
                return "Anterior";
            }
            if(p1.getY() < p2.getY()){
                return "Posterior";
            }
            if(p1.getY()== p2.getY()){
                return "Same AP position";
            }
            else
                return "";
        }
        public String castPath(Path path){
            return FileManager.getPath(path);
        }
        //********************************************************************\\

        public Point convertPoint2D(Point2D p){
            return OrthyMath.convertPoint2D(p);
        }
        
        public Double getCalibratedValue(Point cal1, Point cal2, Double lengthPx){
            Double cal = OrthyMath.calibrate(cal1, cal2);
            return OrthyMath.getLengthMM(lengthPx, cal);
        }
        public Double getLengthRatio(Double total, Double part){
            return part/total*100;
        }

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }
    
}
