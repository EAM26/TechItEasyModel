package com.example.techiteasymodel.controllers;


import com.example.techiteasymodel.dtos.CIModuleInputDto;
import com.example.techiteasymodel.dtos.CIModuleOutputDto;
import com.example.techiteasymodel.services.CIModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ci_modules")
public class CIModuleController {

    private final CIModuleService service;

    public CIModuleController(CIModuleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<CIModuleOutputDto>> getCIModules() {
        return new ResponseEntity(service.getCIModules(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCIModule(@RequestBody CIModuleInputDto ciModuleInputDto) {
        CIModuleOutputDto cim = service.createCIModule(ciModuleInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + cim.getId()).toUriString());

        return ResponseEntity.created(uri).body(cim.getName() + " created and added to inventory.");
    }
}
