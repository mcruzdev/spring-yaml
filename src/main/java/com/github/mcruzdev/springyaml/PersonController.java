package com.github.mcruzdev.springyaml;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @GetMapping
    public ResponseEntity<List<Person>> get() {
        return ResponseEntity.ok(Arrays.asList(new Person("Jéssica", 27)));
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
}
