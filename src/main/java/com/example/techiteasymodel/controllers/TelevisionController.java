package com.example.techiteasymodel.controllers;

import com.example.techiteasymodel.dtos.TelevisionInputDto;
import com.example.techiteasymodel.dtos.TelevisionOutputDto;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.Television;
import com.example.techiteasymodel.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Iterable<TelevisionOutputDto>> getTelevisions() {
        return new ResponseEntity(service.getTelevisions(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) throws RecordNotFoundException {
        return new ResponseEntity(service.getTelevision(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody @Valid TelevisionInputDto televisionInputDto, BindingResult br) {
        if (br.hasFieldErrors()) {
            return ResponseEntity.badRequest().body(validationMessage(br).toString());
        }
        Television tv = service.createTelevision(televisionInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + televisionInputDto.id).toUriString());

        return ResponseEntity.created(uri).body(tv.getName() + " created and added to inventory.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @RequestBody @Valid TelevisionInputDto televisionInputDto, BindingResult br) {
        System.out.println("test putmapping"); //Test message
        if(br.hasFieldErrors()){
            System.out.println("Test Controller updateTelevision "); // Test message
            return ResponseEntity.badRequest().body(validationMessage(br).toString());
        }
        service.updateTelevision(id, televisionInputDto);
        return new ResponseEntity<>(("Updated tv at location: " + id), HttpStatus.OK);
    }

    @PutMapping("/{id}/remotecontroller/{rcId}")
    public ResponseEntity<Object> assignRemoteControllerToTelevision(@PathVariable("id") Long tvId, @PathVariable Long rcId) {
        service.assignRemoteControllerToTelevision(tvId, rcId);
        return new ResponseEntity("test", HttpStatus.OK);
    }

    private StringBuilder validationMessage(BindingResult br) {
        StringBuilder sb = new StringBuilder();
        for (FieldError fe : br.getFieldErrors()) {
            sb.append(fe.getField() + " ");
            sb.append(fe.getDefaultMessage());
            sb.append("\n");
        }
        return sb;
    }
}
