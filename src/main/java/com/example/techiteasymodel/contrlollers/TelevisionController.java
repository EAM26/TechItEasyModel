package com.example.techiteasymodel.contrlollers;

import com.example.techiteasymodel.exceptions.IllegalNameLengthException;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.Television;
import com.example.techiteasymodel.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {


    @Autowired
    TelevisionRepository repos;

    @GetMapping
    public ResponseEntity<Iterable<Television>> getTelevisions() {
        return new ResponseEntity(repos.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable int id) throws RecordNotFoundException {
        Optional<Television> tv = repos.findById((long) id);
        if(tv!=null) {
            return new ResponseEntity(tv, HttpStatus.OK);
        }
        else {
            throw new RecordNotFoundException("Not a legal index number");
        }
    }

    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television tv) throws IllegalNameLengthException {
        if (tv.getName().length() > 20) {
            throw new IllegalNameLengthException("Name must not be longer than 20 chars.");
        }
        repos.save(tv);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + tv.getId()).toUriString());
        return ResponseEntity.created(uri).body(tv);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        repos.deleteById((long) id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Television> updateTelevision(@RequestBody Television tv, @PathVariable int id) {
//        Optional<Television> oldTelevision = repos.findById((long) id);
//        if(!oldTelevision.isEmpty()) {
//            oldTelevision.set
//        }
//    }
}
