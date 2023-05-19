package com.example.techiteasymodel.services;

import com.example.techiteasymodel.dtos.TelevisionInputDto;
import com.example.techiteasymodel.dtos.TelevisionOutputDto;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.Television;
import com.example.techiteasymodel.repositories.TelevisionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    public ModelMapper mapper;
    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }


    public void setup() {
        this.mapper = new ModelMapper();
    }

    public Iterable<TelevisionOutputDto> getTelevisions() {
        List<TelevisionOutputDto> televisionDtos = new ArrayList<>();
        for (Television television: repos.findAll()) {
            televisionDtos.add(this.convertToDto(television));
        }
        return televisionDtos;
    }

    public Television createTelevision(TelevisionInputDto televisionInputDto) {
        Television createdTelevision = this.convertToTelevision(televisionInputDto);
        repos.save(createdTelevision);
        return createdTelevision;
    }

    public TelevisionOutputDto getTelevision(Long id) {
        Television television = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("No television found at location: " + id));

        return convertToDto(television);
    }

    public void deleteTelevision(Long id) {
        try {
            repos.deleteById(id);
        } catch (Exception e) {
            throw new RecordNotFoundException("No television found at location: " + id);
        }
    }


    public void updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
        System.out.println("Test Service update Television");
        Television television = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("No television found at location: " + id));
        if(televisionInputDto.getName() != null) {
            System.out.println("has name");
            television.setName(televisionInputDto.getName());
        } else {
            System.out.println("No name");
        }
        if(televisionInputDto.getBrand() != null) {
            television.setBrand(televisionInputDto.getBrand());
        }
        if(televisionInputDto.getType() != null) {
            television.setType(televisionInputDto.getType());
        }
        if(televisionInputDto.getPrice() != null) {
            television.setPrice(televisionInputDto.getPrice());
        }
        repos.save(television);
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
//    private TelevisionOutputDto convertTelevisionToDto(Television television) {
//        TelevisionOutputDto televisionDtoOutput = new TelevisionOutputDto();
//
//        televisionDtoOutput.id = television.getId();
//        televisionDtoOutput.brand = television.getBrand();
//        televisionDtoOutput.type = television.getType();
//        televisionDtoOutput.name = television.getName();
//        televisionDtoOutput.price = television.getPrice();
//        televisionDtoOutput.hdr = television.getHdr();
//        televisionDtoOutput.bluetooth = television.getBluetooth();
//        televisionDtoOutput.ambiLight = television.getAmbiLight();
//        televisionDtoOutput.sold = television.getSold();
//        televisionDtoOutput.wifi = television.getWifi();
//        televisionDtoOutput.availableSize = television.getAvailableSize();
//        televisionDtoOutput.refreshRate = television.getRefreshRate();
//        televisionDtoOutput.originalStock = television.getOriginalStock();
//        televisionDtoOutput.voiceControl = television.getVoiceControl();
//        televisionDtoOutput.smartTv = television.getSmartTv();
//        televisionDtoOutput.screenQuality = television.getScreenQuality();
//        televisionDtoOutput.screenType = television.getScreenType();
//
//        return televisionDtoOutput;
//
//    }

//    private Television convertDtoToTelevision(TelevisionInputDto televisionDtoInput) {
//        Television television = new Television();
//        television.setBrand(televisionDtoInput.brand);
//        television.setType(televisionDtoInput.type);
//        television.setName(televisionDtoInput.name);
//        television.setPrice(televisionDtoInput.price);
//        television.setHdr(televisionDtoInput.hdr);
//        television.setBluetooth(televisionDtoInput.bluetooth);
//        television.setAmbiLight(televisionDtoInput.ambiLight);
//        television.setSold(televisionDtoInput.sold);
//        television.setWifi(televisionDtoInput.wifi);
//        television.setAvailableSize(televisionDtoInput.availableSize);
//        television.setRefreshRate(televisionDtoInput.refreshRate);
//        television.setOriginalStock(televisionDtoInput.originalStock);
//        television.setVoiceControl(televisionDtoInput.voiceControl);
//        television.setSmartTv(televisionDtoInput.smartTv);
//        television.setScreenQuality(televisionDtoInput.screenQuality);
//        television.setScreenType(televisionDtoInput.screenType);
//
//        return television;
//    }


}
