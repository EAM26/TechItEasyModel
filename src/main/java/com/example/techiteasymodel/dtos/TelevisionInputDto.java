package com.example.techiteasymodel.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TelevisionInputDto {

    public Long id;

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
