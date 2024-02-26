package com.example.students.events;

import com.example.students.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class DeletingStudentEvent extends ApplicationEvent {

    private final int id;
    public DeletingStudentEvent(Object source, int id){
        super(source);
        this.id = id;
    }
}
