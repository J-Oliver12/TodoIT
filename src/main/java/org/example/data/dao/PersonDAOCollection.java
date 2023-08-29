package org.example.data.dao;

import org.example.model.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PersonDAOCollection implements PersonDAO {

    private final Map<Integer, Person> personMap = new HashMap<>();
    private int currentId = 1;

    @Override
    public Person persist(Person person) {
        if (person.getId() == 0) {
            person.setId(currentId++);
        }
        personMap.put(person.getId(), person);
        return person;
    }

    @Override
    public Person findById(int id) {
        return personMap.get(id);
    }

    @Override
    public Person findByEmail(String email) {
        return personMap.values()
                .stream()
                .filter(person -> person.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Person> findAll() {
        return personMap.values();
    }

    @Override
    public void remove(int id) {
        personMap.remove(id);
    }
}
