/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Settings.Schools;

import com.mycompany.project1.Factories.GUI.GUIFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
public class RemoveSchoolState extends GUIState {
    
    JList schoolList;
    
    private ActionListener backAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editSchoolMenu;
                    endFrame();
                }
    };
    
      private ActionListener removeAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    School school = (School) schoolList.getSelectedValue();
                    SchoolManager.getInstance().removeSchool(school);
                    
                    schoolList.setModel(GUIFactory.createListModel(SchoolManager.getInstance().getSchools()));
                }
    };
    
    @Override
    protected void render() {
    
        
        
         ArrayList<School> schools = SchoolManager.getInstance().getSchools();
         schoolList = GUIFactory.createList(schools);
         
         
         JPanel schoolPanel = GUIFactory.createListPanel("Schools: ", schoolList);
    
         JButton backButton = GUIFactory.createButton("Back", backAction);
         JButton removeButton = GUIFactory.createButton("Delete", removeAction);
         JPanel buttonPane = GUIFactory.createButtonPanel(new JButton[]{removeButton, backButton});

            centerPanel.add(schoolPanel, BorderLayout.CENTER);
            centerPanel.add(buttonPane, BorderLayout.SOUTH);
    
    }
    
}
