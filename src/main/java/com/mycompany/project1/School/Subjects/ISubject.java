/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project1.School.Subjects;

import com.mycompany.project1.Factories.SubjectFactory;
import java.io.Serializable;

/**
 *
 * @author Andrii
 */
public interface ISubject extends Serializable {
    
 //   void enroll(Student s);
//    void disenroll(Student s);
    int getGrade();
    SubjectFactory.SubjectEnum getSubjectEnum();
}
