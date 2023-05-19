package com.example.krokodilce.src.memory;

import com.example.krokodilce.src.XML_Wrappers.Patients;
import com.example.krokodilce.src.cloud.Cloud;
import com.example.krokodilce.src.dataObjects.Patient;

/**
 *
 * @author Stefan Todorovic <orthybt@gmail.com>
 */
//****************************************************************************\\
//                              DATA - TEMPORARY STORAGE                      \\
//****************************************************************************\\
public final class Data {
    //************************************************************************\\
    //                      SPACE FOR DATA OBJECTS                            \\
    //************************************************************************\\
    //                           SINGLETON INIT                               \\
    //************************************************************************\\
    private final static Data data = new Data();
    public static Data get(){
        return data;
    }
    //************************************************************************\\
    //                          CLOUD ACCESS                                  \\
    //************************************************************************\\
    private Cloud c;
    //************************************************************************\\
    //                          CLASS VARIABLES                               \\
    //************************************************************************\\
    private Patient currentPatient;
    private Patients patients = new Patients();
    //************************************************************************\\
    //                     METHODS                                            \\
    //************************************************************************\\
    public void hardReset(){
        this.patients = new Patients();
        this.currentPatient = null;
    }
    public void softReset(){
        this.patients = new Patients();
    }
    //************************************************************************\\
    //                     DATA GETTERS AND SETTERS                           \\
    //************************************************************************\\

    public Patient getCurrentPatient() {
        return currentPatient;
    }

    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    //************************************************************************\\
    //                               END :))))))                              \\
    //************************************************************************\\

    public Cloud getC() {
        return c;
    }

    public void setC(Cloud c) {
        this.c = c;
    }
}
