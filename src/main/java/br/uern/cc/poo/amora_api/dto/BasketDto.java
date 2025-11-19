package br.uern.cc.poo.amora_api.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class BasketDto {

    private UUID id;
    private String name;
    private Double price;
    private String description;
    private String photoId;

}
