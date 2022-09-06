/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Subjects;

import com.mycompany.project1.School.ISubject;
import com.mycompany.project1.School.SubjectFactory;

/**
 *
 * @author Andrii
 */
public class PhilosophySubject implements ISubject{

    @Override
    public int getGrade() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SubjectFactory.SubjectEnum getSubjectEnum() {
        return SubjectFactory.SubjectEnum.Philosophy;
    }
    
      @Override
    public String toString(){
        return "Philosophy";
    }
    
}
