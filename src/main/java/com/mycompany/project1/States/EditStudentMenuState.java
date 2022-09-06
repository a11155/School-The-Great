/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States;

import com.mycompany.project1.GUI.Menu.Menu;
import com.mycompany.project1.Factories.MenuFactory;
;
import com.mycompany.project1.GUI.Menu.MenuItem;
import com.mycompany.project1.GUI.Menu.MenuItem;
import com.mycompany.project1.GUI.Menu.MenuItem;
import com.mycompany.project1.GUI.Menu.MenuItem;

/**
 *
 * @author Andrii
 */
public class EditStudentMenuState implements IState {
    private Menu<MenuItem> menu;
    public EditStudentMenuState(){
        menu = MenuFactory.createEditStudentMenu();
    }
    
    @Override
    public States.state handle() {
        return menu.select().getState();
    }
}
