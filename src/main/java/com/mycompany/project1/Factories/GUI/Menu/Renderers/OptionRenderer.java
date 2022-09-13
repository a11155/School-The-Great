/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories.GUI.Menu.Renderers;

import com.mycompany.project1.Project1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrii
 */
public class OptionRenderer<T> implements Renderer<T> {

    @Override
    public T render(String name, ArrayList<T> arr) {
         return (T) JOptionPane.showInputDialog(
                null,
                "What type of car are you interested in? ",
                "The Choice of a Lifetime",
                JOptionPane.QUESTION_MESSAGE,
                null, // Use default icon
                arr.toArray(), // Array of choices
                0); // Initial choice
        //System.out.println(mytype);
    }
    
}