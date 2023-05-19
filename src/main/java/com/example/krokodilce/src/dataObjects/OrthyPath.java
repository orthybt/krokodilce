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

package com.example.krokodilce.src.dataObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Data object = OrthyPath - essential paths to the patient data
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//              ORTHY PATH - ESSENTIAL PATHS TO THE PATIENT DATA              \\
//****************************************************************************\\
public class OrthyPath{
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    private String rootDir;
    private String patientDir;
    private String imageFile;
    private String xmlPath;
    private List<String> paths;
    //************************************************************************\\
    //                          CONSTRUCTORS                                  \\
    //************************************************************************\\  
    public OrthyPath(){
        this.rootDir = "";
        this.patientDir = "";
        this.imageFile = "";
        this.xmlPath = "";
        this.paths = new ArrayList<String>();
    } 
    public OrthyPath(
                    String rootDir,
                    String patientDir, 
                    String imageFile, 
                    String xmlPath){
        
       this.rootDir = rootDir;
       this.patientDir = patientDir;
       this.imageFile = imageFile;
       this.xmlPath = xmlPath;
       this.paths = new ArrayList<String>();
       this.paths.add(rootDir);
       this.paths.add(patientDir);
       this.paths.add(imageFile);
       this.paths.add(xmlPath);
    }
    //************************************************************************\\
    //                          METHODS                                       \\
    //************************************************************************\\
 
    //************************************************************************\\
    //                          GETTERS/SETTERS                               \\
    //************************************************************************\\
    public String getPatientDir() {
        return patientDir;
    }

    public void setPatientDir(String patientDir) {
        this.patientDir = patientDir;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
    
    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }
    //************************************************************************\\
    //                          TO STRING                                     \\
    //************************************************************************\\
    @Override
    public String toString(){
        String _rootDir = String.format("%s%100s%n", "Root dir", rootDir);
        String _patientDir = String.format("%s%100s%n", "Patient dir", patientDir);
        String _imageFile = String.format("%s%100s%n", "Image path", imageFile);
        String _xmlName = String.format("%s%100s%n", "XML name", xmlPath);
        return _rootDir+_patientDir+_imageFile+_xmlName;
    }
//****************************************************************************\\
//                              ENDs                                          \\
//****************************************************************************\\ 

    
    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    
}
