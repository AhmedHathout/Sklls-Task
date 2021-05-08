package com.ahmedhathout.skllstask.repositories;

import com.ahmedhathout.skllstask.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAllByLocationContains(String location);
}
