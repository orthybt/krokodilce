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
import com.example.krokodilce.src.dataObjects.OrthyPath;
import com.example.krokodilce.src. dataObjects.Patient;
import com.example.krokodilce.src.util.FileManager;

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                           PATH HANDLER                                     \\
//****************************************************************************\\
public class PathHandler{    
    //************************************************************************\\
    //                           CONSTRUCTORS                                 \\
    //************************************************************************\\
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    //************************************************************************\\
    //                              METHODS                                   \\
    //************************************************************************\\
    
    public void initPatientPaths(File file, Patient patient){
        //ROOT DIR
        Path rootDir = getRootDir();

        //PATIENT DIR
        Path patientDir = getPatientDir(file, patient);

        //FILE PATH
        Path filePath = getImagePath(file, patient);

        //XML PATH
        Path xmlPath = getXML_Path(file, patient);
        
        OrthyPath tempPath = new OrthyPath( FileManager.getPath(rootDir), 
                                            FileManager.getPath(patientDir), 
                                            FileManager.getPath(filePath), 
                                            FileManager.getPath(xmlPath));
        patient.updateOrthyPath(tempPath);//PATIENT SHOULD BE ABLE TO UPDATE ITSELF
        c.dataManager().updateData(patient);//DATA MANAGER SHOULD ONLY REFER THE UPDATED PATIENT
    }
    //************************************************************************\\
    //                              RESET                                     \\
    //************************************************************************\\
    public void resetPaths(){
        Patient patient = c.data().getCurrentPatient();
        c.data().setCurrentPatient(patient.resetPatient_Paths(patient));
    }
    //************************************************************************\\
    //                         GETTERS/SETTERS                                \\
    //************************************************************************\\
    public Path getRootDir(){
        return FileManager.getPath("C:\\Users\\Orthy\\Desktop\\Orthy");
    }
    public Path getPatientDir(File file, Patient patient){
        //THE PATH TO THE PATIENTS'S FOLDER
        String patientPath = file.getParent();
        return FileManager.getPath(patientPath);
    }
    public Path getImagePath(File file, Patient patient){
        //PATH TO THE IMAGE
        String imagePath = file.getAbsolutePath();
        return FileManager.getPath(imagePath);
    }
    public Path getXML_Path(File file, Patient patient){
        //XML NAME
        String xmlName = String.format("%s%s", patient.getFirstName()+"_"+patient.getLastName(),".xml");
        String path = file.getParent();
        String xmlPath = String.format("%s%s%s", path,File.separator,xmlName);
        return FileManager.getPath(xmlPath);
    }
    public Path getPatientsSavePath(){
        return FileManager.getPath("C:\\Users\\Orthy\\Desktop\\Orthy\\Data\\patientData.xml");
    }
    
//****************************************************************************\\
//                                    END                                     \\
//****************************************************************************\\    

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }
}
