/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Factories.GUI.Play;

import com.mycompany.project1.Models.Competitions.Competition;
import com.mycompany.project1.Models.Competitions.Evaluations.IEvaluation;
import com.mycompany.project1.Factories.GUI.GUIFactory;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.States.Play.CompeteState;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author Andrii
 */
public class CompetitionPanel{
    
    private final int WAIT_TIME = 0;
    private Competition competition;
    private Iterator<School>  schoolIterator; 
    private JPanel content;
    private JFrame frame;
    private CompeteState state;
    public CompetitionPanel(Competition competition, JFrame frame){
        this.competition = competition;
        this.frame = frame; // Remove frame
    }
    
    private ActionListener nextAction = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
               
                if(schoolIterator.hasNext()){
                    
                        frame.remove(content);
                        frame.revalidate();
                        frame.repaint();
                        frame.setVisible(true);
                        
                        content = new JPanel();
                        content.setLayout(new BorderLayout());
                        
                        frame.add(content, BorderLayout.CENTER);
                         frame.revalidate();
                        frame.repaint();
                    try {
                        createSchoolPane(content, schoolIterator.next());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CompetitionPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else{
                    content.removeAll();
                    createResultsPanel();
                }
             
            }
    };
    
    
    private ActionListener nextCompAction = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
               state.nextCompetition();
               
             
            }
    };
    
    
    
    public void create(JPanel _content, CompeteState state) throws InterruptedException{
        this.state = state;
        content = _content;
        content.setLayout(new BorderLayout());
        HashMap<School, Student[]> competitors = competition.getCompetitors();
        
        Set<School> schools = competitors.keySet();
        
        schoolIterator = schools.iterator();            
        
        if(schoolIterator.hasNext())
            createSchoolPane(content, schoolIterator.next());
        else{
            content.removeAll();
            createResultsPanel();
        }
        
    }
    
    private double roundValue(double d){
        return Math.round(d*10.0)/10.0;
    }
    
    private void createSchoolPane(JPanel content, School school) throws InterruptedException{
    
       
        content.add(GUIFactory.createLabel("School: " + school.getName()), BorderLayout.NORTH);
        
        HashMap<School, Student[]> competitors = competition.getCompetitors();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        
        
        content.add(panel);
         content.revalidate();
         content.repaint();
        frame.setVisible(true);
        
        panel.add(GUIFactory.createGrid(new Component[]{
            GUIFactory.createLabel("Name"),
            GUIFactory.createLabel("Bonus"),
            GUIFactory.createLabel("Score"),
        }));
                
        
        double overallScore = 0;
        
        for(Student student : competitors.get(school)){
            IEvaluation eval = competition.evaluate(student);
            JPanel grid = new JPanel();
            grid.setLayout(new GridLayout(1, 3));
            
            JLabel bonuses = GUIFactory.createLabel("");
            JLabel score = GUIFactory.createLabel(competition.getBaseScore(student));
            panel.add(grid);
            grid.add(GUIFactory.createLabel(student.getName()));
            
            grid.revalidate();
            grid.repaint();
            
            Thread.sleep(WAIT_TIME);
            grid.add(bonuses);
            grid.add(score);
            
            grid.revalidate();
            grid.repaint();
            
            Thread.sleep(WAIT_TIME);
            String evalBonus = ("".equals(eval.getBonus())) ? "None" : eval.getBonus();
            bonuses.setText(evalBonus);
            
            grid.revalidate();
            grid.repaint();
            
            Thread.sleep(WAIT_TIME);
            score.setText(Double.toString(roundValue(eval.getScore())));
            
            grid.revalidate();
            grid.repaint();
            
            Thread.sleep(WAIT_TIME);
            
            
            overallScore += eval.getScore();
            grid.revalidate();
            grid.repaint();
            
        }
        
        
        JPanel grid = new JPanel();
        panel.add(grid);
        grid.setLayout(new GridLayout(1, 3));
        grid.add(GUIFactory.createLabel("Total:"));
        
        grid.revalidate();
        grid.repaint();
        
        Thread.sleep(WAIT_TIME);
        grid.add(GUIFactory.createLabel(""));
        grid.add(GUIFactory.createLabel(overallScore));
        content.add(
                GUIFactory.createButtonPanel( new JButton[]{
                    GUIFactory.createButton("Next", nextAction)}
        ), BorderLayout.SOUTH);
        grid.revalidate();
        grid.repaint();
        
        
        competition.getScores().put(school, overallScore);
        
    }

    
    public void createResultsPanel(){
     
         
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        content.add(panel);
        
        panel.add(GUIFactory.createGrid(new Component[]{
            GUIFactory.createLabel("No"),
            GUIFactory.createLabel("School"),
            GUIFactory.createLabel("Score"),
        }));
        
        List<Map.Entry<School, Double> > list =
               new LinkedList<Map.Entry<School, Double> >(competition.getScores().entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<School, Double> >() {
            public int compare(Map.Entry<School, Double> o1,
                               Map.Entry<School, Double> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        int i = 1;
        for(Map.Entry<School, Double> entry : list){
            
        panel.add(GUIFactory.createGrid(new Component[]{
            GUIFactory.createLabel(Integer.toString(i++)),
            GUIFactory.createLabel(entry.getKey().getName()),
            GUIFactory.createLabel(entry.getValue()),
        }));
        }
        content.add(
                GUIFactory.createButtonPanel( new JButton[]{
                    GUIFactory.createButton("Next Competition", nextCompAction)}
        ), BorderLayout.SOUTH);
        
        content.revalidate();
        content.repaint();
        
        if(!list.isEmpty())
        { 
            School winnerSchool = list.get(0).getKey();

            winnerSchool.setPrestige(winnerSchool.getPrestige() + competition.getPrestige());
            competition.getPrize().reward(winnerSchool);
        }
        
                
    }
    
}
