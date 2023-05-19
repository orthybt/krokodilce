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

import com.example.krokodilce.src.XML_Wrappers.OrthyPaths;
import com.example.krokodilce.src.XML_Wrappers.OrthyPoints;
import com.example.krokodilce.src.util.FileManager;

import java.nio.file.Path;

/**
 * Data object = Patient - contains all the data of the patient
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//              PATIENT - MAIN DATA OBJECT OF ORTHY                           \\
//****************************************************************************\\
public class Patient {
    //************************************************************************\\
    //                              CLASS VARIABLES                           \\
    //************************************************************************\\
    private String id;
    private String firstName;
    private String lastName;
    private OrthyPoints orthyPoints;
    private OrthyPaths orthyPaths;

    //************************************************************************\\
    //                              CONSTRUCTORS                              \\
    //************************************************************************\\
    //Blank constructor
    public Patient() {
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        //DEFAULT INIT - POINTS
        this.orthyPoints = new OrthyPoints();
        this.orthyPoints.getOrthyPoints().add(new OrthyPoint());
        //DEFAULT INIT - POINTS
        this.orthyPaths = new OrthyPaths();
        this.orthyPaths.getOrthyPaths().add(new OrthyPath());

    }

    //Init constructor
    public Patient(String _id, String _firstName, String _lastName) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        //DEFAULT INIT - POINTS
        this.orthyPoints = new OrthyPoints();
        this.orthyPoints.getOrthyPoints().add(new OrthyPoint());
        //DEFAULT INIT - POINTS
        this.orthyPaths = new OrthyPaths();
        this.orthyPaths.getOrthyPaths().add(new OrthyPath());
    }

    public Patient(String _id, String _firstName, String _lastName,
                   OrthyPoints _points, OrthyPaths _paths) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        //DEFAULT INIT - POINTS
        this.orthyPoints = new OrthyPoints();
        this.orthyPoints.getOrthyPoints().add(new OrthyPoint());
        //DEFAULT INIT - POINTS
        this.orthyPaths = new OrthyPaths();
        this.orthyPaths.getOrthyPaths().add(new OrthyPath());
    }

    //************************************************************************\\
    //                              METHODS - PATIENT
    //                                                                        \\
    //************************************************************************\\
    public void updatePatient(Patient patient) {
        this.id = patient.id;
        this.firstName = patient.firstName;
        this.lastName = patient.lastName;
        this.orthyPoints = patient.orthyPoints;
        this.orthyPaths = patient.orthyPaths;
    }

    public void updatePatient(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void updatePatient(OrthyPath path) {
        //THE DATA MODEL OF ORTHY IMPLIES ONE PATIENT ONE PATH OBJECT!!!
        this.orthyPaths.getOrthyPaths().clear();
        this.orthyPaths.getOrthyPaths().add(path);
    }

    public void updatePatient(OrthyPaths paths) {
        this.orthyPaths = paths;
    }

    public void updatePatient(OrthyPoint point, int index) {
        //MIGHT REQUIRE TWEAKING!!!!
        this.orthyPoints.getOrthyPoints().remove(index);
        this.orthyPoints.getOrthyPoints().add(index, point);
    }

    public void updatePatient(OrthyPoints points) {
        this.orthyPoints = points;
    }

    //************************************************************************\\
    //                              METHODS - ORTHY PATHS
    //                              \\
    //************************************************************************\\
    public void updateOrthyPath(OrthyPath path) {
        //first clear the array
        this.orthyPaths.getOrthyPaths().clear();
        //update with the new paths
        this.orthyPaths.getOrthyPaths().add(path);
    }

    public void updateOrthyPaths(OrthyPaths paths) {
        //CLEAR THE ARRAY
        this.getOrthyPaths().getOrthyPaths().clear();
        //ADD THE THE PATHS
        this.getOrthyPaths().getOrthyPaths().addAll(paths.getOrthyPaths());
    }

    //************************************************************************\\
    //                              METHODS - ORTHY POINTS                    \\
    //************************************************************************\\
    public void updateOrthyPoints(OrthyPoints points) {
        //first clear the array
        this.orthyPoints.getOrthyPoints().clear();
        //update with the new points
        this.orthyPoints.getOrthyPoints().addAll(points.getOrthyPoints());
    }

    public void updateOrthyPoint(OrthyPoint p, int index) {
        getOrthyPoints().getOrthyPoints().remove(index);
        getOrthyPoints().getOrthyPoints().add(index, p);
    }

    //************************************************************************\\
    //                              METHODS - RESET                           \\
    //************************************************************************\\
    public Patient resetPatient(Patient patient) {
        patient.id = "";
        patient.firstName = "";
        patient.lastName = "";
        //DEFAULT INIT - POINTS
        patient.orthyPoints = new OrthyPoints();
        patient.orthyPoints.getOrthyPoints().add(new OrthyPoint());
        //DEFAULT INIT - PATHS
        patient.orthyPaths = new OrthyPaths();
        patient.orthyPaths.getOrthyPaths().add(new OrthyPath());
        return patient;
    }

    public Patient resetPatient_Paths(Patient patient) {
        //DEFAULT INIT - PATHS
        patient.orthyPaths = new OrthyPaths();
        patient.orthyPaths.getOrthyPaths().add(new OrthyPath());
        return patient;
    }

    public Patient resetPatient_Points(Patient patient) {
        //DEFAULT INIT - POINTS
        patient.orthyPoints = new OrthyPoints();
        patient.orthyPoints.getOrthyPoints().add(new OrthyPoint());
        return patient;
    }

    //************************************************************************\\
    //                              METHODS - TO STRING                       \\
    //************************************************************************\\
    @Override
    public String toString() {
        String header = String.format("%s%15s%15s%n", "ID", "FIRST NAME",
                "LAST NAME");
        String basicInfo = String.format("%s%15s%15s%n", this.id,
                this.firstName, this.lastName);
        String paths = this.orthyPaths.getOrthyPaths().toString();
        return header + basicInfo + paths;
    }

    //************************************************************************\\
    //                              GETTERS/SETTERS                           \\
    //************************************************************************\\  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public OrthyPoints getOrthyPoints() {
        return orthyPoints;
    }

    public void setOrthyPoints(OrthyPoints orthyPoints) {
        this.orthyPoints = orthyPoints;
    }

    public OrthyPaths getOrthyPaths() {
        return orthyPaths;
    }

    public void setOrthyPaths(OrthyPaths orthyPaths) {
        this.orthyPaths = orthyPaths;
    }

    public OrthyPath getOrthyPath() {
        return this.orthyPaths.getOrthyPaths().get(0);
    }

    public Path getRoorPath() {
        return FileManager.getPath(this.getOrthyPath().getRootDir());
    }

    public Path getPatientDir() {
        return FileManager.getPath(this.getOrthyPath().getPatientDir());
    }

    public Path getImagePath() {
        return FileManager.getPath(this.getOrthyPath().getImageFile());
    }

    public Path getXML_Path() {
        return FileManager.getPath(this.getOrthyPath().getXmlPath());
    }
    //****************************************************************************\\
    //                              ENDs
    //                              \\
    //****************************************************************************\\
}
