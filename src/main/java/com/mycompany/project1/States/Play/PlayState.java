/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play;

import com.mycompany.project1.Factories.GUI.Play.RankPanel;
import com.mycompany.project1.Factories.GUI.Play.DashBoardPanel;
import com.mycompany.project1.Models.Competitions.Competition;
import com.mycompany.project1.Models.Competitions.MathCompetition;
import com.mycompany.project1.Models.Competitions.Prizes.SubjectPrize;
import com.mycompany.project1.Factories.CompetitionFactory;
import com.mycompany.project1.Factories.GUI.GUIFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.IState;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    

    
    
    
    public PlayState() {
    }

    private ActionListener backAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            nextState = State.state.mainMenu;
            endFrame();
        }
    };
    
    
    @Override 
    public State.state handle(){
         initMainFrame();
        render();
          
        waitForAction();
        
        suspend();
        
        return nextState;
    }
    @Override
    protected void render() {
        
        Competition[] competitions = CompetitionFactory.generateCompetitions();
        School[] schools = SchoolManager.getInstance().getSchoolsArray();
               
        JTabbedPane tabbedPane = new JTabbedPane();
       
        JPanel rankPanel = new JPanel();
        JPanel dashboardPanel = new JPanel();
       
        
        
        PlayActions actions = new PlayActions(schools, competitions);
        
        
       
        RankPanel rankPane = new RankPanel(SchoolManager.getInstance().getSchools());
        rankPane.create(rankPanel);
        
        tabbedPane.addTab("Dashboard", dashboardPanel);
        tabbedPane.addTab("Rank", rankPanel); 
       
        centerPanel.add(tabbedPane, BorderLayout.CENTER);
        
    
        addFrame();
        
        
        int i = 0;
        while(i < schools.length){
            School currentSchool = schools[actions.getCurrentSchool()];
            
            dashboardPanel.removeAll();
            dashboardPanel.revalidate();
            dashboardPanel.repaint();
            DashBoardPanel dashboard = new DashBoardPanel(currentSchool, competitions, actions);
            dashboard.create(dashboardPanel);
            
            i++;
            
            System.out.println(i + " " + actions.getCurrentSchool());
            int x = 0;
            while(i > actions.getCurrentSchool() && !done){
                try {
               Thread.sleep(0);
            } catch(InterruptedException e) {
            }
            }
            
        }
        
            dashboardPanel.removeAll();
            
            actions.setCurrentSchool(0);
            nextState = State.state.compete;
            endFrame();
            
            
        
        
        
    
    }

    
}
