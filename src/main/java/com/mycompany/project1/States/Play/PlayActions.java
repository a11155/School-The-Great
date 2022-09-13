/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play;

import com.mycompany.project1.Models.Competitions.Competition;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.States.Play.Frames.CheckSchoolFrame;
import com.mycompany.project1.States.Play.Frames.CompeteFrame;
import com.mycompany.project1.States.Play.Frames.TradeFrame;
import com.mycompany.project1.States.Play.Frames.TrainFrame;
import com.mycompany.project1.States.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Andrii
 */
public class PlayActions {
   
    private Competition[] competitions;
    private School[] schools;
    private int currentSchool;
    private PlayActions actions;
    
    
    public int getCurrentSchool(){
        return currentSchool;
    }
    public void setCurrentSchool(int i){
        currentSchool = i;
    } 
    
    public PlayActions(School[] schools, Competition[] competitions){
        this.schools= schools;
        this.competitions = competitions;
        currentSchool = 0;
        
        actions = this;
    }
    
        public ActionListener competeSubmitAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
        }
        };
        public  ActionListener nextAction = new ActionListener() {
                @Override
                public synchronized void actionPerformed(ActionEvent evt) {
                    currentSchool++;
                    notifyAll();
                }
            };
     public ActionListener competeAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            JButton button = (JButton)evt.getSource();
            button.setEnabled( false );
            
            CompeteFrame frame = new CompeteFrame(
                    schools[currentSchool], competitions, actions);
            
            frame.render();
        }
    };
  
    
     public  ActionListener trainAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            System.out.println("hi");
            TrainFrame trainFrame = new TrainFrame(schools[currentSchool]);
            
            trainFrame.render();
            
        }
    };
    
     public ActionListener tradeAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
             TradeFrame tradeFrame = new TradeFrame();
            
            tradeFrame.render();
        }
    };
    
    
    
      public  ActionListener competeDetailsAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    };
      
      public MouseListener schoolDetails = new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
              CheckSchoolFrame csf = new CheckSchoolFrame(schools[currentSchool]);
              csf.render();
          }
      };
}
