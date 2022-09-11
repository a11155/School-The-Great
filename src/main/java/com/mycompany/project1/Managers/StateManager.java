/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Managers;
import com.mycompany.project1.States.Settings.Students.CheckStudentState;
import com.mycompany.project1.States.Settings.Students.AddStudentState;
import com.mycompany.project1.States.Settings.Schools.CheckSchoolState;
import com.mycompany.project1.States.Settings.SettingsState;
import com.mycompany.project1.States.Settings.Schools.AddSchoolState;
import com.mycompany.project1.States.NullState;
import com.mycompany.project1.States.Settings.Students.EditStudentMenuState;
import com.mycompany.project1.States.MainMenuState;
import com.mycompany.project1.States.Settings.Schools.EditSchoolMenuState;
import com.mycompany.project1.States.IState;
import com.mycompany.project1.States.Play.CompeteState;
import com.mycompany.project1.States.Play.PlayState;
import com.mycompany.project1.States.Play.TrainState;
import com.mycompany.project1.States.Settings.InitState;
import com.mycompany.project1.States.State;

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
    
    
    private void setState(State.state state)
    {
        currentState = convertState(state);
    }
    
    private void setState(IState state){
        currentState = state;
    }
    private IState convertState(State.state state){
        
        switch(state){
            case settings:
                return new SettingsState();
            case mainMenu:
                return new MainMenuState();
            case editSchoolMenu:
                return  new EditSchoolMenuState();
            case addSchool:
                return new AddSchoolState();
            case checkSchool:
                return new CheckSchoolState();
            case editStudentMenu:
                return new EditStudentMenuState();
            case addStudent:
                return new AddStudentState();
            case checkStudent:
                return new CheckStudentState();
            case init:
                return new InitState();
            case play:
                return new PlayState();
            case compete:
                return new CompeteState();
            case train:
                return new TrainState();
                
                
            default:
                return new NullState();
        }
        
    }
    
    public void nextState(){
        State.state state = currentState.handle();
        
        setState(state);
        
        
    }
    
}
