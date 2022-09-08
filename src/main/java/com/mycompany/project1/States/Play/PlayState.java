/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play;

import com.mycompany.project1.Competitions.Competition;
import com.mycompany.project1.Competitions.MathCompetition;
import com.mycompany.project1.Competitions.Prizes.SubjectPrize;
import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.IState;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

/**
 *
 * @author Andrii
 */
public class PlayState extends GUIState implements IState {

    
    private ActionListener backAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
    
    
    private ActionListener competeAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
    
    
    private ActionListener tradeAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
    
    private ActionListener nextAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
    private ActionListener trainAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
    
    
    
    
    
    
    public PlayState() {
    }

    @Override
    protected void render() {
        JTabbedPane tabbedPane = new JTabbedPane();
       
         JPanel content = new JPanel();
         JPanel rankPanel = new JPanel();
         
        tabbedPane.addTab("Dashboard", content);
        tabbedPane.addTab("Rank", rankPanel);
        
        
        
    
        Competition x = new MathCompetition("Math1", 3, new SubjectPrize());
        Competition y = new MathCompetition("Mathy", 2, new SubjectPrize());
      
    
        
        JButton trainButton = GUIFactory.createButton("Train", trainAction);
        JButton tradeButton = GUIFactory.createButton("Trade", tradeAction);
        
        JPanel studentPane = new JPanel();
        studentPane.setLayout(new BorderLayout());
        studentPane.add(GUIFactory.createLabel("Manage Students:"), BorderLayout.NORTH);
        studentPane.add(GUIFactory.createButtonPanel(new JButton[]{
            trainButton, tradeButton}), BorderLayout.CENTER);
        
        
        
        
            content.setLayout(new GridLayout(4, 2));
        
            content.add(GUIFactory.createLabel("Current Competitions:"));
        content.add(GUIFactory.createLabel("School:" + "Westeros"));
        
        
        
        content.add(GUIFactory.createCompetitionVignette(x));
        
        
        content.add(studentPane);
        
        content.add(GUIFactory.createCompetitionVignette(x));
        
        content.add(GUIFactory.createButton("Compete", competeAction));
        content.add(GUIFactory.createCompetitionVignette(y));

        content.add(GUIFactory.createButton("Next", nextAction));        
         
        
        centerPanel.add(tabbedPane, BorderLayout.CENTER);
    
    }

    
}
