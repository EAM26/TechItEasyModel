package com.example.techiteasymodel.services;

import com.example.techiteasymodel.dtos.CIModuleInputDto;
import com.example.techiteasymodel.dtos.CIModuleOutputDto;
import com.example.techiteasymodel.models.CIModule;
import com.example.techiteasymodel.repositories.CIModuleRepostitory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {

    private ModelMapper mapper = new ModelMapper();
    private final CIModuleRepostitory repos;

    public CIModuleService(CIModuleRepostitory repos) {
        this.repos = repos;
    }

    public Iterable<CIModuleOutputDto> getCIModules() {
        List<CIModuleOutputDto> ciModuleOutputDtos = new ArrayList<>();
        for (CIModule cim: repos.findAll()) {
            ciModuleOutputDtos.add(this.convertToDto(cim));
        }
        return ciModuleOutputDtos;
    }


    public CIModuleOutputDto convertToDto(CIModule ciModule) {
        return this.mapper.map(ciModule, CIModuleOutputDto.class);
    }

    public CIModuleOutputDto createCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule cim = this.convertToCIModule(ciModuleInputDto);
        repos.save(cim);
        return this.convertToDto(cim);
    }

    public CIModule convertToCIModule(CIModuleInputDto ciModuleInputDto) {
        return this.mapper.map(ciModuleInputDto, CIModule.class);
    }
}
