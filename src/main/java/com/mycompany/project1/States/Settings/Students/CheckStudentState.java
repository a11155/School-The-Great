/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Settings.Students;

import com.mycompany.project1.GUI.GUIFactory;
import com.mycompany.project1.GUI.Menu.Menu;
import com.mycompany.project1.Factories.MenuFactory;
import com.mycompany.project1.Schools.School;
import com.mycompany.project1.Schools.Student;
import com.mycompany.project1.Factories.SubjectFactory;
import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Schools.Subjects.ISubject;
import com.mycompany.project1.States.GUIState;
import com.mycompany.project1.States.State;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * author Andrii
 */
public class CheckStudentState extends GUIState{

       private JComboBox schoolNameComboBox;
       private JList subjectList;
       private JList studentList;
    
      private ActionListener backAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    nextState = State.state.editStudentMenu;
                    endFrame();
                }
    };
     
    private ActionListener detailsAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    createDetailsFrame((Student) studentList.getSelectedValue());
                }

           
    };
      
   
      
     
     private void studentSelect(MouseEvent e){
         Student student = (Student) studentList.getSelectedValue();
         School school = (School) schoolNameComboBox.getSelectedItem();
         
         ArrayList<ISubject> subjects = student.getSubjects();
         
         subjectList.setModel(
                 GUIFactory.createListModel(subjects)
         );
     
     }
    
     
     
     
        private ActionListener chooseSchool = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                School school = (School) schoolNameComboBox.getSelectedItem();
                
                studentList.setModel(
                        GUIFactory.createListModel(school.getStudents())
                );
                subjectList.setModel(
                        GUIFactory.createListModel(new ArrayList())
                );
            }
        };
     
     
     
     
     
     
     
      
    private void createDetailsFrame(Student student) {
        HashMap<Student.Skill, Double> skills = student.getSkills();

        
        JFrame detailsFrame = new JFrame();          
        
          detailsFrame.setSize(250, 300);
          detailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
     
    @Override
    protected void render() {
        
          
        
         schoolNameComboBox = new JComboBox(SchoolManager.getInstance().getSchools().toArray());
         schoolNameComboBox.addActionListener(chooseSchool);
        
          JButton backButton = GUIFactory.createButton("Back", backAction);
          JButton detailsButton = GUIFactory.createButton("Details", detailsAction);
          
          ArrayList<School> schools = SchoolManager.getInstance().getSchools();
           ArrayList<String> schoolNames = new ArrayList<>();
         
           
           
           subjectList = GUIFactory.createList(new ArrayList());
           JPanel subjectPanel = GUIFactory.createListPanel("Subjects: ", subjectList);
           
           
           
           studentList = GUIFactory.createList(new ArrayList());
           
           studentList.addMouseListener(new MouseAdapter(){
               public void mouseClicked(MouseEvent e){
                   studentSelect(e);
               
               }
           });
           
           JPanel studentPanel = GUIFactory.createListPanel("Students: ", studentList);
           
   
           
           JPanel buttonPane = GUIFactory.createButtonPanel(new JButton[]{detailsButton, backButton});
           
           JPanel centerGrid = GUIFactory.createGrid(
                    new Component[]{studentPanel, subjectPanel});
           
           centerPanel.add(schoolNameComboBox, BorderLayout.NORTH);
            centerPanel.add(centerGrid, BorderLayout.CENTER);
            centerPanel.add(buttonPane, BorderLayout.SOUTH);
    }

    
        
    
}
