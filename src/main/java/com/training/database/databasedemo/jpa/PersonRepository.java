package com.training.database.databasedemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> find_all_persons =
                entityManager.createNamedQuery("find_all_persons", Person.class);
        return find_all_persons.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public void insert(Person person) {
        entityManager.merge(person);
    }
    public void update(Person person) {
        entityManager.merge(person);
    }
    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}
