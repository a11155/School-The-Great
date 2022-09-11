/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play;

import com.mycompany.project1.Competitions.Competition;
import com.mycompany.project1.Factories.CompetitionFactory;
import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.GUI.Play.CompetitionPanel;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.State;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrii
 */
public class CompeteState extends GUIState {

    
    private int currComp;
    
    public CompeteState(){
        currComp = 0;
    }
    
    @Override
    protected void render() {
        Competition competition = CompetitionFactory.currentCompetitions[currComp];
        
        CompetitionPanel competitionPanel = new CompetitionPanel(competition, frame);
        
        topPanel.add(GUIFactory.createLabel(competition.getName()));
        
        try {
            competitionPanel.create(centerPanel, this);
        } catch (InterruptedException ex) {
            Logger.getLogger(CompeteState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nextCompetition(){
        currComp++;
        
        
        if(currComp < CompetitionFactory.currentCompetitions.length)
        {
            topPanel.removeAll();
            centerPanel.removeAll();
            
            Competition competition = CompetitionFactory.currentCompetitions[currComp];
            CompetitionPanel competitionPanel = new CompetitionPanel(competition, frame);
        
            topPanel.add(GUIFactory.createLabel(competition.getName()));

            try {
                competitionPanel.create(centerPanel, this);
            } catch (InterruptedException ex) {
                Logger.getLogger(CompeteState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            nextState = State.state.train;
            endFrame();
        }
    }
}
