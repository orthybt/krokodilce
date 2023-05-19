package com.example.krokodilce.src.imports;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Handles the canvas
 * Contains methods appropriate for this canvas
 * Contains all the methods necessary for drawing on the canvas like points, lines, text,
 *      
 * @author stali
 */
public final class VectorMath 

{
    private final static VectorMath vectorMath = new VectorMath();
    
    private VectorMath(){};
    public static VectorMath getInstance(){
        return vectorMath;
    }
    // addition, subtraction and multiplication(dot product of two vectors)
    //Convert a line with P1,P2 to a vector
    /*
    Every point with P(x,y) is a can be represented as a vector with two attributes(length,
    and direction) Length is the distance of this point from origin(0,0). Direction is the deviation
    from absolute horizontal.
    */
    public static Vector createVector(Point p)
    {
        return new Vector(p);
    }
    public static Vector vectorAddition(Point p1, Point p2)
    {
        /*
        Create a new Point with(x1+x2),(y1,y2) and use this Point to create a new Vector and
        return it
        */
        Point sumVectors = new Point((p1.x+p2.x), (p1.y+p2.y));
        return new Vector(sumVectors);
    }
    public static Vector vectorSubtraction(Point p1, Point p2){
        Point subtractVectors = new Point((p1.x-p2.x), (p1.y-p2.y));
        return  new Vector(subtractVectors);
    }
    public static Point pointAddition(Point p1, Point p2)
    {
        Point sumVectors = new Point((p1.x+p2.x), (p1.y+p2.y));
        return new Point(sumVectors);
    }
    public static Point pointSubtraction(Point p1, Point p2){
        Point subtractVectors = new Point((p1.x-p2.x), (p1.y-p2.y));
        return  new Point(subtractVectors);
    }
    public static Double dotProduct(Point p1, Point p2){
        return new Double((p1.x*p2.x)+(p1.y*p2.y));
    }
    public static Vector convertLineToVector(Point p1, Point p2){
        int x;
        int y;
        x = p1.x - p2.x;
        y = p1.y - p2.y;
        return new Vector(new Point(x, y));
    }
     public static Double GetAngleOfLineBetweenTwoPoints(Point.Double p1, Point.Double p2) {
        double xDiff = p2.x - p1.x;
        double yDiff = p2.y - p1.y;
        return Math.toDegrees(Math.atan2(yDiff, xDiff));
    }
    public static Double getAngleBetweenThreePoints(Point p1, Point center, Point p3){
        /*
        convert the lines to vectors. The first line is (p1,center)
        the second line is (center, p2)
        After this find the length of each line
        Calculate the dotProduct
        and finally calculate the angle
        */
        Vector line1 = convertLineToVector(center, p1);
        Vector line2 = convertLineToVector(center, p3);
        Double line1Length = line1.getLength();
        Double line2Length = line2.getLength();
        Double lengthProduct = line1Length*line2Length;
        Double dotProduct = dotProduct(line1.getPoint(), line2.getPoint());
        Double theta = (Math.acos(dotProduct/lengthProduct));
        return theta;
    }
    public static Point translateLine(Point destination, Point startPoint, Point endPoint){
        /**
         * Creates a parallel line at a destination point
         * Genuine copy of a line in the Cartesian space is any line that satisfies these 
         * conditions: start.x - end.x and start.y and end.y is constant(the same as in the 
         * original line);
         * start.x(newLine) and start.y(newLine) are the same as the destinationPoint
         * end.x(newLine) and end.y(newLine) are defined as start.x(newLine)+xDiff, 
         * start.y(newLine)+yDiff of the original line
         */
        Integer xDiff = endPoint.x - startPoint.x;
        System.out.println(xDiff);
        Integer yDiff = endPoint.y - startPoint.y;
        System.out.println(yDiff);
        Integer newXStart = destination.x;
        System.out.println(newXStart);
        Integer newYStart = destination.y;
        System.out.println(newYStart);
        Point newEndPoint = new Point(newXStart+xDiff, newYStart+yDiff);
        return newEndPoint;
    }
    
    public static boolean isPositiveLine(Point p1, Point p2){
        /**
         * In computer graphics the cartesian space is a set of numbers(x,y) that are only positive
         * If we take as an axiom that the start point of any line is the point that has y value 
         * either equal to the y value of the end point or less,and the x value is either equal or
         * less than the end point x value, we can assume that every line that satisfies these 
         * conditions will be a positive line. If a line has greater value of either xstart or ystart
         * compared to xend or yend, we can assume that this line is a negative line. Now we cannot
         * accurately and properly compare two lines one positive and one negative with same 
         * length(physical) in the computer coordinate system. This is why we must convert every 
         * negative line to a positive line.
         */
        if(p1.x <= p2.x && p1.y <= p2.y){
            return true;
        }
        else{
            return false;
        }
    }
    public static Point convertNegativeLineToPositive(Point p1, Point p2){
        /**
         * Because its hard and tedious to always define which point is start and which is end
         * for a start point in a negative line we will use the point that has a lower x value
         * For a pivot(rotation point) we will select the point with greater x value. 
         * The translation will be on the x axis according to this formula: 
         * ((x_end*2-x_start),y_start).
         */
        //Now compare the x values of the points
        int newStartX = p2.x;
        int newStartY = p2.y;
        int newEndX = newStartX*2-p1.x;
        int newEndY = p1.y;
        return new Point(newEndX, newEndY);
    }
    public static Point findIntersection(Line2D.Double l1, Line2D.Double l2){
        double a1 = l1.getP2().getY() - l1.getP1().getY();
        double b1 = l1.getP1().getX() - l1.getP2().getX();
        double c1 = a1*l1.getP1().getX() + b1*l1.getP1().getY();
        
        double a2 = l2.getP2().getY() - l2.getP1().getY();
        double b2 = l2.getP1().getX() - l2.getP2().getX();
        double c2 = a2*l2.getP1().getX() + b2*l2.getP1().getY();
        
        double delta = a1 * b2 - a2* b1;
        Double x = (b2*c1-b1*c2) / delta;
        Double y = (a1*c2-a2*c1) / delta;
        int x_int = x.intValue();
        int y_int = y.intValue();
        return new Point(x_int, y_int);
    }
}
