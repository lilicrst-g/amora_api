package br.uern.cc.poo.amora_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class UserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @Email
    private String email;
}
