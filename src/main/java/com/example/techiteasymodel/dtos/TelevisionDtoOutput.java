package com.example.techiteasymodel.dtos;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TelevisionDtoOutput {
    public Long Id;

    public String type;
    public String brand;
    public String name;
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
