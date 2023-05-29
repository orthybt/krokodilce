package com.example.krokodilce.src.util;

/**
 * First you need a Path, where you want to create the directory
 * @author Stefan Todorovic <orthybt@gmail.com>
 */

import com.example.krokodilce.src.XML_Wrappers.Patients;
import com.example.krokodilce.src.dataObjects.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//****************************************************************************\\
public final class FileManager{
    //************************************************************************\\
    //                     SINGLETON CLASS                                    \\
    //************************************************************************\\
    private final static FileManager obj = new FileManager();
    public static FileManager get(){
        return obj;
    }
    //************************************************************************\\
    //                     CLASS FIELDS                                       \\
    //************************************************************************\\
    private static Tester t = new Tester();
    //************************************************************************\\
    //                     PATH METHODS                                       \\
    //************************************************************************\\
    /**
     * PATH to STRING 
     * @param path
     * @return 
     */
    public static String getPath(Path path){
        String _path = "";
        try {
            _path = path.toAbsolutePath().toString();
        } catch (Exception e) {
            System.err.println(
                    "ERROR -> castPath(Path path)");
        }
        return _path;
    }
    /**
     * STRING TO PATH
     * @param location
     * @return 
     */
    public static Path getPath(String location){
        Path p = null;
        try {
            p = Paths.get(location).toAbsolutePath();
        } catch (Exception e) {
            System.err.println
        ("ERROR -> castString(String location)");
        }
        return p;
    }
     /**
     * CUSTOM XML FILENAME
     * @param patient
     * @param path
     * @return 
     */
    public static String getXML_FileName(Patient patient, Path path){
        String fileName = String.format("%s_%s%s", 
                                        patient.getFirstName(),
                                        patient.getLastName(),
                                        ".xml");
        //System.out.println(fileName);
        Path patientDirectory = FileManager.getPath(
                                                    patient.getOrthyPath().getPatientDir());
        //System.out.println(patientDirectory);
        String xmlFileName = 
                String.format("%s%s%s", FileManager.getPath(patientDirectory),
                                System.lineSeparator(),
                                fileName);
        //System.out.println(patientDirectory);
        return xmlFileName;
    }
    /**public static String XML(Patient patient, Path path){
        String fileName = String.format("%s_%s%s", 
                                        patient.getFirstName(),
                                        patient.getLastName(),
                                        ".xml");
        //System.out.println(fileName);
        Path patientDirectory = FileManager.getPath(
                                                    patient.getOrthyPath().
                                                    getPatientDirectory());
        //System.out.println(patientDirectory);
        String xmlFileName = 
                String.format("%s%s%s", FileManager.getPath(patientDirectory),
                                System.lineSeparator(),
                                fileName);
        //System.out.println(patientDirectory);
        return xmlFileName;
    }*/
    /**
     * THE PATH WHERE THE JAR IS LOCATED AT RUNTIME
     * @param filename
     * @return 
     */
    public static Path getLocalPath(String filename){
        //an empthy abstract path to access file system object
        Path path = Paths.get("");
        try {
            Path localDir = path.getFileSystem().getPath(filename);
            path.normalize();
            path.toAbsolutePath();
            path = localDir.resolve(path);
        } catch (Exception e) {
            System.err.println
        ("Something went wrong in method getLocalPath(String filename)");
        }
        return path;
    }
    //************************************************************************\\
    //                     DIR METHODS                                        \\
    //************************************************************************\\
    public static Path createDirectory(Path _path){
        Path newFolder = null;
        try {
            if (Files.exists(_path)) {
                newFolder = _path;
            }
            if (Files.notExists(_path)) {
                //make a folder at the destination path using Files class
                Path tempFolder = Files.createDirectory(_path);
                newFolder = tempFolder;
            }
        } catch (IOException e) {
            System.err.println
        ("Something went wrong in method createDirectory(Path _path)");
        }
        return newFolder;
    }
    /**
     * CUSTOM NAMED PATIENT FOLDER
     * @param rootDir
     * @param patient
     * @return 
     */
    public static Path createDirectory_Custom(Patient patient){
        String firstName = patient.getFirstName();
        String lastName = patient.getLastName();
        
        Path patientFolder =  FileManager.getPath(patient.getOrthyPath().getPatientDir());
        //create a path object from an existing root dir and a patient
        try {
            if (Files.exists(patientFolder)) {
                patientFolder = patientFolder;
            }
            if (Files.notExists(patientFolder)) {
                Path customPath = Paths.get(patient.getOrthyPath().getPatientDir(),
                                            firstName+"_"+lastName);
                patientFolder = Files.createDirectory(customPath);
            }
        } catch (Exception e) {
            System.err.println(
                    "Something went wrong in method getPath("
                    + "Path path, String firstName, String lastName)");
        }
        
        return patientFolder;
    }
    //************************************************************************\\
    //                     FILES                                              \\
    //************************************************************************\\
    public static File getFile(Path path){
        return path.toFile();
    }
    //************************************************************************\\
    //                     WRITER AND READER                                  \\
    //************************************************************************\\
    public static BufferedWriter getWriter(Path _path){
        BufferedWriter w = null;
        try {
            w = Files.newBufferedWriter(_path);
        } catch (IOException e) {
            System.err.println
        ("Something went wrong in method getWriter(Path _path)");
        }
        return w;
    }
    public static BufferedReader getReader(Path _path){
        BufferedReader r = null;
        try {
            r = Files.newBufferedReader(_path);
        } catch (IOException e) {
            System.err.println
        ("Something went wrong in method getReader(Path _path)");
        }
        return r;
    }
    //************************************************************************\\
    //                     SAVING AND LOADING                                 \\
    //************************************************************************\\
    public static void saveXML(Path _path, Patients patients){
        try {
            ObjectMapper xmlMapper = new XmlMapper();
            BufferedWriter writer = getWriter(_path);
            xmlMapper.writeValue(writer, patients);
            writer.close();
        } catch (Exception e) {
            System.err.println
                    ("Something went wrong in method saveXML(Path _path, Patients patients)");
        }
    }

    public static Patients loadXML(Path _path) {
        Patients patients = null;
        if(Files.exists(_path)){
            try {
                ObjectMapper xmlMapper = new XmlMapper();
                BufferedReader reader = getReader(_path);
                Patients tempPatients = xmlMapper.readValue(reader, Patients.class);
                patients = tempPatients;
                reader.close();
            } catch (Exception e) {
                System.err.println
                        ("Something went wrong in method loadXML(Path _path, Patients patients)");
            }
        }
        return patients;
    }
    //************************************************************************\\
    //************************************************************************\\
}
