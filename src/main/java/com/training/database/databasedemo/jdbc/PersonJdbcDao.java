package com.training.database.databasedemo.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    private final JdbcTemplate jdbcTemplate;

    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //instead of new BeanPropertyRowMapper<>(Person.class)
    static class PersonRowMapper implements RowMapper<PersonJdbc>{

        @Override
        public PersonJdbc mapRow(ResultSet resultSet, int i) throws SQLException {
            PersonJdbc personJdbc = new PersonJdbc();
            personJdbc.setId(resultSet.getInt("id"));
            personJdbc.setName(resultSet.getString("name"));
            personJdbc.setLocation(resultSet.getString("location"));
            personJdbc.setBirthDate(resultSet.getTimestamp("birth_date"));
            return personJdbc;
        }
    }

    public List<PersonJdbc> findAll() {
        return jdbcTemplate
                .query("SELECT * FROM Person", new PersonRowMapper());
    }

    public PersonJdbc findById(int id) {
        return jdbcTemplate
                .queryForObject("SELECT * FROM Person WHERE id = ?",
                        new PersonRowMapper(), id);
    }

    public int insert(PersonJdbc personJdbc) {
        return jdbcTemplate
                .update("INSERT INTO Person VALUES(?,?,?,?)",
                        personJdbc.getId(), personJdbc.getName(),
                        personJdbc.getLocation(),
                        new Timestamp(personJdbc.getBirthDate().getTime()));
    }

    public int update(PersonJdbc personJdbc) {
        return jdbcTemplate
                .update("UPDATE Person " +
                                "SET name = ?, location = ?, birth_date = ? " +
                                "WHERE id = ?",
                        personJdbc.getName(),
                        personJdbc.getLocation(),
                        new Timestamp(personJdbc.getBirthDate().getTime()),
                        personJdbc.getId());
    }

    public int deleteById(int id) {
        return jdbcTemplate
                .update("DELETE FROM Person WHERE id = ?", id);
    }

}
