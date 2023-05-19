package com.example.krokodilce.src.handlers;

import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.util.OrthyLine;

import javax.swing.*;
import java.awt.*;

/**
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                              GUI HANDLER                                   \\
//****************************************************************************\\
public class GuiHandler{
    //************************************************************************\\
    //                          CONSTRUCTORS                                  \\
    //************************************************************************\\
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //     --------------------       GFX        --------------------         \\
    //************************************************************************\\
    private Graphics2D gfx;
    //************************************************************************\\
    //                              PANELS                                    \\
    //************************************************************************\\
    public void clearImagePanel_Lateral(){
        c.gc().getImagePanelLateral().repaint();
    }
    public void clearCanvas_Lateral(){
        c.gc().getImageLabelLateral().setIcon(new ImageIcon());
        c.gc().getImagePanelLateral().repaint();
    }
    //************************************************************************\\
    //                              CHECK BOXES                               \\
    //************************************************************************\\
    public void unMarkCheckBox(int index){
        getC().gc().getCheckBoxes().get(index).setSelected(false);
    }
    public void markCheckBox(int index){
        getC().gc().getCheckBoxes().get(index).setSelected(true);
    }
    public void clearCheckBoxes(){
        c.gc().getCheckBoxes().forEach((t) -> {
            t.setSelected(false);
        });        
    }
    //************************************************************************\\
    //                              TEXT FIELDS                               \\
    //************************************************************************\\
    public void disable_tx_PatientInputFields(){
        c.gc().getTxId_lateral().setVisible(false);
        c.gc().getTxFirstName_lateral().setVisible(false);
        c.gc().getTxLastName_lateral().setVisible(false);
    }
    private void clear_tx_PatientInputFields(){
        c.gc().getTxId_lateral().setText("");
        c.gc().getTxFirstName_lateral().setText("");
        c.gc().getTxLastName_lateral().setText("");
    }
    private void clear_tx_JPF(){
        c.gc().getTx1().setText("");;
        c.gc().getTx2().setText("");;
    }
    private void clear_tx_ELine(){
        c.gc().getTx3().setText("");;
        c.gc().getTx4().setText("");;
        c.gc().getTx5().setText("");;
    }
    private void clear_tx_Zangle(){
        c.gc().getTx6().setText("");;
    }
    private void clear_tx_facialConvexity(){
        c.gc().getTx7().setText("");;
    }
    private void clear_tx_nasolabialAngle(){
        c.gc().getTx8().setText("");;
    }
    private void clear_tx_mentolabialAngle(){
        c.gc().getTx9().setText("");;
    }
    private void clear_tx_Lateral(){
        clear_tx_PatientInputFields();
        clear_tx_JPF();
        clear_tx_ELine();
        clear_tx_Zangle();
        clear_tx_facialConvexity();
        clear_tx_nasolabialAngle();
        clear_tx_mentolabialAngle();
    }
    //************************************************************************\\
    //                              RESET                              \\
    //************************************************************************\\
    public void softReset_Lateral(){
        clearCheckBoxes();
        clearImagePanel_Lateral();
        clear_tx_JPF();
        clear_tx_ELine();
        clear_tx_Zangle();
        clear_tx_facialConvexity();
        clear_tx_nasolabialAngle();
        clear_tx_mentolabialAngle();
    }
    public void hardReset_Lateral(){
        clearCanvas_Lateral();
        clearCheckBoxes();
        clear_tx_Lateral();
        
    }
    //************************************************************************\\
    //                              MISC METHODS                              \\
    //************************************************************************\\
    public void getFileDialog(){
        JOptionPane optionPane = new JOptionPane("THE FILE IS CORUPTED");
        optionPane.setVisible(true);
    }
    public String getText(String txt){
        return String.format("%s", txt);
    }
    public String getTextNoDecimals(Double value){
        return String.format("%.0f%%", value);
    }
    public String getText(Double value){
        return String.format("%.1f", value);
    }
    public void setText(String txt, JTextField txtField){
        txtField.setText(txt);
    }
    public void setText(Double value, JTextField txtField){
        txtField.setText(getText(value));
    }
    public void setTextPercent(Double value, JTextField txtField){
        txtField.setText(getTextNoDecimals(value));
    }
    public void drawText(String txt, OrthyLine line){
        //Get the midpoint of the line and this will be the destination of the txt
        Point midPoint = line.getMidPoint();
        //At this location draw text            
    }
    //************************************************************************\\
    //                          GETTERS AND SETTERS                           \\
    //*************************|*|********************************************\\
    public Graphics2D getGfx() {
        Graphics2D _gfx = (Graphics2D)c.gc().getImagePanelLateral().getGraphics();
        setGfx(gfx);
        return this.gfx;
    }

    public void setGfx(Graphics2D gfx) {
        this.gfx = gfx;
    }

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
