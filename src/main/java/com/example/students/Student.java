package com.example.students;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    String firstName;
    String lastName;
    int age;
    int id;
    @Override
    public String toString(){
        return String.format("Id: %d Имя: %s Фамилия: %s Возраст %d", id, firstName, lastName, age);
    }
}