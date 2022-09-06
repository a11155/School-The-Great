/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project1.School;

import com.mycompany.project1.School.Subjects.ISubject;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class School implements Serializable {
    private ArrayList<Student> students;
    private ArrayList<ISubject> subjects;

    private String name;
    


    public School(String name, ArrayList<String> subjects) {
        this.name = name;
        this.subjects = SubjectFactory.convertToSubjectArray(subjects);
        this.students = new ArrayList<Student>();
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
    
    public void addStudent(Student student){
        this.students.add(student);
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

}
