/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories;

import com.mycompany.project1.Factories.GUI.Menu.Menu;
import com.mycompany.project1.Factories.GUI.Menu.MenuItem;
import com.mycompany.project1.States.State;
import com.mycompany.project1.Factories.GUI.Menu.Renderers.DialogRenderer;
import com.mycompany.project1.Factories.GUI.Menu.Renderers.OptionRenderer;
import com.mycompany.project1.Models.School;
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
                    add(new MenuItem("Play", State.state.play));
                    add(new MenuItem("Settings",  State.state.settings));
                    add(new MenuItem("Exit",  State.state.nullState));
                    
                }
            },
            
            new DialogRenderer()
        );
    }
    
    public static Menu<MenuItem> createSettingsMenu(){
        return new Menu<MenuItem>("Settings",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Edit Students",  State.state.editStudentMenu));
                    add(new MenuItem("Edit Schools",  State.state.editSchoolMenu));
                    add(new MenuItem("Init", State.state.init));
                    add(new MenuItem("Back",  State.state.mainMenu));
                    
                }
            },
               new DialogRenderer()
        );
    }

    public static Menu<MenuItem> createEditSchoolMenu() {
    return new Menu<MenuItem>("Edit School",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Add",  State.state.addSchool));
                    add(new MenuItem("Check",  State.state.checkSchool));
                    add(new MenuItem("Remove",  State.state.removeSchool));
                    add(new MenuItem("Back",  State.state.settings));
                    
                }
            },
            new DialogRenderer()
        );  
    
    
    

    }

    public static Menu<MenuItem> createEditStudentMenu() {
        return new Menu<MenuItem>("Edit Students",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Add",  State.state.addStudent));
                    add(new MenuItem("Check",  State.state.checkStudent));
                    add(new MenuItem("Remove",  State.state.removeStudent));
                    add(new MenuItem("Back",  State.state.settings));
                    
                }
            },
            new DialogRenderer()
        );
    
    }
    
}
