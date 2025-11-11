package br.uern.cc.poo.amora_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class BasketRequest {
    
    @NotBlank
    private String name;
    
    @PositiveOrZero
    private double price;

    @NotBlank
    private String description;

}
