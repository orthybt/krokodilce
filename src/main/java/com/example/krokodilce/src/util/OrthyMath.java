package com.example.krokodilce.src.util;

import com.example.krokodilce.src.imports.Vector;
import com.example.krokodilce.src.imports.VectorMath;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static imports.VectorMath.dotProduct;

/**
 *      
 * @author stali
 */
public final class OrthyMath 

{
    private final static OrthyMath orthyMath = new OrthyMath();
    private OrthyMath(){};
    public static OrthyMath get(){
        return orthyMath;
    } 
    //Double Methods
    /**
     * Calibrate a value in pixels on an image to mm
     * Note! - the selected value in pixels must be 10 mm
     * @param p1 - Point
     * @param p2 - Point
     * @return Calibrated value(how many px are in 1(one) mm)
     */
    public static Double calibrate(Point p1, Point p2){
        Double valueInPixels = getLineLength(p1, p2);
        Double oneMilimeter = valueInPixels/10;
        return oneMilimeter;//return how much pixels are in 1 mm on the calibration ruler
    }
    /**
     * Convert px to mm
     * Note! - we must calibrate first
     * @param valuePixels
     * @param oneMilimeter
     * @return 1(one) 
     */
    public static Double getLengthMM(Double valuePixels, Double oneMilimeter){
        /*
        the standard value for now will be 10mm
        TBA... add another parameter in this method that will coincide with a JList, where you can
        select the precision of the calibration in terms whether the distance in pixels received 
        will be 10,20,25 mm etc...
        */
        Double convertedValue = valuePixels/oneMilimeter;
        return convertedValue;
    }
    /**
     * Convert degrees to Radians
     * @param degrees
     * @return Degrees to radians
     */
    public static Double convertDegreesToRadians(Double degrees){
        return Math.toRadians(degrees);
    }
    public static Double getLineLength(Point p1, Point p2){
        double dX = p1.x - p2.x;
        double dY = p1.y - p2.y;
        return Math.sqrt(dX * dX + dY * dY);
    }
    public static Double getLineLength(OrthyLine _line){
        Line2D line = _line.getLine();
        double dX = convertPoint2D(line.getP1()).x - convertPoint2D(line.getP2()).x;
        double dY = convertPoint2D(line.getP1()).y - convertPoint2D(line.getP2()).y;;
        //Pythagorean theorem, which states that the square of the hypotenuse is equal to the added squares of the other two sides
        //So here, we add the squares of the sides of the imaginary triangle and end up with the square of the imaginary hypotenuse
        //Then we just square-root this number and we have the imaginary hypotenuse length, that is, the length of the line between the two points
        //Return a value in pixels
        return Math.sqrt(dX * dX + dY * dY);
    }
    public static Double getLengthRatioBetweenTwoLines(OrthyLine _lineOne, OrthyLine _lineTwo){
        Line2D lineOne = _lineOne.getLine();
        Line2D lineTwo = _lineTwo.getLine();
        Point p1 = convertPoint2D(lineOne.getP1());
        Point p2 = convertPoint2D(lineOne.getP2());
        Point p3 = convertPoint2D(lineTwo.getP1());
        Point p4 = convertPoint2D(lineTwo.getP2());
        Vector line1 = VectorMath.convertLineToVector(p1, p2);
        Vector line2 = VectorMath.convertLineToVector(p3, p4);
        Double line1Length = line1.getLength();
        Double line2Length = line2.getLength();
        Double ratio = (line1Length*line2Length)/100;
        return ratio;
    }
    public static Double getAngleBetweenThreePoints(Point p1, Point center, Point p3){
        /*
        convert the lines to vectors. The first line is (p1,center)
        the second line is (center, p2)
        After this find the length of each line
        Calculate the dotProduct
        and finally calculate the angle
        */
        Vector line1 = VectorMath.convertLineToVector(center, p1);
        Vector line2 = VectorMath.convertLineToVector(center, p3);
        Double line1Length = line1.getLength();
        Double line2Length = line2.getLength();
        Double lengthProduct = line1Length*line2Length;
        Double dotProduct = dotProduct(line1.getPoint(), line2.getPoint());
        Double theta = (Math.acos(dotProduct/lengthProduct));
        return Math.toDegrees(theta);
    }
    public static Double getAngleBetweenTwoLines(OrthyLine _refLine, OrthyLine _line){
        //Unzip the ref line
        Point p1 = _refLine.getA();
        Point p2 = _refLine.getB();
        //Unzip the line
        Point __p1 = _line.getA();
        Point __p2 = _line.getB();
        //Translate the line at the refLine A point
        Point p3 = translateLine(p1, __p1, __p2);
        return getAngleBetweenThreePoints(p2, p1, p3);
    }
    public static Double getX_Difference(Point p1, Point p2){
        return p1.getX() - p2.getX();
    }
    public static Double getY_Difference(Point p1, Point p2){
        return p1.getY() - p2.getY();
    }
    
    //Point Methods
    public static Point convertPoint2D(Point2D p){
        Double x = p.getX();
        Double y = p.getY();
        return new Point(x.intValue(), y.intValue());
    }
    public static Point2D convertPoint(Point p){
        Integer x = p.x;
        Integer y = p.y;
        return new Point2D.Double(x.doubleValue(), y.doubleValue());
    }
    public static Point perpendicularIntersectionPoint(Point point, OrthyLine _line){
        /**
         * Given a line and a point that does not lie on the given line, find 
         * the intersection point of a line drawn from the given point
         * and the first line, the line that intersects the first line being 
         * perpendicular to the first line
         * IMPORTANT!!!
         * Always check how the line that is being translated is created what are
         * the starting and what is the ending point and modify the functions
         * accordingly, because the line that is being translated to the destination
         * point can be translated left od right, and therefore the function might require some tweaks
         */
        OrthyLine line = _line;
        //Create a line that is a translate line with a starting point at A(point)
        OrthyLine translateLine = LineFactory.translate(point, _line);
        //Create a perpendicular line at point A(starting point)
        OrthyLine perLine = LineFactory.perpendicularLineAt_B(translateLine);
        //Find the intersection point
        Point intersection = OrthyMath.findIntersection(line, perLine);
        return intersection;
    }
    public static Point translateLine(Point destination, Point startPoint, Point endPoint){
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
        Integer xDiff = endPoint.x - startPoint.x;
        Integer yDiff = endPoint.y - startPoint.y;
        Integer newXStart = destination.x;
        Integer newYStart = destination.y;
        Point newEndPoint = new Point(newXStart+xDiff, newYStart+yDiff);
        return newEndPoint;
    }
    public static OrthyLine translateLine(Point destination, OrthyLine _line){
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
        Point startPoint = _line.getA();
        Point endPoint = _line.getB();
        Integer xDiff = endPoint.x - startPoint.x;
        Integer yDiff = endPoint.y - startPoint.y;
        Integer newXStart = destination.x;
        Integer newYStart = destination.y;
        Point newEndPoint = new Point(newXStart+xDiff, newYStart+yDiff);
        //create a line from destinatio point as A, and newEndPoint as B
        return new OrthyLine(destination, newEndPoint);
        
    }
    public static Point findIntersection(OrthyLine _l1, OrthyLine _l2){
        Line2D l1 = LineFactory.createLine(_l1.getA(), _l1.getB());
        Line2D l2 = LineFactory.createLine(_l2.getA(), _l2.getB());
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
    
    //Perpendicular Line Methods
    public static Double calculateLineSlope(Point p1, Point p2){
        return (double)(p2.y - p1.y) / (double) (p2.x - p1.x);
    }
    public static Double calculatePerpendicularLineSlope(Double slope){
        return -1 / slope;
    }
    public static Point getMidpointOfLine(Point p1, Point p2){
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
    public static Double calculateY_Intercept(Double slope, Point endPoint){
        return -slope * endPoint.x + endPoint.y;    
    }
}
