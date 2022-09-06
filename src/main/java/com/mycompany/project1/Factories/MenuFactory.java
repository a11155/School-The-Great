/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.GUI.Menu.Menu;
import com.mycompany.project1.GUI.Menu.MenuItem;
import com.mycompany.project1.States.States;
import com.mycompany.project1.GUI.Menu.Renderers.DialogRenderer;
import com.mycompany.project1.GUI.Menu.Renderers.OptionRenderer;
import com.mycompany.project1.School.School;
import com.mycompany.project1.StatesFolder.MenuState;
import com.mycompany.project1.States.NullState;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class MenuFactory {
 
    public static Menu<MenuItem> createMainMenu(){
        return new Menu<MenuItem>("Main Menu",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Compete", States.state.Null));
                    add(new MenuItem("Settings",  States.state.Settings));
                    add(new MenuItem("Exit",  States.state.Null));
                    
                }
            },
            
            new DialogRenderer()
        );
    }
    
    public static Menu<MenuItem> createSettingsMenu(){
        return new Menu<MenuItem>("Settings",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Edit Students",  States.state.EditStudentMenu));
                    add(new MenuItem("Edit Schools",  States.state.EditSchoolMenu));
                    add(new MenuItem("Edit Competitions",  States.state.EditCompetitionMenu));
                    add(new MenuItem("Back",  States.state.MainMenu));
                    
                }
            },
               new DialogRenderer()
        );
    }

    public static Menu<MenuItem> createEditSchoolMenu() {
    return new Menu<MenuItem>("Edit School",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Add",  States.state.AddSchool));
                    add(new MenuItem("Check",  States.state.CheckSchool));
                    add(new MenuItem("Remove",  States.state.RemoveSchool));
                    add(new MenuItem("Back",  States.state.Settings));
                    
                }
            },
            new DialogRenderer()
        );  
    
    
    

    }

    public static Menu<MenuItem> createEditStudentMenu() {
        return new Menu<MenuItem>("Edit Students",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Add",  States.state.AddStudent));
                    add(new MenuItem("Check",  States.state.CheckStudent));
                    add(new MenuItem("Remove",  States.state.RemoveStudent));
                    add(new MenuItem("Back",  States.state.Settings));
                    
                }
            },
            new DialogRenderer()
        );
    
    }
    
}
