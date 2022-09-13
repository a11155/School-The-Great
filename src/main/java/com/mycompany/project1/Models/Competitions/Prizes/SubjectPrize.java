/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models.Competitions.Prizes;

import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Subject;
import com.mycompany.project1.Models.Subjects.ISubject;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class SubjectPrize implements IPrize {

    private Subject subject; 
   
    
    @Override
    public void reward(School school) {
        school.addSubject(SubjectFactory.createSubject(Subject.Philosophy));
    }
    
    @Override
    public String toString(){
        return "Subject";
    }
    
}
