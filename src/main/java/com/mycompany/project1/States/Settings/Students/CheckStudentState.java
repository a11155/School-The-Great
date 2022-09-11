/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Settings.Students;

import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.GUI.Menu.Menu;
import com.mycompany.project1.Factories.MenuFactory;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.Subjects.ISubject;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
     
    private ActionListener detailsAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    GUIFactory.createDetailsFrame((Student) studentList.getSelectedValue());
                }

           
    };
      
   
      
     
     private void studentSelect(MouseEvent e){
         Student student = (Student) studentList.getSelectedValue();
         School school = (School) schoolNameComboBox.getSelectedItem();
         
         ArrayList<ISubject> subjects = student.getSubjects();
         
         subjectList.setModel(
                 GUIFactory.createListModel(subjects)
         );
     
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
          JButton detailsButton = GUIFactory.createButton("Details", detailsAction);
          
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
           
   
           
           JPanel buttonPane = GUIFactory.createButtonPanel(new JButton[]{detailsButton, backButton});
           
           JPanel centerGrid = GUIFactory.createGrid(
                    new Component[]{studentPanel, subjectPanel});
           
           centerPanel.add(schoolNameComboBox, BorderLayout.NORTH);
            centerPanel.add(centerGrid, BorderLayout.CENTER);
            centerPanel.add(buttonPane, BorderLayout.SOUTH);
    }

    
        
    
}
