package com.mycompany.project1.States.Settings.Students;

import com.mycompany.project1.Factories.GUI.Menu.Menu;
import com.mycompany.project1.Factories.MenuFactory;
;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.States.IState;
import com.mycompany.project1.States.State;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;

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
    public State.state handle() {
        return menu.select().getState();
    }
}