package com.example.techiteasymodel.controllers;

import com.example.techiteasymodel.dtos.WallBracketInputDto;
import com.example.techiteasymodel.dtos.WallBracketOutputDto;
import com.example.techiteasymodel.models.WallBracket;
import com.example.techiteasymodel.services.WallBracketService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<WallBracket>> getAllWallBrackets() {
        return new ResponseEntity(this.service.getAllWallBrackets(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createWallBracket(@RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketOutputDto wallBracketOutputDto = service.createWallBracket(wallBracketInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + wallBracketOutputDto.getId()).toUriString());
        return ResponseEntity.created(uri).body(wallBracketOutputDto.getName()  + " created and added to inventory.");
    }



}
