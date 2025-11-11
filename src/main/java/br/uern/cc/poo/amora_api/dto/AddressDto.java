package br.uern.cc.poo.amora_api.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class AddressDto {

    private UUID id;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;
    private UserDto owner;

}
