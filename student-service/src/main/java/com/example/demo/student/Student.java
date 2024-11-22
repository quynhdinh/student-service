package com.example.demo.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Entity
@Table
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    long id;
    String name;
    String email;
    long created;
    LocalDate dob;
    @Transient
    int age;

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public Student(String name, String email, long created, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.created = created;
        this.dob = dob;
    }
}