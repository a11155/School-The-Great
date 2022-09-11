/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project1.Models;

import com.mycompany.project1.Models.Subjects.ISubject;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class School implements Serializable, Comparable<School> {
    private ArrayList<Student> students;
    private ArrayList<ISubject> subjects;

    private int prestige = 0;
    
    private String name;
    


    public School(String name, ArrayList<ISubject> subjects) {
        this.name = name;
        this.subjects = subjects;
        this.students = new ArrayList<Student>();
    }
    
    public School(String name, ArrayList<ISubject> subjects, ArrayList<Student> students) {
        this.name = name;
        this.subjects = subjects;
        this.students = students;
    }
    
    public String getName(){
        return this.name;
    }
    
    public ArrayList<ISubject> getSubjects(){
        return this.subjects;
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    
    public double getGPA(){
        double gpa = 0;
        for(Student student : students){
            gpa += student.getGPA();
        }
        return gpa / students.size();
    }
    
    public int getPrestige(){
        return this.prestige;
    }
    public void setPrestige(int prestige){
        this.prestige = prestige;
        SchoolManager.getInstance().serialize();
    }
    public void addStudent(Student student){
        this.students.add(student);
        SchoolManager.getInstance().serialize();
        
    }
    public void addSubject(ISubject subject){
        this.subjects.add(subject);
        SchoolManager.getInstance().serialize();
    }
    
    public Student getStudentByName(String name){
        for(Student student : students){
            if(student.getName().equals(name))
                return student;
        }
        throw new InvalidParameterException();
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int compareTo(School o) {
        return Double.compare(o.getPrestige(), this.getPrestige());
    }

}
