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

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * A refference class for every gui component that needs interaction with, a pretty 
 * cool idea :) Love you man and good luck <3
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                              GUI COMPONENTS                                \\
//****************************************************************************\\
public final class GuiComponents {
    //************************************************************************\\
    //                          SINGLETON INIT                                \\
    //************************************************************************\\
    private final static GuiComponents gc = new GuiComponents();
    public static GuiComponents get(){
        return gc;
    }
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //*************************|*|********************************************\\
    private Cloud c; 
    //************************************************************************\\
    //                         PANELS/LABELS - IMAGE DUO                      \\
    //************************************************************************\\
    private JPanel imagePanelLateral;
    private JLabel imageLabelLateral;
    
    private JPanel imagePanelFrontal;
    private JLabel imageLabelFrontal;
    
    private JPanel imagePanelCastModel;
    private JLabel imageLabelCastModel;
    //************************************************************************\\
    //                         MISC VARIABLES                      v          \\
    //************************************************************************\\
    private File file;
    private BufferedImage originalImage;
    private BufferedImage resizeImage;
    private BufferedImage rotateImage;
    //************************************************************************\\
    //                          LABELS                               \\
    //************************************************************************\\
    private JLabel lab1;
    private JLabel lab2;
    private JLabel lab3;
    private JLabel lab4;
    private JLabel lab5;
    private JLabel lab6;
    //************************************************************************\\
    //                          CHECKBOXES                                     \\
    //************************************************************************\\
    private JCheckBox ch1;
    private JCheckBox ch2;
    private JCheckBox ch3;
    private JCheckBox ch4;
    private JCheckBox ch5;
    private JCheckBox ch6;
    private JCheckBox ch7;
    private JCheckBox ch8;
    private JCheckBox ch9;
    private JCheckBox ch10;
    private JCheckBox ch11;
    private JCheckBox ch12;
    private JCheckBox ch13;
    private JCheckBox ch14;
    private JCheckBox ch15;
    private JCheckBox ch16;
    private JCheckBox ch17;
    private JCheckBox ch18;
    private JCheckBox ch19;
    private JCheckBox ch20;
    private JCheckBox ch21;
    private JCheckBox ch22;
    private JCheckBox ch23;
    private JCheckBox ch24;
    private JCheckBox ch25;
    private JCheckBox ch26;
    private JCheckBox ch27;
    private JCheckBox ch28;
    private JCheckBox ch29;
    private JCheckBox ch30;
    private JCheckBox ch31;
    private JCheckBox ch32;
    private JCheckBox ch33;
    private JCheckBox ch34;
    private JCheckBox ch35;
    private JCheckBox ch36;
    private JCheckBox ch37;
    private JCheckBox ch38;
    private JCheckBox ch39;
    private JCheckBox ch40;
    private JCheckBox ch41;
    private JCheckBox ch42;
    private JCheckBox ch43;
    private JCheckBox ch44;
    private JCheckBox ch45;
    private JCheckBox ch46;
    private JCheckBox ch47;
    private JCheckBox ch48;
    private JCheckBox ch49;
    private JCheckBox ch50;
    private JCheckBox ch51;
    private JCheckBox ch52;
    private JCheckBox ch53;
    private JCheckBox ch54;
    private JCheckBox ch55;
    private JCheckBox ch56;
    private JCheckBox ch57;
    private JCheckBox ch58;
    private JCheckBox ch59;
    private JCheckBox ch60;
    private ArrayList<JCheckBox> checkBoxes = new ArrayList();
    //************************************************************************\\
    //                          TEXT FIELDS                                   \\
    //************************************************************************\\
    //Lateral Patient info variables
    private JTextField txId_lateral;
    private JTextField txFirstName_lateral;
    private JTextField txLastName_lateral;
    //Lateral 
    private JTextField tx1;
    private JTextField tx2;
    private JTextField tx3;
    private JTextField tx4;
    private JTextField tx5;
    private JTextField tx6;
    private JTextField tx7;
    private JTextField tx8;
    private JTextField tx9;
    //
    private JTextField tx10;
    private JTextField tx11;
    private JTextField tx12;
    private JTextField tx13;
    private JTextField tx14;
    private JTextField tx15;
    private JTextField tx16;
    private JTextField tx17;
    private JTextField tx18;
    private JTextField tx19;
    private JTextField tx20;
    private JTextField tx21;
    private JTextField tx22;
    private JTextField tx23;
    private JTextField tx24;
    private JTextField tx25;
    private JTextField tx26;
    private JTextField tx27;
    private JTextField tx28;
    private JTextField tx29;
    private JTextField tx30;    
    private JTextField tx31;
    private JTextField tx32;
    private JTextField tx33;
    private JTextField tx34;
    private JTextField tx35;
    private JTextField tx36;
    private JTextField tx37;
    private JTextField tx38;
    private JTextField tx39;
    private JTextField tx40;
    private JTextField tx41;
    private JTextField tx42;
    private JTextField tx43;
    private JTextField tx44;
    private JTextField tx45;
    private JTextField tx46;
    private JTextField tx47;
    private JTextField tx48;
    private JTextField tx49;
    private JTextField tx50;
    private JTextField tx51;
    private JTextField tx52;
    private JTextField tx53;
    private JTextField tx54;
    private JTextField tx55;
    private JTextField tx56;
    private JTextField tx57;
    private JTextField tx58;
    private JTextField tx59;
    private JTextField tx60;
    private JTextField tx61;
    private JTextField tx62;
    private JTextField tx63;
    private JTextField tx64;
    private JTextField tx65;
    private JTextField tx66;
    private JTextField tx67;
    private JTextField tx68;
    private JTextField tx69;
    private JTextField tx70;
    //************************************************************************\\
    //                          METHODS                                       \\
    //*************************|*|********************************************\\
    public void initCheckBoxes_Lateral(){
        this.getCheckBoxes().add(getCh1());
        this.getCheckBoxes().add(getCh2());
        this.getCheckBoxes().add(getCh3());
        this.getCheckBoxes().add(getCh4());
        this.getCheckBoxes().add(getCh5());
        this.getCheckBoxes().add(getCh6());
        this.getCheckBoxes().add(getCh7());
        this.getCheckBoxes().add(getCh8());
        this.getCheckBoxes().add(getCh9());
        this.getCheckBoxes().add(getCh10());
        this.getCheckBoxes().add(getCh11());
        this.getCheckBoxes().add(getCh12());
        this.getCheckBoxes().add(getCh13());
        this.getCheckBoxes().add(getCh14());
        this.getCheckBoxes().add(getCh15());
        this.getCheckBoxes().add(getCh16());
        /**this.getCheckBoxes().add(getCh17());
        this.getCheckBoxes().add(getCh18());
        this.getCheckBoxes().add(getCh19());
        this.getCheckBoxes().add(getCh20());
        this.getCheckBoxes().add(getCh21());
        this.getCheckBoxes().add(getCh22());
        this.getCheckBoxes().add(getCh23());
        this.getCheckBoxes().add(getCh24());
        this.getCheckBoxes().add(getCh25());
        this.getCheckBoxes().add(getCh26());
        this.getCheckBoxes().add(getCh27());
        this.getCheckBoxes().add(getCh28());
        this.getCheckBoxes().add(getCh29());
        this.getCheckBoxes().add(getCh30());
        this.getCheckBoxes().add(getCh31());
        this.getCheckBoxes().add(getCh32());
        this.getCheckBoxes().add(getCh33());
        this.getCheckBoxes().add(getCh34());
        this.getCheckBoxes().add(getCh35());
        this.getCheckBoxes().add(getCh36());
        this.getCheckBoxes().add(getCh37());
        this.getCheckBoxes().add(getCh38());
        this.getCheckBoxes().add(getCh39());
        this.getCheckBoxes().add(getCh40());
        this.getCheckBoxes().add(getCh41());
        this.getCheckBoxes().add(getCh42());
        this.getCheckBoxes().add(getCh43());
        this.getCheckBoxes().add(getCh44());
        this.getCheckBoxes().add(getCh45());
        this.getCheckBoxes().add(getCh46());
        this.getCheckBoxes().add(getCh47());
        this.getCheckBoxes().add(getCh48());
        this.getCheckBoxes().add(getCh49());
        this.getCheckBoxes().add(getCh50());
        this.getCheckBoxes().add(getCh51());
        this.getCheckBoxes().add(getCh52());
        this.getCheckBoxes().add(getCh53());
        this.getCheckBoxes().add(getCh54());
        this.getCheckBoxes().add(getCh55());
        this.getCheckBoxes().add(getCh56());
        this.getCheckBoxes().add(getCh57());
        this.getCheckBoxes().add(getCh58());
        this.getCheckBoxes().add(getCh59());
        this.getCheckBoxes().add(getCh60());*/
    }
    //************************************************************************\\
    //                          GETTERS AND SETTERS                           \\
    //*************************|*|********************************************\\
    
    public JPanel getImagePanelLateral() {
        return imagePanelLateral;
    }

    public void setImagePanelLateral(JPanel imagePanelLateral) {
        this.imagePanelLateral = imagePanelLateral;
    }

    public JLabel getImageLabelLateral() {
        return imageLabelLateral;
    }

    public void setImageLabelLateral(JLabel imageLabelLateral) {
        this.imageLabelLateral = imageLabelLateral;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BufferedImage getResizeImage() {
        return resizeImage;
    }

    public void setResizeImage(BufferedImage resizeImage) {
        this.resizeImage = resizeImage;
    }

    public BufferedImage getRotateImage() {
        return rotateImage;
    }

    public void setRotateImage(BufferedImage rotateImage) {
        this.rotateImage = rotateImage;
    }

    public JLabel getLab1() {
        return lab1;
    }

    public void setLab1(JLabel lab1) {
        this.lab1 = lab1;
    }

    public JLabel getLab2() {
        return lab2;
    }

    public void setLab2(JLabel lab2) {
        this.lab2 = lab2;
    }

    public JLabel getLab3() {
        return lab3;
    }

    public void setLab3(JLabel lab3) {
        this.lab3 = lab3;
    }

    public JLabel getLab4() {
        return lab4;
    }

    public void setLab4(JLabel lab4) {
        this.lab4 = lab4;
    }

    public JLabel getLab5() {
        return lab5;
    }

    public void setLab5(JLabel lab5) {
        this.lab5 = lab5;
    }

    public JLabel getLab6() {
        return lab6;
    }

    public void setLab6(JLabel lab6) {
        this.lab6 = lab6;
    }

    public JCheckBox getCh1() {
        return ch1;
    }

    public void setCh1(JCheckBox ch1) {
        this.ch1 = ch1;
    }

    public JCheckBox getCh2() {
        return ch2;
    }

    public void setCh2(JCheckBox ch2) {
        this.ch2 = ch2;
    }

    public JCheckBox getCh3() {
        return ch3;
    }

    public void setCh3(JCheckBox ch3) {
        this.ch3 = ch3;
    }

    public JCheckBox getCh4() {
        return ch4;
    }

    public void setCh4(JCheckBox ch4) {
        this.ch4 = ch4;
    }

    public JCheckBox getCh5() {
        return ch5;
    }

    public void setCh5(JCheckBox ch5) {
        this.ch5 = ch5;
    }

    public JCheckBox getCh6() {
        return ch6;
    }

    public void setCh6(JCheckBox ch6) {
        this.ch6 = ch6;
    }

    public JCheckBox getCh7() {
        return ch7;
    }

    public void setCh7(JCheckBox ch7) {
        this.ch7 = ch7;
    }

    public JCheckBox getCh8() {
        return ch8;
    }

    public void setCh8(JCheckBox ch8) {
        this.ch8 = ch8;
    }

    public JCheckBox getCh9() {
        return ch9;
    }

    public void setCh9(JCheckBox ch9) {
        this.ch9 = ch9;
    }

    public JCheckBox getCh10() {
        return ch10;
    }

    public void setCh10(JCheckBox ch10) {
        this.ch10 = ch10;
    }

    public JCheckBox getCh11() {
        return ch11;
    }

    public void setCh11(JCheckBox ch11) {
        this.ch11 = ch11;
    }

    public JCheckBox getCh12() {
        return ch12;
    }

    public void setCh12(JCheckBox ch12) {
        this.ch12 = ch12;
    }

    public JCheckBox getCh13() {
        return ch13;
    }

    public void setCh13(JCheckBox ch13) {
        this.ch13 = ch13;
    }

    public JCheckBox getCh14() {
        return ch14;
    }

    public void setCh14(JCheckBox ch14) {
        this.ch14 = ch14;
    }

    public JCheckBox getCh15() {
        return ch15;
    }

    public void setCh15(JCheckBox ch15) {
        this.ch15 = ch15;
    }

    public JCheckBox getCh16() {
        return ch16;
    }

    public void setCh16(JCheckBox ch16) {
        this.ch16 = ch16;
    }

    public JCheckBox getCh17() {
        return ch17;
    }

    public void setCh17(JCheckBox ch17) {
        this.ch17 = ch17;
    }

    public JCheckBox getCh18() {
        return ch18;
    }

    public void setCh18(JCheckBox ch18) {
        this.ch18 = ch18;
    }

    public JCheckBox getCh19() {
        return ch19;
    }

    public void setCh19(JCheckBox ch19) {
        this.ch19 = ch19;
    }

    public JCheckBox getCh20() {
        return ch20;
    }

    public void setCh20(JCheckBox ch20) {
        this.ch20 = ch20;
    }

    public ArrayList<JCheckBox> getCheckBoxes() {
        return checkBoxes;
    }

    public void setCheckBoxesLatera(ArrayList<JCheckBox> checkBoxes) {
        this.setCheckBoxes(getCheckBoxes());
    }

    public JTextField getTx1() {
        return tx1;
    }

    public void setTx1(JTextField tx1) {
        this.tx1 = tx1;
    }

    public JTextField getTx2() {
        return tx2;
    }

    public void setTx2(JTextField tx2) {
        this.tx2 = tx2;
    }

    public JTextField getTx3() {
        return tx3;
    }

    public void setTx3(JTextField tx3) {
        this.tx3 = tx3;
    }

    public JTextField getTx4() {
        return tx4;
    }

    public void setTx4(JTextField tx4) {
        this.tx4 = tx4;
    }

    public JTextField getTx5() {
        return tx5;
    }

    public void setTx5(JTextField tx5) {
        this.tx5 = tx5;
    }

    public JTextField getTx6() {
        return tx6;
    }

    public void setTx6(JTextField tx6) {
        this.tx6 = tx6;
    }

    public JTextField getTx7() {
        return tx7;
    }

    public void setTx7(JTextField tx7) {
        this.tx7 = tx7;
    }

    public JTextField getTx8() {
        return tx8;
    }

    public void setTx8(JTextField tx8) {
        this.tx8 = tx8;
    }

    public JTextField getTx9() {
        return tx9;
    }

    public void setTx9(JTextField tx9) {
        this.tx9 = tx9;
    }

    public JTextField getTx10() {
        return tx10;
    }

    public void setTx10(JTextField tx10) {
        this.tx10 = tx10;
    }

    public JTextField getTx11() {
        return tx11;
    }

    public void setTx11(JTextField tx11) {
        this.tx11 = tx11;
    }

    public JTextField getTx12() {
        return tx12;
    }

    public void setTx12(JTextField tx12) {
        this.tx12 = tx12;
    }

    public JTextField getTx13() {
        return tx13;
    }

    public void setTx13(JTextField tx13) {
        this.tx13 = tx13;
    }

    public JTextField getTx14() {
        return tx14;
    }

    public void setTx14(JTextField tx14) {
        this.tx14 = tx14;
    }

    public JTextField getTx15() {
        return tx15;
    }

    public void setTx15(JTextField tx15) {
        this.tx15 = tx15;
    }

    public JTextField getTx16() {
        return tx16;
    }

    public void setTx16(JTextField tx16) {
        this.tx16 = tx16;
    }

    public JTextField getTx17() {
        return tx17;
    }

    public void setTx17(JTextField tx17) {
        this.tx17 = tx17;
    }

    public JTextField getTx18() {
        return tx18;
    }

    public void setTx18(JTextField tx18) {
        this.tx18 = tx18;
    }

    public JTextField getTx19() {
        return tx19;
    }

    public void setTx19(JTextField tx19) {
        this.tx19 = tx19;
    }

    public JTextField getTx20() {
        return tx20;
    }

    public void setTx20(JTextField tx20) {
        this.tx20 = tx20;
    }

    public JTextField getTx21() {
        return tx21;
    }

    public void setTx21(JTextField tx21) {
        this.tx21 = tx21;
    }

    public JTextField getTx22() {
        return tx22;
    }

    public void setTx22(JTextField tx22) {
        this.tx22 = tx22;
    }

    public JTextField getTx23() {
        return tx23;
    }

    public void setTx23(JTextField tx23) {
        this.tx23 = tx23;
    }

    public JTextField getTx24() {
        return tx24;
    }

    public void setTx24(JTextField tx24) {
        this.tx24 = tx24;
    }

    public JTextField getTx25() {
        return tx25;
    }

    public void setTx25(JTextField tx25) {
        this.tx25 = tx25;
    }

    public JTextField getTx26() {
        return tx26;
    }

    public void setTx26(JTextField tx26) {
        this.tx26 = tx26;
    }

    public JTextField getTx27() {
        return tx27;
    }

    public void setTx27(JTextField tx27) {
        this.tx27 = tx27;
    }

    public JTextField getTx28() {
        return tx28;
    }

    public void setTx28(JTextField tx28) {
        this.tx28 = tx28;
    }

    public JTextField getTx29() {
        return tx29;
    }

    public void setTx29(JTextField tx29) {
        this.tx29 = tx29;
    }

    public JTextField getTx30() {
        return tx30;
    }

    public void setTx30(JTextField tx30) {
        this.tx30 = tx30;
    }

    public JTextField getTx31() {
        return tx31;
    }

    public void setTx31(JTextField tx31) {
        this.tx31 = tx31;
    }

    public JTextField getTx32() {
        return tx32;
    }

    public void setTx32(JTextField tx32) {
        this.tx32 = tx32;
    }

    public JTextField getTx33() {
        return tx33;
    }

    public void setTx33(JTextField tx33) {
        this.tx33 = tx33;
    }

    public JTextField getTx34() {
        return tx34;
    }

    public void setTx34(JTextField tx34) {
        this.tx34 = tx34;
    }

    public JTextField getTx35() {
        return tx35;
    }

    public void setTx35(JTextField tx35) {
        this.tx35 = tx35;
    }

    public JTextField getTx36() {
        return tx36;
    }

    public void setTx36(JTextField tx36) {
        this.tx36 = tx36;
    }

    public JTextField getTx37() {
        return tx37;
    }

    public void setTx37(JTextField tx37) {
        this.tx37 = tx37;
    }

    public JTextField getTx38() {
        return tx38;
    }

    public void setTx38(JTextField tx38) {
        this.tx38 = tx38;
    }

    public JTextField getTx39() {
        return tx39;
    }

    public void setTx39(JTextField tx39) {
        this.tx39 = tx39;
    }

    public JTextField getTx40() {
        return tx40;
    }

    public void setTx40(JTextField tx40) {
        this.tx40 = tx40;
    }

    public JTextField getTx41() {
        return tx41;
    }

    public void setTx41(JTextField tx41) {
        this.tx41 = tx41;
    }

    public JTextField getTx42() {
        return tx42;
    }

    public void setTx42(JTextField tx42) {
        this.tx42 = tx42;
    }

    public JTextField getTx43() {
        return tx43;
    }

    public void setTx43(JTextField tx43) {
        this.tx43 = tx43;
    }

    public JTextField getTx44() {
        return tx44;
    }

    public void setTx44(JTextField tx44) {
        this.tx44 = tx44;
    }

    public JTextField getTx45() {
        return tx45;
    }

    public void setTx45(JTextField tx45) {
        this.tx45 = tx45;
    }

    public JTextField getTx46() {
        return tx46;
    }

    public void setTx46(JTextField tx46) {
        this.tx46 = tx46;
    }

    public JTextField getTx47() {
        return tx47;
    }

    public void setTx47(JTextField tx47) {
        this.tx47 = tx47;
    }

    public JTextField getTx48() {
        return tx48;
    }

    public void setTx48(JTextField tx48) {
        this.tx48 = tx48;
    }

    public JTextField getTx49() {
        return tx49;
    }

    public void setTx49(JTextField tx49) {
        this.tx49 = tx49;
    }

    public JTextField getTx50() {
        return tx50;
    }

    public void setTx50(JTextField tx50) {
        this.tx50 = tx50;
    }

    public JTextField getTx51() {
        return tx51;
    }

    public void setTx51(JTextField tx51) {
        this.tx51 = tx51;
    }

    public JTextField getTx52() {
        return tx52;
    }

    public void setTx52(JTextField tx52) {
        this.tx52 = tx52;
    }

    public JTextField getTx53() {
        return tx53;
    }

    public void setTx53(JTextField tx53) {
        this.tx53 = tx53;
    }

    public JTextField getTx54() {
        return tx54;
    }

    public void setTx54(JTextField tx54) {
        this.tx54 = tx54;
    }

    public JTextField getTx55() {
        return tx55;
    }

    public void setTx55(JTextField tx55) {
        this.tx55 = tx55;
    }

    public JTextField getTx56() {
        return tx56;
    }

    public void setTx56(JTextField tx56) {
        this.tx56 = tx56;
    }

    public JTextField getTx57() {
        return tx57;
    }

    public void setTx57(JTextField tx57) {
        this.tx57 = tx57;
    }

    public JTextField getTx58() {
        return tx58;
    }

    public void setTx58(JTextField tx58) {
        this.tx58 = tx58;
    }

    public JTextField getTx59() {
        return tx59;
    }

    public void setTx59(JTextField tx59) {
        this.tx59 = tx59;
    }

    public JTextField getTx60() {
        return tx60;
    }

    public void setTx60(JTextField tx60) {
        this.tx60 = tx60;
    }

    public JTextField getTx61() {
        return tx61;
    }

    public void setTx61(JTextField tx61) {
        this.tx61 = tx61;
    }

    public JTextField getTx62() {
        return tx62;
    }

    public void setTx62(JTextField tx62) {
        this.tx62 = tx62;
    }

    public JTextField getTx63() {
        return tx63;
    }

    public void setTx63(JTextField tx63) {
        this.tx63 = tx63;
    }

    public JTextField getTx64() {
        return tx64;
    }

    public void setTx64(JTextField tx64) {
        this.tx64 = tx64;
    }

    public JTextField getTx65() {
        return tx65;
    }

    public void setTx65(JTextField tx65) {
        this.tx65 = tx65;
    }

    public JTextField getTx66() {
        return tx66;
    }

    public void setTx66(JTextField tx66) {
        this.tx66 = tx66;
    }

    public JTextField getTx67() {
        return tx67;
    }

    public void setTx67(JTextField tx67) {
        this.tx67 = tx67;
    }

    public JTextField getTx68() {
        return tx68;
    }

    public void setTx68(JTextField tx68) {
        this.tx68 = tx68;
    }

    public JTextField getTx69() {
        return tx69;
    }

    public void setTx69(JTextField tx69) {
        this.tx69 = tx69;
    }

    public JTextField getTx70() {
        return tx70;
    }

    public void setTx70(JTextField tx70) {
        this.tx70 = tx70;
    }

    public JCheckBox getCh21() {
        return ch21;
    }

    public void setCh21(JCheckBox ch21) {
        this.ch21 = ch21;
    }

    public JCheckBox getCh22() {
        return ch22;
    }

    public void setCh22(JCheckBox ch22) {
        this.ch22 = ch22;
    }

    public JCheckBox getCh23() {
        return ch23;
    }

    public void setCh23(JCheckBox ch23) {
        this.ch23 = ch23;
    }

    public JCheckBox getCh24() {
        return ch24;
    }

    public void setCh24(JCheckBox ch24) {
        this.ch24 = ch24;
    }

    public JCheckBox getCh25() {
        return ch25;
    }

    public void setCh25(JCheckBox ch25) {
        this.ch25 = ch25;
    }

    public JCheckBox getCh26() {
        return ch26;
    }

    public void setCh26(JCheckBox ch26) {
        this.ch26 = ch26;
    }

    public JCheckBox getCh27() {
        return ch27;
    }

    public void setCh27(JCheckBox ch27) {
        this.ch27 = ch27;
    }

    public JCheckBox getCh28() {
        return ch28;
    }

    public void setCh28(JCheckBox ch28) {
        this.ch28 = ch28;
    }

    public JCheckBox getCh29() {
        return ch29;
    }

    public void setCh29(JCheckBox ch29) {
        this.ch29 = ch29;
    }

    public JCheckBox getCh31() {
        return ch31;
    }

    public void setCh31(JCheckBox ch31) {
        this.ch31 = ch31;
    }

    public JCheckBox getCh32() {
        return ch32;
    }

    public void setCh32(JCheckBox ch32) {
        this.ch32 = ch32;
    }

    public JCheckBox getCh33() {
        return ch33;
    }

    public void setCh33(JCheckBox ch33) {
        this.ch33 = ch33;
    }

    public JCheckBox getCh34() {
        return ch34;
    }

    public void setCh34(JCheckBox ch34) {
        this.ch34 = ch34;
    }

    public JCheckBox getCh35() {
        return ch35;
    }

    public void setCh35(JCheckBox ch35) {
        this.ch35 = ch35;
    }

    public JCheckBox getCh36() {
        return ch36;
    }

    public void setCh36(JCheckBox ch36) {
        this.ch36 = ch36;
    }

    public JCheckBox getCh37() {
        return ch37;
    }

    public void setCh37(JCheckBox ch37) {
        this.ch37 = ch37;
    }

    public JCheckBox getCh38() {
        return ch38;
    }

    public void setCh38(JCheckBox ch38) {
        this.ch38 = ch38;
    }

    public JCheckBox getCh39() {
        return ch39;
    }

    public void setCh39(JCheckBox ch39) {
        this.ch39 = ch39;
    }

    public JCheckBox getCh40() {
        return ch40;
    }

    public void setCh40(JCheckBox ch40) {
        this.ch40 = ch40;
    }

    public JCheckBox getCh41() {
        return ch41;
    }

    public void setCh41(JCheckBox ch41) {
        this.ch41 = ch41;
    }

    public JCheckBox getCh42() {
        return ch42;
    }

    public void setCh42(JCheckBox ch42) {
        this.ch42 = ch42;
    }

    public JCheckBox getCh43() {
        return ch43;
    }

    public void setCh43(JCheckBox ch43) {
        this.ch43 = ch43;
    }

    public JCheckBox getCh44() {
        return ch44;
    }

    public void setCh44(JCheckBox ch44) {
        this.ch44 = ch44;
    }

    public JCheckBox getCh45() {
        return ch45;
    }

    public void setCh45(JCheckBox ch45) {
        this.ch45 = ch45;
    }

    public JCheckBox getCh46() {
        return ch46;
    }

    public void setCh46(JCheckBox ch46) {
        this.ch46 = ch46;
    }

    public JCheckBox getCh47() {
        return ch47;
    }

    public void setCh47(JCheckBox ch47) {
        this.ch47 = ch47;
    }

    public JCheckBox getCh48() {
        return ch48;
    }

    public void setCh48(JCheckBox ch48) {
        this.ch48 = ch48;
    }

    public JCheckBox getCh49() {
        return ch49;
    }

    public void setCh49(JCheckBox ch49) {
        this.ch49 = ch49;
    }

    public JCheckBox getCh50() {
        return ch50;
    }

    public void setCh50(JCheckBox ch50) {
        this.ch50 = ch50;
    }

    public JCheckBox getCh51() {
        return ch51;
    }

    public void setCh51(JCheckBox ch51) {
        this.ch51 = ch51;
    }

    public JCheckBox getCh52() {
        return ch52;
    }

    public void setCh52(JCheckBox ch52) {
        this.ch52 = ch52;
    }

    public JCheckBox getCh53() {
        return ch53;
    }

    public void setCh53(JCheckBox ch53) {
        this.ch53 = ch53;
    }

    public JCheckBox getCh54() {
        return ch54;
    }

    public void setCh54(JCheckBox ch54) {
        this.ch54 = ch54;
    }

    public JCheckBox getCh55() {
        return ch55;
    }

    public void setCh55(JCheckBox ch55) {
        this.ch55 = ch55;
    }

    public JCheckBox getCh56() {
        return ch56;
    }

    public void setCh56(JCheckBox ch56) {
        this.ch56 = ch56;
    }

    public JCheckBox getCh57() {
        return ch57;
    }

    public void setCh57(JCheckBox ch57) {
        this.ch57 = ch57;
    }

    public JCheckBox getCh58() {
        return ch58;
    }

    public void setCh58(JCheckBox ch58) {
        this.ch58 = ch58;
    }

    public JCheckBox getCh59() {
        return ch59;
    }

    public void setCh59(JCheckBox ch59) {
        this.ch59 = ch59;
    }

    public JCheckBox getCh60() {
        return ch60;
    }

    public void setCh60(JCheckBox ch60) {
        this.ch60 = ch60;
    }

    public void setCheckBoxes(ArrayList<JCheckBox> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public JCheckBox getCh30() {
        return ch30;
    }

    public void setCh30(JCheckBox ch30) {
        this.ch30 = ch30;
    }

    public JPanel getImagePanelFrontal() {
        return imagePanelFrontal;
    }

    public void setImagePanelFrontal(JPanel imagePanelFrontal) {
        this.imagePanelFrontal = imagePanelFrontal;
    }

    public JLabel getImageLabelFrontal() {
        return imageLabelFrontal;
    }

    public void setImageLabelFrontal(JLabel imageLabelFrontal) {
        this.imageLabelFrontal = imageLabelFrontal;
    }

    public JPanel getImagePanelCastModel() {
        return imagePanelCastModel;
    }

    public void setImagePanelCastModel(JPanel imagePanelCastModel) {
        this.imagePanelCastModel = imagePanelCastModel;
    }

    public JLabel getImageLabelCastModel() {
        return imageLabelCastModel;
    }

    public void setImageLabelCastModel(JLabel imageLabelCastModel) {
        this.imageLabelCastModel = imageLabelCastModel;
    }
//****************************************************************************\\
//                                  END                                       \\
//****************************************************************************\\s

    public JTextField getTxId_lateral() {
        return txId_lateral;
    }

    public void setTxId_lateral(JTextField txId_lateral) {
        this.txId_lateral = txId_lateral;
    }

    public JTextField getTxFirstName_lateral() {
        return txFirstName_lateral;
    }

    public void setTxFirstName_lateral(JTextField txFirstName_lateral) {
        this.txFirstName_lateral = txFirstName_lateral;
    }

    public JTextField getTxLastName_lateral() {
        return txLastName_lateral;
    }

    public void setTxLastName_lateral(JTextField txLastName_lateral) {
        this.txLastName_lateral = txLastName_lateral;
    }

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }

}
