/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import com.mycompany.project1.Managers.StateManager;
import com.mycompany.project1.StatesFolder.MenuState;
import com.mycompany.project1.Managers.SchoolManager;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class STG {
    
    private StateManager stateManager;
    
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
