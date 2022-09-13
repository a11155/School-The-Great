/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models.Competitions.Evaluations;

/**
 *
 * @author Andrii
 */
public class EvaluationImpl implements IEvaluation {
    
   private double score;

   public EvaluationImpl(double score){
       this.score = score;
   }
   public double getScore(){
       return score;
   }

    @Override
    public String getBonus() {
        return "";
    }
   
}
