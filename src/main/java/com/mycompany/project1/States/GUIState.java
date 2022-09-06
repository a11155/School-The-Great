/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
abstract public class GUIState implements IState {
    private boolean done;
    protected JFrame frame;
    protected State.state nextState;
    
    protected JPanel topPanel;
    protected JPanel bottomPanel;
    protected JPanel centerPanel;
    
    public GUIState(){
        this.done = false;
        this.nextState = State.state.nullState;
        this.frame = new JFrame();
    
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        centerPanel = new JPanel();
    }
    
    protected void endFrame(){
        done = true;
    }
    
    protected void suspend(){
        frame.setVisible(false);
        frame.dispose();
    }
    protected  void waitForAction(){
        
          while(done == false){
            try {
               Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
    }
    @Override
    public State.state handle() {
        
        initFrame();
        render();
        addFrame();
          
        waitForAction();
        
        suspend();
          
        
        return nextState;
    
    }
    
    
    
    
    protected void initFrame(){
        //frame init
          frame.setSize(350, 400);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLayout(new BorderLayout(4, 1));
          
          //top panel
          topPanel.setBackground(Color.red);
          topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
          topPanel.add(Box.createRigidArea(new Dimension(0,5)));
          topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    
          //center panel
          centerPanel.setLayout(new BorderLayout());
          centerPanel.add(Box.createRigidArea(new Dimension(0,5)));
          centerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
          
         //Bottom panel
          bottomPanel.setBackground(Color.green);
          bottomPanel.setPreferredSize(new Dimension(100, 80));
          bottomPanel.setLayout(new FlowLayout());
          
          
    
    }
    
    protected void addFrame(){
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER); 
        frame.add(bottomPanel, BorderLayout.SOUTH);
          
        frame.setVisible(true);
    }
    protected abstract void render(); 
}
