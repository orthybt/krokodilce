package com.example.krokodilce.src.managers;

import com.example.krokodilce.src.XML_Wrappers.OrthyPaths;
import com.example.krokodilce.src.XML_Wrappers.OrthyPoints;
import com.example.krokodilce.src.XML_Wrappers.Patients;
import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.dataObjects.Patient;
import com.example.krokodilce.src.util.FileManager;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                                DATA MANAGER                                \\
//****************************************************************************\\
public final class DataManager {
    //************************************************************************\\
    //                      SPACE FOR DATA OBJECTS                            \\
    //************************************************************************\\
    //                           SINGLETON INIT                               \\
    //************************************************************************\\
    private final static DataManager dataManager = new DataManager();
    public static DataManager get(){
        return dataManager;
    }
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    //************************************************************************\\
    //                           CONSTRUCTORS                                 \\
    //************************************************************************\\
    //************************************************************************\\
    //                            PATIENT - CREATE PATIENT                    \\
    //************************************************************************\\
    public void createPatient(String id, String firstName, String lastName){  
        //NEW PATIENT
        Patient patient = new Patient(id, firstName, lastName);
        //CURRENT PATIENT
        c.data().setCurrentPatient(patient);
        //UPDATE THE DATABASE
        c.test().testPatient(patient);
        updateData(patient);
    }
    public void createPatient(String id, String firstName, String lastName,
                                    OrthyPoints points, OrthyPaths paths){  
        //NEW PATIENT
        Patient patient = new Patient(id, firstName, lastName, points, paths);
        //CURRENT PATIENT
        c.data().setCurrentPatient(patient);
        //UPDATE THE DATABASE
        updateData(patient);
        c.test().testPatient(patient);
    }
    //************************************************************************\\
    //                            PATIENT - EDIT PATIENT                      \\
    //************************************************************************\\
    /**
     * EDIT A PATIENT IN A LIST
     * @param index
     * @param id
     * @param firstName
     * @param lastName
     * @param points
     * @param paths 
     */
    public void editPatient(Integer index, String id, String firstName, String lastName,
                                    OrthyPoints points, OrthyPaths paths){
        //Modify the selected patient with the method parameters
        Patient patient = getC().data().getCurrentPatient();
        patient.setId(id);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setOrthyPoints(points);
        patient.setOrthyPaths(paths);
        //Update the database
        updateData(patient, index);
    }
    /**
     * UPDATE THE CURRENT PATIENT AND ADD PATIENT TO PATIENTS
     * @param patient 
     */
    //************************************************************************\\
    //                            PATIENT - UPDATE DATA                       \\
    //************************************************************************\\
    public void updateData(Patient patient){
        //UPDATE THE PATIENTS IN DATA
        //getC().data().getPatients().getPatients().clear();
        getC().data().getPatients().getPatients().add(patient);
        //UPDATE THE CURRENT PATIENT
        getC().data().setCurrentPatient(patient);
    }
    /**
     * PATIENT UPDATE IF YOU WANT TO UPDATE A LIST
     * @param patient
     * @param index 
     */
    public void updateData(Patient patient, int index){
        getC().data().getPatients().getPatients().get(index).updatePatient(patient);
        //update the selected patient
        getC().data().setCurrentPatient(patient);
    }
    public void updateData(Patients patients, Patient patient){
        //ADD THE CURRENT PATIENT TO THE PATIENTS
        c.data().getPatients().getPatients().add(c.data().getCurrentPatient());
    }
    //************************************************************************\\
    //                            PATIENT - LOAD DATA                         \\
    //************************************************************************\\
    public void loadData(Patients patients){
        c.data().setPatients(patients);
        c.data().setCurrentPatient(patients.getPatients().get(0));
        c.p().setOrthyPointsLateral(patients.getPatients().get(0).getOrthyPoints().getOrthyPoints());
    }
    public void deletePatient(int index){
        //update the database
        getC().data().getPatients().getPatients().remove(index);
    }
    
    public void savePatient(Patient patient){
        
        Patients __patient = new Patients();
        
        //CREATE XML FILE IN THE PATIENT DIR
        Path savePath_Patient = FileManager.getPath(c.data().getCurrentPatient().getOrthyPath().getXmlPath());
        //DATA DIR WHERE ALL THE PATIENTS ARE
        Path savePath_Patients = c.pathHandler().getPatientsSavePath();
        File savePath = savePath_Patients.toFile();
        //ADD A PATIENT TO PATIENTS 
        __patient.getPatients().add(patient);
        loadPatients(savePath);
        Patients patients = c.data().getPatients();
        patients.getPatients().add(patient);
        //SAVE
        FileManager.saveXML(savePath_Patient, __patient);
        FileManager.saveXML(savePath_Patients, patients);
    }
    public void savePatients(Patients patients){
        //ADD A PATIENT TO PATIENT DATA( BIG SAVE FILE WITH ALL THE PATIENTS)
        Path savePath = c.pathHandler().getPatientsSavePath();   
        FileManager.saveXML(savePath, patients);    
           
    }
    public void loadPatient(File patientSaveFile){
        try {
            //THE LOAD DATA
            Patients patients = FileManager.loadXML(patientSaveFile.toPath());
            //INIT DATA 
            c.data().setPatients(patients);
            //SINCE YOU ARE LOADING A XML FILE FROM A PATIENT FOLDER THE CURRENT
            //PATIENT WILL BE AT index 0
            c.data().setCurrentPatient(c.data().getPatients().getPatient_ZERO());
            //INIT EVERYTHING
            List<Point> tempList = c.data().getCurrentPatient().getOrthyPoints().getPoints();
            c.pointHandler().initPoints(tempList);
        } catch (NullPointerException e) {
            //gui handler show a message corupted or unsoported file
            //please select a new file
        }
        
    }
    public void loadPatients(File patientSaveFile){
        try {
            //THE LOAD DATA
            Patients patients = FileManager.loadXML(patientSaveFile.toPath());
            //INIT DATA 
            c.data().setPatients(patients);
            //CURRENT PATIENT SHOULD BE HANDLED INDIVIDUALLY
        } catch (NullPointerException e) {
            //gui handler show a message corupted or unsoported file
            //please select a new file
        }
        
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
//                                  END                                       \\
//****************************************************************************\\
}
