/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.GUI.Play;

import com.mycompany.project1.Competitions.Competition;
import com.mycompany.project1.Competitions.MathCompetition;
import com.mycompany.project1.Competitions.Prizes.SubjectPrize;
import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.States.Play.PlayActions;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
public class DashBoardPanel {
    private Competition[] competitions;
    private School school;
    private PlayActions actions;
    
    public DashBoardPanel(School school, Competition[] competitions, PlayActions actions){
        this.school = school;
        this.competitions = competitions;
        this.actions = actions;
    }
    
    
    public void create(JPanel content){
        
     
        
        JButton trainButton = GUIFactory.createButton("Train", actions.trainAction);
        JButton tradeButton = GUIFactory.createButton("Trade", actions.tradeAction);
        
        JPanel studentPane = new JPanel();
        studentPane.setLayout(new BorderLayout());
        studentPane.add(GUIFactory.createLabel("Manage Students:"), BorderLayout.NORTH);
        studentPane.add(GUIFactory.createButtonPanel(new JButton[]{
            trainButton, tradeButton}), BorderLayout.CENTER);
        
        
        
        content.setLayout(new GridLayout(4, 2));
        
        content.add(GUIFactory.createLabel("Current Competitions:"));
        JLabel schoolLabel = GUIFactory.createLabel("School:" + school.toString());
        schoolLabel.addMouseListener(actions.schoolDetails);
        content.add(schoolLabel);
        
        
        
        content.add(GUIFactory.createCompetitionVignette(competitions[0]));
        
        
        content.add(studentPane);
        
        content.add(GUIFactory.createCompetitionVignette(competitions[1]));
        
        content.add(GUIFactory.createButton("Compete", actions.competeAction));
        content.add(GUIFactory.createCompetitionVignette(competitions[2]));

        content.add(GUIFactory.createButton("Next", actions.nextAction));        
         
        
    }
    
}
