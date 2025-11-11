package br.uern.cc.poo.amora_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class AddressRequest {

    @NotBlank
    private String city;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private String complement;

}
