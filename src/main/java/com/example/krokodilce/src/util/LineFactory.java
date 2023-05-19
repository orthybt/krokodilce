/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.krokodilce.src.util;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static com.example.krokodilce.src.util.OrthyMath.convertPoint2D;
import static com.example.krokodilce.src.util.OrthyMath.findIntersection;
import com.example.krokodilce.src.objects.Orthy_Line;

/**
 *
 * @author stalinbt <stalinbt@gmail.com>
 */
public final class LineFactory {
    //************************************************************************\\
    //                     LINE CREATOR                                       \\
    //************************************************************************\\
    private final static LineFactory lineCreator = new LineFactory();
    private LineFactory(){};
    public static LineFactory get(){
        return lineCreator;
    }
    //************************************************************************\\
    //                     __________________                                 \\
    //************************************************************************\\
    public static Line2D createLine(Point p1, Point p2){
        return new Line2D.Double(OrthyMath.convertPoint(p1), 
                OrthyMath.convertPoint(p2));
    }
    public static Line2D createLine(Point2D p1, Point2D p2){
        return new Line2D.Double(p1, p2);
    }
    public static OrthyLine createLineOrthy(Point p1, Point p2){
        return new OrthyLine(p1, p2);
    }
    public static OrthyLine createLineOrthy(Line2D line){
        return new OrthyLine(line);
    }
    //************************************************************************\\
    //                     __________________                                 \\
    //************************************************************************\\
    public static OrthyLine horizontalLine(Point p){
        int x = p.x;
        int y = p.y;
        Point start = new Point(x - 5000, y);
        Point end = new Point(x + 5000, y);
        return new OrthyLine(start, end);    }
    public static OrthyLine verticalLine(Point p){
        int x = p.x;
        int y = p.y;
        Point start = new Point(x, y - 5000);
        Point end = new Point(x, y + 5000);
        return new OrthyLine(start, end);
    } 
    //************************************************************************\\
    //                     __________________                                 \\
    //************************************************************************\\
    public static OrthyLine perpendicularLineAt_MidPoint(OrthyLine _line){
        Point a = OrthyMath.convertPoint2D(_line.getA());
        Point b = OrthyMath.convertPoint2D(_line.getB());
        Point midPoint = OrthyMath.getMidpointOfLine(a, b);
        Double slope = OrthyMath.calculateLineSlope(a, b);
        Double negativeSlope = OrthyMath.calculatePerpendicularLineSlope(slope);
        Double yIntercept = OrthyMath.calculateY_Intercept(slope, b);
        Double yInterceptPerpendicular = OrthyMath.calculateY_Intercept(negativeSlope, midPoint);
        Point perpendicularStart = new Point(0, yInterceptPerpendicular.intValue());
        OrthyLine perpendicularStartMidpoint = createLineOrthy(perpendicularStart, midPoint);
        OrthyLine perLine = extend(perpendicularStartMidpoint);
        return perLine;
    }
    public static OrthyLine perpendicularLineAt_A(OrthyLine _line){
        Point a = OrthyMath.convertPoint2D(_line.getA());
        Point b = OrthyMath.convertPoint2D(_line.getB());
        Point midPoint = OrthyMath.getMidpointOfLine(a, b);
        Double slope = OrthyMath.calculateLineSlope(a, b);
        Double negativeSlope = OrthyMath.calculatePerpendicularLineSlope(slope);
        Double yIntercept = OrthyMath.calculateY_Intercept(slope, b);
        Double yInterceptPerpendicular = OrthyMath.calculateY_Intercept(negativeSlope, midPoint);
        Point perpendicularStart = new Point(0, yInterceptPerpendicular.intValue());
        OrthyLine perpendicularStartMidpoint = createLineOrthy(perpendicularStart, midPoint);
        OrthyLine translateLine = translate(OrthyMath.convertPoint2D(_line.getA()), 
                perpendicularStartMidpoint);
        OrthyLine perLine = extend(translateLine);
        return perLine;
    }
    public static OrthyLine perpendicularLineAt_B(OrthyLine _line){
        Point a = OrthyMath.convertPoint2D(_line.getA());
        Point b = OrthyMath.convertPoint2D(_line.getB());
        Point midPoint = OrthyMath.getMidpointOfLine(a, b);
        Double slope = OrthyMath.calculateLineSlope(a, b);
        Double negativeSlope = OrthyMath.calculatePerpendicularLineSlope(slope);
        Double yIntercept = OrthyMath.calculateY_Intercept(slope, b);
        Double yInterceptPerpendicular = OrthyMath.calculateY_Intercept(negativeSlope, midPoint);
        Point perpendicularStart = new Point(0, yInterceptPerpendicular.intValue());
        OrthyLine perpendicularStartMidpoint = createLineOrthy(perpendicularStart, midPoint);
        OrthyLine translateLine = translate(OrthyMath.convertPoint2D(_line.getB()), 
                perpendicularStartMidpoint);
        OrthyLine perLine = extend(translateLine);
        return perLine;
    }
    public static OrthyLine horizontalIntersectionLine(Point start, OrthyLine _line){
        //create a horizontal line at the start point
        OrthyLine horizontalLine = horizontalLine(start);
        //find the intersection with the other line
        Point intersection = OrthyMath.findIntersection(horizontalLine, _line);
        //create a line from start to intersection
        return createLineOrthy(start, intersection);
    }
    public static OrthyLine verticalIntersectionLine(Point start, OrthyLine _line){
        //create a vertical line at the start point
        OrthyLine verticalLine = verticalLine(start);
        //find the intersection with the other line
        Point intersection = findIntersection(verticalLine, _line);
        //create a line from start to intersection
        return createLineOrthy(start, intersection);
    }
    public static OrthyLine perpendicular_refererence_line(Point p, OrthyLine _refLine){
            /**
            * This method creates a line that is perpendicular to the reference line
            * and it starts at p. Thats it. Its  big line. And its perpendicular to the ref line 
            */
            //first get the ref line, either horizontal or vertical
            OrthyLine refLine = _refLine;
            //draw a perpendicular to this line at a random point
            OrthyLine perLine = extend(perpendicularLineAt_A(refLine));
            //translate this line at a destination point
            OrthyLine line = translate(p, perLine);
            //The return line is a line that is a perpendicular to any ref line, from any point
            return line;
        }
    public static OrthyLine perpendicular_intersection_line(Point p, OrthyLine _refLine){
            /**
            * This method creates a line that is defined by p as a start point and
            * p_end as end point. p_end is an intersection of the ref line and the newly
            * created line. The magic is that this is a perpendicular line to ref line
            */
            //first get the ref line, either horizontal or vertical
            OrthyLine refLine = _refLine;
            //draw a perpendicular to this line at a random point
            OrthyLine perLine = extend(perpendicularLineAt_A(refLine));
            //translate this line at a destination point
            OrthyLine line = translate(p, perLine);
            //Find the end of the line(P2)
            Point p1 = p;
            Point p2 = OrthyMath.findIntersection(refLine, line);
            //Create the line now
            OrthyLine linePerNew = createLineOrthy(p1, p2);
            //The return line is a line that is a perpendicular to any ref line, from any point
            return linePerNew;
        }
    //************************************************************************\\
    //                     __________________                                 \\
    //************************************************************************\\
    public static OrthyLine extend(OrthyLine _line){
        Line2D line = _line.getLine();
        //create the points of the original line
        Point a = convertPoint2D(line.getP1());
        Point b = convertPoint2D(line.getP2());
        //create the original line
        OrthyLine AB = createLineOrthy( _line.getA(), _line.getB());
        //create the original line - opposite direction
        OrthyLine BA = createLineOrthy(_line.getB(), _line.getA());
                
        //At B
        //translate
        OrthyLine lineOne = translate(b, AB);
        //create a bigger line
        OrthyLine lineTwo = createLineOrthy(a, lineOne.getB());
        //translate 
        OrthyLine lineThree = translate(convertPoint2D(lineTwo.getB()), lineTwo);
        //create a bigger line
        OrthyLine lineFour = createLineOrthy(a, lineThree.getB());
        //translate
        OrthyLine lineFive = translate(convertPoint2D(lineFour.getB()), lineFour);
        //create a bigger line
        OrthyLine lineSix = createLineOrthy(a, lineFive.getB());
        //translate
        OrthyLine lineSeven = translate(convertPoint2D(lineSix.getB()), lineSix);
        //create a bigger line
        OrthyLine lineEight = createLineOrthy(a, lineSeven.getB());
        //now the other direction at A
        //translate
        OrthyLine bOne = translate(b, BA);
        //create a bigger line
        OrthyLine bTwo = createLineOrthy(b, bOne.getB());
        //translate 
        OrthyLine bThree = translate(convertPoint2D(bTwo.getB()), bTwo);
        //create a bigger line
        OrthyLine bFour = createLineOrthy(b, bThree.getB());
        //translate
        OrthyLine bFive = translate(convertPoint2D(bFour.getB()), bFour);
        //create a bigger line
        OrthyLine bSix = createLineOrthy(b, bFive.getB());
        //translate
        OrthyLine bSeven = translate(convertPoint2D(bSix.getB()), bSix);
        //create a bigger line
        OrthyLine bNine = createLineOrthy(b, bSeven.getB());
        //create the GREAT line :)))
        OrthyLine extendedLine = createLineOrthy(bNine.getB(), lineEight.getB());
       
        return extendedLine;
    }
    public static OrthyLine translate(Point destination, OrthyLine _line){
        /**
         * Creates a parallel line at a destination point
         * Genuine copy of a line in the Cartesian space is any line that satisfies these 
         * conditions: start.x - end.x and start.y and end.y is constant(the same as in the 
         * original line);
         * This line is a genuine copy of the original line, with that difference
         * that this line as a start point has a new(another) point as a start
         * point, and this is the destination.
         * start.x(newLine) and start.y(newLine) are the same as the destinationPoint
         * end.x(newLine) and end.y(newLine) are defined as start.x(newLine)+xDiff, 
         * start.y(newLine)+yDiff of the original line
         */
        Point startPoint = OrthyMath.convertPoint2D(_line.getA());
        Point endPoint = OrthyMath.convertPoint2D(_line.getB());
        Integer xDiff = endPoint.x - startPoint.x;
        Integer yDiff = endPoint.y - startPoint.y;
        Integer newXStart = destination.x;
        Integer newYStart = destination.y;
        Point newEndPoint = new Point(newXStart+xDiff, newYStart+yDiff);
        return createLineOrthy(destination, newEndPoint);
    }
    //************************************************************************\\
    //                     __________________                                 \\
    //************************************************************************\\
    
    
}
