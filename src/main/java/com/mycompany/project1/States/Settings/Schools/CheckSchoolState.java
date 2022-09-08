/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Settings.Schools;

import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.GUI.Menu.Menu;
import com.mycompany.project1.Factories.MenuFactory;
import com.mycompany.project1.Schools.School;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.States.GUIState;
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
 * author Andrii
 */
public class CheckSchoolState extends GUIState{

        private JList schoolList;
        private JList subjectList;
    
     private void backButtonPressed(ActionEvent evt){
         
         nextState = State.state.editSchoolMenu;
        
        endFrame();
        
        
    }
     
     private void schoolListItemSelected(MouseEvent e){
         String name = (String) schoolList.getSelectedValue();
         
         School school = SchoolManager.getSchoolByName(name);
         
         ArrayList<String> subjects = SubjectFactory.convertToStringArray(school.getSubjects());
         
         subjectList.setModel(GUIFactory.createListModel(subjects));
     }
    
    @Override
    protected void render() {
        
          
          JButton backButton = new JButton();
          backButton.setText("Back");
          
          backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    backButtonPressed(evt);
                }
            });
          
          ArrayList<School> schools = SchoolManager.getInstance().getSchools();
           ArrayList<String> schoolNames = new ArrayList<>();
           
           for(int i = 0; i < schools.size(); i++){
               schoolNames.add(schools.get(i).getName());
           }
           
           schoolList = GUIFactory.createList(schoolNames);
           JPanel schoolPanel = GUIFactory.createListPanel("Schools: ", schoolList);
           
           schoolList.addMouseListener(new MouseAdapter(){
               public void mouseClicked(MouseEvent e){
                   schoolListItemSelected(e);
               
               }
           });
           
           subjectList = new JList();
           JPanel subjectPanel = GUIFactory.createListPanel("subjects: ", subjectList);
          
           JPanel buttonPane = GUIFactory.createButtonPanel(new JButton[]{backButton});
           
           JPanel centerGrid = GUIFactory.createGrid(
                    new Component[]{schoolPanel, subjectPanel});
            centerPanel.add(centerGrid, BorderLayout.CENTER);
            centerPanel.add(buttonPane, BorderLayout.SOUTH);
    }

    
        
    
}
