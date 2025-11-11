package br.uern.cc.poo.amora_api.dto;

import java.util.UUID;

import lombok.Value;

@Value
public class UserDto {

    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;

}
