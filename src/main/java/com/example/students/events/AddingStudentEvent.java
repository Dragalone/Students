package com.example.students.events;


import com.example.students.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class AddingStudentEvent extends ApplicationEvent {

    private final Student student;
    public AddingStudentEvent(Object source, Student student){
        super(source);
        this.student = student;
    }
}
