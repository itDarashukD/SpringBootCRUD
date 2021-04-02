package com.darashuk.project.student.config;

import com.darashuk.project.student.entity.Student;
import com.darashuk.project.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {

        return args -> {
            Student dima = new Student("dima",

                    "ima@.com",
                    LocalDate.of(1986, Month.JULY, 19));
            Student vika = new Student("vika",

                    "vika@.com",
                    LocalDate.of(1986, Month.AUGUST, 1));

            repository.saveAll(List.of(dima, vika));

        };
    }
}
