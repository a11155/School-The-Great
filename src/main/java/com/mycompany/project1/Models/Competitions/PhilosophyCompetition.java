/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models.Competitions;

/**
 *
 * @author Andrii
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.project1.Models.Competitions.Prizes.IPrize;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.STG;
import java.util.HashMap;


/**
 *
 * @author Andrii
 */
public class PhilosophyCompetition extends Competition {

    
    private static String[] names = new String[]{
        "Philosophy competition", "Symposium", "Sophistry"
    };
    
    
    
    public PhilosophyCompetition(String name, int prestige, IPrize prize){
        super(name, prestige, prize);
    }
    
    
    public PhilosophyCompetition(IPrize prize){
        super(prize);
        this.name = names[STG.random.nextInt(names.length)];
    }

    @Override
    public double getBaseScore(Student student) {
        HashMap<Student.Skill, Double> skills = student.getSkills();
        
        double score = 0;
        
        score += 0.2*skills.get(Student.Skill.Math);
        score += skills.get(Student.Skill.Rhetoric);
        score += competitors.get(student.getSchool()).length * skills.get(Student.Skill.Teamwork);
    
        return score;
    }
    
    
    
    
}

