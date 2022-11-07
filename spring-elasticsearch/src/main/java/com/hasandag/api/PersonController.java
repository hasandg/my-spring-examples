package com.hasandag.api;

import com.hasandag.entitiy.Person;
import com.hasandag.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @PostConstruct
    private void init() {
        Person person = new Person();
        person.setName("Hasan");
        person.setLastName("Oltu");
        person.setAddress("Test Address");
        person.setBirthDay(Calendar.getInstance().getTime());
        personRepository.save(person);

        Person person2 = new Person();
        person2.setName("Hakan");
        person2.setLastName("Tosun");
        person2.setAddress("My Test Address2");
        person2.setBirthDay(Calendar.getInstance().getTime());
        personRepository.save(person2);

    }

    @GetMapping()
    public ResponseEntity<Iterable<Person>> getUsers() {
        Iterable<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getUsers(@PathVariable String search) {
        List<Person> users = personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/{search}")
    public ResponseEntity<List<Person>> getUsersByNameOrLastName(@PathVariable String search) {
        List<Person> users = personRepository.getByNameLikeOrLastNameLike(search, search);
        return ResponseEntity.ok(users);
    }
}
