package com.example.techiteasymodel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@Entity
@Table(name="televisions")
public class Television {

    @Id
    @GeneratedValue
    private Long Id;

    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double refreshRate;
    private Double availableSize;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;


    public Television() {
    }

    public Television(Long id, String type, String brand, String name, Double price) {
        Id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public void copyProperties(Television target) {
        BeanUtils.copyProperties(target, this);
    }
}
