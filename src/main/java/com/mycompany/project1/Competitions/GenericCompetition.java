/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Competitions;

import com.mycompany.project1.Schools.School;

/**
 *
 * @author Andrii
 */
public class GenericCompetition implements ICompetition {

    
    double mathMult, rhetoricMult;
    
    
    public GenericCompetition(double mathMult, double rhetoricMult){
        this.mathMult = mathMult;
        this.rhetoricMult = rhetoricMult;
    }
    
    @Override
    public boolean compete(School school1, School school2) {
        
    }
    
}
