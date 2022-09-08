/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States;

/**
 *
 * @author Andrii
 */
public class State {
    public static enum state{
        play,
        mainMenu, 
        settings,
        editSchoolMenu,
        addSchool,
        editSchool,
        removeSchool,
        editCompetitionMenu,
        addCompetition,
        removeCompetition,
        editCompetition,
        checkSchool,
        editStudentMenu,
        addStudent,
        removeStudent,
        nullState,
        checkStudent,
        init
    }
    
    private State() {};
}
