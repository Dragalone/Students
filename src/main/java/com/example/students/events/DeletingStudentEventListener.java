package com.example.students.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DeletingStudentEventListener {
    @EventListener
    public void listen(DeletingStudentEvent deletingStudentEvent){
        System.out.println("Удалён студент с id: " + deletingStudentEvent.getId());
    }
}
