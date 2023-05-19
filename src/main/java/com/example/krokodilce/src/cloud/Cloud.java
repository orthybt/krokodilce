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
package com.example.krokodilce.src.cloud;

import com.example.krokodilce.src.handlers.*;
import com.example.krokodilce.src.managers.DataManager;
import com.example.krokodilce.src.memory.Data;
import com.example.krokodilce.src.memory.GuiComponents;
import com.example.krokodilce.src.memory.Lines;
import com.example.krokodilce.src.memory.Points;
import com.example.krokodilce.src.util.*;

import java.awt.*;

/**
 * This is the Cloud, everything can be accesed through the cloud
 * The perfect API for Orthy :) Love and all the best man <3 Godspeed
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                              THE CLOUD                                     \\
//****************************************************************************\\
public class Cloud {                                                              
//                                                                            \\
//                                                                            \\
    //************************************************************************\\
    //                          API MADE FOR ORTHY                            \\
    //************************************************************************\\
    private Cloud cloud;
    //************************************************************************\\
    //              MEMORY OBJECTS - PROGRAM NATIVE - PRIMITIVES              \\
    //************************************************************************\\
    private Points points;
    private Lines lines;
    private GuiComponents guiComponents;
    //************************************************************************\\
    //              MEMORY OBJECTS - DATABASE READY OBJECTS                   \\
    //************************************************************************\\
    private Data data;
    //************************************************************************\\
    //                         CORE ORTHY :))))                               \\
    //************************************************************************\\
    private LineFactory lineFactory;
    private OrthyMath orthyMath;
    //************************************************************************\\
    //                          DATA MANAGERS                                 \\
    //************************************************************************\\
    private DataManager dataManager;
    //************************************************************************\\
    //                          HANDLERS                                      \\
    //************************************************************************\\
    private PointHandler pointHandler;
    private LineHandler lineHandler;
    private GuiHandler guiHandler;
    private PathHandler pathHandler;
    private ImageHandler imageHandler;
    private ResultHandler resultHandler;
    //************************************************************************\\
    //                         UTILITIES                                      \\
    //************************************************************************\\
    private Pen pen;
    private Helper help;
    private Tester test;
    //************************************************************************\\
    //                         MISC OBJECTS(SORTING NEEDED)                   \\
    //************************************************************************\\
    private Graphics2D gfx;
    //************************************************************************\\
    //                          CONSTRUCTORS                                  \\
    //************************************************************************\\
    public Cloud(){
        this.points = Points.get();
        this.lines = Lines.get();
        this.guiComponents = GuiComponents.get();
        this.data = Data.get();
        this.orthyMath = OrthyMath.get();
        this.lineFactory = LineFactory.get();
        this.dataManager = DataManager.get();
        this.pointHandler = new PointHandler();
        this.lineHandler = new LineHandler();
        this.guiHandler = new GuiHandler();
        this.pathHandler = new PathHandler();
        this.imageHandler = new ImageHandler();
        this.resultHandler = new ResultHandler();
        this.pen = new Pen();
        this.help = new Helper();
        this.test = new Tester();
    }
    //************************************************************************\\
    //                         METHODS                                        \\
    //************************************************************************\\
    public void initialize(){
        points.get().setC(this);
        lines.get().setC(this);
        guiComponents.get().setC(this);
        data.get().setC(this);
        dataManager.setC(this);
        pointHandler.setC(this);
        lineHandler.setC(this);
        guiHandler.setC(this);
        pathHandler.setC(this);
        imageHandler.setC(this);
        resultHandler.setC(this);
        pen.setC(this);
        help.setC(this);
        help.setC(this);
        //GFX HANDLING!!! TO BE REWORKED SOME OTHER TIME MAYBE
        this.gfx = help.castGraphics(guiComponents.getImagePanelLateral().getGraphics());
        this.pointHandler.initGFX(gfx);
    }
    //************************************************************************\\
    //                         GETTERS AND SETTERS                            \\
    //************************************************************************\\
    public Cloud getC() {
        return cloud;
    }
    
    public void setCloud(Cloud c) {
        this.cloud = c;
    }
    
    public Points p() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public Lines l() {
        return lines;
    }

    public void setLines(Lines lines) {
        this.lines = lines;
    }

    public GuiComponents gc() {
        return guiComponents;
    }

    public void setGuiComponents(GuiComponents guiComponents) {
        this.guiComponents = guiComponents;
    }

    public Data data() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public LineFactory lineFactory() {
        return lineFactory;
    }

    public void setLineFactory(LineFactory lineFactory) {
        this.lineFactory = lineFactory;
    }

    public OrthyMath orthyMath() {
        return orthyMath;
    }

    public void setOrthyMath(OrthyMath orthyMath) {
        this.orthyMath = orthyMath;
    }

    public DataManager dataManager() {
        return dataManager;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public PointHandler pointHandler() {
        return pointHandler;
    }

    public void setPointHandler(PointHandler pointHandler) {
        this.pointHandler = pointHandler;
    }

    public LineHandler lineHandler() {
        return lineHandler;
    }

    public void setLineHandler(LineHandler lineHandler) {
        this.lineHandler = lineHandler;
    }

    public GuiHandler guiHandler() {
        return guiHandler;
    }

    public void setGuiHandler(GuiHandler guiHandler) {
        this.guiHandler = guiHandler;
    }

    public PathHandler pathHandler() {
        return pathHandler;
    }

    public void setPathHandler(PathHandler pathHandler) {
        this.pathHandler = pathHandler;
    }

    public ImageHandler imageHandler() {
        return imageHandler;
    }

    public void setImageHandler(ImageHandler imageHandler) {
        this.imageHandler = imageHandler;
    }

    public ResultHandler resultHandler() {
        return resultHandler;
    }

    public void setResultHandler(ResultHandler resultHandler) {
        this.resultHandler = resultHandler;
    }

    public Pen pen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public Helper help() {
        return help;
    }

    public void setHelp(Helper help) {
        this.help = help;
    }

    public Tester test() {
        return test;
    }

    public void setTest(Tester test) {
        this.test = test;
    }        
//****************************************************************************\\
//                              END                                           \\
//****************************************************************************\\        

    public Graphics2D getGfx() {
        return gfx;
    }

    public void setGfx(Graphics2D gfx) {
        this.gfx = gfx;
    }
}
