package com.ahmedhathout.skllstask.controllers;

import com.ahmedhathout.skllstask.entities.Person;
import com.ahmedhathout.skllstask.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
@Log4j2
@Validated
public class PersonController {
    private final PersonService personService;

    // TODO Authentication
    @GetMapping
    public ResponseEntity<List<Person>> findAllPersons(@RequestParam Optional<String> location) {

        log.debug("Called with args: locations=" + location);

        // Gets all the entries with that location, if location is null, it will return all entries (str.contains("") == true)
        List<Person> persons = personService.findAllByLocationContains(location.orElse(""));

        log.debug("Got all persons: " + persons);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@NonNull @Valid Person person) {

        log.debug("Called with args: person=" + person);

        Person savedPerson = personService.savePerson(person);
        log.debug("savedPerson=" + savedPerson);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }
}
