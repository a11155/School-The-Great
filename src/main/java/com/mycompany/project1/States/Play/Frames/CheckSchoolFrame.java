/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play.Frames;

import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Factories.GUI.GUIFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
public class CheckSchoolFrame {

    private School school;
       
    public CheckSchoolFrame(School school){
        this.school = school;
        
    }
    public void render(){
        JFrame frame = new JFrame();
        frame.setSize(350, 400);
        frame.setLayout(new BorderLayout(4, 1));
        
        
        frame.add(GUIFactory.createLabel(school.getName()), BorderLayout.NORTH);
        JList list =GUIFactory.createList(school.getSubjects()); 
        frame.add(GUIFactory.createListPanel("Subjects:", list), BorderLayout.CENTER);
        
        
        frame.setVisible(true);
    }


    
}
