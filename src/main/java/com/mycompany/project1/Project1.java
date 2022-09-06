/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.project1;

import com.mycompany.project1.States.State.NullState;
import com.mycompany.project1.States.Settings.Schools.AddSchoolState;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrii
 */
public class Project1 {
    public static final String TITLE = "School The Great";
    public static void main(String[] args) {
        
        //AddSchoolState state = new AddSchoolState();
        
        //state.handle();
        STG stg = new STG(); 
        
        stg.run();
        
    }
}
