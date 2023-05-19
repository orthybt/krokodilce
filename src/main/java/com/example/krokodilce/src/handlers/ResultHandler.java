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
package com.example.krokodilce.src.handlers;

import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.memory.GuiComponents;
import com.example.krokodilce.src.memory.Lines;
import com.example.krokodilce.src.memory.Points;
import com.example.krokodilce.src.util.*;

import java.awt.*;

/**
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//              RESULT HANDLER - A SOMEWHAT ABSTRACT CLASS                    \\
//****************************************************************************\\
public class ResultHandler{
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    private ResultHandler_Lateral resultHandler_Lateral = 
            new ResultHandler_Lateral();
    //private ResultHandler_FrontalPhoto frontalPhotoResultHandler = 
      //      new ResultHandler_FrontalPhoto();
    //private ResultHandler_CastModel castModelResultHandler = 
      //      new ResultHandler_CastModel();
    //************************************************************************\\
    //TEMPORARY SOLUTUON :)))
    protected Points p = Points.get();
    protected Lines l = Lines.get();
    protected GuiComponents gc = GuiComponents.get();
    protected GuiHandler guiHandler = new GuiHandler();
    protected Pen pen = new Pen();
    protected Helper help = new Helper();
    //************************************************************************\\
    //                           CONSTRUCTORS                                 \\
    //************************************************************************\\
    //                                                                        \\
    //************************************************************************\\
    //                           METHODS                                      \\
    //************************************************************************\\
    public void initResults_Lateral(){
        resultHandler_Lateral.initResults();
    }
    //************************************************************************\\
    //                  GETTERS/SETTERS - RESULT HANDLER                      \\
    //************************************************************************\\
    public ResultHandler_Lateral getResultHandler_Lateral() {
        return resultHandler_Lateral;
    }
    public void setResultHandler_Lateral
                    (ResultHandler_Lateral resultHandler_Lateral) {
        this.resultHandler_Lateral = resultHandler_Lateral;
    }
    //************************************************************************\\
    //                           SUBCLASSES                                   \\    
    //************************************************************************\\
    //                   RESULT HANDLER LATERAL - SUBCLASS                    \\
    //************************************************************************\\
    public class ResultHandler_Lateral {
        //********************************************************************\\
        //              CLASS VARIABLES                                       \\
        //********************************************************************\\
        
        //********************************************************************\\
        //              CONSTRUCTORS                                          \\   
        //********************************************************************\\
        
        //********************************************************************\\
        //              METHODS                                               \\
        //********************************************************************\\
        //              JAW PROFILE FIELD                                     \\
        //********************************************************************\\
        public void maxillaAP_Position(){
            //Subnasale
            Point _p = p.getP9();
            //Pn line
            OrthyLine pnLine = l.getL5();
            Integer apValue = getC().help().compareX_Point_Line(_p, pnLine);
            if (apValue != 0 && apValue == 3) {
                getC().guiHandler().setText("Anteface", gc.getTx1());
            }
            if (apValue != 0 && apValue == 2) {
                getC().guiHandler().setText("Retroface", gc.getTx1());
            }
            if(apValue != 0 && apValue == 1){
                getC().guiHandler().setText("Average face", gc.getTx1());
            }
        }
        public void mandibleToMaxilla_AP_Position(){
            //Line between pog and Orbiculare perpendicular
            OrthyLine pogOr = LineFactory.perpendicular_intersection_line
                            (p.getP15(), l.getL4());
            //KPF line - a perpendicular line from Po to Pn
            OrthyLine KPF = LineFactory.perpendicular_intersection_line
                            (p.getP4(), l.getL5());
            //Length of the lines
            Double pogOrLength = pogOr.getLineLength();
            Double KPF_Length = KPF.getLineLength();
            //Ratio between the lengths of the lines
            Double ratio = help.getLengthRatio(KPF_Length, pogOrLength);
            
            if(ratio >= 30 && ratio <=33.3){
                getC().guiHandler().setText("Straight Face", gc.getTx2());
            }
            if(ratio > 33.3){
                getC().guiHandler().setText("Forward slanting ", gc.getTx2());
            }
            if(ratio < 30){
                getC().guiHandler().setText("Backward slanting", gc.getTx2());
            }
        }
        public void jawProfileField(){
            maxillaAP_Position();
            mandibleToMaxilla_AP_Position();
        }    
        //********************************************************************\\
        //              E - PLANE                                             \\
        //********************************************************************\\
        public void rickets_E_Plane(){
            getC().guiHandler().setText
                (help.compareX_Point_Line_Str(p.getP11(), l.getL6()), gc.getTx3());
            getC().guiHandler().setText
                (help.compareX_Point_Line_Str(p.getP13(), l.getL6()), gc.getTx4());
            getC().guiHandler().setText
                (help.compareX_Points_Str(p.getP11(), p.getP13()), gc.getTx5());
            
        }
        //********************************************************************\\
        //              Z ANGLE                                               \\
        //********************************************************************\\
        public void zAngle(){
            OrthyLine extLine = LineFactory.extend(l.getL7());
            Point intP = OrthyMath.findIntersection(extLine, l.getL2());
            getC().guiHandler().setText( OrthyMath.getAngleBetweenThreePoints(p.getP15(),
                                intP, p.getP3()), gc.getTx6());
        }
        //********************************************************************\\
        //              FACIAL CONVEXITY                                      \\
        //********************************************************************\\
        public void facialConvexity(){
            Double value = 180 - OrthyMath.getAngleBetweenThreePoints(p.getP6(),
                                 p.getP9(), p.getP15());
            getC().guiHandler().setText(value, gc.getTx7());
        }
        //********************************************************************\\
        //              NASOLABIAL ANGLE                                      \\
        //********************************************************************\\
        public void nasoLabialAngle(){
            getC().guiHandler().setText( OrthyMath.getAngleBetweenThreePoints(p.getP8(),
                                p.getP9(), p.getP11()), gc.getTx8());
        }
        //********************************************************************\\
        //              MENTOLABIAL ANGLE                                     \\
        //********************************************************************\\
        public void mentoLabialAngle(){
            getC().guiHandler().setText( OrthyMath.getAngleBetweenThreePoints(p.getP13()
                                , p.getP14(), p.getP15()), gc.getTx9());
        }
        //********************************************************************\\
        //              INIT                                                  \\
        //********************************************************************\\
        public void initResults(){
            jawProfileField();
            rickets_E_Plane();
            zAngle();
            facialConvexity();
            nasoLabialAngle();
            mentoLabialAngle();
        }
        //**************************************************** ***************\\
        //                           GETTERS/SETTERS                          \\
        //********************************************************************\\
    }

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }
    
    /**
     * 
     
    //*********************************//*************************************\\
    //                       RESULT HANDLER FRONTAL PHOTO - SUBCLASS          \\
    //************************************************************************\\
    public class ResultHandler_FrontalPhoto{
        //********************************************************************\\
        //              CLASS VARIABLES                                       \\
        //************************************************************************\\
        
        //********************************************************************\\
        //              CONSTRUCTORS                                          \\   
        //************************************************************************\\
        
        //********************************************************************\\
        //              METHODS                                               \\
        //************************************************************************\\
        public Double getFacialIndex(){
            Double facialHeight = l.getL9().getLineLength();
            Double facialWidth = l.getL10().getLineLength();
            Double index = facialHeight/facialWidth*100;
            return index;
        }
        public void facialType(){
            if(getFacialIndex()<=83.9){
                guiHandler.setText("Wide", gc.getTx1());
            }
            if(getFacialIndex()>= 84 && getFacialIndex()<=87.9){
                guiHandler.setText("Medium", gc.getTx1());
            }
            if(getFacialIndex()>=88){
                guiHandler.setText("Narrow", gc.getTx1());
            }
        }
        //                                                                    \\
        public Double getSumOfThirds(){
            Double upper = l.getL4().getLineLength();
            Double mid = l.getL5().getLineLength();
            Double lower = l.getL6().getLineLength();
            Double sum = upper+mid+lower;
            return sum;
        }
        public Double getUpperThird(){
            Double value = l.getL4().getLineLength();
            return value/getSumOfThirds()*100;
        }
        public Double getMidThird(){
            Double value = l.getL5().getLineLength();
            return value/getSumOfThirds()*100;
        }
        public Double getLowerThird(){
            Double value = l.getL6().getLineLength();
            return value/getSumOfThirds()*100;
        }
        public void facialThirds(){
            Double upper = getUpperThird();
            Double mid = getMidThird();
            Double lower = getLowerThird();
            guiHandler.setTextPercent(upper, gc.getTx2());
            guiHandler.setTextPercent(mid, gc.getTx3());
            guiHandler.setTextPercent(lower, gc.getTx4());
        } 
        //                                                                    \\
        public Double getSumLowerThirds(){
            Double upper = l.getL7().getLineLength();
            Double lower = l.getL8().getLineLength();
            Double sum = upper+lower;
            return sum;
        }
        public Double getUpperRatio(){
            Double value = l.getL7().getLineLength();
            return value/getSumLowerThirds()*100;
        }
        public Double getLowerRatio(){
            Double value = l.getL8().getLineLength();
            return value/getSumLowerThirds()*100;
        }
        public void lowerHalf(){
            Double upper = getUpperRatio();
            Double lower = getLowerRatio();
            guiHandler.setTextPercent(upper, gc.getTx5());
            guiHandler.setTextPercent(lower, gc.getTx6());
        }
        //                                                                    \\
        public Double occlusalCantValue(){
           //Comisural Line
           OrthyLine comisuralLine = l.getL12();
           //Bipupillary Line
           OrthyLine bipupillaryLine = l.getL2();
           Double value = OrthyMath.getAngleBetweenTwoLines(bipupillaryLine, comisuralLine);
           return value;
        }
        public String occlusalCantDirection(){
            if(occlusalCantValue() == 0){
                return "None";
            }
            if(occlusalCantValue() < 0){
                return "Counter Clockwise";
            }
            if(occlusalCantValue() > 0){
                return "Clockwise";
            }
            else
                return "";
        }
        public void occlusalCant(){
            guiHandler.setText(occlusalCantValue(), gc.getTx7());
            guiHandler.setText(occlusalCantDirection(), gc.getTx8());
        }
        //                                                                    \\
        public Double midlineDeviationValue(){
            //Bipupillary line
            OrthyLine bipupillaryLine = l.getL2();
            //Facial midline
            OrthyLine mid = l.getL3();
            Double val = 90 - OrthyMath.getAngleBetweenTwoLines(bipupillaryLine, mid);
            return val;
        }    
        public String midlineDeviationDirection(){
            if(midlineDeviationValue() > 0){
                return "Left";
            }
            if(midlineDeviationValue() < 0){
                return "Right";
            }
            else{
                return "";
            }
        }
        public void midlineDeviation(){
            guiHandler.setText(midlineDeviationValue(), gc.getTx9());
            guiHandler.setText(midlineDeviationDirection(), gc.getTx10());
        }
        //                                                                    \\
        public void initResults(){
            facialType();
            facialThirds();
            lowerHalf();
            occlusalCant();
            midlineDeviation();
        }
    }
    //************************************************************************\\
    //                       RESULT HANDLER CAST MODEL - SUBCLASS             \\
    //************************************************************************\\
    private class ResultHandler_CastModel{
    //*********************************//*************************************\\
    //                       RESULT HANDLER CAST MODEL - SUBCLASS             \\
    //************************************************************************\\  
        public void transverse(){
            //If the result is a -2 that means this point is 2mm closer to midline relative to the other point
            OrthyLine l1 = LineCreator.perpendicular_intersection_line(p.getP3(), l.getL2());
            OrthyLine l2 = LineCreator.perpendicular_intersection_line(p.getP4(), l.getL2());
            OrthyLine l3 = LineCreator.perpendicular_intersection_line(p.getP5(), l.getL2());
            OrthyLine l4 = LineCreator.perpendicular_intersection_line(p.getP6(), l.getL2());
            OrthyLine l5 = LineCreator.perpendicular_intersection_line(p.getP7(), l.getL2());
            OrthyLine l6 = LineCreator.perpendicular_intersection_line(p.getP8(), l.getL2());
            OrthyLine l7 = LineCreator.perpendicular_intersection_line(p.getP9(), l.getL2());
            OrthyLine l8 = LineCreator.perpendicular_intersection_line(p.getP10(), l.getL2());
            OrthyLine l9 = LineCreator.perpendicular_intersection_line(p.getP11(), l.getL2());
            OrthyLine l10 = LineCreator.perpendicular_intersection_line(p.getP12(), l.getL2());
            OrthyLine l11 = LineCreator.perpendicular_intersection_line(p.getP13(), l.getL2());
            OrthyLine l12 = LineCreator.perpendicular_intersection_line(p.getP14(), l.getL2());
            OrthyLine l13 = LineCreator.perpendicular_intersection_line(p.getP15(), l.getL2());
            OrthyLine l14 = LineCreator.perpendicular_intersection_line(p.getP16(), l.getL2());

            Double t_7_R = l1.getLineLength();
            Double t_6_R = l2.getLineLength();
            Double t_5_R = l3.getLineLength();
            Double t_4_R = l4.getLineLength();
            Double t_3_R = l5.getLineLength();
            Double t_2_R = l6.getLineLength();
            Double t_1_R = l7.getLineLength();
            Double t_1_L = l8.getLineLength();
            Double t_2_L = l9.getLineLength();
            Double t_3_L = l10.getLineLength();
            Double t_4_L = l11.getLineLength();
            Double t_5_L = l12.getLineLength();
            Double t_6_L = l13.getLineLength();
            Double t_7_L = l14.getLineLength();


            guiHandler.setText(help.getDiff_R(t_7_R, t_7_L), gc.getTx1());
            guiHandler.setText(help.getDiff_R(t_6_R, t_6_L), gc.getTx2());
            guiHandler.setText(help.getDiff_R(t_5_R, t_5_L), gc.getTx3());
            guiHandler.setText(help.getDiff_R(t_4_R, t_4_L), gc.getTx4());
            guiHandler.setText(help.getDiff_R(t_3_R, t_3_L), gc.getTx5());
            guiHandler.setText(help.getDiff_R(t_2_R, t_2_L), gc.getTx6());
            guiHandler.setText(help.getDiff_R(t_1_R, t_1_L), gc.getTx7());
            guiHandler.setText(help.getDiff_L(t_1_R, t_1_L), gc.getTx8());
            guiHandler.setText(help.getDiff_L(t_2_R, t_2_L), gc.getTx9());
            guiHandler.setText(help.getDiff_L(t_3_R, t_3_L), gc.getTx10());
            guiHandler.setText(help.getDiff_L(t_4_R, t_4_L), gc.getTx11());
            guiHandler.setText(help.getDiff_L(t_5_R, t_5_L), gc.getTx12());
            guiHandler.setText(help.getDiff_L(t_6_R, t_6_L), gc.getTx13());
            guiHandler.setText(help.getDiff_L(t_7_R, t_7_L), gc.getTx14());
        }  
        public void vertical(){
                //If the result is a -2 that means this point is 2mm closer to midline relative to the other point
            OrthyLine l1 = LineCreator.perpendicular_intersection_line(p.getP3(), l.getL3());
            OrthyLine l2 = LineCreator.perpendicular_intersection_line(p.getP4(), l.getL3());
            OrthyLine l3 = LineCreator.perpendicular_intersection_line(p.getP5(), l.getL3());
            OrthyLine l4 = LineCreator.perpendicular_intersection_line(p.getP6(), l.getL3());
            OrthyLine l5 = LineCreator.perpendicular_intersection_line(p.getP7(), l.getL3());
            OrthyLine l6 = LineCreator.perpendicular_intersection_line(p.getP8(), l.getL3());
            OrthyLine l7 = LineCreator.perpendicular_intersection_line(p.getP9(), l.getL3());
            OrthyLine l8 = LineCreator.perpendicular_intersection_line(p.getP10(), l.getL3());
            OrthyLine l9 = LineCreator.perpendicular_intersection_line(p.getP11(), l.getL3());
            OrthyLine l10 = LineCreator.perpendicular_intersection_line(p.getP12(), l.getL3());
            OrthyLine l11 = LineCreator.perpendicular_intersection_line(p.getP13(), l.getL3());
            OrthyLine l12 = LineCreator.perpendicular_intersection_line(p.getP14(), l.getL3());
            OrthyLine l13 = LineCreator.perpendicular_intersection_line(p.getP15(), l.getL3());
            OrthyLine l14 = LineCreator.perpendicular_intersection_line(p.getP16(), l.getL3());


            Double t_7_R = l1.getLineLength();
            Double t_6_R = l2.getLineLength();
            Double t_5_R = l3.getLineLength();
            Double t_4_R = l4.getLineLength();
            Double t_3_R = l5.getLineLength();
            Double t_2_R = l6.getLineLength();
            Double t_1_R = l7.getLineLength();
            Double t_1_L = l8.getLineLength();
            Double t_2_L = l9.getLineLength();
            Double t_3_L = l10.getLineLength();
            Double t_4_L = l11.getLineLength();
            Double t_5_L = l12.getLineLength();
            Double t_6_L = l13.getLineLength();
            Double t_7_L = l14.getLineLength();
            

            guiHandler.setText(help.getDiff_R(t_7_R, t_7_L), gc.getTx15());
            guiHandler.setText(help.getDiff_R(t_6_R, t_6_L), gc.getTx16());
            guiHandler.setText(help.getDiff_R(t_5_R, t_5_L), gc.getTx17());
            guiHandler.setText(help.getDiff_R(t_4_R, t_4_L), gc.getTx18());
            guiHandler.setText(help.getDiff_R(t_3_R, t_3_L), gc.getTx19());
            guiHandler.setText(help.getDiff_R(t_2_R, t_2_L), gc.getTx20());
            guiHandler.setText(help.getDiff_R(t_1_R, t_1_L), gc.getTx21());
            guiHandler.setText(help.getDiff_L(t_1_R, t_1_L), gc.getTx22());
            guiHandler.setText(help.getDiff_L(t_2_R, t_2_L), gc.getTx23());
            guiHandler.setText(help.getDiff_L(t_3_R, t_3_L), gc.getTx24());
            guiHandler.setText(help.getDiff_L(t_4_R, t_4_L), gc.getTx25());
            guiHandler.setText(help.getDiff_L(t_5_R, t_5_L), gc.getTx26());
            guiHandler.setText(help.getDiff_L(t_6_R, t_6_L), gc.getTx27());
            guiHandler.setText(help.getDiff_L(t_7_R, t_7_L), gc.getTx28());
        }
        public void linderHarthKorkhaus(){
            
        }
        //************************************************************************\\
        public void initResults(){
            transverse();   
            vertical();
        }
    }
    
    
//****************************************************************************\\
//                              END                                           \\
//****************************************************************************\\
*/
    
}
