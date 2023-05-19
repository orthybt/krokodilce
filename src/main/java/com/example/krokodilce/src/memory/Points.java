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

package com.example.krokodilce.src.memory;

import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.dataObjects.OrthyPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan Todorovic <orthybt@gmail.com>
 */

//****************************************************************************\\
//                              POINTS                                        \\
//****************************************************************************\\
public final class Points {

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
    //************************************************************************\\
    //                          SINGLETON INIT                                  \\
    //************************************************************************\\
    private final static Points p = new Points();
    public static Points get(){
        return p;
    }
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          LATERAL POINTS                               \\
    //************************************************************************\\
    private Point p1;   //__Calibration_point1
    private Point p2;   //__Calibration_point2
    private Point p3;   //__Porion
    private Point p4;   //__Orbiculare
    private Point p5;   //__Glabela
    private Point p6;   //__Nasion 
    private Point p7;   //__Pronasale
    private Point p8;   //__Columela
    private Point p9;   //__SubNasale
    private Point p10;  //__Ala
    private Point p11;  //__LabiumSuperior
    private Point p12;  //__Stomion
    private Point p13;  //__LabiumInferior
    private Point p14;  //__SubMentale
    private Point p15;  //__Pogonion
    private Point p16;  //__Gnation    
    private List<Point> pointsLateral = new ArrayList<Point>();
    private List<OrthyPoint> orthyPointsLateral = new ArrayList<OrthyPoint>();
    //************************************************************************\\
    //                          FRONTAL POINTS                                \\
    //************************************************************************\\    
    private Point p17;   //  CalibrationPoint1
    private Point p18;   //  CalibrationPoint2
    private Point p19;   //  RotationPoint1 =>   PupilRight
    private Point p20;   //  RotationPoint2 =>   PupilLeft
    private Point p21;   //  Trichion
    private Point p22;   //  Glabella
    private Point p23;   //  Nasion
    private Point p24;   //  Subnasale 
    private Point p25;   //  LabiumSuperior
    private Point p26;  //  Stomion
    private Point p27;  //  LabiumInferior
    private Point p28;  //  Pogonion
    private Point p29;  //  Gnation
    private Point p30;  //  ZygionRight
    private Point p31;  //  ZygionLeft
    private Point p32;  //  RightLipCorner
    private Point p33;  //  LeftLipCorner
    //************************************************************************\\
    //                          CAST MODEL POINTS                                \\
    //************************************************************************\\
    private Point p34;   //__Calibration_point1
    private Point p35;   //__Calibration_point2  
    private Point p36;   //__7__right 
    private Point p37;   //__6__right
    private Point p38;   //__5__right
    private Point p39;   //__4__right
    private Point p40;   //__3__right
    private Point p41;   //__2__right 
    private Point p42;   //__1__right
    private Point p43;  //__1__left 
    private Point p44;  //__2__left
    private Point p45;  //__3__left
    private Point p46;  //__4__left
    private Point p47;  //__5__left
    private Point p48;  //__6__left
    private Point p49;  //__7__left
    private Point p50;  //__midPoint__1 
    private Point p51;  //__midPoint__2
    private Point p52;  //__tuberosity__right
    private Point p53;  //__tuberosity__left
    private Point p54;  //__posteriorWidth__1
    private Point p55;  //__posteriorWidth__2
    private Point p56;  //__anteriorWidth_1
    private Point p57;  //__anteriorWidth_2
    private Point p58;  //__mostAnteriorPoint
    private List<Point> points = new ArrayList<Point>();
    private List<OrthyPoint> orthyPoints = new ArrayList<OrthyPoint>();
    //************************************************************************\\
    //                          METHODS                                       \\
    //************************************************************************\\
    public void resetPoints_Lateral(){
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.p4 = null;
        this.p5 = null;
        this.p6 = null;
        this.p7 = null;
        this.p8 = null;
        this.p9 = null;
        this.p10 = null;
        this.p11 = null;
        this.p12 = null;
        this.p13 = null;
        this.p14 = null;
        this.p15 = null;
        this.p16 = null;
        this.pointsLateral.clear();
        this.orthyPointsLateral.clear();
    }
    //************************************************************************\\
    //                          GETTERS AND SETTERS                           \\
    //************************************************************************\\

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public Point getP5() {
        return p5;
    }

    public void setP5(Point p5) {
        this.p5 = p5;
    }

    public Point getP6() {
        return p6;
    }

    public void setP6(Point p6) {
        this.p6 = p6;
    }

    public Point getP7() {
        return p7;
    }

    public void setP7(Point p7) {
        this.p7 = p7;
    }

    public Point getP8() {
        return p8;
    }

    public void setP8(Point p8) {
        this.p8 = p8;
    }

    public Point getP9() {
        return p9;
    }

    public void setP9(Point p9) {
        this.p9 = p9;
    }

    public Point getP10() {
        return p10;
    }

    public void setP10(Point p10) {
        this.p10 = p10;
    }

    public Point getP11() {
        return p11;
    }

    public void setP11(Point p11) {
        this.p11 = p11;
    }

    public Point getP12() {
        return p12;
    }

    public void setP12(Point p12) {
        this.p12 = p12;
    }

    public Point getP13() {
        return p13;
    }

    public void setP13(Point p13) {
        this.p13 = p13;
    }

    public Point getP14() {
        return p14;
    }

    public void setP14(Point p14) {
        this.p14 = p14;
    }

    public Point getP15() {
        return p15;
    }

    public void setP15(Point p15) {
        this.p15 = p15;
    }

    public Point getP16() {
        return p16;
    }

    public void setP16(Point p16) {
        this.p16 = p16;
    }

    public Point getP17() {
        return p17;
    }

    public void setP17(Point p17) {
        this.p17 = p17;
    }

    public Point getP18() {
        return p18;
    }

    public void setP18(Point p18) {
        this.p18 = p18;
    }

    public Point getP19() {
        return p19;
    }

    public void setP19(Point p19) {
        this.p19 = p19;
    }

    public Point getP20() {
        return p20;
    }

    public void setP20(Point p20) {
        this.p20 = p20;
    }

    public Point getP21() {
        return p21;
    }

    public void setP21(Point p21) {
        this.p21 = p21;
    }

    public Point getP22() {
        return p22;
    }

    public void setP22(Point p22) {
        this.p22 = p22;
    }

    public Point getP23() {
        return p23;
    }

    public void setP23(Point p23) {
        this.p23 = p23;
    }

    public Point getP24() {
        return p24;
    }

    public void setP24(Point p24) {
        this.p24 = p24;
    }

    public Point getP25() {
        return p25;
    }

    public void setP25(Point p25) {
        this.p25 = p25;
    }

    public Point getP26() {
        return p26;
    }

    public void setP26(Point p26) {
        this.p26 = p26;
    }

    public Point getP27() {
        return p27;
    }

    public void setP27(Point p27) {
        this.p27 = p27;
    }

    public Point getP28() {
        return p28;
    }

    public void setP28(Point p28) {
        this.p28 = p28;
    }

    public Point getP29() {
        return p29;
    }

    public void setP29(Point p29) {
        this.p29 = p29;
    }

    public Point getP30() {
        return p30;
    }

    public void setP30(Point p30) {
        this.p30 = p30;
    }

    public Point getP31() {
        return p31;
    }

    public void setP31(Point p31) {
        this.p31 = p31;
    }

    public Point getP32() {
        return p32;
    }

    public void setP32(Point p32) {
        this.p32 = p32;
    }

    public Point getP33() {
        return p33;
    }

    public void setP33(Point p33) {
        this.p33 = p33;
    }

    public Point getP34() {
        return p34;
    }

    public void setP34(Point p34) {
        this.p34 = p34;
    }

    public Point getP35() {
        return p35;
    }

    public void setP35(Point p35) {
        this.p35 = p35;
    }

    public Point getP36() {
        return p36;
    }

    public void setP36(Point p36) {
        this.p36 = p36;
    }

    public Point getP37() {
        return p37;
    }

    public void setP37(Point p37) {
        this.p37 = p37;
    }

    public Point getP38() {
        return p38;
    }

    public void setP38(Point p38) {
        this.p38 = p38;
    }

    public Point getP39() {
        return p39;
    }

    public void setP39(Point p39) {
        this.p39 = p39;
    }

    public Point getP40() {
        return p40;
    }

    public void setP40(Point p40) {
        this.p40 = p40;
    }

    public Point getP41() {
        return p41;
    }

    public void setP41(Point p41) {
        this.p41 = p41;
    }

    public Point getP42() {
        return p42;
    }

    public void setP42(Point p42) {
        this.p42 = p42;
    }

    public Point getP43() {
        return p43;
    }

    public void setP43(Point p43) {
        this.p43 = p43;
    }

    public Point getP44() {
        return p44;
    }

    public void setP44(Point p44) {
        this.p44 = p44;
    }

    public Point getP45() {
        return p45;
    }

    public void setP45(Point p45) {
        this.p45 = p45;
    }

    public Point getP46() {
        return p46;
    }

    public void setP46(Point p46) {
        this.p46 = p46;
    }

    public Point getP47() {
        return p47;
    }

    public void setP47(Point p47) {
        this.p47 = p47;
    }

    public Point getP48() {
        return p48;
    }

    public void setP48(Point p48) {
        this.p48 = p48;
    }

    public Point getP49() {
        return p49;
    }

    public void setP49(Point p49) {
        this.p49 = p49;
    }

    public Point getP50() {
        return p50;
    }

    public void setP50(Point p50) {
        this.p50 = p50;
    }

    public Point getP51() {
        return p51;
    }

    public void setP51(Point p51) {
        this.p51 = p51;
    }

    public Point getP52() {
        return p52;
    }

    public void setP52(Point p52) {
        this.p52 = p52;
    }

    public Point getP53() {
        return p53;
    }

    public void setP53(Point p53) {
        this.p53 = p53;
    }

    public Point getP54() {
        return p54;
    }

    public void setP54(Point p54) {
        this.p54 = p54;
    }

    public Point getP55() {
        return p55;
    }

    public void setP55(Point p55) {
        this.p55 = p55;
    }

    public Point getP56() {
        return p56;
    }

    public void setP56(Point p56) {
        this.p56 = p56;
    }

    public Point getP57() {
        return p57;
    }

    public void setP57(Point p57) {
        this.p57 = p57;
    }

    public Point getP58() {
        return p58;
    }

    public void setP58(Point p58) {
        this.p58 = p58;
    }

    public List<OrthyPoint> getOrthyPoints() {
        return orthyPoints;
    }

    public void setOrthyPoints(List<OrthyPoint> orthyPoints) {
        this.orthyPoints = orthyPoints;
    }
//****************************************************************************\\
//                              END                                   6        \\
//****************************************************************************\\    

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }

    public List<Point> getPointsLateral() {
        return pointsLateral;
    }

    public void setPointsLateral(List<Point> pointsLateral) {
        this.pointsLateral = pointsLateral;
        this.p1 = pointsLateral.get(0);
        this.p2 = pointsLateral.get(1);
        this.p3 = pointsLateral.get(2);
        this.p4 = pointsLateral.get(3);
        this.p5 = pointsLateral.get(4);
        this.p6 = pointsLateral.get(5);
        this.p7 = pointsLateral.get(6);
        this.p8 = pointsLateral.get(7);
        this.p9 = pointsLateral.get(8);
        this.p10 = pointsLateral.get(9);
        this.p11 = pointsLateral.get(10);
        this.p12 = pointsLateral.get(11);
        this.p13 = pointsLateral.get(12);
        this.p14 = pointsLateral.get(13);
        this.p15 = pointsLateral.get(14);
        this.p16 = pointsLateral.get(15);
    }

    public List<OrthyPoint> getOrthyPointsLateral() {
        return orthyPointsLateral;
    }

    public void setOrthyPointsLateral(List<OrthyPoint> orthyPointsLateral) {
        this.orthyPointsLateral = orthyPointsLateral;
    }
}
