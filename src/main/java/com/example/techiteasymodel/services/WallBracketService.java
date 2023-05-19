package com.example.techiteasymodel.services;

import com.example.techiteasymodel.dtos.WallBracketInputDto;
import com.example.techiteasymodel.dtos.WallBracketOutputDto;
import com.example.techiteasymodel.models.WallBracket;
import com.example.techiteasymodel.repositories.WallBracketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private ModelMapper mapper = new ModelMapper();
    private final WallBracketRepository repos;

    public WallBracketService(WallBracketRepository repos) {
        this.repos = repos;
    }


    public Iterable<WallBracketOutputDto> getAllWallBrackets() {
        List<WallBracketOutputDto> wallBracketOutputDtos = new ArrayList<>();
        for (WallBracket wallBracket: repos.findAll()) {
            wallBracketOutputDtos.add(this.convertToDto(wallBracket));
        }
        return wallBracketOutputDtos;
    }

    public WallBracketOutputDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = this.convertToWallBracket(wallBracketInputDto);
        repos.save(wallBracket);
        return this.convertToDto(wallBracket);
    }

    private WallBracketOutputDto convertToDto(WallBracket wallBracket) {
        return this.mapper.map(wallBracket, WallBracketOutputDto.class);
    }

    private WallBracket convertToWallBracket(WallBracketInputDto wallBracketInputDto) {
        return this.mapper.map(wallBracketInputDto, WallBracket.class);
    }

}
