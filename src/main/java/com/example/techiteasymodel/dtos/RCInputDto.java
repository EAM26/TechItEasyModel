package com.example.techiteasymodel.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RCInputDto {

    private Long id;

    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;
}
