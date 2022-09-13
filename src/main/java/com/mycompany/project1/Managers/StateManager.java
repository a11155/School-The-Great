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
import com.mycompany.project1.States.Settings.Schools.RemoveSchoolState;
import com.mycompany.project1.States.Settings.Students.RemoveStudentState;
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
        
        return switch (state) {
            case settings -> new SettingsState();
            case mainMenu -> new MainMenuState();
            case editSchoolMenu -> new EditSchoolMenuState();
            case addSchool -> new AddSchoolState();
            case checkSchool -> new CheckSchoolState();
            case editStudentMenu -> new EditStudentMenuState();
            case addStudent -> new AddStudentState();
            case checkStudent -> new CheckStudentState();
            case init -> new InitState();
            case play -> new PlayState();
            case compete -> new CompeteState();
            case train -> new TrainState();
            case removeSchool -> new RemoveSchoolState();
            case removeStudent -> new RemoveStudentState();
            default -> new NullState();
        };
        
    }
    
    public void nextState(){
        State.state state = currentState.handle();
        
        setState(state);
        
        
    }
    
}
