package com.example.demo.student;


import com.example.demo.utils.Time;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student quynh = new Student("Quynh", "quynh@email.com", Time.now(), LocalDate.of(1997, DECEMBER, 5));
            Student alex = new Student("Alex", "alex@email.com", Time.now(), LocalDate.of(2005, JANUARY, 5));
            repository.saveAll(
                    List.of(quynh, alex)
            );
        };
    }
}
