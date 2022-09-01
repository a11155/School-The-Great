/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import com.mycompany.project1.StatesFolder.MenuState;
import com.mycompany.project1.StatesFolder.NullState;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class MenuFactory {
 
    public static Menu createMainMenu(){
        return new Menu("Main Menu",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Compete", States.state.Null));
                    add(new MenuItem("Settings",  States.state.Settings));
                    add(new MenuItem("Exit",  States.state.Null));
                    
                }
            }
        );
    }
    
    public static Menu createSettingsMenu(){
        return new Menu("Settings",
            new ArrayList<MenuItem>(){ 
                {
                    add(new MenuItem("Schools",  States.state.Null));
                    add(new MenuItem("Competitions",  States.state.Null));
                    add(new MenuItem("Back",  States.state.MainMenu));
                    
                }
            }
        );
    }
    
}
