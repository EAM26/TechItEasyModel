package com.example.techiteasymodel.dtos;

import com.example.techiteasymodel.models.Television;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RCOutputDto {

    private Long Id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;
    Television television;
}
