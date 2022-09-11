/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Competitions;

import com.mycompany.project1.Competitions.Evaluations.Decorators.EruditionEvaluation;
import com.mycompany.project1.Competitions.Evaluations.Decorators.LuckEvaluation;
import com.mycompany.project1.Competitions.Evaluations.EvaluationImpl;
import com.mycompany.project1.Competitions.Evaluations.IEvaluation;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import java.util.ArrayList;
import java.util.HashMap;
import com.mycompany.project1.Competitions.Prizes.IPrize;
import com.mycompany.project1.STG;

/**
 *
 * @author Andrii
 */
public abstract class Competition {
    protected String name;
    protected int maxStudents = 10;
    protected IPrize prize;
    
    protected int prestige;
    protected HashMap<School, Student[]> competitors = new HashMap<>();
    protected HashMap<School, Double> scores = new HashMap<>();
    
    
    public Competition(String name, int prestige, IPrize prize){
        this.name = name;
        this.prestige = prestige;
        this.prize = prize;
        
        maxStudents = 10;
        competitors = new HashMap<>();
        scores = new HashMap<>();
    }
    public Competition(IPrize prize){
        this.name = "Unknown";
        this.prize = prize;
        this.prestige = STG.random.nextInt(5);
    }
    
    public abstract double getBaseScore(Student student); 
    
    public IEvaluation evaluate(Student student){
        IEvaluation eval = new EvaluationImpl(getBaseScore(student));
    
        if(STG.random.nextInt(100) < 50){
            eval = new LuckEvaluation(eval);
        }
        if(STG.random.nextInt(100) < 7*student.getSkills().get(Student.Skill.Erudition)){
            eval = new EruditionEvaluation(eval);
        }
        
        return eval;
    }
    
    
   
    
    
    public HashMap<School, Student[]> getCompetitors(){
        return competitors;
    }
    public void addCompetitors(School school, Student[] students){
        competitors.put(school, students);
    }
    
    public int getMaxStudents(){
        return this.maxStudents;
    }
    
    public HashMap<School, Double> getScores(){
        return this.scores;
    }
    
    public String getName(){
        return this.name;
    }
    public int getPrestige(){
        return this.prestige;
    }
    public IPrize getPrize(){
        return this.prize;
    }
    @Override
    public String toString(){
        return name;
    }
    
}
