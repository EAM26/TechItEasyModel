package com.example.techiteasymodel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.RestController;

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
//    private Double refreshRate;
//    private Double availableSize;
//    private String screenType;
//    private String screenQuality;
//    private Boolean smartTv;
//    private Boolean wifi;
//    private Boolean voiceControl;
//    private Boolean hdr;
//    private Boolean bluetooth;
//    private Boolean ambiLight;
//    private Integer originalStock;
//    private Integer sold;


    public Television() {
    }

    public Television(Long id, String type, String brand, String name, Double price) {
        Id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
