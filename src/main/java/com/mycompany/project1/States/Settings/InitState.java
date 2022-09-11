/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Settings;

import com.mycompany.project1.Factories.SchoolFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.States.IState;
import com.mycompany.project1.States.State;

/**
 *
 * @author Andrii
 */
public class InitState implements IState {

    @Override
    public State.state handle() {
        
        SchoolManager.getInstance().clear();
        
        for(int i = 0; i < 3; i++){
            SchoolFactory.createRandomSchool();
        }
        return State.state.settings;
    }
    
}
