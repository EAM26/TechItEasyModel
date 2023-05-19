package com.example.techiteasymodel.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="remotecontrollers")
public class RC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;



}
