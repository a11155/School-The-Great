/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.Competitions.Competition;
import com.mycompany.project1.Competitions.MathCompetition;
import com.mycompany.project1.Competitions.Prizes.SubjectPrize;
import com.mycompany.project1.STG;


/**
 *
 * @author Andrii
 */
public class CompetitionFactory {
    public static Competition[] currentCompetitions; 
    
    public static Competition createCompetition(){
        return new MathCompetition(PrizeFactory.createPrize());
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
