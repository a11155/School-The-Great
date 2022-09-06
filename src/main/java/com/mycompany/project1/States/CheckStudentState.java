/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States;

import com.mycompany.project1.Factories.GUIFactory;
import com.mycompany.project1.GUI.Menu.Menu;
import com.mycompany.project1.Factories.MenuFactory;
import com.mycompany.project1.School.School;
import com.mycompany.project1.School.Student;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * author Andrii
 */
public class CheckStudentState extends GUIState{

       private JComboBox schoolNameComboBox;
       private JList subjectList;
       private JList studentList;
    
      private ActionListener backAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = States.state.EditSchoolMenu;
                    endFrame();
                }
    };
     
     private void studentSelect(MouseEvent e){
         String name = (String) studentList.getSelectedValue();
         School school = (School) schoolNameComboBox.getSelectedItem();
                
         Student student = school.getStudentByName(name);
     }
    
     
     
     
        private ActionListener chooseSchool = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                School school = (School) schoolNameComboBox.getSelectedItem();
                
                studentList.setModel(
                        GUIFactory.createListModel(school.getStudents())
                );
                subjectList.setModel(
                        GUIFactory.createListModel(new ArrayList())
                );
            }
        };
     
     
     
     
     
     
     
     
     
    @Override
    protected void render() {
        
          
        
         schoolNameComboBox = new JComboBox(SchoolManager.getInstance().getSchools().toArray());
         schoolNameComboBox.addActionListener(chooseSchool);
        
          JButton backButton = GUIFactory.createButton("Back", backAction);
          
          ArrayList<School> schools = SchoolManager.getInstance().getSchools();
           ArrayList<String> schoolNames = new ArrayList<>();
         
           
           
           subjectList = GUIFactory.createList(new ArrayList());
           JPanel subjectPanel = GUIFactory.createListPanel("Subjects: ", subjectList);
           
           
           
           studentList = GUIFactory.createList(new ArrayList());
           
           studentList.addMouseListener(new MouseAdapter(){
               public void mouseClicked(MouseEvent e){
                   studentSelect(e);
               
               }
           });
           
           JPanel studentPanel = GUIFactory.createListPanel("Students: ", studentList);
           
   
           
           JPanel buttonPane = GUIFactory.createButtonPanel(new JButton[]{backButton});
           
           JPanel centerGrid = GUIFactory.createGrid(
                    new Component[]{studentPanel, subjectPanel});
           
           centerPanel.add(schoolNameComboBox, BorderLayout.NORTH);
            centerPanel.add(centerGrid, BorderLayout.CENTER);
            centerPanel.add(buttonPane, BorderLayout.SOUTH);
    }

    
        
    
}
