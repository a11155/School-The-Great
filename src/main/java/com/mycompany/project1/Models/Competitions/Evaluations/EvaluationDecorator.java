/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models.Competitions.Evaluations;

/**
 *
 * @author Andrii
 */
public abstract class EvaluationDecorator implements IEvaluation{
    private IEvaluation evaluation;
    
    public EvaluationDecorator(IEvaluation evaluation){
        this.evaluation = evaluation;
    }
    
    @Override
    public double getScore() {
        return evaluation.getScore();
    }
    
    @Override 
    public String getBonus(){
        return evaluation.getBonus();
    }
}
