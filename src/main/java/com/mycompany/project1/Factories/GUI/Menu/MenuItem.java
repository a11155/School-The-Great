/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories.GUI.Menu;

import com.mycompany.project1.States.State;
import com.mycompany.project1.States.IState;

/**
 *
 * @author Andrii
 */

public class MenuItem {
    private String name;
    private State.state state;
    
    public MenuItem(String name, State.state state){
        this.name = name;
        this.state = state;
    }
    
    
    @Override
    public String toString(){
        return getName();
    }
    
    public String getName(){
        return this.name;
    }
    
    public State.state getState(){
        return this.state;
    }
    
    
    
    public void setState(State.state state){
        this.state = state;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    
}
