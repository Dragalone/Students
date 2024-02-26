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
}