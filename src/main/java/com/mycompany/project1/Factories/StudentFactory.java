/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.School.Subjects.ISubject;
import com.mycompany.project1.School.School;
import com.mycompany.project1.School.Student;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class StudentFactory {
    public static Student createStudent(String name, School school, ArrayList<ISubject> subjects){
        Student student = new Student(name, school, subjects);
        school.addStudent(student);
        
        return student;
    }
}
