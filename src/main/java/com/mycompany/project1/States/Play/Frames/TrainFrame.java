/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play.Frames;

import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Factories.GUI.GUIFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Models.Subjects.ISubject;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

/**
 *
 * @author Andrii
 */
public class TrainFrame {

    private JComboBox studentComboBox;
    private JList studentList, schoolList;
    
    private School school;
    public TrainFrame(School school){
        this.school = school;
        System.out.println("WHAT");
    }
    
       private ActionListener saveAction = new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent evt){
             
                Student student = (Student) studentComboBox.getSelectedItem();
              ListModel listModel = studentList.getModel();

                   ArrayList<ISubject> subjects = new ArrayList<ISubject>();
                   for(int i = 0; i < listModel.getSize(); i++){
                       subjects.add(SubjectFactory.createSubject(listModel.getElementAt(i).toString()));
                   }
                   
                   student.setSubjects(subjects);
                   
                   
                   
                
            
         }
     };
       
          private ActionListener detailsAction = new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent evt){
             
                  GUIFactory.createDetailsFrame((Student) studentComboBox.getSelectedItem());
               
         }
     };
    
    
    
    private ActionListener chooseSchool = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                Student student = (Student) studentComboBox.getSelectedItem();
                
                studentList.setModel(
                        GUIFactory.createListModel(student.getSubjects()));
               
                schoolList.setModel(
                        GUIFactory.createListModel(school.getSubjects())
                );
            }
        };
    
    
    public void render(){
         JFrame frame = new JFrame();
        frame.setSize(350, 400);
        frame.setLayout(new BorderLayout(4, 1));
        
        studentComboBox = new JComboBox(school.getStudents().toArray());
        studentComboBox.addActionListener(chooseSchool);
        
        
        
        studentList = GUIFactory.createDraggableList(new ArrayList(), Student.MAX_SUBJECTS);
        JPanel studentPanel = GUIFactory.createListPanel("Student's Subjects: ", studentList);
        
        schoolList = GUIFactory.createDraggableList(new ArrayList());
        JPanel schoolPanel = GUIFactory.createListPanel("School's Subjects: ", schoolList);
           
        frame.add(studentComboBox, BorderLayout.NORTH);
        frame.add(GUIFactory.createGrid(new Component[]{
                studentPanel, schoolPanel}));
        
        frame.add(GUIFactory.createButtonPanel(new JButton[]{
            GUIFactory.createButton("Save", saveAction),
            GUIFactory.createButton("Details", detailsAction),
            
        }), BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
