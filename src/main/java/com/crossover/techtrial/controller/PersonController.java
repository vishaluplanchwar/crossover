/**
 *
 */
package com.crossover.techtrial.controller;

import java.util.List;

import com.crossover.techtrial.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crossover.techtrial.service.PersonService;

/**
 * @author crossover
 */

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping(path = "/api/person")
    public ResponseEntity<PersonDTO> register(@RequestBody PersonDTO p) {
        return ResponseEntity.ok(personService.save(p));
    }

    @GetMapping(path = "/api/person")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAll());
    }


    @GetMapping(path = "/api/person/{person-id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable(name = "person-id", required = true) Long personId) {
        PersonDTO person = personService.findById(personId);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.notFound().build();
    }

}
