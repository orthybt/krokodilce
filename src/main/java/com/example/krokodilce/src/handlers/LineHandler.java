package com.example.krokodilce.src.handlers;

import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.util.LineFactory;
import com.example.krokodilce.src.util.OrthyLine;

import java.awt.*;

/**
 * A Template class for functional objects, AKA handlers :)
 * They Handle stuff
 * @author Orthy
 */
//****************************************************************************\\
//                              LINE HAND                                     \\
//****************************************************************************\\
public class LineHandler{
    //************************************************************************\\
    //                          LINE HANDLER                                  \\
    //************************************************************************\\
    //************************************************************************\\
    //                          CONSTRUCTORS                                  \\
    //************************************************************************\\
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    //************************************************************************\\
    //                          METHODS - RESET                               \\
    //************************************************************************\\
    public void resetLines(){
        c.l().resetLines_Lateral();
    }
    //************************************************************************\\
    //                          CREATION OF LINES                                       \\
    //************************************************************************\\
    //Calibration Line
    private void line1(){
        OrthyLine line = LineFactory.createLineOrthy(getC().p().getP1(), getC().p().getP2());
        getC().l().setL1(line);
    }
    //Frankfort Horizontal
    private void line2(){
        OrthyLine line = LineFactory.createLineOrthy(getC().p().getP3(), getC().p().getP4());
        getC().l().setL2(LineFactory.extend(line));
    }
    //Camper Line
    private void line3(){
        getC().l().setL3(LineFactory.createLineOrthy(getC().p().getP10(), getC().p().getP3()));
    }
    //Orbiculare perpendicular
    private void line4(){
        Graphics2D gfx = (Graphics2D)getC().gc().getImagePanelLateral().getGraphics();
        //first get the ref line, either horizontal or vertical
        OrthyLine refLine = getC().l().getL2();
        //draw a perpendicular to this line at a random point
        OrthyLine perLine = LineFactory.extend(LineFactory.perpendicularLineAt_A(refLine));
        //translate this line at a destination point
        OrthyLine line = LineFactory.translate(getC().p().getP4(), perLine);
        getC().l().setL4(line);
    }
        //Nasion perpendicular
    private void line5(){
        //first get the ref line, either horizontal or vertical
        OrthyLine refLine = getC().l().getL2();
        //draw a perpendicular to this line at a random point
        OrthyLine perLine = LineFactory.extend(LineFactory.perpendicularLineAt_A(refLine));
        //translate this line at a destination point   
        OrthyLine line = LineFactory.translate(getC().p().getP6(), perLine);
        getC().l().setL5(line);
    }
    //E-Line
    private void line6(){
        OrthyLine line = LineFactory.createLineOrthy(getC().p().getP15(), getC().p().getP7());
        getC().l().setL6(LineFactory.extend(line));
    }
    //Z-Line, a line connecting the pog with the most anterior point of the lips
    private void line7(){
        Point p1 = getC().p().getP15();
        Point p2 = getC().help().compareX_Points(getC().p().getP11(), getC().p().getP13());
        OrthyLine extLine = LineFactory.extend(LineFactory.createLineOrthy(p1, p2));
        getC().l().setL7(extLine);
    }
    //col_sn
    private void line8(){
        getC().l().setL8(LineFactory.createLineOrthy(getC().p().getP8(), getC().p().getP9()));
    }
    //sn_ls
    private void line9(){
        getC().l().setL9(LineFactory.createLineOrthy(getC().p().getP9(), getC().p().getP11()));
    }
    //li_sm
    private void line10(){
        getC().l().setL10(LineFactory.createLineOrthy(getC().p().getP13(), getC().p().getP14()));
    }
    //N_sn
    private void line11(){
        getC().l().setL11(LineFactory.createLineOrthy(getC().p().getP6(), getC().p().getP9()));
    }
    //sn_pog
    private void line12(){ 
        getC().l().setL12(LineFactory.createLineOrthy(getC().p().getP9(), getC().p().getP15()));
    }
    //sm_pog
    private void line13(){
        getC().l().setL13(LineFactory.createLineOrthy(getC().p().getP14(), getC().p().getP15()));
    }
    public void createLines(){
        //****************************************************************\\
        //init the GFX of the Pen here :))) good job dude <3              \\
        //****************************************************************\\
        //c.pen().setGfx(c.gc().getGfx());
        //****************************************************************\\
        try {
            line1();
            line2();
            line3();
            line4();
            line5();
            line6();
            line7();
            line8();
            line9();
            line10();
            line11();
            line12();
            line13();
        } catch (Exception e) {
            
        }
        
    }
    //************************************************************************\\
    //                          DRAWING LINES                                       \\
    //************************************************************************\\    
    public void drawLines(){
        drawFrankfortHorizontal();
        drawCamperPlane();
        drawJawProfileField();
        drawELine();
        drawZLine();
        drawNasolabialAngle();
        drawNasolabialAngle();
    }
    public void drawFrankfortHorizontal(){
        getC().pen().magenta(getC().l().getL2());
    }
    public void drawCamperPlane(){
        getC().pen().magenta(getC().l().getL3());
    }
    public void drawJawProfileField(){
        getC().pen().magenta(getC().l().getL4());
        getC().pen().magenta(getC().l().getL5());
    }
    public void drawELine(){
        drawFrankfortHorizontal();
        getC().pen().magenta(getC().l().getL6());
    }
    public void drawZLine(){
        drawFrankfortHorizontal();
        getC().pen().magenta(getC().l().getL7());
    }
    public void drawFacialConvexity(){
        getC().pen().magentaThick(getC().l().getL11());
        getC().pen().magentaThick(getC().l().getL12());
    }
    public void drawNasolabialAngle(){
        getC().pen().magentaThick(getC().l().getL8());
        getC().pen().magentaThick(getC().l().getL9());
    }
    public void drawMentolabialAngle(){
        getC().pen().magentaThick(getC().l().getL13());
        getC().pen().magentaThick(getC().l().getL10());
    }
    //************************************************************************\\
    //                          INIT                                          \\
    //************************************************************************\\
    public void initLines(){
        createLines();
    }
    //************************************************************************\\
    //                          GETTERS AND SETTERS                           \\
    //************************************************************************\\

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
