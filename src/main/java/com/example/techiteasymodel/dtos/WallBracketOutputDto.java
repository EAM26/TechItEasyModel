package com.example.techiteasymodel.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallBracketOutputDto {

    private Long id;

    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
}
