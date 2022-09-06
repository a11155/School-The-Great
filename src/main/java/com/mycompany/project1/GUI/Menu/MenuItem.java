/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.GUI.Menu;

import com.mycompany.project1.States.States;
import com.mycompany.project1.States.IState;

/**
 *
 * @author Andrii
 */

public class MenuItem {
    private String name;
    private States.state state;
    
    public MenuItem(String name, States.state state){
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
    
    public States.state getState(){
        return this.state;
    }
    
    
    
    public void setState(States.state state){
        this.state = state;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    
}
