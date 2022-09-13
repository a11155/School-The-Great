/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play.Frames;

import com.mycompany.project1.Factories.GUI.GUIFactory;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Models.Subjects.ISubject;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
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
public class TradeFrame {
    
    private JComboBox schoolComboBox1, schoolComboBox2;
    private JList studentList1, studentList2;
    private SchoolManager schoolManager = SchoolManager.getInstance();
    
    
    public TradeFrame(){}
    
       private ActionListener saveAction = new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent evt){
            
            School school1 = (School) schoolComboBox1.getSelectedItem();
            School school2 = (School) schoolComboBox2.getSelectedItem();
            
            if(school1.equals(school2)){
                return;
            }
            ArrayList<Student> studentsArray1 = new ArrayList<>();
            ArrayList<Student> studentsArray2 = new ArrayList<>();
            
            DefaultListModel students1 = (DefaultListModel) studentList1.getModel();
            for(int i = 0; i < students1.getSize(); i++){
                studentsArray1.add((Student)students1.getElementAt(i));
            }
            
            
            DefaultListModel students2 = (DefaultListModel) studentList2.getModel();
            for(int i = 0; i < students2.getSize(); i++){
                String studentName = (String)students2.getElementAt(i);
                Student student;
                try{
                    student = school1.getStudentByName(studentName);
                } catch(InvalidParameterException e){
                    student = school2.getStudentByName(studentName);
                }
                studentsArray2.add(student);
            }
            
           // school1.setStudents(studentsArray1);
           // school2.setStudents(studentsArray2);
         }
     };   

      private ActionListener chooseSchool = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                School school1 = (School) schoolComboBox1.getSelectedItem();
                
                studentList1.setModel(
                        GUIFactory.createListModel(school1.getStudents()));
                }
                catch(Exception e){}
                try{
                School school2 = (School) schoolComboBox2.getSelectedItem();
                
                studentList2.setModel(
                        GUIFactory.createListModel(school2.getStudents()));
                }
                catch(Exception e){}
                }
        };
    
    
    public void render(){
        
        
        JFrame frame = new JFrame();
        frame.setSize(350, 400);
        frame.setLayout(new BorderLayout(4, 1));
        
        schoolComboBox1 = new JComboBox(schoolManager.getSchools().toArray());
        schoolComboBox2 = new JComboBox(schoolManager.getSchools().toArray());
        
        schoolComboBox1.addActionListener(chooseSchool);
        schoolComboBox2.addActionListener(chooseSchool);
        
        
        frame.add(GUIFactory.createGrid(new Component[]{schoolComboBox1, schoolComboBox2}), BorderLayout.NORTH);
        
        
        
        studentList1 = GUIFactory.createDraggableList(new ArrayList());
        studentList2 = GUIFactory.createDraggableList(new ArrayList());
        
        JPanel studentPanel1 = GUIFactory.createListPanel("Students:: ", studentList1);        
        JPanel studentPanel2 = GUIFactory.createListPanel("Students: ", studentList2);
        
        
        frame.add(GUIFactory.createGrid(new Component[]{
                studentPanel1, studentPanel2}));
        
        frame.add(GUIFactory.createButtonPanel(new JButton[]{
            GUIFactory.createButton("Save", saveAction)
        }), BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
