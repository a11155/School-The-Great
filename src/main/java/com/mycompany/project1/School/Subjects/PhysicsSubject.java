/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.School.Subjects;

import com.mycompany.project1.Factories.SubjectFactory;

/**
 *
 * @author Andrii
 */
public class PhysicsSubject implements ISubject{

    @Override
    public int getGrade() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SubjectFactory.SubjectEnum getSubjectEnum() {
        return SubjectFactory.SubjectEnum.Physics;
    }
    
      @Override
    public String toString(){
        return "Physics";
    }
    
}
