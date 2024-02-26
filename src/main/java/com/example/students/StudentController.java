package com.example.students;


import com.example.students.events.AddingStudentEvent;
import com.example.students.events.DeletingStudentEvent;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@ShellComponent
public class StudentController {
    int idCounter = 0;


    private ApplicationEventPublisher publisher;



    ArrayList<Student> studentArray = new ArrayList<>();



    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    @Value("${app.start_values.enabled}")
    private boolean startValues;
    @PostConstruct
    public void startStudentArrayValues(){
        if (startValues){
            addStudent("Иван", "Иванов", 15);
            addStudent("Василий", "Смирнов", 25);
            addStudent("Анна", "Алексеева", 21);
            addStudent("Павел", "Денисов", 19);
            addStudent("Виктория", "Сергеева", 23);
            addStudent("Андрей", "Горшков", 22);
        }
    }

    @ShellMethod(key = "add")
    public void addStudent(String firstName, String lastName, int age){
        int id = idCounter++;
        Student student = new Student(firstName, lastName, age, id);
        studentArray.add(student);
        publisher.publishEvent(new AddingStudentEvent(this,student));
    }

    @ShellMethod(key = "list")
    @ShellMethodAvailability("emptyList")
    public void listStudent(){
        studentArray.forEach((s)->System.out.println(s));
    }


    @ShellMethod(key = "clear_list")
    @ShellMethodAvailability("emptyList")
    public void clearList() {
        studentArray.clear();
    }

    @ShellMethod(key = "delete")
    @ShellMethodAvailability("emptyList")
    public void deleteStudent(int id) {
        int index = Collections.binarySearch(studentArray,
                new Student(null,null,0,id),
                Comparator.comparingInt(Student::getId));
        if (index < 0){
            System.out.println("Студент не найден!");
            return;
        }
        studentArray.remove(index);
        publisher.publishEvent(new DeletingStudentEvent(this,id));
    }

    Availability emptyList(){
        return studentArray.isEmpty() ? Availability.unavailable("Список студентов пуст!") : Availability.available();
    }

}