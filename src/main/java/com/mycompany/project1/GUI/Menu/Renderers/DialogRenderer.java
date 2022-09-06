/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.GUI.Menu.Renderers;

import com.mycompany.project1.Project1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrii
 */
public class DialogRenderer<T> implements Renderer<T> {

    @Override
    public T render(String name, ArrayList<T> arr) {
        int index =  JOptionPane.showOptionDialog(null, name,
                Project1.TITLE,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, arr.toArray(), 0);
       return arr.get(index);
    }
    
}
