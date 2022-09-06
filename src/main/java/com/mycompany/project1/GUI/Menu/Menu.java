/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.GUI.Menu;

import com.mycompany.project1.Project1;
import com.mycompany.project1.GUI.Menu.Renderers.Renderer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrii
 */
public class Menu<T> {
   private String name;
   private Renderer<T> renderer; 
   
   
   private ArrayList<T> menuItems;
   
   public Menu(String name, ArrayList<T> menuItems, Renderer renderer){
       this.name = name;
       this.menuItems = menuItems;
       this.renderer = renderer;
   }
  
   public T select(){
       return renderer.render(name, menuItems);
   }
   private T renderDialog(){
         int index =  JOptionPane.showOptionDialog(null, getName(),
                Project1.TITLE,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menuItems.toArray(), 0);
       return menuItems.get(index);
   }
   
   private T renderOption(){
      return (T) JOptionPane.showInputDialog(
                null,
                "What type of car are you interested in? ",
                "The Choice of a Lifetime",
                JOptionPane.QUESTION_MESSAGE,
                null, // Use default icon
                menuItems.toArray(), // Array of choices
                0); // Initial choice
        //System.out.println(mytype);    
   }
   
  
       /*  
    public States.state selectState(){
        
        return menuItems.get(renderDialog()).getState();
    }*/
    
   
   
   
      public String getName(){
        return this.name;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
   
   
    
}
