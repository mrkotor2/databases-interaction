package com.training.database.databasedemo;

import com.training.database.databasedemo.jpa.Person;
import com.training.database.databasedemo.jpa.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Autowired
    public JpaDemoApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Person id 10001 {}", personRepository.findById(10001));
        personRepository.deleteById(10001);
        log.info("Person with id 10001 number deleted ");

        personRepository.insert(
                new Person("Inserted", "DB", new Date()));
        log.info("Person with name Inserted inserted ");

        personRepository.update(
                new Person(1, "updated", "DB_Updated", new Date()));
        log.info("Person with id 1 updated ");
        log.info("All persons {}", personRepository.findAll());

    }
}
