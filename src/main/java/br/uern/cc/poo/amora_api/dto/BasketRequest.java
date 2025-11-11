package br.uern.cc.poo.amora_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class BasketRequest {
    
    @NotBlank
    private String name;
    
    @NotNull
    @PositiveOrZero
    private Double price;

    @NotBlank
    private String description;

}
