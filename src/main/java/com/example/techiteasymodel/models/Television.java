package com.example.techiteasymodel.models;

import com.example.techiteasymodel.dtos.TelevisionOutputDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@Entity
@Table(name="televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "rcs", nullable = false)
//    private RC rc;


    public Television() {
    }

    public Television(Long id, String type, String brand, String name, Double price) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

}
