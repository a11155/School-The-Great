/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play.Frames;

import com.mycompany.project1.Competitions.Competition;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Models.Subjects.ISubject;
import com.mycompany.project1.States.Play.PlayActions;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

/**
 *
 * @author Andrii
 */




public class CompeteFrame {
    private School school;
    private Competition[] competitions;
    private PlayActions actions;
    private Competition selectedCompetition;
    private JList selectedStudentList;

    private JFrame frame;
    
    
     private ActionListener competeBackAction = new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent evt){
             
             frame.dispose();
             
            CompeteFrame new_frame = new CompeteFrame(
                    school, competitions, actions);
            
            new_frame.render();
         }
     };
     
     
     private ActionListener competeSubmitAction = new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent evt){
             
            
            ListModel listModel = selectedStudentList.getModel();
        
            Student[] students = new Student[listModel.getSize()];

            for(int i = 0; i < listModel.getSize(); i++){
                students[i] = school.getStudentByName((String) listModel.getElementAt(i));
            }
            
            selectedCompetition.addCompetitors(school, students);
            frame.dispose();
            
            
         }
     };
    
    private MouseAdapter detailsListener = new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent evt) {
            JList list = (JList)evt.getSource();
            if (evt.getClickCount() == 2) {
                Student student = (Student) list.getSelectedValue();
                
                GUIFactory.createDetailsFrame(student);
            }
        }

    };
           
    
    
    
    
    
    public CompeteFrame(School school, Competition[] competitions, PlayActions actions){
        this.school = school;
        this.competitions = competitions;
        this.actions = actions;
    }
    
    private Competition selectCompetition(){
        int index =  JOptionPane.showOptionDialog(null, "hi",
                "Select Competition:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                competitions, 0);
    
        return competitions[index];
    }
    public void render(){
        selectedCompetition = selectCompetition();
        
        
        frame = new JFrame();
        frame.setSize(350, 400);
        frame.setLayout(new BorderLayout(4, 1));
        
        
        JList studentList = GUIFactory.createDraggableList(school.getStudents());
        JPanel studentPanel = GUIFactory.createListPanel("Students: ", studentList);
        
        selectedStudentList = GUIFactory.createDraggableList(
                new ArrayList(), selectedCompetition.getMaxStudents());
        JPanel selectedStudentPanel = GUIFactory.createListPanel("Selected subjects: ", selectedStudentList);
          
        studentList.addMouseListener(detailsListener);
        selectedStudentList.addMouseListener(detailsListener);
        
        JButton backButton = GUIFactory.createButton("Back", competeBackAction);
        JButton submitButton = GUIFactory.createButton("Submit", competeSubmitAction);
         frame.add(GUIFactory.createGrid(
                 new Component[]{studentPanel, selectedStudentPanel}),
                  BorderLayout.NORTH
          );
         
         frame.add(GUIFactory.createButtonPanel(new JButton[]{
                 submitButton, backButton}
         ));
        frame.setVisible(true);
        
        
         
         
    }
}
