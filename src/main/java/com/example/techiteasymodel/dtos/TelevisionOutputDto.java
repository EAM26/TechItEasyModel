package com.example.techiteasymodel.dtos;


import com.example.techiteasymodel.models.RC;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TelevisionOutputDto {
    public Long id;

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
    RC rc;

}
