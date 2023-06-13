package com.example.techiteasymodel.controllers;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdInputDto {

    @NotNull
    public Long id;
}
