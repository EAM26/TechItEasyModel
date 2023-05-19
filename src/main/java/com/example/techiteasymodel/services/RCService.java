package com.example.techiteasymodel.services;

import com.example.techiteasymodel.dtos.RCInputDto;
import com.example.techiteasymodel.dtos.RCOutputDto;
import com.example.techiteasymodel.exceptions.RecordNotFoundException;
import com.example.techiteasymodel.models.RC;
import com.example.techiteasymodel.repositories.RCRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RCService {

    private ModelMapper mapper = new ModelMapper();
    private final RCRepository repos;

    public RCService(RCRepository repos) {
        this.repos = repos;
    }

    public Iterable<RCOutputDto> getAllRCs() {
        List<RCOutputDto> rcOutputDtos = new ArrayList<>();
        for (RC rc: repos.findAll()) {
            rcOutputDtos.add(this.convertToDto(rc));
        }
        return rcOutputDtos;
    }

    public RCOutputDto createRC(RCInputDto rcInputDto) {
        RC rc = this.convertToRC(rcInputDto);
        repos.save(rc);
        return this.convertToDto(rc);
    }

    public RCOutputDto getRC(Long id) {
        RC rc = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("No Rc found at location " + id));
        return convertToDto(rc);
    }

    public RCOutputDto convertToDto(RC rc) {
        return this.mapper.map(rc, RCOutputDto.class);
    }

    public RC convertToRC(RCInputDto rcInputDto) {
        return this.mapper.map(rcInputDto, RC.class);
    }
}
