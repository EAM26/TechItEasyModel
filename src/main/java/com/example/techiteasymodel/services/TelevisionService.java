package com.example.techiteasymodel.services;

import com.example.techiteasymodel.dtos.TelevisionInputDto;
import com.example.techiteasymodel.dtos.TelevisionOutputDto;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.RC;
import com.example.techiteasymodel.models.Television;
import com.example.techiteasymodel.repositories.RCRepository;
import com.example.techiteasymodel.repositories.TelevisionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final RCRepository rcRepos;
    public ModelMapper mapper;
    private final TelevisionRepository televisionRepos;

    public TelevisionService(TelevisionRepository televisionRepos, RCRepository rcRepos) {
        this.televisionRepos = televisionRepos;
        this.rcRepos = rcRepos;
    }

    public void assignRemoteControllerToTelevision(Long tvId, Long rcId) {
        Television tv = televisionRepos.findById(tvId).orElseThrow(() -> new RecordNotFoundException("No television found at location: " + tvId));
        RC rc = rcRepos.findById(rcId).orElseThrow(() -> new RecordNotFoundException("No RC found at location: " + rcId));
        tv.setRc(rc);
        televisionRepos.save(tv);
    }

    public Iterable<TelevisionOutputDto> getTelevisions() {
        List<TelevisionOutputDto> televisionDtos = new ArrayList<>();
        for (Television television : televisionRepos.findAll()) {
            televisionDtos.add(this.convertToDto(television));
        }
        return televisionDtos;
    }

    public Television createTelevision(TelevisionInputDto televisionInputDto) {
        Television createdTelevision = this.convertToTelevision(televisionInputDto);
        televisionRepos.save(createdTelevision);
        return createdTelevision;
    }

    public TelevisionOutputDto getTelevision(Long id) {
        Television television = televisionRepos.findById(id).orElseThrow(() -> new RecordNotFoundException("No television found at location: " + id));
        return convertToDto(television);
    }

    public void deleteTelevision(Long id) {
        try {
            televisionRepos.deleteById(id);
        } catch (Exception e) {
            throw new RecordNotFoundException("No television found at location: " + id);
        }
    }


    public void updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
        System.out.println("Test Service update Television");
        Television television = televisionRepos.findById(id).orElseThrow(() -> new RecordNotFoundException("No television found at location: " + id));
        if (televisionInputDto.getName() != null) {
            System.out.println("has name");
            television.setName(televisionInputDto.getName());
        } else {
            System.out.println("No name");
        }
        if (televisionInputDto.getBrand() != null) {
            television.setBrand(televisionInputDto.getBrand());
        }
        if (televisionInputDto.getType() != null) {
            television.setType(televisionInputDto.getType());
        }
        if (televisionInputDto.getPrice() != null) {
            television.setPrice(televisionInputDto.getPrice());
        }
        televisionRepos.save(television);
    }


    // Below the private conversion methods for DTO to Television and vice versa

    public TelevisionOutputDto convertToDto(Television television) {
        this.mapper = new ModelMapper();
        return this.mapper.map(television, TelevisionOutputDto.class);
    }

    public Television convertToTelevision(TelevisionInputDto televisionInputDto) {
        this.mapper = new ModelMapper();
        return this.mapper.map(televisionInputDto, Television.class);

    }

}
