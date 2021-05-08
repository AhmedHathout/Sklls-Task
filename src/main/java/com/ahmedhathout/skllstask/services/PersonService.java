package com.ahmedhathout.skllstask.services;

import com.ahmedhathout.skllstask.entities.Person;
import com.ahmedhathout.skllstask.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import org.apache.commons.text.WordUtils;

import java.util.List;

@AllArgsConstructor
@Validated
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public Person savePerson(@Valid @NonNull Person person) {

        // Lowercase the email and capitalize the first letter of every word in the 3 other fields.
        person.setEmail(person.getEmail().toLowerCase().trim());
        person.setFirstName(WordUtils.capitalizeFully(person.getFirstName().trim()));
        person.setLastName(WordUtils.capitalizeFully(person.getLastName()).trim());
        person.setLocation(WordUtils.capitalizeFully(person.getLocation()).trim());

        return personRepository.save(person);
    }

    public List<Person> findAllByLocationContains(String location) {
        return personRepository.findAllByLocationContains(WordUtils.capitalizeFully(location).trim());
    }
}
