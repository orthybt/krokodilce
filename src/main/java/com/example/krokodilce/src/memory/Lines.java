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
import com.example.krokodilce.src.util.OrthyLine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                              LINES                               \\
//****************************************************************************\\
public final class Lines {
    //************************************************************************\\
    //                          SINGLETON INIT                                \\
    //************************************************************************\\
    private final static Lines l = new Lines(); 
    public static Lines get(){
        return l;
    }
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //*************************|*|********************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               
    //************************************************************************\\
    //                          LATERAL LINES
    //************************************************************************\\
    private OrthyLine l1;   //__Calibration___________p1___p2
    private OrthyLine l2;   //__Frankfort Horizontal______________p3____p4
    private OrthyLine l3;   //__Camper Line_______________________p10___p3
    private OrthyLine l4;   //__Po(Orbiculare Perpendicular_______p4
    private OrthyLine l5;   //__Pn(Nasion Perpendicular)__________p6
    private OrthyLine l6;   //__E_Line________________p15___p7
    private OrthyLine l7;   //__Z_Line________________p15
    private OrthyLine l8;   //__col__sn_______________p8____p9
    private OrthyLine l9;   //__sn__ls________________p9____p11
    private OrthyLine l10;  //__li__sm________________p13___p14
    private OrthyLine l11;  //__N__sn_________________p6____p9        
    private OrthyLine l12;  //__sn__Pog_______________p9____p15
    private OrthyLine l13;  //__sm__Pog_______________p14___p15
    private List<OrthyLine> lateralLines = new ArrayList<OrthyLine>();
    //************************************************************************\\
    //                          FRONTAL LINES
    //************************************************************************\\
    private OrthyLine l14;  //__Calibration___________p1____p2
    private OrthyLine l15;  //  Bipupillary          _p3____p4
    private OrthyLine ll6;  //  Midline              _p7____p13
    private OrthyLine ll7;  //  UpperThird          __p5____p6      
    private OrthyLine ll8;  //  MidThird             _p6____p8
    private OrthyLine ll9;  //  LowerThird           _p8____p13
    private OrthyLine l20;  //  UpperHalf            _p8____p9
    private OrthyLine l21;  //  LowerHalf            _p9____p13
    private OrthyLine l22;  //  FacialHeight         _p7____p13
    private OrthyLine l23;  //  FacialWidth          _p14___p15
    private OrthyLine l25;  //  BipupillaryPer      
    private OrthyLine l26;  //  ComisuralLine_______ _p16___p17
    private OrthyLine l27;  //  Gnathion Horizontal  (Bipup)      Gn___l2
    private OrthyLine l28;  //  Trichion Horizontal  (Bipup)     Tr___l2
    private List<OrthyLine> frontalLines = new ArrayList<OrthyLine>();
    //************************************************************************\\
    //                          CAST MODEL LINES
    //************************************************************************\\
    private OrthyLine l29;  //__Calibration___________p1___p2
    private OrthyLine l30;  //__Midline_______________p17___p18
    private OrthyLine l31;  //__Tuberosity____________p19___p20
    private OrthyLine l32;  //__PosteriorWidth________p21___p22      
    private OrthyLine l33;  //__AnteriorWidth_________p23___p24
    private OrthyLine l34;  //__ArchHeight______________X___p26
    private OrthyLine l35;  //  
    private OrthyLine l36;  //  
    private OrthyLine l37;  //  
    private OrthyLine l38;  //  
    private OrthyLine l39;  //       
    private OrthyLine l40;  //  
    private List<OrthyLine> castModelLines = new ArrayList<OrthyLine>();
    //************************************************************************\\
    //                          METHODS                                       \\
    //************************************************************************\\
    public void resetLines_Lateral(){
        this.l1 = null;
        this.l2 = null;
        this.l3 = null;
        this.l4 = null;
        this.l5 = null;
        this.l6 = null;
        this.l7 = null;
        this.l8 = null;
        this.l9 = null;
        this.l10 = null;
        this.l11 = null;
        this.l12 = null;
        this.l13 = null;
        this.lateralLines.clear();
    }
    //************************************************************************\\
    //                          GETTERS/SETTERS                                       
    //************************************************************************\\
    public OrthyLine getL1() {
        return l1;
    }

    public void setL1(OrthyLine l1) {
        this.l1 = l1;
    }

    public OrthyLine getL2() {
        return l2;
    }

    public void setL2(OrthyLine l2) {
        this.l2 = l2;
    }

    public OrthyLine getL3() {
        return l3;
    }

    public void setL3(OrthyLine l3) {
        this.l3 = l3;
    }

    public OrthyLine getL4() {
        return l4;
    }

    public void setL4(OrthyLine l4) {
        this.l4 = l4;
    }

    public OrthyLine getL5() {
        return l5;
    }

    public void setL5(OrthyLine l5) {
        this.l5 = l5;
    }

    public OrthyLine getL6() {
        return l6;
    }

    public void setL6(OrthyLine l6) {
        this.l6 = l6;
    }

    public OrthyLine getL7() {
        return l7;
    }

    public void setL7(OrthyLine l7) {
        this.l7 = l7;
    }

    public OrthyLine getL8() {
        return l8;
    }

    public void setL8(OrthyLine l8) {
        this.l8 = l8;
    }

    public OrthyLine getL9() {
        return l9;
    }

    public void setL9(OrthyLine l9) {
        this.l9 = l9;
    }

    public OrthyLine getL10() {
        return l10;
    }

    public void setL10(OrthyLine l10) {
        this.l10 = l10;
    }

    public OrthyLine getL11() {
        return l11;
    }

    public void setL11(OrthyLine l11) {
        this.l11 = l11;
    }

    public OrthyLine getL12() {
        return l12;
    }

    public void setL12(OrthyLine l12) {
        this.l12 = l12;
    }

    public OrthyLine getL13() {
        return l13;
    }

    public void setL13(OrthyLine l13) {
        this.l13 = l13;
    }

    public OrthyLine getL14() {
        return l14;
    }

    public void setL14(OrthyLine l14) {
        this.l14 = l14;
    }

    public OrthyLine getL15() {
        return l15;
    }

    public void setL15(OrthyLine l15) {
        this.l15 = l15;
    }

    public OrthyLine getLl6() {
        return ll6;
    }

    public void setLl6(OrthyLine ll6) {
        this.ll6 = ll6;
    }

    public OrthyLine getLl7() {
        return ll7;
    }

    public void setLl7(OrthyLine ll7) {
        this.ll7 = ll7;
    }

    public OrthyLine getLl8() {
        return ll8;
    }

    public void setLl8(OrthyLine ll8) {
        this.ll8 = ll8;
    }

    public OrthyLine getLl9() {
        return ll9;
    }

    public void setLl9(OrthyLine ll9) {
        this.ll9 = ll9;
    }

    public OrthyLine getL20() {
        return l20;
    }

    public void setL20(OrthyLine l20) {
        this.l20 = l20;
    }

    public OrthyLine getL21() {
        return l21;
    }

    public void setL21(OrthyLine l21) {
        this.l21 = l21;
    }

    public OrthyLine getL22() {
        return l22;
    }

    public void setL22(OrthyLine l22) {
        this.l22 = l22;
    }

    public OrthyLine getL23() {
        return l23;
    }

    public void setL23(OrthyLine l23) {
        this.l23 = l23;
    }

    public OrthyLine getL25() {
        return l25;
    }

    public void setL25(OrthyLine l25) {
        this.l25 = l25;
    }

    public OrthyLine getL26() {
        return l26;
    }

    public void setL26(OrthyLine l26) {
        this.l26 = l26;
    }

    public OrthyLine getL27() {
        return l27;
    }

    public void setL27(OrthyLine l27) {
        this.l27 = l27;
    }

    public OrthyLine getL28() {
        return l28;
    }

    public void setL28(OrthyLine l28) {
        this.l28 = l28;
    }

    public OrthyLine getL29() {
        return l29;
    }

    public void setL29(OrthyLine l29) {
        this.l29 = l29;
    }

    public OrthyLine getL30() {
        return l30;
    }

    public void setL30(OrthyLine l30) {
        this.l30 = l30;
    }

    public OrthyLine getL31() {
        return l31;
    }

    public void setL31(OrthyLine l31) {
        this.l31 = l31;
    }

    public OrthyLine getL32() {
        return l32;
    }

    public void setL32(OrthyLine l32) {
        this.l32 = l32;
    }

    public OrthyLine getL33() {
        return l33;
    }

    public void setL33(OrthyLine l33) {
        this.l33 = l33;
    }

    public OrthyLine getL34() {
        return l34;
    }

    public void setL34(OrthyLine l34) {
        this.l34 = l34;
    }

    public OrthyLine getL35() {
        return l35;
    }

    public void setL35(OrthyLine l35) {
        this.l35 = l35;
    }

    public OrthyLine getL36() {
        return l36;
    }

    public void setL36(OrthyLine l36) {
        this.l36 = l36;
    }

    public OrthyLine getL37() {
        return l37;
    }

    public void setL37(OrthyLine l37) {
        this.l37 = l37;
    }

    public OrthyLine getL38() {
        return l38;
    }

    public void setL38(OrthyLine l38) {
        this.l38 = l38;
    }

    public OrthyLine getL39() {
        return l39;
    }

    public void setL39(OrthyLine l39) {
        this.l39 = l39;
    }

    public OrthyLine getL40() {
        return l40;
    }

    public void setL40(OrthyLine l40) {
        this.l40 = l40;
    }
    public List<OrthyLine> getLateralLines() {
        return lateralLines;
    }

    public void setLateralLines(List<OrthyLine> lateralLines) {
        this.lateralLines = lateralLines;
    }

    public List<OrthyLine> getFrontalLines() {
        return frontalLines;
    }

    public void setFrontalLines(List<OrthyLine> frontalLines) {
        this.frontalLines = frontalLines;
    }

    public List<OrthyLine> getCastModelLines() {
        return castModelLines;
    }

    public void setCastModelLines(List<OrthyLine> castModelLines) {
        this.castModelLines = castModelLines;
    }
//****************************************************************************\\
//                                  END                                       \\
//****************************************************************************\\

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }

    
}
