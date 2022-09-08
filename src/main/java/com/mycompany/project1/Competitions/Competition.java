/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Competitions;

import com.mycompany.project1.Schools.School;
import com.mycompany.project1.Schools.Student;
import java.util.ArrayList;
import java.util.HashMap;
import com.mycompany.project1.Competitions.Prizes.IPrize;

/**
 *
 * @author Andrii
 */
public abstract class Competition {
    private String name;
    private int prestige;
    private IPrize prize;
    
    public Competition(String name, int prestige, IPrize prize){
        this.name = name;
        this.prestige = prestige;
        this.prize = prize;
    }
    
    abstract public boolean compete(HashMap<School, ArrayList<Student>> schools);
   
    
    public String getName(){
        return this.name;
    }
    public int getPrestige(){
        return this.prestige;
    }
    public IPrize getPrize(){
        return this.prize;
    }
    
}
