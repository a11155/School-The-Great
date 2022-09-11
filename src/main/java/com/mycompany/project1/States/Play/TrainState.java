/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.States.Play;

import com.mycompany.project1.Managers.SchoolManager;
import com.mycompany.project1.Models.School;
import com.mycompany.project1.Models.Student;
import com.mycompany.project1.Models.Subjects.ISubject;
import com.mycompany.project1.States.IState;
import com.mycompany.project1.States.State;
import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public class TrainState implements IState {

    @Override
    public State.state handle() {
        ArrayList<School> schools = SchoolManager.getInstance().getSchools();
        for(School school : schools){
            for(Student student : school.getStudents()){
                for(ISubject subject : student.getSubjects()){
                    subject.train(student);
                }
            }
        }
        
        return State.state.play;
    }
    
}
