package com.example.students;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@ShellComponent
public class StudentController {
    int idCounter = 0;
    ArrayList<Student> studentArray = new ArrayList<Student>();

    @ShellMethod(key = "add")
    public void addStudent(String firstName, String lastName, int age){
        int id = idCounter++;
        Student student = new Student(firstName, lastName, age, id);
        studentArray.add(student);
    }


    @ShellMethod(key = "delete")
    public void deleteStudent(int id){

        int index = Collections.binarySearch(studentArray,
                new Student(null,null,0,id),
                Comparator.comparingInt(Student::getId));

    }


}