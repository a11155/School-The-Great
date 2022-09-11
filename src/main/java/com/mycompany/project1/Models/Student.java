/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models;

import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.STG;
import com.mycompany.project1.Models.Subjects.ISubject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrii
 */
public class Student implements Serializable {
    
    public static final int MAX_SUBJECTS = 3;
    
    private School school;
    
    private ArrayList<ISubject> subjects;
    
    private String name;
    
    public enum Skill{
        Math,
        Rhetoric,
        Erudition,
        Teamwork
    }
    
    private HashMap<Skill, Double> skills;
    
    private double getRandomSkill(int x){
        double a = STG.random.nextDouble(x);
        return Math.round(a * 10.0) / 10.0;
    }
    
    private void initSkills(){
        skills = new HashMap<>();
        
        skills.put(Skill.Math, getRandomSkill(10));
        skills.put(Skill.Erudition, getRandomSkill(10));
        skills.put(Skill.Teamwork, getRandomSkill(10));
        skills.put(Skill.Rhetoric, getRandomSkill(10));
    }
    
    public HashMap<Skill, Double> getSkills(){
        return skills;
    }
    
    public Student(String name, School school, ArrayList<ISubject> subjects){
        this.name = name;
        this.school = school;
        this.subjects = subjects;
    
        initSkills();
    }
    
    public School getSchool(){
        return school;
    }
    public ArrayList<ISubject> getSubjects(){
        return this.subjects;
    }
    public String getName(){
        return this.name;
    }
    public void setSubjects(ArrayList<ISubject> subjects){
        this.subjects = subjects;
        SchoolManager.getInstance().serialize();
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    public double getGPA(){
        double gpa = 0;
        for(Skill skill : skills.keySet()){
            gpa += skills.get(skill);
        }
        
        return gpa;
    }
    
    
    
    
}
