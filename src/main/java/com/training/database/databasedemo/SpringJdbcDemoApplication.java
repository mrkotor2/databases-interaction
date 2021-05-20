package com.training.database.databasedemo;

import com.training.database.databasedemo.jdbc.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@Slf4j
//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

    private final PersonJdbcDao personJdbcDao;

    public SpringJdbcDemoApplication(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        log.info("All persons {}", personJdbcDao.findAll());
//        log.info("Person id 10001 {}", personJdbcDao.findById(10001));
//        log.info("Person id 10001 number of rows affected deleted {} ", personJdbcDao.deleteById(10001));
//        log.info("Person id 10004 number of rows inserted {}", personJdbcDao.insert(
//                new PersonJdbc(10004, "Inserted", "DB", new Date())));
//        log.info("Person id 10004 number of rows updated {}", personJdbcDao.update(
//                new PersonJdbc(10004, "updated", "DB_Updated", new Date())));
    }
}
