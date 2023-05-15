package com.example.techiteasymodel.dtos;

import com.example.techiteasymodel.models.Television;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
public class TelevisionDtoInput {

    public Long Id;

    @NotBlank
    public String type;

    @NotBlank
    public String brand;

    @NotBlank
    public String name;

    @NotNull
    public Double price;

    public Double refreshRate;
    public Double availableSize;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;

}