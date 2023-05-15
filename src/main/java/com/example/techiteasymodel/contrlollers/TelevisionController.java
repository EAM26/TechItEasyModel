package com.example.techiteasymodel.contrlollers;

import com.example.techiteasymodel.exceptions.IllegalNameLengthException;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.Television;
import com.example.techiteasymodel.repositories.TelevisionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionRepository repos;

    public TelevisionController(TelevisionRepository repos) {
        this.repos = repos;
    }


    @GetMapping
    public ResponseEntity<Iterable<Television>> getTelevisions() {
        return new ResponseEntity(repos.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) throws RecordNotFoundException {
        Optional<Television> optionalTelevision = repos.findById(id);
        if(optionalTelevision.isEmpty()) {
            throw new RecordNotFoundException("No television found with id: " + id);
        }
        return new ResponseEntity(optionalTelevision.get(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television tv) throws IllegalNameLengthException {
        if (tv.getName().length() > 20) {
            throw new IllegalNameLengthException("Name cannot be longer than 20 chars.");
        }
        repos.save(tv);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + tv.getId()).toUriString());
        return ResponseEntity.created(uri).body(tv);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        repos.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@RequestBody Television tv, @PathVariable Long id) {
        Optional<Television> optionalTelevision = repos.findById(id);
        if(optionalTelevision.isEmpty()) {
            throw new RecordNotFoundException("No television found with id: " + id);
        }
        Television television = optionalTelevision.get();
        television.setBrand(tv.getBrand());
        television.setType(tv.getType());
        television.setName(tv.getName());
        television.setPrice(tv.getPrice());
        repos.save(television);
        return new ResponseEntity<>((television.getName() + " added to inventory"), HttpStatus.OK);
    }
}
