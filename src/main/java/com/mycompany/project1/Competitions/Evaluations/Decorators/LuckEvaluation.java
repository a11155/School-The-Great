/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Competitions.Evaluations.Decorators;

import com.mycompany.project1.Competitions.Evaluations.EvaluationDecorator;
import com.mycompany.project1.Competitions.Evaluations.IEvaluation;

/**
 *
 * @author Andrii
 */
public class LuckEvaluation extends EvaluationDecorator {

    private String bonus = "Luck";
    
    public LuckEvaluation(IEvaluation evaluation) {
        super(evaluation);
    }
    @Override
    public double getScore(){
        return super.getScore() * 1.2;
    }
    
    @Override
    public String getBonus() {
        return super.getBonus() +  " " + bonus;
    }
    
}
