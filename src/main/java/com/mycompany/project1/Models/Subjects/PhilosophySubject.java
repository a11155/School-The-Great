/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models.Subjects;

import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Models.Subject;
import java.util.HashMap;

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
    public Subject getSubjectEnum() {
        return Subject.Philosophy;
    }
    
      @Override
    public String toString(){
        return "Philosophy";
    
    }
    
         @Override
    public void train(Student student) {
        HashMap<Student.Skill, Double> skills = student.getSkills();
        
        skills.put(Student.Skill.Rhetoric, skills.get(Student.Skill.Rhetoric) + 1);
        skills.put(Student.Skill.Erudition, skills.get(Student.Skill.Erudition) + 1);
        skills.put(Student.Skill.Teamwork, skills.get(Student.Skill.Teamwork) + 1);
        
        SchoolManager.getInstance().serialize();
    }
    
}
