/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.School.Subjects;

import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.School.Subject;

/**
 *
 * @author Andrii
 */
public class GeographySubject implements ISubject{

    @Override
    public int getGrade() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subject getSubjectEnum() {
        return Subject.Geography;
    }
    
    
    @Override
    public String toString(){
        return "Geography";
    }
}
