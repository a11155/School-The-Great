/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.Models;


import com.mycompany.project1.Models.Subjects.*;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public enum Subject {
        Math, 
        Physics,
        Philosophy,
        English,
        Literature,
        Geography;
        
        public ISubject getSubject(){
            switch(this){
                case Math:
                    return new MathSubject();
                case Physics:
                    return new PhysicsSubject();
                case Philosophy:
                    return new PhilosophySubject();
                case Literature:
                    return new LiteratureSubject();
                case Geography:
                    return new GeographySubject();
                case English:
                    return new EnglishSubject();
                   
            }
            throw new IllegalArgumentException();
        }
        
        
       static public ArrayList<String> getStringValues(){
            Subject[] subjects = Subject.values();
            
            ArrayList<String> arr = new ArrayList<>();
            
            for(Subject subject : subjects){
                arr.add(subject.name());
            }
            
            return arr;
        }
}
