/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models.Competitions.Evaluations.Decorators;

import com.mycompany.project1.Models.Competitions.Evaluations.EvaluationDecorator;
import com.mycompany.project1.Models.Competitions.Evaluations.IEvaluation;

/**
 *
 * @author Andrii
 */
public class EruditionEvaluation extends EvaluationDecorator {

    private String bonus = "Erudition";
    
    public EruditionEvaluation(IEvaluation evaluation) {
        super(evaluation);
    }
    @Override
    public double getScore(){
        return super.getScore() * 2;
    }
    
    @Override
    public String getBonus() {
        return super.getBonus() +  " " + bonus;
    }
    
}