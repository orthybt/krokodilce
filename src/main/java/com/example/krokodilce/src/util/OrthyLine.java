/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.krokodilce.src.util;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 *
 * @author stali
 * A line object that contain just the line the points(a,b) and
 * the slope, the negativeSlope, and the y_Intercept. Also it can draw itself,
 * it can draw the points, the line as well as the perpendicular line. That's it    
 * 
 */
public class OrthyLine {
    //Original line points
    private Point a;
    private Point b;
    //Perpendicular line points
    private Point midPoint;//endPoint
    private Point perpendicularStart;//startPoint
    //lines
    private Line2D line;
    private Line2D perpendicularLine;
    //Original line slope and yIntercept
    private Double slope;
    private Double yIntercept;
    //Perpendicular line slope and yIntercepts
    private Double negativeSlope;
    private Double yInterceptPerpendicular;
    
    public OrthyLine(Point a, Point b){
        this.a = a;
        this.b = b;
        this.midPoint = OrthyMath.getMidpointOfLine(a, b);
        this.line = new Line2D.Double(a, b);
        this.slope = OrthyMath.calculateLineSlope(a, b);
        this.negativeSlope = OrthyMath.calculatePerpendicularLineSlope(slope);
        this.yIntercept = OrthyMath.calculateY_Intercept(slope, b);
        this.yInterceptPerpendicular = OrthyMath.calculateY_Intercept(negativeSlope, midPoint);
        this.perpendicularStart = new Point(0, getyInterceptPerpendicular().intValue());
        this.perpendicularLine = 
                new Line2D.Double(getPerpendicularStart(), getMidPoint());
    }
    public OrthyLine(Line2D line){
        this.a = OrthyMath.convertPoint2D(line.getP1());
        this.b = OrthyMath.convertPoint2D(line.getP2());
        this.midPoint = OrthyMath.getMidpointOfLine(a, b);
        this.line = new Line2D.Double(a, b);
        this.slope = OrthyMath.calculateLineSlope(a, b);
        this.negativeSlope = OrthyMath.calculatePerpendicularLineSlope(slope);
        this.yIntercept = OrthyMath.calculateY_Intercept(slope, b);
        this.yInterceptPerpendicular = OrthyMath.calculateY_Intercept(negativeSlope, midPoint);
        this.perpendicularStart = new Point(0, getyInterceptPerpendicular().intValue());
        this.perpendicularLine = 
                new Line2D.Double(getPerpendicularStart(), getMidPoint());
        
    }
    public Line2D getPerpendicularTranslate(Point destination){
        Line2D lineP = 
                new Line2D.Double(destination, OrthyMath.translateLine
        (destination, perpendicularStart, midPoint));
        return lineP;
    }
    
    
    public Point getA() {
        return a;
    }
    public Point getB() {
        return b;
    }
    public Point getMidPoint() {
        return midPoint;
    }
    public Point getPerpendicularStart() {
        return perpendicularStart;
    }
    public Line2D getLine() {
        return line;
    }
    public Line2D getPerpendicularLine() {
        return perpendicularLine;
    }
    public Double getSlope() {
        return slope;
    }
    public Double getyIntercept() {
        return yIntercept;
    }
    public Double getNegativeSlope() {
        return negativeSlope;
    }
    public Double getyInterceptPerpendicular() {
        return yInterceptPerpendicular;
    }
    public void setA(Point a) {
        this.a = a;
    }
    public void setB(Point b) {
        this.b = b;
    }
    public void setMidPoint(Point midPoint) {
        this.midPoint = midPoint;
    }
    public void setPerpendicularStart(Point perpendicularStart) {
        this.perpendicularStart = perpendicularStart;
    }
    public void setLine(Line2D line) {
        this.line = line;
    }
    public void setPerpendicularLine(Line2D perpendicularLine) {
        this.perpendicularLine = perpendicularLine;
    }
    public Double getLineLength(){
        return OrthyMath.getLineLength(a, b);
    }
}
