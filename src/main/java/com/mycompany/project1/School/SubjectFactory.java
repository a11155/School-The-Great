/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.School;

import com.mycompany.project1.Subjects.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Andrii
 */
public class SubjectFactory {
   
    
    static private final HashMap<String, SubjectEnum> availableSubjects;

    
     public static enum SubjectEnum{
        Math, 
        Physics,
        Philosophy,
        English,
        Literature,
        Geography
    }
    
    static{
        availableSubjects = new HashMap<>();
        
        availableSubjects.put("Math", SubjectEnum.Math);
        availableSubjects.put("Physics", SubjectEnum.Physics);
        availableSubjects.put("Philosophy", SubjectEnum.Philosophy);
        availableSubjects.put("English", SubjectEnum.English);
        availableSubjects.put("Literature", SubjectEnum.Literature);
        availableSubjects.put("Geography", SubjectEnum.Geography);
    }
    public static ISubject createSubject(String subjectString){
        return createSubject(availableSubjects.get(subjectString));
        
    }
    public static ISubject createSubject(SubjectEnum subject){
        switch(subject){
            case Math:
                return new MathSubject();
            case Physics:
                return new PhysicsSubject();
            case Philosophy:
                return new PhilosophySubject();
            case English:
                return new EnglishSubject();
            case Literature:
                return new LiteratureSubject();
            case Geography:
                return new GeographySubject();
        
        }
        throw new IllegalArgumentException();
    }

    public static String createSubjectString(SubjectEnum subject){
        for(Map.Entry<String, SubjectEnum> entry: availableSubjects.entrySet()){
            if(entry.getValue() == subject)
                return entry.getKey();
        }
        return "Unknown";
    }
    
    public static ArrayList<ISubject> convertToSubjectArray(ArrayList<String> arr){
        ArrayList<ISubject> new_arr = new ArrayList<>();
        
        for(String s : arr){
            new_arr.add(createSubject(s));
        }
        return new_arr;
    } 
    
    public static ArrayList<String> convertToStringArray(ArrayList<ISubject> arr){
        ArrayList<String> new_arr = new ArrayList<>();
        
        for(ISubject s : arr){
            new_arr.add(createSubjectString(s.getSubjectEnum()));
        }
        return new_arr;
    } 
    
    
    public static ArrayList<String> getSubjectsStrings(){
        ArrayList<String> subjects = new ArrayList<>();
        
        for(String s : availableSubjects.keySet()){
            subjects.add(s);
        }
        return subjects;
    }
    
}
