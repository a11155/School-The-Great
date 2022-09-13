/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models.Competitions;

import com.mycompany.project1.Models.Competitions.Prizes.IPrize;
import com.mycompany.project1.STG;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Models.Student.Skill;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrii
 */
public class MathCompetition extends Competition {

    
    private static String[] names = new String[]{
        "Math Olympiad", "Math something", "Mathacre",
        "Math Tournament", "Physics Olympiad", "Physics Tournament",
        "Chemistry Tournament", "Science Olympiad"
    };
    
    
    
    public MathCompetition(String name, int prestige, IPrize prize){
        super(name, prestige, prize);
    }
    
    
    public MathCompetition(IPrize prize){
        super(prize);
        this.name = names[STG.random.nextInt(names.length)];
    }

    @Override
    public double getBaseScore(Student student) {
        HashMap<Skill, Double> skills = student.getSkills();
        
        double score = 0;
        
        score += skills.get(Student.Skill.Math);
        score += 0.5*skills.get(Student.Skill.Rhetoric);
        score += competitors.get(student.getSchool()).length * skills.get(Student.Skill.Teamwork);
    
        return score;
    }
    
    
    
    
}
