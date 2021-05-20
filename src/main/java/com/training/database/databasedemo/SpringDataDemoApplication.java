package com.training.database.databasedemo;

import com.training.database.databasedemo.jpa.Person;
import com.training.database.databasedemo.jpa.PersonRepository;
import com.training.database.databasedemo.jpa.PersonSpringDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

    private final PersonSpringDataRepository personSpringDataRepository;

    @Autowired
    public SpringDataDemoApplication(PersonSpringDataRepository personSpringDataRepository) {
        this.personSpringDataRepository = personSpringDataRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Person id 10001 {}", personSpringDataRepository.findById(10001));
        personSpringDataRepository.deleteById(10001);
        log.info("Person with id 10001 number deleted ");

        personSpringDataRepository.save(
                new Person("Inserted", "DB", new Date()));
        log.info("Person with name Inserted inserted ");

        personSpringDataRepository.save(
                new Person(1, "updated", "DB_Updated", new Date()));
        log.info("Person with id 1 updated ");
        log.info("All persons {}", personSpringDataRepository.findAll());

    }
}
