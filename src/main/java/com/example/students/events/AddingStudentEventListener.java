package com.example.students.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class AddingStudentEventListener {

    @EventListener
    public void listen(AddingStudentEvent addingStudentEvent){
        System.out.println("Добавлен студент:\n" + addingStudentEvent.getStudent());
    }

}
