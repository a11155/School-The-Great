/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States;

import com.mycompany.project1.Factories.StudentFactory;
import com.mycompany.project1.Factories.GUIFactory;
import com.mycompany.project1.School.Subjects.ISubject;
import com.mycompany.project1.School.School;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
 *
 * @author Andrii
 */
public class AddStudentState extends GUIState {

    
    private JTextField studentNameInput;
    private JComboBox schoolNameComboBox;
    private JList subjectList;
    private JList selectedSubjectList;
    
    
    private ActionListener backAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = States.state.EditSchoolMenu;
                    endFrame();
                }
    };
    
    private ActionListener submitAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                    ListModel listModel = selectedSubjectList.getModel();

                   System.out.println(listModel);
                   ArrayList<ISubject> subjects = new ArrayList<ISubject>();
                   for(int i = 0; i < listModel.getSize(); i++){
                       subjects.add(SubjectFactory.createSubject((String)listModel.getElementAt(i)));
                   }
                   
                    
                    
                    
                    StudentFactory.createStudent(
                            studentNameInput.getText(),
                            (School) schoolNameComboBox.getSelectedItem(),
                            subjects);
                    
                    
                    nextState = States.state.EditSchoolMenu;
                    endFrame();
                }
    };
    
    private ActionListener chooseSchool = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                School school = (School) schoolNameComboBox.getSelectedItem();
                
                subjectList.setModel(
                        GUIFactory.createListModel(school.getSubjects())
                );
                selectedSubjectList.setModel(
                        GUIFactory.createListModel(new ArrayList())
                );
            }
        };
        
        
        
    
    
    
    @Override
    protected void render() {
   
        
        
          JLabel studentNameLabel = new JLabel("Student Name:");  
          studentNameLabel.setPreferredSize(new Dimension(100, 25));
          studentNameInput = new JTextField(15);
          
          topPanel.add(studentNameLabel);
          topPanel.add(studentNameInput);
          
          JLabel schoolNameLabel = new JLabel("School Name:");  
          schoolNameLabel.setPreferredSize(new Dimension(100, 25));
          
          schoolNameComboBox = new JComboBox(SchoolManager.getInstance().getSchools().toArray());
          schoolNameComboBox.addActionListener(chooseSchool);
          
          JButton backButton = GUIFactory.createButton("Back", backAction);
          JButton submitButton = GUIFactory.createButton("Submit", submitAction);
            
         JPanel buttonPane = GUIFactory.createButtonPanel(
         new JButton[]{backButton, submitButton}
         );
          
          
            
           subjectList = GUIFactory.createDraggableList(new ArrayList());
           JPanel subjectPanel = GUIFactory.createListPanel("Subjects: ", subjectList);
           
           
           
           selectedSubjectList = GUIFactory.createDraggableList(new ArrayList());
           JPanel selectedSubjectPanel = GUIFactory.createListPanel("Selected subjects: ", selectedSubjectList);
          
         
       
          centerPanel.add(GUIFactory.createGrid(new 
                  Component[]{schoolNameLabel, schoolNameComboBox}),
                  BorderLayout.NORTH
          );
          
          centerPanel.add(GUIFactory.createGrid(
                  new Component[]{selectedSubjectPanel, subjectPanel}),
                  BorderLayout.CENTER        
          );
          centerPanel.add(buttonPane, BorderLayout.SOUTH);
          
          
          
          
             
          
    }
    
}
