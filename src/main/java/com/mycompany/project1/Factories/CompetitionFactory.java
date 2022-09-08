/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.Competitions.GenericCompetition;
import com.mycompany.project1.Competitions.ICompetition;
import com.mycompany.project1.STG;

/**
 *
 * @author Andrii
 */
public class CompetitionFactory {
    
    public static ICompetition createRandomCompetition(){
        int randInt = STG.random.nextInt(5);
        
        private static enum competition{
            Math,
            English
        }
        
        private static HashMap<competition, double[]> params =
                new HashMap<>();
        
        static{
            params.put(Math, new double[]{1, 1});
            params.put(English, new double[]{2, 2});
        }
        switch(randInt){
            case 1:
                return new GenericCompetition();
        }
        
    }
}
