/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Settings.Students;

import com.mycompany.project1.Factories.GUI.GUIFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Models.Subjects.ISubject;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
public class RemoveStudentState extends GUIState {
     
        JList studentList;
        JComboBox schoolNameComboBox;
    
        private ActionListener chooseSchool = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                School school = (School) schoolNameComboBox.getSelectedItem();
                
                studentList.setModel(
                        GUIFactory.createListModel(school.getStudents())
                );
            }
        };
        
        private ActionListener backAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
        
        private ActionListener removeAction = new ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent evt) {
                    School school = (School) schoolNameComboBox.getSelectedItem();
                    Student student = (Student) studentList.getSelectedValue();
                    school.removeStudent(student);
                    
                    studentList.setModel(GUIFactory.createListModel(school.getStudents()));
                }
    };

    @Override
    protected void render() {
     schoolNameComboBox = new JComboBox(SchoolManager.getInstance().getSchools().toArray());
         schoolNameComboBox.addActionListener(chooseSchool);
         studentList = GUIFactory.createList(new ArrayList());
         
         
         JPanel studentPanel = GUIFactory.createListPanel("Students: ", studentList);
    
          JButton removeButton = GUIFactory.createButton("Remove", removeAction);
          JButton backButton = GUIFactory.createButton("Back", backAction);
          
          JPanel buttonPane = GUIFactory.createButtonPanel(new JButton[]{removeButton, backButton});

              centerPanel.add(schoolNameComboBox, BorderLayout.NORTH);
            centerPanel.add(studentPanel, BorderLayout.CENTER);
            centerPanel.add(buttonPane, BorderLayout.SOUTH);
    }
     
}
