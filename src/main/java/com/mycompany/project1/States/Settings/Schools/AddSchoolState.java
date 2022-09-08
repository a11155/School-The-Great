/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Settings.Schools;

import com.mycompany.project1.GUI.DNDList;
import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.Schools.School;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Schools.Subject;
import com.mycompany.project1.Schools.Subjects.ISubject;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
 *
 * @author Andrii
 */
public class AddSchoolState extends GUIState {

    private JTextField schoolNameInput;
    private DNDList subjectList;
    private DNDList selectedSubjectList;
    
    
    public AddSchoolState(){
        super();
        
    }
    
    private void backButtonPressed(ActionEvent evt){
        
        nextState = State.state.editSchoolMenu;
        
        endFrame();
        
        
    }
    
    private void submitButtonPressed(ActionEvent evt){
       
        SchoolManager schoolManager = SchoolManager.getInstance();
        
        ListModel listModel = selectedSubjectList.getModel();
        
        ArrayList<ISubject> subjects = new ArrayList<>();
        
        for(int i = 0; i < listModel.getSize(); i++){
            subjects.add(SubjectFactory.createSubject((String)listModel.getElementAt(i)));
        }
        
        
        schoolManager.addSchool(new School(       
                schoolNameInput.getText(),
                subjects
                
        ));
        
        nextState = State.state.editSchoolMenu;
        
         endFrame();
    }
    
    
    
    
    @Override
    protected void render(){
        
          
          
          
          JLabel schoolNameLabel = new JLabel("School Name:");  
          schoolNameLabel.setPreferredSize(new Dimension(100, 25));
          schoolNameInput = new JTextField(15);
          
          topPanel.add(schoolNameLabel);
          topPanel.add(schoolNameInput);
          
          
          
          
          ArrayList<String> subjects = Subject.getStringValues();
          ArrayList<String> selectedSubjects = new ArrayList<>();
          
          subjectList = GUIFactory.createDraggableList(subjects);
          JPanel subjectListPane = GUIFactory.createListPanel("Subjects: ", subjectList);
          
          
          selectedSubjectList = GUIFactory.createDraggableList(selectedSubjects);
          JPanel selectedSubjectListPane = GUIFactory.createListPanel("Selected Subjects:", selectedSubjectList);
          
          
          
            //Lay out the buttons from left to right.
            
            

            //Put everything together, using the content pane's BorderLayout.
        
          JButton backButton = new JButton();
          backButton.setText("Back");
          
          JButton submitButton = new JButton();
          submitButton.setText("Submit");
          
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    backButtonPressed(evt);
                }
            });
            
              submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    submitButtonPressed(evt);
                }
            });
            
            
            
            JPanel buttonPane = GUIFactory.createButtonPanel(
                    new JButton[]{backButton, submitButton});
            
       
        
            
            JPanel centerGrid = GUIFactory.createGrid(
                    new Component[]{selectedSubjectListPane, subjectListPane});

            centerPanel.add(centerGrid, BorderLayout.CENTER);
            centerPanel.add(buttonPane, BorderLayout.SOUTH);
          
          
    }
    
}
