package com.example.techiteasymodel.services;

import com.example.techiteasymodel.dtos.TelevisionDtoInput;
import com.example.techiteasymodel.dtos.TelevisionDtoOutput;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.Television;
import com.example.techiteasymodel.repositories.TelevisionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public Iterable<TelevisionDtoOutput> getTelevisions() {
        List<TelevisionDtoOutput> televisionDtos = new ArrayList<>();
        for (Television television: repos.findAll()) {
            televisionDtos.add(this.convertTelevisionToDto(television));
        }
        return televisionDtos;
    }

    public Television createTelevision(TelevisionDtoInput televisionDtoInput) {
        Television createdTelevision = this.convertDtoToTelevision(televisionDtoInput);
        repos.save(createdTelevision);
        return createdTelevision;
    }

    public TelevisionDtoOutput getTelevision(Long id) {
        Television television = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("No television found at location: " + id));
        return convertTelevisionToDto(television);
    }

    public void deleteTelevision(Long id) {
        try {
            repos.deleteById(id);
        } catch (Exception e) {
            throw new RecordNotFoundException("No television found at location: " + id);
        }
    }

    public void updateTelevision(Long id, TelevisionDtoInput televisionDtoInput) {
        Television television = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("No television found at location: " + id));
        if(televisionDtoInput.getName() != null) {
            television.setName(televisionDtoInput.getName());
        }
        if(televisionDtoInput.getBrand() != null) {
            television.setBrand(televisionDtoInput.getBrand());
        }
        if(televisionDtoInput.getType() != null) {
            television.setType(televisionDtoInput.getType());
        }
        if(televisionDtoInput.getPrice() != null) {
            television.setPrice(televisionDtoInput.getPrice());
        }
        repos.save(television);
    }




    // Below the private conversion methods for DTO to Television and vice versa
    private TelevisionDtoOutput convertTelevisionToDto(Television television) {
        TelevisionDtoOutput televisionDtoOutput = new TelevisionDtoOutput();

        televisionDtoOutput.Id = television.getId();
        televisionDtoOutput.brand = television.getBrand();
        televisionDtoOutput.type = television.getType();
        televisionDtoOutput.name = television.getName();
        televisionDtoOutput.price = television.getPrice();
        televisionDtoOutput.hdr = television.getHdr();
        televisionDtoOutput.bluetooth = television.getBluetooth();
        televisionDtoOutput.ambiLight = television.getAmbiLight();
        televisionDtoOutput.sold = television.getSold();
        televisionDtoOutput.wifi = television.getWifi();
        televisionDtoOutput.availableSize = television.getAvailableSize();
        televisionDtoOutput.refreshRate = television.getRefreshRate();
        televisionDtoOutput.originalStock = television.getOriginalStock();
        televisionDtoOutput.voiceControl = television.getVoiceControl();
        televisionDtoOutput.smartTv = television.getSmartTv();
        televisionDtoOutput.screenQuality = television.getScreenQuality();
        televisionDtoOutput.screenType = television.getScreenType();

        return televisionDtoOutput;

    }

    private Television convertDtoToTelevision(TelevisionDtoInput televisionDtoInput) {
        Television television = new Television();
        television.setBrand(televisionDtoInput.brand);
        television.setType(televisionDtoInput.type);
        television.setName(televisionDtoInput.name);
        television.setPrice(televisionDtoInput.price);
        television.setHdr(televisionDtoInput.hdr);
        television.setBluetooth(televisionDtoInput.bluetooth);
        television.setAmbiLight(televisionDtoInput.ambiLight);
        television.setSold(televisionDtoInput.sold);
        television.setWifi(televisionDtoInput.wifi);
        television.setAvailableSize(televisionDtoInput.availableSize);
        television.setRefreshRate(televisionDtoInput.refreshRate);
        television.setOriginalStock(televisionDtoInput.originalStock);
        television.setVoiceControl(televisionDtoInput.voiceControl);
        television.setSmartTv(televisionDtoInput.smartTv);
        television.setScreenQuality(televisionDtoInput.screenQuality);
        television.setScreenType(televisionDtoInput.screenType);

        return television;
    }


}
