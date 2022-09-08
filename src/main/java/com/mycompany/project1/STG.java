/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import com.github.javafaker.Faker;
import com.mycompany.project1.Managers.StateManager;
import com.mycompany.project1.Managers.SchoolManager;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andrii
 */
public class STG {
    
    private StateManager stateManager;
    public static final Random random = new Random();
    public static final Faker faker = new Faker();
    
    
    public static String WORKING_DIR = System.getProperty("user.dir")
            + "\\src\\main\\java\\com\\mycompany\\project1";
    
    
    
    private void initialize(){
        stateManager = StateManager.getInstance();
        
      
    }
    
    
    public STG(){
        
        System.out.println(WORKING_DIR);
        initialize();
    }
    
    
    public void run(){
        while(true){
            
            stateManager.nextState();
        }
        
        
    }
    
}
