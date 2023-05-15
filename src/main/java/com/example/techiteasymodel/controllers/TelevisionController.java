package com.example.techiteasymodel.controllers;

import com.example.techiteasymodel.dtos.TelevisionDtoInput;
import com.example.techiteasymodel.dtos.TelevisionDtoOutput;
import com.example.techiteasymodel.exceptions.IllegalNameLengthException;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.Television;
import com.example.techiteasymodel.repositories.TelevisionRepository;
import com.example.techiteasymodel.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service){
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Iterable<TelevisionDtoOutput>> getTelevisions() {
        return new ResponseEntity(service.getTelevisions(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) throws RecordNotFoundException {
        return new ResponseEntity(service.getTelevision(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody @Valid TelevisionDtoInput televisionDtoInput, BindingResult br)  {
        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        }
        Television tv = service.createTelevision(televisionDtoInput);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + televisionDtoInput.Id).toUriString());
        return ResponseEntity.created(uri).body(tv.getName() + " created and added to inventory.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateTelevision(@RequestBody Television tv, @PathVariable Long id) {
//        service.updateTelevision
//        Optional<Television> optionalTelevision = repos.findById(id);
//        if(optionalTelevision.isEmpty()) {
//            throw new RecordNotFoundException("No television found with id: " + id);
//        }
//        Television television = optionalTelevision.get();
//        television.setBrand(tv.getBrand());
//        television.setType(tv.getType());
//        television.setName(tv.getName());
//        television.setPrice(tv.getPrice());
//        repos.save(television);
//        return new ResponseEntity<>((television.getName() + " added to inventory"), HttpStatus.OK);
//    }
}
