package com.example.techiteasymodel.controllers;


import com.example.techiteasymodel.dtos.RCInputDto;
import com.example.techiteasymodel.dtos.RCOutputDto;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.services.RCService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/rcs")
public class RCController {

    private final RCService service;

    public RCController(RCService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<RCOutputDto>> getAllRCs() {
        return new ResponseEntity(service.getAllRCs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getRC(@PathVariable Long id) throws RecordNotFoundException {
        return new ResponseEntity(service.getRC(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Object> createRC(@RequestBody RCInputDto rcInputDto) {
        RCOutputDto rcOutputDto = service.createRC(rcInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + rcOutputDto.getId()).toUriString());
//        return new ResponseEntity("RC added at position " + rcOutputDto.getId(), HttpStatus.CREATED);
        return ResponseEntity.created(uri).body(rcOutputDto.getName() + " created and added to inventory.");
    }
}
