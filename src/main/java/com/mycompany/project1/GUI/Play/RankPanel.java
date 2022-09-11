/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.GUI.Play;

import com.mycompany.project1.Models.School;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrii
 */
public class RankPanel {
    private School[] schools;
    public RankPanel(ArrayList<School> schools){
        this.schools = new School[schools.size()];
        for(int i = 0; i < schools.size(); i++){
            this.schools[i] = schools.get(i);
        }
    
       
    }
    
    public void create(JPanel content){
        
        
        String[][] data = new String[schools.length][3];
        int i = 0;  
        
        
        
        
        Arrays.sort(schools);
        
        for(School school : schools){
            
            data[i++] = new String[]{Integer.toString(i),
                    school.getName(), Double.toString(school.getPrestige())};
        
        }
        
        String[] labels = new String[] {"No", "Name", "GPA"};
        
        
        JTable table = new JTable(data, labels);

//table.setDefaultEditor(Object.class, null);  
        
        content.setLayout(new GridLayout(1,1));
        
        content.add(table);
        
    }
}
