/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.Schools.Subject;
import com.mycompany.project1.Schools.Subjects.MathSubject;
import com.mycompany.project1.Schools.Subjects.PhysicsSubject;
import com.mycompany.project1.Schools.Subjects.EnglishSubject;
import com.mycompany.project1.Schools.Subjects.PhilosophySubject;
import com.mycompany.project1.Schools.Subjects.GeographySubject;
import com.mycompany.project1.Schools.Subjects.LiteratureSubject;
import com.mycompany.project1.Schools.Subjects.ISubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Andrii
 */
public class SubjectFactory {
   
    
    public static ISubject createSubject(Subject subject){
        return subject.getSubject();
    }
    public static ISubject createSubject(String subject){
        return createSubject(Subject.valueOf(subject));
    }
    
    public static ArrayList<ISubject> getAllSubjects(){
        ArrayList<ISubject> subjects = new ArrayList<>();
        for(Subject s : Subject.values()){
            subjects.add(createSubject(s));
        }
        return subjects;
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
            new_arr.add((s.getSubjectEnum().name()));
        }
        return new_arr;
    } 
    
    
    
}