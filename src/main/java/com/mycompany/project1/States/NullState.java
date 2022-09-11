/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States;

/**
 *
 * @author Andrii
 */
public class NullState implements IState {

    @Override
    public State.state handle() {
        
        return State.state.editStudentMenu;
    }
  
}
