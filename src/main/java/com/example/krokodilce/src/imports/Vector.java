/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.krokodilce.src.imports;

import java.awt.*;

/**
 *
 * @author stali
 */
public class Vector {
    private Point point;
    private double length;
    private double direction;
    public Vector(Point p){
        this.point = p;
    }
    public Double getLength(){
        this.length = Math.sqrt(point.x * point.x + point.y * point.y);
        return length;
    }
    public Double getDirection(){
        return Math.atan2(point.y,point.x);
    }
    public Point getPoint(){
        return point;
    }
}
