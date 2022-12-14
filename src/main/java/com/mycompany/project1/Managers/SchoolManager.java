/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Managers;

import com.mycompany.project1.STG;
import com.mycompany.project1.Models.School;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrii
 */
public class SchoolManager implements Serializable {

    static public String SAVE_FILENAME = "schools.ser";
    static public String SAVE_DIR = STG.WORKING_DIR + "\\tmp";
    
    
    static SchoolManager instance;

    public static School getSchoolByName(String name) {
        ArrayList<School> _schools = instance.getSchools();

        for (School s : _schools) {
            if (s.getName() == name) {
                return s;
            }
        }
        throw new IllegalArgumentException();
    }
    private ArrayList<School> schools;

    private SchoolManager() {
       schools = new ArrayList<School>();
    }

    public void addSchool(School school) {
        System.out.println("Hellosfaj;l");
        this.schools.add(school);
        serialize();
    }
    public void clear(){
        schools.clear(); // The garbage collector should take care
        serialize(); // Of all the students, and subjects, that no longer have a point of reference
    }

    public void removeSchool(School school) {
        this.schools.remove(school);
        serialize();
    }

    public ArrayList<School> getSchools() {
        System.out.println(schools);
        return this.schools;
    }
    
    
    public School[] getSchoolsArray() {
        School[] arr = new School[schools.size()];
        for(int i = 0; i < schools.size(); i++){
            arr[i] = schools.get(i);
        }
        return arr;
    }

    public static SchoolManager getInstance() {
        if (instance == null) {
            deserialize();
        }
        return instance;
    }

    
    
    public void serialize(){
        try{
            FileOutputStream fileOut = new FileOutputStream(SAVE_DIR + "\\" + SAVE_FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Schools are serialized");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void deserialize(){
        
        instance = new SchoolManager();
      try {
         FileInputStream fileIn = new FileInputStream(SAVE_DIR + "\\" + SAVE_FILENAME);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         instance = (SchoolManager) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
      }
      
    }
}
