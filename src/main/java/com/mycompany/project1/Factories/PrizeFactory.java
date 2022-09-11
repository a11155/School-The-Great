/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.Competitions.Prizes.IPrize;
import com.mycompany.project1.Competitions.Prizes.SubjectPrize;

/**
 *
 * @author Andrii
 */
public class PrizeFactory {
    public static IPrize createPrize(){
        return new SubjectPrize();
    }
}
