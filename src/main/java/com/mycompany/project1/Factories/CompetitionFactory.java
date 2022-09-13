/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.Models.Competitions.Competition;
import com.mycompany.project1.Models.Competitions.MathCompetition;
import com.mycompany.project1.Models.Competitions.PhilosophyCompetition;
import com.mycompany.project1.Models.Competitions.Prizes.SubjectPrize;
import com.mycompany.project1.STG;


/**
 *
 * @author Andrii
 */
public class CompetitionFactory {
    public static Competition[] currentCompetitions; 
    
    public static Competition createCompetition(){
        return switch(STG.random.nextInt(2)){
            case 0 -> new MathCompetition(PrizeFactory.createPrize());
            case 1 -> new PhilosophyCompetition(PrizeFactory.createPrize());
            default -> throw new IllegalStateException("Invalid Competition");
        };
    }
    
    public static Competition[] generateCompetitions(){
        currentCompetitions = new Competition[]{
            createCompetition(),
            createCompetition(),
            createCompetition()
        };
        return currentCompetitions;
    }

}
