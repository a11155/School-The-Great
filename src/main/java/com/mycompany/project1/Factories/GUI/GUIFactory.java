/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories.GUI;

import com.mycompany.project1.Models.Competitions.Competition;
import com.mycompany.project1.Factories.GUI.DNDList;
import com.mycompany.project1.Models.Student;
import java.awt.BorderLayout;
import java.awt.Component;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Andrii
 */
public class GUIFactory {
    
    
    public static DefaultListModel createListModel(ArrayList elements){
          DefaultListModel listModel = new DefaultListModel();
          
          for(Object elem : elements ){
              listModel.addElement(elem);
          }
        return listModel;
    }
    
    
    public static DNDList createDraggableList(ArrayList elements){
          
        DNDList list = new DNDList(createListModel(elements)); 
        return list;
    } 
    public static DNDList createDraggableList(ArrayList elements, int size){
          
        DNDList list = new DNDList(createListModel(elements), size); 
        return list;
    } 
    
    public static JList createList(ArrayList elements){
          JList list = new JList(createListModel(elements));
          
          return list;
    }
    
    public static JPanel createListPanel(String _label, JList list){
         
          
          JScrollPane listScroller = new JScrollPane();
          
          listScroller.setViewportView(list);
          
         listScroller.setPreferredSize(new Dimension(250, 150));
         listScroller.setAlignmentX(LEFT_ALIGNMENT);
         
            //Lay out the label and scroll pane from top to bottom.
         JPanel listPane = new JPanel();
         listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
         JLabel label = new JLabel(_label);
         listPane.add(label);
         listPane.add(Box.createRigidArea(new Dimension(0,5)));
         listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
         
         listPane.add(listScroller);
         
         return listPane;
    }
    
    public static void addArray(Container receiver, Component[] components){
        for(Component c : components){
            receiver.add(c);
        }
    }
    
    public static JPanel createGrid(Component[] components, int y){
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(y, components.length));
        
        for(Component c : components){
            grid.add(c);
        }
        return grid;
    }
    
    public static JPanel createGrid(Component[] components){
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(1, components.length));
        
        for(Component c : components){
            grid.add(c);
        }
        return grid;
    }
    
    public static JLabel createLabel(String _label){
       JLabel label = new JLabel(_label);  
       label.setPreferredSize(new Dimension(100, 25));
       return label;
    }
    
    public static JLabel createLabel(double num){
        
        double rounded_num = Math.round(num * 10.0) / 10.0;
        return createLabel(Double.toString(rounded_num));
    }
    public static JPanel createPanel(Component[] components){
            JPanel pane = new JPanel();
            pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
            pane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
            pane.add(Box.createHorizontalGlue());
            
            boolean first = true; 
            for(Component component : components){
                if(!first)
                    pane.add(Box.createRigidArea(new Dimension(10, 0)));
                else 
                    first = false;
                pane.add(component);
            }
            
     
            
            return pane;
    }

    
    
    public static JPanel createButtonPanel(JButton[] buttons){
        return createPanel(buttons);
    }
    
    public static JButton createButton(String label, ActionListener action){
          JButton button = new JButton();
          button.setText(label);
          button.addActionListener(action);
          
          return button;
    }
    
    public static JProgressBar createProgressBar(int min, int max, int value){
        JProgressBar progressBar = new JProgressBar(min, max);
        progressBar.setSize(300, 25);
        progressBar.setValue(value);
        
        return progressBar;
        
    }
    
    public static JPanel createCompetitionVignette(Competition competition){
        JPanel panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel name = createLabel("Name: " + competition.getName());
        JProgressBar prestige = createProgressBar(0, 5, competition.getPrestige());
        JLabel prize = createLabel("Prize: " + competition.getPrize().toString());
        
        panel.add(name);
        panel.add(prestige);
        panel.add(prize);
        panel.setBorder(BorderFactory.createBevelBorder(0));
        
        return panel;
    }
    
    
    
    public static void createDetailsFrame(Student student) {
        HashMap<Student.Skill, Double> skills = student.getSkills();

        
        JFrame detailsFrame = new JFrame();          
        
          detailsFrame.setSize(250, 300);
          detailsFrame.setLayout(new BorderLayout());
          
          JPanel detailsPanel = new JPanel();
          detailsPanel.setLayout(new GridLayout(1 + skills.size(), 2));
          
          
          
          JLabel nameLabel = GUIFactory.createLabel("Name:");
          JLabel name = GUIFactory.createLabel(student.getName());
          
          
          
          detailsPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
          
          
          GUIFactory.addArray(detailsPanel, new Component[]{
              nameLabel, name
          });

          
          Component[] skillset = new Component[skills.size() * 2];
          
          int i = 0;
          for(Student.Skill skill : skills.keySet()){
              skillset[i++] = GUIFactory.createLabel(skill.name() + ":");
              skillset[i++] = GUIFactory.createLabel(skills.get(skill).toString());
          }
          GUIFactory.addArray(detailsPanel, skillset);
          
          
          
          detailsFrame.add(detailsPanel, BorderLayout.CENTER);
          detailsFrame.setVisible(true);
        
    }
}
