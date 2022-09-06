/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Managers;
import com.mycompany.project1.States.CheckStudentState;
import com.mycompany.project1.States.AddStudentState;
import com.mycompany.project1.States.CheckSchoolState;
import com.mycompany.project1.States.SettingsState;
import com.mycompany.project1.States.AddSchoolState;
import com.mycompany.project1.States.NullState;
import com.mycompany.project1.States.EditStudentMenuState;
import com.mycompany.project1.States.MainMenuState;
import com.mycompany.project1.States.EditSchoolMenuState;
import com.mycompany.project1.States.IState;
import com.mycompany.project1.States.States;

/**
 *
 * @author Andrii
 */
public class StateManager {
    
    private static StateManager instance;

    
    private StateManager(){
        currentState = new MainMenuState();
    };
    
    private IState currentState;
    
    
    
    public static StateManager getInstance(){
        if(instance == null) 
            return instance = new StateManager();
        return instance;
    }
    
    
    private void setState(States.state state)
    {
        currentState = convertState(state);
    }
    
    private void setState(IState state){
        currentState = state;
    }
    private IState convertState(States.state state){
        
        switch(state){
            case Settings:
                return new SettingsState();
            case MainMenu:
                return new MainMenuState();
            case EditSchoolMenu:
                return  new EditSchoolMenuState();
            case AddSchool:
                return new AddSchoolState();
            case CheckSchool:
                return new CheckSchoolState();
            case EditStudentMenu:
                return new EditStudentMenuState();
            case AddStudent:
                return new AddStudentState();
            case CheckStudent:
                return new CheckStudentState();
            
                
                
            default:
                return new NullState();
        }
        
    }
    
    public void nextState(){
        States.state state = currentState.handle();
        
        setState(state);
        
        
    }
    
}
