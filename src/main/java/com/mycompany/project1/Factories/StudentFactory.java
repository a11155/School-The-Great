/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.github.javafaker.Faker;
import com.mycompany.project1.STG;
import com.mycompany.project1.Schools.Subjects.ISubject;
import com.mycompany.project1.Schools.School;
import com.mycompany.project1.Schools.Student;
import java.util.ArrayList;
import java.util.Collections;

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
    
    public static Student createStudentRandomly(School school){
        String name = STG.faker.name().fullName();
        ArrayList<ISubject> schoolSubjects = school.getSubjects();
        ArrayList<ISubject> studentSubjects = new ArrayList<>();
        Collections.shuffle(schoolSubjects);
        
        for(int i = 0; i < Student.MAX_SUBJECTS; i++){
            studentSubjects.add(schoolSubjects.get(i));
        }
        return createStudent(name, school, studentSubjects);
    
    } 
}
