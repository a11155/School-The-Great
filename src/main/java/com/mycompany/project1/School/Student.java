/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.School;

import com.mycompany.project1.School.Subjects.ISubject;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class Student implements Serializable {
    
    public static final int MAX_SUBJECTS = 3;
    
    private School school;
    
    private ArrayList<ISubject> subjects;
    
    private String name;
    
    
    public Student(String name, School school, ArrayList<ISubject> subjects){
        this.name = name;
        this.school = school;
        this.subjects = subjects;
    }
    
    public School getSchool(){
        return school;
    }
    public ArrayList<ISubject> getSubjects(){
        return this.subjects;
    }
    public String getName(){
        return this.name;
    }
    
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
    
}
