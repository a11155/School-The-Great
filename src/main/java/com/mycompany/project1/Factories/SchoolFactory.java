/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.STG;
import com.mycompany.project1.School.School;
import com.mycompany.project1.School.Student;
import com.mycompany.project1.School.Subject;
import com.mycompany.project1.School.Subjects.ISubject;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Andrii
 */
public class SchoolFactory {
    private final static int MAX_SUBJECTS = 4;
    private final static int MAX_STUDENTS = 3;
    public static School createRandomSchool(){
        String name = STG.faker.gameOfThrones().city();
        
        ArrayList<ISubject> subjects = SubjectFactory.getAllSubjects();
        
        Collections.shuffle(subjects);
        
        ArrayList<ISubject> schoolSubjects = new ArrayList<>();
        
        for(int i = 0; i < MAX_SUBJECTS; i++)
            schoolSubjects.add(subjects.get(i));
            
        ArrayList<Student> students = new ArrayList<>();
        
        School school = new School(name, schoolSubjects);
        
        
        for(int i = 0; i < MAX_STUDENTS; i++){
            students.add(StudentFactory.createStudentRandomly(school));
        }
        SchoolManager.getInstance().addSchool(school);
        
        return school;
     }
}
