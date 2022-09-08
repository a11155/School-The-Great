/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Competitions;

import com.mycompany.project1.Competitions.Prizes.IPrize;
import com.mycompany.project1.Schools.School;
import com.mycompany.project1.Schools.Student;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrii
 */
public class MathCompetition extends Competition {

    public MathCompetition(String name, int prestige, IPrize prize){
        super(name, prestige, prize);
    }
    
    @Override
    public boolean compete(HashMap<School, ArrayList<Student>> schools) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
